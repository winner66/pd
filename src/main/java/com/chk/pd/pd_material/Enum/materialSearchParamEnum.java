package com.chk.pd.pd_material.Enum;

public enum materialSearchParamEnum {

    filterType("filterType","搜索参数类型"),
    std("std","执行标准"),
    clzqa("clzqa","分类"),

    quality("quality","质量等级"),

    model("model",""),

    size("size",""),

    searchKey("searchKey",""),

    surfaceCode("surfaceCode",""),

    thicknessCode("thicknessCode",""),

    lengthWidthCode("lengthWidthCode",""),

    materialCode("materialCode",""),

    centerFrequency("centerFrequency",""),

    passBandRange("passBandRange",""),

    other("other",""),

    ripple("ripple",""),

    powerCapacity("powerCapacity",""),

    vswr("vswr",""),

    amplitudeBalance("amplitudeBalance",""),

    phaseBalance("phaseBalance",""),

    insertionLoss("insertionLoss",""),

    isolation("isolation",""),

    frequencyRange("frequencyRange",""),

    vswrStopBand("vswrStopBand",""),

    vswrPassBand("vswrPassBand",""),

    stopBandBy20("stopBandBy20",""),

    cutOffFrequency("cutOffFrequency",""),

    breakdownVoltage("breakdownVoltage",""),

    insulationResistance("insulationResistance",""),

    flexureStrength("flexureStrength",""),

    dielectricStrength("dielectricStrength",""),


    temperatureAlterationRatio("temperatureAlterationRatio",""),

    dielectricLossBy1mhz("dielectricLossBy1mhz",""),

    permittivity("permittivity",""),

    powderDensity("powderDensity",""),

    specificSurfacearea("specificSurfacearea",""),
    sinteringTemperature("sinteringTemperature",""),

    soakingTime("soakingTime",""),

    performance("performance",""),

    padMetallurgy("padMetallurgy",""),

    materialType("materialType",""),

    ratedCurrent("ratedCurrent",""),

    bandwidth("bandwidth",""),

    stopBandBy40("stopBandBy40",""),

    materialType2("materialType2",""),

    basisMaterial("basisMaterial",""),

    outlet("outlet",""),

    evaluatingScope("evaluatingScope",""),

    appearance("appearance","");

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
