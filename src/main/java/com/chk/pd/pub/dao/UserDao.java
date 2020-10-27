package com.chk.pd.pub.dao;

import com.chk.pd.pub.dao.mapper.UserAccountMapper;
import com.chk.pd.pub.dao.mapper.UserAddressMapper;
import com.chk.pd.pub.domain.UserAccount;
import com.chk.pd.pub.domain.UserAccountExample;
import com.chk.pd.pub.domain.UserAddress;
import com.chk.pd.pub.domain.UserAddressExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserAccountMapper userMapper;

    @Autowired
    private UserAddressMapper addressMapper;

    public UserAccountMapper getUserMapper() {
        return userMapper;
    }

    public UserAddressMapper getAddressMapper() {
        return addressMapper;
    }

    public UserAccount getByOpenId(String openId){
        UserAccountExample exp = new UserAccountExample();
        exp.createCriteria().andOpenIdEqualTo(openId);
        List<UserAccount> users = userMapper.selectByExample(exp);
        return users.size() > 0 ? users.get(0) : null;
    }

    public UserAccount getByToken(String token){
        if (StringUtils.isBlank(token)){
            return null;
        }
        UserAccountExample exp = new UserAccountExample();
        exp.createCriteria().andTokenEqualTo(token);
        List<UserAccount> users = userMapper.selectByExample(exp);
        return users.size() > 0 ? users.get(0) : null;
    }

    public UserAddress getUserAddress(Long uid){
        UserAddressExample exp = new UserAddressExample();
        exp.createCriteria().andUidEqualTo(uid);
        exp.setOrderByClause("id desc");
        List<UserAddress> address = addressMapper.selectByExample(exp);
        return address.size() > 0 ? address.get(0) : null;
    }

    public void saveUserAddress(UserAddress address){
        if (address.getId() == null){
            this.addressMapper.insert(address);
        }else{
            this.addressMapper.updateByPrimaryKey(address);
        }
    }
}
