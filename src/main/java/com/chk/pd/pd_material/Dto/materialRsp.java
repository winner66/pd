package com.chk.pd.pd_material.Dto;


import lombok.Data;

@Data
public class materialRsp {

    private String filterType;
    //搜索分类
    private String searchType;

    private Integer pdModelId;

    private String std;

    private String quality;

    private String model;

    private Double size;

    private String searchKey;

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

    private Integer materialType;

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
}
