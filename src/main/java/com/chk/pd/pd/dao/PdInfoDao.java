package com.chk.pd.pd.dao;

import com.chk.pd.pd.dao.extmapper.ExtPdInfoMapper;
import com.chk.pd.pd.dao.mapper.PdInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PdInfoDao {

    @Autowired
    private PdInfoMapper pdInfoMapper;

    @Autowired
    private ExtPdInfoMapper extPdInfoMapper;

    public PdInfoMapper getPdInfoMapper() {
        return pdInfoMapper;
    }

    public ExtPdInfoMapper getExtPdInfoMapper() {
        return extPdInfoMapper;
    }
}
