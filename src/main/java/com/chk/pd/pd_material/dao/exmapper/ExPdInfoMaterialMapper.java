package com.chk.pd.pd_material.dao.exmapper;

import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd_material.Dto.materialRsp;
import com.chk.pd.pd_material.Dto.pdMaterialInfoVo;
import com.chk.pd.pd_material.domain.PdInfoMaterial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExPdInfoMaterialMapper {
    List<PdInfoMaterial> List();
    List<PdClass> listLev3Class(@Param("materRsp")materialRsp materRsp);
    List<PdParam> listLengthWidthCode(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listBandwidth(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listFrequencyRange(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listThicknessCode(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listMaterialCode(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listSurfaceCode(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listCenterFrequency(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listCutOffFrequency(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listPassBandRange(@Param("materRsp")materialRsp materRsp);

    List<String> listOutlet(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listSize(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listQuality(@Param("materRsp")materialRsp materRsp);

    List<PdParam> listStd(@Param("materRsp")materialRsp rsp);

    List<PdParam> listPadMetallurgy(@Param("materRsp")materialRsp rsp);

    List<PdParam> listRipple(@Param("materRsp")materialRsp rsp);

    List<PdParam> listPowerCapacity(@Param("materRsp")materialRsp rsp);

    List<PdParam> listModel(@Param("materRsp")materialRsp rsp);

    List<pdMaterialInfoVo> getPdMaterialInfos(@Param("materRsp")materialRsp pdInfoReq);

}
