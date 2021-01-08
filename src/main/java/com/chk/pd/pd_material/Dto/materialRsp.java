package com.chk.pd.pd_material.Dto;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

@Data
public class materialRsp {

    private String filterType;
    //搜索分类
    private String clzqa;

    private Integer pdModelId;

    private String std;

    private String quality;

    private String model;

    private String size;

    private String key;

    private String surfaceCode;

    private String thicknessCode;

    private String lengthWidthCode;

    private String materialCode;

    private String centerFrequency;

    private String passBandRange;

    private String other;

    private String ripple;

    private String powerCapacity;

    private String vswr;

    private String amplitudeBalance;

    private String phaseBalance;

    private String insertionLoss;

    private String isolation;

    private String frequencyRange;

    private String vswrStopBand;

    private String vswrPassBand;

    private String stopBandBy20;

    private String cutOffFrequency;

    private String breakdownVoltage;

    private String insulationResistance;

    private String flexureStrength;

    private String dielectricLossBy20g;

    private String dielectricLossBy19g;

    private String permittivityBy15g;

    private String permittivityBy19g;

    private String dielectricStrength;

    private String insulationResistanceBy125;

    private String insulationResistanceBy25;

    private String temperatureAlterationRatio;

    private String dielectricLossBy1mhz;

    private String permittivity;

    private String powderDensity;

    private String specificSurfacearea;

    private String d90;

    private String d50;

    private String d10;

    private String sinteringTemperature;

    private String soakingTime;

    private String performance;

    private String padMetallurgy;

    private String outOfBandRejection1;

    private String outOfBandRejection2;

    private String outOfBandRejection3;

    private String outOfBandRejection4;

    private String outOfBandRejection5;

    private String materialType;

    private String ratedCurrent;

    private String bandwidth;

    private String stopBandBy40;

    private String passBandInsertionLossBy13;

    private String passBandInsertionLossBy20typ;

    private String materialType2;

    private String basisMaterial;

    private String outlet;

    private String evaluatingScope;

    private String appearance;
    public boolean isNull() {
        try {
            for (Field f : this.getClass().getDeclaredFields()) {
                if (!f.getName().equals("filterType")) {
                    Object o = f.get(this);
                    if (o != null) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    materialRsp(){

    }


    public materialRsp(String filterType, String clzqa, Integer pdModelId, String std, String quality, String model, String size, String searchKey, String surfaceCode, String thicknessCode, String lengthWidthCode, String materialCode, String centerFrequency, String passBandRange, String other, String ripple, String powerCapacity, String vswr, String amplitudeBalance, String phaseBalance, String insertionLoss, String isolation, String frequencyRange, String vswrStopBand, String vswrPassBand, String stopBandBy20, String cutOffFrequency, String breakdownVoltage, String insulationResistance, String flexureStrength, String dielectricLossBy20g, String dielectricLossBy19g, String permittivityBy15g, String permittivityBy19g, String dielectricStrength, String insulationResistanceBy125, String insulationResistanceBy25, String temperatureAlterationRatio, String dielectricLossBy1mhz, String permittivity, String powderDensity, String specificSurfacearea, String d90, String d50, String d10, String sinteringTemperature, String soakingTime, String performance, String padMetallurgy, String outOfBandRejection1, String outOfBandRejection2, String outOfBandRejection3, String outOfBandRejection4, String outOfBandRejection5,  String ratedCurrent, String bandwidth, String stopBandBy40, String passBandInsertionLossBy13, String passBandInsertionLossBy20typ,  String basisMaterial, String outlet, String evaluatingScope, String appearance) {
        this.filterType = filterType;
        this.clzqa = clzqa;
        this.pdModelId = pdModelId;
        this.std = std;
        this.quality = quality;
        this.model = model;
        this.size = size;
        this.key = searchKey;
        this.surfaceCode = surfaceCode;
        this.thicknessCode = thicknessCode;
        this.lengthWidthCode = lengthWidthCode;
        this.materialCode = materialCode;
        this.centerFrequency = centerFrequency;
        this.passBandRange = passBandRange;
        this.other = other;
        this.ripple = ripple;
        this.powerCapacity = powerCapacity;
        this.vswr = vswr;
        this.amplitudeBalance = amplitudeBalance;
        this.phaseBalance = phaseBalance;
        this.insertionLoss = insertionLoss;
        this.isolation = isolation;
        this.frequencyRange = frequencyRange;
        this.vswrStopBand = vswrStopBand;
        this.vswrPassBand = vswrPassBand;
        this.stopBandBy20 = stopBandBy20;
        this.cutOffFrequency = cutOffFrequency;
        this.breakdownVoltage = breakdownVoltage;
        this.insulationResistance = insulationResistance;
        this.flexureStrength = flexureStrength;
        this.dielectricLossBy20g = dielectricLossBy20g;
        this.dielectricLossBy19g = dielectricLossBy19g;
        this.permittivityBy15g = permittivityBy15g;
        this.permittivityBy19g = permittivityBy19g;
        this.dielectricStrength = dielectricStrength;
        this.insulationResistanceBy125 = insulationResistanceBy125;
        this.insulationResistanceBy25 = insulationResistanceBy25;
        this.temperatureAlterationRatio = temperatureAlterationRatio;
        this.dielectricLossBy1mhz = dielectricLossBy1mhz;
        this.permittivity = permittivity;
        this.powderDensity = powderDensity;
        this.specificSurfacearea = specificSurfacearea;
        this.d90 = d90;
        this.d50 = d50;
        this.d10 = d10;
        this.sinteringTemperature = sinteringTemperature;
        this.soakingTime = soakingTime;
        this.performance = performance;
        this.padMetallurgy = padMetallurgy;
        this.outOfBandRejection1 = outOfBandRejection1;
        this.outOfBandRejection2 = outOfBandRejection2;
        this.outOfBandRejection3 = outOfBandRejection3;
        this.outOfBandRejection4 = outOfBandRejection4;
        this.outOfBandRejection5 = outOfBandRejection5;

        this.ratedCurrent = ratedCurrent;
        this.bandwidth = bandwidth;
        this.stopBandBy40 = stopBandBy40;
        this.passBandInsertionLossBy13 = passBandInsertionLossBy13;
        this.passBandInsertionLossBy20typ = passBandInsertionLossBy20typ;

        this.basisMaterial = basisMaterial;
        this.outlet = outlet;
        this.evaluatingScope = evaluatingScope;
        this.appearance = appearance;

        if(clzqa!=null&& clzqa!=""){
            String  str[]= clzqa.split("_");
            if(str.length>1){
                this.materialType2=str[1];
            }
            this.materialType=str[0];
        }

    }

    public void setClzqa(String clzqa) {
        this.clzqa = clzqa;
        if (StringUtils.isNotBlank(clzqa)){
            if(clzqa!=null&& clzqa!=""){
                String  str[]= clzqa.split("_");
                this.materialType=str[0];
                if(str.length>1){
                    this.materialType2=str[1];
                }

            }
        }
    }

    public void setSize(String size) {
        if (StringUtils.isBlank(size)){
            return;
        }
        String[] s = StringUtils.split(size, "_");
        if (s.length == 2){
            this.size = s[0];
        }else {
            this.size = size;
        }
    }
    public void setBasisMaterial(String basisMaterial) {
        if (StringUtils.isBlank(basisMaterial)){
            return;
        }
        String[] s = StringUtils.split(basisMaterial, "_");
        if (s.length == 2){
            this.basisMaterial = s[0];
        }else {
            this.basisMaterial= basisMaterial;
        }
    }

}
