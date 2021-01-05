package com.chk.pd.pd_material.Enum;

public enum materialSearchParamEnum {

    filterType("filterType","搜索参数类型"),
    std("std","执行标准"),
    clzqa("clzqa","分类"),
    quality("quality","质量等级"),

    model("model","产品型号"),

    size("size","封装及外形尺寸"),

    surfaceCode("surfaceCode","陶瓷基片的表面代码"),

    thicknessCode("thicknessCode","陶瓷基片的厚度代码"),

    lengthWidthCode("lengthWidthCode","陶瓷基片的长宽代码"),

    materialCode("materialCode","陶瓷基片的材料代码"),

    centerFrequency("centerFrequency","中心频率"),

    passBandRange("passBandRange","通带范围"),

    other("other","其他要求"),

    ripple("ripple","带内纹波"),

    powerCapacity("powerCapacity","功率容量"),

    vswr("vswr","驻波"),

    amplitudeBalance("amplitudeBalance","幅度平衡度"),

    phaseBalance("phaseBalance","相位平衡度"),

    insertionLoss("insertionLoss","插入损耗"),

    isolation("isolation","隔离度"),

    frequencyRange("frequencyRange","频率范围"),

    vswrStopBand("vswrStopBand","电压驻波比阻带"),

    vswrPassBand("vswrPassBand","电压驻波比通带1.5:1"),

    stopBandBy20("stopBandBy20","阻带损耗(≥20dB）MHz"),

    cutOffFrequency("cutOffFrequency","3dB截止频率"),

    breakdownVoltage("breakdownVoltage","击穿电压"),

    insulationResistance("insulationResistance","绝缘电阻"),

    flexureStrength("flexureStrength","抗弯强度"),

    dielectricStrength("dielectricStrength","绝缘强度"),


    temperatureAlterationRatio("temperatureAlterationRatio","温度变化率"),

    dielectricLossBy1mhz("dielectricLossBy1mhz","介电损耗@1MHZ"),

    permittivity("permittivity","介电常数"),

    powderDensity("powderDensity","粉体密度"),

    specificSurfacearea("specificSurfacearea",""),

    sinteringTemperature("sinteringTemperature",""),

    soakingTime("soakingTime","烧结温度"),

    performance("performance","产品性能"),

    padMetallurgy("padMetallurgy","金属成分"),

    materialType("materialType",""),

    ratedCurrent("ratedCurrent","额定电流"),

    bandwidth("bandwidth","带宽"),

    stopBandBy40("stopBandBy40",""),

    materialType2("materialType2",""),

    basisMaterial("basisMaterial","适配基体材料"),

    outlet("outlet","引出形式"),

    evaluatingScope("evaluatingScope","指标范围"),

    appearance("appearance","外形url");

    private String value;

    private String title;

    materialSearchParamEnum(String value,String title) {
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
