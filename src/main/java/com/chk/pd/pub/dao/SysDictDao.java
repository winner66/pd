package com.chk.pd.pub.dao;

import com.chk.pd.pub.dao.mapper.SysDictMapper;
import com.chk.pd.pub.domain.SysDict;
import com.chk.pd.pub.domain.SysDictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("all")
public class SysDictDao {

    @Autowired
    private SysDictMapper dictMapper;

    public SysDictMapper getDictMapper() {
        return dictMapper;
    }

    public List<SysDict> listByType(String type){
        SysDictExample exp = new SysDictExample();
        exp.createCriteria().andTypeEqualTo(type);
        exp.setOrderByClause("sort asc");
        return dictMapper.selectByExample(exp);
    }

}
