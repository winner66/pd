package com.chk.pd.data.service;

import com.chk.pd.data.controller.DataController;
import com.chk.pd.data.dao.DataDao;
import com.chk.pd.data.domain.DataCollect;
import com.chk.pd.data.vo.DataCVo;
import com.chk.pd.pub.dao.UserDao;
import com.chk.pd.pub.domain.UserAccount;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataService {

    private Logger log = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private DataDao dataDao;

    @Autowired
    private UserDao userDao;

    @SneakyThrows
    public void insert(DataCVo vo){
        UserAccount user = userDao.getByToken(vo.getToken());
        DataCollect dc = new DataCollect();
        PropertyUtils.copyProperties(dc, vo);
        dc.setDate(new Date());
        dc.setUid(user == null ? null : user.getId());
        dataDao.getDataCollectMapper().insert(dc);
    }
}
