package com.chk.pd.pd_material.dao.dao;

import com.chk.pd.pd_material.dao.ClassMaterialTypeMapper;
import com.chk.pd.pd_material.dao.exmapper.exClassMaterialTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("all")
public class ClassMaterialTypeDao {
    @Autowired
    private exClassMaterialTypeMapper exClassMaterialmapper;
    @Autowired
    private ClassMaterialTypeMapper  ClassMaterialmapper;

    public ClassMaterialTypeMapper getClassMaterialmapper() {
        return ClassMaterialmapper;
    }

    public exClassMaterialTypeMapper getExClassMaterialmapper() {
        return exClassMaterialmapper;
    }
}
