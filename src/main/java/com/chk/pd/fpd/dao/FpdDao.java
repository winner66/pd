package com.chk.pd.fpd.dao;

import com.chk.pd.fpd.dao.mapper.FpdMapMapper;
import com.chk.pd.fpd.dao.mapper.FpdModelMapper;
import com.chk.pd.fpd.domain.FpdMap;
import com.chk.pd.fpd.domain.FpdMapExample;
import com.chk.pd.fpd.domain.FpdModel;
import com.chk.pd.fpd.domain.FpdModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FpdDao {

    @Autowired
    private FpdModelMapper modelMapper;

    @Autowired
    private FpdMapMapper mapMapper;

    public FpdModelMapper getModelMapper() {
        return modelMapper;
    }

    public FpdMapMapper getMapMapper() {
        return mapMapper;
    }

    public List<FpdMap> getFpdMaps(Long fpdId){
        FpdMapExample exp = new FpdMapExample();
        exp.createCriteria().andFpdModelIdEqualTo(fpdId);
        return mapMapper.selectByExample(exp);
    }

    public List<FpdModel> getFpdModels(){
        FpdModelExample exp = new FpdModelExample();
        exp.setOrderByClause("idx asc");
        return modelMapper.selectByExample(exp);
    }

    public FpdModel getFpdModel(String model){
        FpdModelExample exp = new FpdModelExample();
        exp.createCriteria().andCodeEqualTo(model);
        List<FpdModel> models = modelMapper.selectByExample(exp);
        return models.size() > 0 ? models.get(0) : null;
    }
}
