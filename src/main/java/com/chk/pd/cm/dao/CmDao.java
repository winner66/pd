package com.chk.pd.cm.dao;

import com.chk.pd.cm.dao.mapper.CmContactMapper;
import com.chk.pd.cm.domain.CmContact;
import com.chk.pd.cm.domain.CmContactExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CmDao {
    @Autowired
    private CmContactMapper contactMapper;

    public CmContactMapper getContactMapper() {
        return contactMapper;
    }

    public List<CmContact> listContact() {
        CmContactExample exp = new CmContactExample();
        exp.setOrderByClause("idx asc limit 100");
        return contactMapper.selectByExample(exp);
    }
}
