package com.chk.pd.pd_material.entity;

import lombok.Data;

import java.io.Serializable;
//LBPF


@Data
public class PDHKLBPFInfoEntity implements Serializable {
//   LBPF
     private static final long serialVersionUID = 1L;


    private String pdname;

    private String std;

    private String quality;


    private  String centerFrequency;
    private  String bandwidth;


    private  String size;
    //    插入损耗

    private  String insertionLoss;
    //    带内纹波

    private  String ripple;
    //    带外抑制1
    private  String  outOfBandRejection1;
    //    带外抑制2
    private  String  outOfBandRejection2;
    //    带外抑制3
    private  String  outOfBandRejection3;
    //    带外抑制4
    private  String  outOfBandRejection4;
    //    带外抑制5
    private  String  outOfBandRejection5;
    //    电压驻波比
    private  String  vswr;
}
