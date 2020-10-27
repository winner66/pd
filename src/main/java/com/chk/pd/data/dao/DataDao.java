package com.chk.pd.data.dao;

import com.chk.pd.data.dao.mapper.DataCollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    @Autowired
    private DataCollectMapper collectMapper;

    public DataCollectMapper getDataCollectMapper() {
        return collectMapper;
    }
}
