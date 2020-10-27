package com.chk.pd.common.interceptor;

import com.chk.pd.common.bean.UserContext;
import com.chk.pd.common.exception.BusinessException;
import com.chk.pd.common.vo.User;
import com.chk.pd.pub.dao.UserDao;
import com.chk.pd.pub.domain.UserAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenCheckInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(TokenCheckInterceptor.class);

    private UserDao userDao;

    public TokenCheckInterceptor(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("x-access-token");
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException("用户状态异常，请清除缓存再重试");
        }
        try {
            UserAccount account = userDao.getByToken(token);
            if(account == null){
                throw new BusinessException("非法Token, 请清除缓存再重试");
            }
            User user = new User();
            user.setId(account.getId());
            UserContext.set(user);
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage(), e);
            throw new BusinessException("获取用户信息出错, 请清除缓存再重试");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
