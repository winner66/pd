package com.chk.pd.pd_material.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class PDHKJBPFInfoEntity extends baseMaterialEntiey implements Serializable {

    private static final long serialVersionUID = 1L;


    private String pdname;

    private  String centerFrequency;
    private  String bandwidth;
    //    插入损耗
    private  String insertionLoss;
    //    带内纹波
    private  String ripple;

    private  String size;


    //    带外抑制1
    private  String  outOfBandRejection1;
    //    带外抑制2
    private  String  outOfBandRejection2;
    //    带外抑制3
    private  String  outOfBandRejection3;

    //    电压驻波比
    private  String  vswr;

//    分类
    private  String  hkJBPFType;
    private  String  hkJBPFTypeName;
//    外形
    private  String appearance;
//    指标范围
    private  String evaluatingScope;
//    、引出形式
    private  String outlet;

    public String getHkJBPFTypeName() {
        return hkJBPFTypeName;
    }

    public void setHkJBPFTypeName(String hkJBPFTypeName) {
        this.hkJBPFTypeName = hkJBPFTypeName;
    }
}
