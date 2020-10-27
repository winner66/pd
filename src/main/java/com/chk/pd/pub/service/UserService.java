package com.chk.pd.pub.service;

import com.alibaba.fastjson.JSONObject;
import com.chk.pd.common.exception.BusinessException;
import com.chk.pd.common.util.HttpClientUtil;
import com.chk.pd.common.util.SnowflakeIdWorker;
import com.chk.pd.pub.dao.UserDao;
import com.chk.pd.pub.domain.UserAccount;
import com.chk.pd.pub.vo.WxOpenId;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Value("${wx.appId}")
    private String wxAppId;

    @Value("${wx.appSecret}")
    private String wxAppSecret;

    private static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private UserDao userDao;

    @Transactional
    public UserAccount login(String wxcode){
        WxOpenId openId = getOpenId(wxcode);
        UserAccount user = userDao.getByOpenId(openId.getOpenId());
        if (user == null){
            user = new UserAccount();
            user.setId(SnowflakeIdWorker.nextID());
            user.setOpenId(openId.getOpenId());
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpireDate(DateTime.now().plusYears(100).toDate());
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            userDao.getUserMapper().insert(user);
        }
        return user;
    }

    public WxOpenId getOpenId(String wxcode){
        Map<String, String> params = new HashMap<>();
        params.put("appid", wxAppId);
        params.put("secret", wxAppSecret);
        params.put("js_code", wxcode);
        params.put("grant_type", "authorization_code");
        JSONObject result = JSONObject.parseObject(HttpClientUtil.sendGet(WX_LOGIN_URL, params));
        String errorCode = result.getString("errcode");
        if(!StringUtils.isEmpty(errorCode) && !"0".equals(errorCode)) {
            log.error("获取openid, wxcode:{}, errorCode:{},errorMsg:{}", wxcode, errorCode, result.getString("errmsg"));
            throw new BusinessException("获取微信openid失败");
        }
        WxOpenId wxOpenId = new WxOpenId();
        wxOpenId.setSessionKey(result.getString("session_key"));
        wxOpenId.setOpenId(result.getString("openid"));
        return wxOpenId;
    }

}
