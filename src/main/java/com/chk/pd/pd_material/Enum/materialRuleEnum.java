package com.chk.pd.pd_material.Enum;

public enum materialRuleEnum {

    std("std","执行标准"),
    quality("quality","质量等级"),
    CS("CS","陶瓷基片"),
    surfaceCode("surfaceCode","表面类型"),
    thicknessCode("thicknessCode","厚度代码"),
    lengthWidthCode("lengthWidthCode","长宽代码"),
    materialCode("materialCode","材料代码"),
    centerFrequency("centerFrequency","中心频率"),
    cutOffFrequency("cutOffFrequency","3dB截止频率"),
    passBandRange2("frequencyRange","通带频率范围"),
    passBandRange("passBandRange","通带范围"),

    size("size","封装及外形尺寸"),
    size1("size","产品尺寸"),
    type("model","产品类别"),
    frequencyRange("frequencyRange","频率范围"),
    bandwidth("bandwidth","带宽");
    private String value;
    private String title;
    materialRuleEnum(String value,String title) {
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
