package com.chk.pd.pd_material.Service;

import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.domain.PdInfoMaterial;

import java.util.List;


public  interface  pdInfoService {

    List<PdInfoMaterial> getMaterial();
    List<PdInfoMaterial> List();
    List<TreeRsp> getclz();
}
