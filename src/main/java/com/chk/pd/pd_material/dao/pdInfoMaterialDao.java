package com.chk.pd.pd_material.dao;

import com.chk.pd.pd_material.dao.exmapper.ExPdInfoMaterialMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.chk.pd.pd_material.dao.mapper.PdInfoMaterialMapper;

@Repository
@SuppressWarnings("all")
public class pdInfoMaterialDao {

    @Autowired
    private PdInfoMaterialMapper materialMapper;


    @Autowired
    private ExPdInfoMaterialMapper exmaterialMapper;

    public PdInfoMaterialMapper getMaterialMapper() {
        return materialMapper;
    }
    public ExPdInfoMaterialMapper getExmaterialMapper() {
        return exmaterialMapper;
    }

}
