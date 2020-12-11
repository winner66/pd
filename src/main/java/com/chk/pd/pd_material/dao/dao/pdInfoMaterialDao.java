package com.chk.pd.pd_material.dao.dao;

import com.chk.pd.pd_material.dao.PdInfoMaterialMapper;
import com.chk.pd.pd_material.dao.exmapper.exPdInfoMateralMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("all")
public class pdInfoMaterialDao {

    @Autowired
    private PdInfoMaterialMapper materialMapper;


    @Autowired
    private exPdInfoMateralMapper exmaterialMapper;

    public PdInfoMaterialMapper getMaterialMapper() {
        return materialMapper;
    }



    public exPdInfoMateralMapper getExmaterialMapper() {
        return exmaterialMapper;
    }


}
