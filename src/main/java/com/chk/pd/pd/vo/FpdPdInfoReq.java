package com.chk.pd.pd.vo;

import lombok.Data;

import java.util.List;


@Data
public class FpdPdInfoReq {
    private String filterType;
    private List<String> clzqa;
    private Long clz;
    private List<String> qas;
    private List<String> key;
    private List<String> cm;
    private List<String> modelCode;
    private List<String> quality;
    private List<String> size;
    private List<String> sizeId;
    private List<String> temperature;
    private List<String> voltage;
    private List<String> capacity;
    private List<String> tolerance;
    private List<String> outlet;
    private List<String> capacityCode;
}
