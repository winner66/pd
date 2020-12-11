package com.chk.pd.pd_material.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PDSizingMaterialInfoEntity   extends baseMaterialEntiey implements Serializable  {
 //    浆料
 private static final long serialVersionUID = 1L;
//    产品型号
    private String pdname;
//    金属成分
    private String padMetallurgy;
    //    烧结温度
    private String sinteringTemperature;

//适配基体材料
    private String basis_material;
//    类别
    private String  sizingMaterialType;



}
