package com.chk.pd.pd.dao;

import com.chk.pd.pd.dao.extmapper.ExtPdClassMapper;
import com.chk.pd.pd.dao.mapper.PdClassMapper;
import com.chk.pd.pd.dao.mapper.PdClassQaMapper;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdClassExample;
import com.chk.pd.pd.domain.PdClassQa;
import com.chk.pd.pd.domain.PdClassQaExample;
import com.chk.pd.pd.vo.PdClassQaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PdClassDao {

    @Autowired
    private PdClassMapper pdClassMapper;

    @Autowired
    private PdClassQaMapper qaMapper;

    @Autowired
    private ExtPdClassMapper extClassMapper;

    public PdClassMapper getPdClassMapper() {
        return pdClassMapper;
    }

    public PdClassQaMapper getQaMapper() {
        return qaMapper;
    }

    public ExtPdClassMapper getExtClassMapper() {
        return extClassMapper;
    }

    public List<PdClass> getPdClasses(Integer level){
        PdClassExample exp = new PdClassExample();
        PdClassExample.Criteria criteria = exp.createCriteria();
        if (level != null){
            criteria.andLevelEqualTo(level);
        }
        exp.setOrderByClause("idx limit 0, 1000");
        List<PdClass> pdClasses = pdClassMapper.selectByExample(exp);
        return pdClasses;
    }
    public void getPdClassById(Integer id){
//        return
    }


}
