package com.chk.pd.pd_material.Service;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.pd.vo.PdDetailReq;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd.vo.PdInfoRsp;
import com.chk.pd.pd.vo.TreeRsp;
import com.chk.pd.pd_material.Dto.PdMaterialDetailRsp;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
import com.chk.pd.pd_material.domain.PdInfoMaterial;

import java.util.List;


public  interface  pdInfoService {


    List<pdMaterialInfoVo> getPdMaterialInfos(materialRsp pdInfoReq, PageReq pageReq);
    List<PdInfoMaterial> getMaterial();
    List<PdInfoMaterial> List();
    List<TreeRsp> getclz();

    PdMaterialDetailRsp getPdMaterialDetail(PdDetailReq req);
}
