package com.chk.pd.pd.dao;

import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.dao.extmapper.ExtPdParamMapper;
import com.chk.pd.pd.dao.mapper.PdParamMapper;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.domain.PdParamExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PdParamDao {

    @Autowired
    private PdParamMapper pdParamMapper;

    @Autowired
    private ExtPdParamMapper extPdParamMapper;

    public PdParamMapper getPdParamMapper() {
        return pdParamMapper;
    }

    public ExtPdParamMapper getExtPdParamMapper() {
        return extPdParamMapper;
    }

    public PdParam getSize(String std, String code){
        if (StringUtils.isBlank(std) || StringUtils.isBlank(code)){
            return null;
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andRelEqualTo(std).andCodeEqualTo(code);
        List<PdParam> params = pdParamMapper.selectByExample(exp);
        return params.size() > 0 ? params.get(0) : null;
    }

    public PdParam getPdParam(String type, String code){
        if (code  == null){
            return null;
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type).andCodeEqualTo(code);
        List<PdParam> param = pdParamMapper.selectByExample(exp);
        return param.size() > 0 ? param.get(0) : null;
    }

    public List<PdParam> getPdParam(String type){
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type);
        exp.setOrderByClause("idx asc");
        return pdParamMapper.selectByExample(exp);
    }

    public List<PdParam> getPdParam(String type, List<String> codes){
        if (CollectionUtils.isEmpty(codes)){
            return Collections.emptyList();
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type).andCodeIn(codes);
        exp.setOrderByClause("idx asc");
        return pdParamMapper.selectByExample(exp);
    }

    public List<PdParam> getCapacities(Integer minIdx, Integer maxIdx){
        if (minIdx == null || maxIdx == null){
            return new ArrayList<>();
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(ParamType.capacity.value()).andIdxBetween(minIdx, maxIdx);
        exp.setOrderByClause("idx asc");
        List<PdParam>  params = pdParamMapper.selectByExample(exp);
        return params;

    }

    public List<PdParam> getAll() {
        PdParamExample exp = new PdParamExample();
        List<PdParam> pdParams = pdParamMapper.selectByExample(exp);
        exp.setOrderByClause("idx asc limit 0, 5000");
        return pdParams;

    }

    public List<PdParam> list(String type ,String gp) {
        PdParamExample example = null;
        example.createCriteria().andGpEqualTo(gp);
        example.createCriteria().andTypeEqualTo(type);
        List<PdParam>  list=pdParamMapper.selectByExample(example);

        return  list;
    }

}
