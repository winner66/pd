package com.chk.pd.cm.service;

import com.chk.pd.cm.dao.CmDao;
import com.chk.pd.cm.domain.CmContact;
import com.chk.pd.cm.vo.ContactRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmService {

    @Autowired
    private CmDao cmDao;

    public ContactRsp listContact(){
        ContactRsp rsp = new ContactRsp();
        List<CmContact> list = cmDao.listContact();

        for (CmContact cm : list) {
            if ("公司".equals(cm.getType())){
                rsp.setCompany(cm);
            }else if ("大区".equals(cm.getType())){
                rsp.addArea(cm);
            }
        }

        for (CmContact cm : list) {
            if ("办事处".equals(cm.getType())){
                rsp.addOffice(cm.getArea(), cm);
            }
        }
        return rsp;
    }
}
