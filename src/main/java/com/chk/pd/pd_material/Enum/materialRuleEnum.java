package com.chk.pd.pd_material.Enum;

public enum materialRuleEnum {

    std("std","执行标准"),
    quality("quality","质量等级"),
    surfaceCode("surfaceCode","陶瓷基片的表面代码"),

    thicknessCode("thicknessCode","陶瓷基片的厚度代码"),

    lengthWidthCode("lengthWidthCode","陶瓷基片的长宽代码"),

    materialCode("materialCode","陶瓷基片的材料代码"),

    centerFrequency("centerFrequency","中心频率"),
    cutOffFrequency("cutOffFrequency","3dB截止频率"),
    passBandRange("passBandRange","通带范围"),
    HK("HK","公司标识"),
    size("size","产品尺寸"),
    type("model","产品类型"),
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
