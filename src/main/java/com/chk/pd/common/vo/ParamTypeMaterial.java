package com.chk.pd.common.vo;

public enum ParamTypeMaterial {
    quality("质量等级", "质量等级"),
    std("执行标准","执行标准"),
    size("封装及外形尺寸","尺寸"),
    cutOffFrequency("3dB截止频率","3dB截止频率"),
    bandwidth(" 带宽"," 带宽"),
    centerFrequency("中心频率","中心频率"),
    passBandRange("通带范围","通带范围");

    private String value;

    private String title;

    ParamTypeMaterial(String value,String title) {
        this.value = value;
        this.title = title;
    }

    public String title(){
        return title;
    }

    public String value(){
        return value;
    }
}
