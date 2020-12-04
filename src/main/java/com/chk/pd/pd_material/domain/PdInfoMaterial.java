package com.chk.pd.pd_material.domain;

import java.io.Serializable;

public class PdInfoMaterial implements Serializable {
    private Integer id;

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

    private String stopBand;

    private String cutOffFrequency;

    private String passBandInsertionLoss;

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

    private Integer material;

    private String pdName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPdModelId() {
        return pdModelId;
    }

    public void setPdModelId(Integer pdModelId) {
        this.pdModelId = pdModelId;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std == null ? null : std.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public String getSurfaceCode() {
        return surfaceCode;
    }

    public void setSurfaceCode(String surfaceCode) {
        this.surfaceCode = surfaceCode == null ? null : surfaceCode.trim();
    }

    public String getThicknessCode() {
        return thicknessCode;
    }

    public void setThicknessCode(String thicknessCode) {
        this.thicknessCode = thicknessCode == null ? null : thicknessCode.trim();
    }

    public String getLengthWidthCode() {
        return lengthWidthCode;
    }

    public void setLengthWidthCode(String lengthWidthCode) {
        this.lengthWidthCode = lengthWidthCode == null ? null : lengthWidthCode.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public String getCenterFrequency() {
        return centerFrequency;
    }

    public void setCenterFrequency(String centerFrequency) {
        this.centerFrequency = centerFrequency == null ? null : centerFrequency.trim();
    }

    public String getPassBandRange() {
        return passBandRange;
    }

    public void setPassBandRange(String passBandRange) {
        this.passBandRange = passBandRange == null ? null : passBandRange.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getRipple() {
        return ripple;
    }

    public void setRipple(String ripple) {
        this.ripple = ripple == null ? null : ripple.trim();
    }

    public String getPowerCapacity() {
        return powerCapacity;
    }

    public void setPowerCapacity(String powerCapacity) {
        this.powerCapacity = powerCapacity == null ? null : powerCapacity.trim();
    }

    public String getVswr() {
        return vswr;
    }

    public void setVswr(String vswr) {
        this.vswr = vswr == null ? null : vswr.trim();
    }

    public String getAmplitudeBalance() {
        return amplitudeBalance;
    }

    public void setAmplitudeBalance(String amplitudeBalance) {
        this.amplitudeBalance = amplitudeBalance == null ? null : amplitudeBalance.trim();
    }

    public String getPhaseBalance() {
        return phaseBalance;
    }

    public void setPhaseBalance(String phaseBalance) {
        this.phaseBalance = phaseBalance == null ? null : phaseBalance.trim();
    }

    public String getInsertionLoss() {
        return insertionLoss;
    }

    public void setInsertionLoss(String insertionLoss) {
        this.insertionLoss = insertionLoss == null ? null : insertionLoss.trim();
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation == null ? null : isolation.trim();
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange == null ? null : frequencyRange.trim();
    }

    public String getVswrStopBand() {
        return vswrStopBand;
    }

    public void setVswrStopBand(String vswrStopBand) {
        this.vswrStopBand = vswrStopBand == null ? null : vswrStopBand.trim();
    }

    public String getVswrPassBand() {
        return vswrPassBand;
    }

    public void setVswrPassBand(String vswrPassBand) {
        this.vswrPassBand = vswrPassBand == null ? null : vswrPassBand.trim();
    }

    public String getStopBand() {
        return stopBand;
    }

    public void setStopBand(String stopBand) {
        this.stopBand = stopBand == null ? null : stopBand.trim();
    }

    public String getCutOffFrequency() {
        return cutOffFrequency;
    }

    public void setCutOffFrequency(String cutOffFrequency) {
        this.cutOffFrequency = cutOffFrequency == null ? null : cutOffFrequency.trim();
    }

    public String getPassBandInsertionLoss() {
        return passBandInsertionLoss;
    }

    public void setPassBandInsertionLoss(String passBandInsertionLoss) {
        this.passBandInsertionLoss = passBandInsertionLoss == null ? null : passBandInsertionLoss.trim();
    }

    public String getBreakdownVoltage() {
        return breakdownVoltage;
    }

    public void setBreakdownVoltage(String breakdownVoltage) {
        this.breakdownVoltage = breakdownVoltage == null ? null : breakdownVoltage.trim();
    }

    public String getInsulationResistance() {
        return insulationResistance;
    }

    public void setInsulationResistance(String insulationResistance) {
        this.insulationResistance = insulationResistance == null ? null : insulationResistance.trim();
    }

    public String getFlexureStrength() {
        return flexureStrength;
    }

    public void setFlexureStrength(String flexureStrength) {
        this.flexureStrength = flexureStrength == null ? null : flexureStrength.trim();
    }

    public String getDielectricLossBy20g() {
        return dielectricLossBy20g;
    }

    public void setDielectricLossBy20g(String dielectricLossBy20g) {
        this.dielectricLossBy20g = dielectricLossBy20g == null ? null : dielectricLossBy20g.trim();
    }

    public String getDielectricLossBy19g() {
        return dielectricLossBy19g;
    }

    public void setDielectricLossBy19g(String dielectricLossBy19g) {
        this.dielectricLossBy19g = dielectricLossBy19g == null ? null : dielectricLossBy19g.trim();
    }

    public String getPermittivityBy15g() {
        return permittivityBy15g;
    }

    public void setPermittivityBy15g(String permittivityBy15g) {
        this.permittivityBy15g = permittivityBy15g == null ? null : permittivityBy15g.trim();
    }

    public String getPermittivityBy19g() {
        return permittivityBy19g;
    }

    public void setPermittivityBy19g(String permittivityBy19g) {
        this.permittivityBy19g = permittivityBy19g == null ? null : permittivityBy19g.trim();
    }

    public String getDielectricStrength() {
        return dielectricStrength;
    }

    public void setDielectricStrength(String dielectricStrength) {
        this.dielectricStrength = dielectricStrength == null ? null : dielectricStrength.trim();
    }

    public String getInsulationResistanceBy125() {
        return insulationResistanceBy125;
    }

    public void setInsulationResistanceBy125(String insulationResistanceBy125) {
        this.insulationResistanceBy125 = insulationResistanceBy125 == null ? null : insulationResistanceBy125.trim();
    }

    public String getInsulationResistanceBy25() {
        return insulationResistanceBy25;
    }

    public void setInsulationResistanceBy25(String insulationResistanceBy25) {
        this.insulationResistanceBy25 = insulationResistanceBy25 == null ? null : insulationResistanceBy25.trim();
    }

    public String getTemperatureAlterationRatio() {
        return temperatureAlterationRatio;
    }

    public void setTemperatureAlterationRatio(String temperatureAlterationRatio) {
        this.temperatureAlterationRatio = temperatureAlterationRatio == null ? null : temperatureAlterationRatio.trim();
    }

    public String getDielectricLossBy1mhz() {
        return dielectricLossBy1mhz;
    }

    public void setDielectricLossBy1mhz(String dielectricLossBy1mhz) {
        this.dielectricLossBy1mhz = dielectricLossBy1mhz == null ? null : dielectricLossBy1mhz.trim();
    }

    public String getPermittivity() {
        return permittivity;
    }

    public void setPermittivity(String permittivity) {
        this.permittivity = permittivity == null ? null : permittivity.trim();
    }

    public String getPowderDensity() {
        return powderDensity;
    }

    public void setPowderDensity(String powderDensity) {
        this.powderDensity = powderDensity == null ? null : powderDensity.trim();
    }

    public String getSpecificSurfacearea() {
        return specificSurfacearea;
    }

    public void setSpecificSurfacearea(String specificSurfacearea) {
        this.specificSurfacearea = specificSurfacearea == null ? null : specificSurfacearea.trim();
    }

    public String getD90() {
        return d90;
    }

    public void setD90(String d90) {
        this.d90 = d90 == null ? null : d90.trim();
    }

    public String getD50() {
        return d50;
    }

    public void setD50(String d50) {
        this.d50 = d50 == null ? null : d50.trim();
    }

    public String getD10() {
        return d10;
    }

    public void setD10(String d10) {
        this.d10 = d10 == null ? null : d10.trim();
    }

    public String getSinteringTemperature() {
        return sinteringTemperature;
    }

    public void setSinteringTemperature(String sinteringTemperature) {
        this.sinteringTemperature = sinteringTemperature == null ? null : sinteringTemperature.trim();
    }

    public String getSoakingTime() {
        return soakingTime;
    }

    public void setSoakingTime(String soakingTime) {
        this.soakingTime = soakingTime == null ? null : soakingTime.trim();
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance == null ? null : performance.trim();
    }

    public String getPadMetallurgy() {
        return padMetallurgy;
    }

    public void setPadMetallurgy(String padMetallurgy) {
        this.padMetallurgy = padMetallurgy == null ? null : padMetallurgy.trim();
    }

    public String getOutOfBandRejection1() {
        return outOfBandRejection1;
    }

    public void setOutOfBandRejection1(String outOfBandRejection1) {
        this.outOfBandRejection1 = outOfBandRejection1 == null ? null : outOfBandRejection1.trim();
    }

    public String getOutOfBandRejection2() {
        return outOfBandRejection2;
    }

    public void setOutOfBandRejection2(String outOfBandRejection2) {
        this.outOfBandRejection2 = outOfBandRejection2 == null ? null : outOfBandRejection2.trim();
    }

    public String getOutOfBandRejection3() {
        return outOfBandRejection3;
    }

    public void setOutOfBandRejection3(String outOfBandRejection3) {
        this.outOfBandRejection3 = outOfBandRejection3 == null ? null : outOfBandRejection3.trim();
    }

    public String getOutOfBandRejection4() {
        return outOfBandRejection4;
    }

    public void setOutOfBandRejection4(String outOfBandRejection4) {
        this.outOfBandRejection4 = outOfBandRejection4 == null ? null : outOfBandRejection4.trim();
    }

    public String getOutOfBandRejection5() {
        return outOfBandRejection5;
    }

    public void setOutOfBandRejection5(String outOfBandRejection5) {
        this.outOfBandRejection5 = outOfBandRejection5 == null ? null : outOfBandRejection5.trim();
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName == null ? null : pdName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pdModelId=").append(pdModelId);
        sb.append(", std=").append(std);
        sb.append(", quality=").append(quality);
        sb.append(", model=").append(model);
        sb.append(", size=").append(size);
        sb.append(", searchKey=").append(searchKey);
        sb.append(", surfaceCode=").append(surfaceCode);
        sb.append(", thicknessCode=").append(thicknessCode);
        sb.append(", lengthWidthCode=").append(lengthWidthCode);
        sb.append(", materialCode=").append(materialCode);
        sb.append(", centerFrequency=").append(centerFrequency);
        sb.append(", passBandRange=").append(passBandRange);
        sb.append(", other=").append(other);
        sb.append(", ripple=").append(ripple);
        sb.append(", powerCapacity=").append(powerCapacity);
        sb.append(", vswr=").append(vswr);
        sb.append(", amplitudeBalance=").append(amplitudeBalance);
        sb.append(", phaseBalance=").append(phaseBalance);
        sb.append(", insertionLoss=").append(insertionLoss);
        sb.append(", isolation=").append(isolation);
        sb.append(", frequencyRange=").append(frequencyRange);
        sb.append(", vswrStopBand=").append(vswrStopBand);
        sb.append(", vswrPassBand=").append(vswrPassBand);
        sb.append(", stopBand=").append(stopBand);
        sb.append(", cutOffFrequency=").append(cutOffFrequency);
        sb.append(", passBandInsertionLoss=").append(passBandInsertionLoss);
        sb.append(", breakdownVoltage=").append(breakdownVoltage);
        sb.append(", insulationResistance=").append(insulationResistance);
        sb.append(", flexureStrength=").append(flexureStrength);
        sb.append(", dielectricLossBy20g=").append(dielectricLossBy20g);
        sb.append(", dielectricLossBy19g=").append(dielectricLossBy19g);
        sb.append(", permittivityBy15g=").append(permittivityBy15g);
        sb.append(", permittivityBy19g=").append(permittivityBy19g);
        sb.append(", dielectricStrength=").append(dielectricStrength);
        sb.append(", insulationResistanceBy125=").append(insulationResistanceBy125);
        sb.append(", insulationResistanceBy25=").append(insulationResistanceBy25);
        sb.append(", temperatureAlterationRatio=").append(temperatureAlterationRatio);
        sb.append(", dielectricLossBy1mhz=").append(dielectricLossBy1mhz);
        sb.append(", permittivity=").append(permittivity);
        sb.append(", powderDensity=").append(powderDensity);
        sb.append(", specificSurfacearea=").append(specificSurfacearea);
        sb.append(", d90=").append(d90);
        sb.append(", d50=").append(d50);
        sb.append(", d10=").append(d10);
        sb.append(", sinteringTemperature=").append(sinteringTemperature);
        sb.append(", soakingTime=").append(soakingTime);
        sb.append(", performance=").append(performance);
        sb.append(", padMetallurgy=").append(padMetallurgy);
        sb.append(", outOfBandRejection1=").append(outOfBandRejection1);
        sb.append(", outOfBandRejection2=").append(outOfBandRejection2);
        sb.append(", outOfBandRejection3=").append(outOfBandRejection3);
        sb.append(", outOfBandRejection4=").append(outOfBandRejection4);
        sb.append(", outOfBandRejection5=").append(outOfBandRejection5);
        sb.append(", material=").append(material);
        sb.append(", pdName=").append(pdName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PdInfoMaterial other = (PdInfoMaterial) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPdModelId() == null ? other.getPdModelId() == null : this.getPdModelId().equals(other.getPdModelId()))
            && (this.getStd() == null ? other.getStd() == null : this.getStd().equals(other.getStd()))
            && (this.getQuality() == null ? other.getQuality() == null : this.getQuality().equals(other.getQuality()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getSearchKey() == null ? other.getSearchKey() == null : this.getSearchKey().equals(other.getSearchKey()))
            && (this.getSurfaceCode() == null ? other.getSurfaceCode() == null : this.getSurfaceCode().equals(other.getSurfaceCode()))
            && (this.getThicknessCode() == null ? other.getThicknessCode() == null : this.getThicknessCode().equals(other.getThicknessCode()))
            && (this.getLengthWidthCode() == null ? other.getLengthWidthCode() == null : this.getLengthWidthCode().equals(other.getLengthWidthCode()))
            && (this.getMaterialCode() == null ? other.getMaterialCode() == null : this.getMaterialCode().equals(other.getMaterialCode()))
            && (this.getCenterFrequency() == null ? other.getCenterFrequency() == null : this.getCenterFrequency().equals(other.getCenterFrequency()))
            && (this.getPassBandRange() == null ? other.getPassBandRange() == null : this.getPassBandRange().equals(other.getPassBandRange()))
            && (this.getOther() == null ? other.getOther() == null : this.getOther().equals(other.getOther()))
            && (this.getRipple() == null ? other.getRipple() == null : this.getRipple().equals(other.getRipple()))
            && (this.getPowerCapacity() == null ? other.getPowerCapacity() == null : this.getPowerCapacity().equals(other.getPowerCapacity()))
            && (this.getVswr() == null ? other.getVswr() == null : this.getVswr().equals(other.getVswr()))
            && (this.getAmplitudeBalance() == null ? other.getAmplitudeBalance() == null : this.getAmplitudeBalance().equals(other.getAmplitudeBalance()))
            && (this.getPhaseBalance() == null ? other.getPhaseBalance() == null : this.getPhaseBalance().equals(other.getPhaseBalance()))
            && (this.getInsertionLoss() == null ? other.getInsertionLoss() == null : this.getInsertionLoss().equals(other.getInsertionLoss()))
            && (this.getIsolation() == null ? other.getIsolation() == null : this.getIsolation().equals(other.getIsolation()))
            && (this.getFrequencyRange() == null ? other.getFrequencyRange() == null : this.getFrequencyRange().equals(other.getFrequencyRange()))
            && (this.getVswrStopBand() == null ? other.getVswrStopBand() == null : this.getVswrStopBand().equals(other.getVswrStopBand()))
            && (this.getVswrPassBand() == null ? other.getVswrPassBand() == null : this.getVswrPassBand().equals(other.getVswrPassBand()))
            && (this.getStopBand() == null ? other.getStopBand() == null : this.getStopBand().equals(other.getStopBand()))
            && (this.getCutOffFrequency() == null ? other.getCutOffFrequency() == null : this.getCutOffFrequency().equals(other.getCutOffFrequency()))
            && (this.getPassBandInsertionLoss() == null ? other.getPassBandInsertionLoss() == null : this.getPassBandInsertionLoss().equals(other.getPassBandInsertionLoss()))
            && (this.getBreakdownVoltage() == null ? other.getBreakdownVoltage() == null : this.getBreakdownVoltage().equals(other.getBreakdownVoltage()))
            && (this.getInsulationResistance() == null ? other.getInsulationResistance() == null : this.getInsulationResistance().equals(other.getInsulationResistance()))
            && (this.getFlexureStrength() == null ? other.getFlexureStrength() == null : this.getFlexureStrength().equals(other.getFlexureStrength()))
            && (this.getDielectricLossBy20g() == null ? other.getDielectricLossBy20g() == null : this.getDielectricLossBy20g().equals(other.getDielectricLossBy20g()))
            && (this.getDielectricLossBy19g() == null ? other.getDielectricLossBy19g() == null : this.getDielectricLossBy19g().equals(other.getDielectricLossBy19g()))
            && (this.getPermittivityBy15g() == null ? other.getPermittivityBy15g() == null : this.getPermittivityBy15g().equals(other.getPermittivityBy15g()))
            && (this.getPermittivityBy19g() == null ? other.getPermittivityBy19g() == null : this.getPermittivityBy19g().equals(other.getPermittivityBy19g()))
            && (this.getDielectricStrength() == null ? other.getDielectricStrength() == null : this.getDielectricStrength().equals(other.getDielectricStrength()))
            && (this.getInsulationResistanceBy125() == null ? other.getInsulationResistanceBy125() == null : this.getInsulationResistanceBy125().equals(other.getInsulationResistanceBy125()))
            && (this.getInsulationResistanceBy25() == null ? other.getInsulationResistanceBy25() == null : this.getInsulationResistanceBy25().equals(other.getInsulationResistanceBy25()))
            && (this.getTemperatureAlterationRatio() == null ? other.getTemperatureAlterationRatio() == null : this.getTemperatureAlterationRatio().equals(other.getTemperatureAlterationRatio()))
            && (this.getDielectricLossBy1mhz() == null ? other.getDielectricLossBy1mhz() == null : this.getDielectricLossBy1mhz().equals(other.getDielectricLossBy1mhz()))
            && (this.getPermittivity() == null ? other.getPermittivity() == null : this.getPermittivity().equals(other.getPermittivity()))
            && (this.getPowderDensity() == null ? other.getPowderDensity() == null : this.getPowderDensity().equals(other.getPowderDensity()))
            && (this.getSpecificSurfacearea() == null ? other.getSpecificSurfacearea() == null : this.getSpecificSurfacearea().equals(other.getSpecificSurfacearea()))
            && (this.getD90() == null ? other.getD90() == null : this.getD90().equals(other.getD90()))
            && (this.getD50() == null ? other.getD50() == null : this.getD50().equals(other.getD50()))
            && (this.getD10() == null ? other.getD10() == null : this.getD10().equals(other.getD10()))
            && (this.getSinteringTemperature() == null ? other.getSinteringTemperature() == null : this.getSinteringTemperature().equals(other.getSinteringTemperature()))
            && (this.getSoakingTime() == null ? other.getSoakingTime() == null : this.getSoakingTime().equals(other.getSoakingTime()))
            && (this.getPerformance() == null ? other.getPerformance() == null : this.getPerformance().equals(other.getPerformance()))
            && (this.getPadMetallurgy() == null ? other.getPadMetallurgy() == null : this.getPadMetallurgy().equals(other.getPadMetallurgy()))
            && (this.getOutOfBandRejection1() == null ? other.getOutOfBandRejection1() == null : this.getOutOfBandRejection1().equals(other.getOutOfBandRejection1()))
            && (this.getOutOfBandRejection2() == null ? other.getOutOfBandRejection2() == null : this.getOutOfBandRejection2().equals(other.getOutOfBandRejection2()))
            && (this.getOutOfBandRejection3() == null ? other.getOutOfBandRejection3() == null : this.getOutOfBandRejection3().equals(other.getOutOfBandRejection3()))
            && (this.getOutOfBandRejection4() == null ? other.getOutOfBandRejection4() == null : this.getOutOfBandRejection4().equals(other.getOutOfBandRejection4()))
            && (this.getOutOfBandRejection5() == null ? other.getOutOfBandRejection5() == null : this.getOutOfBandRejection5().equals(other.getOutOfBandRejection5()))
            && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
            && (this.getPdName() == null ? other.getPdName() == null : this.getPdName().equals(other.getPdName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdModelId() == null) ? 0 : getPdModelId().hashCode());
        result = prime * result + ((getStd() == null) ? 0 : getStd().hashCode());
        result = prime * result + ((getQuality() == null) ? 0 : getQuality().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getSearchKey() == null) ? 0 : getSearchKey().hashCode());
        result = prime * result + ((getSurfaceCode() == null) ? 0 : getSurfaceCode().hashCode());
        result = prime * result + ((getThicknessCode() == null) ? 0 : getThicknessCode().hashCode());
        result = prime * result + ((getLengthWidthCode() == null) ? 0 : getLengthWidthCode().hashCode());
        result = prime * result + ((getMaterialCode() == null) ? 0 : getMaterialCode().hashCode());
        result = prime * result + ((getCenterFrequency() == null) ? 0 : getCenterFrequency().hashCode());
        result = prime * result + ((getPassBandRange() == null) ? 0 : getPassBandRange().hashCode());
        result = prime * result + ((getOther() == null) ? 0 : getOther().hashCode());
        result = prime * result + ((getRipple() == null) ? 0 : getRipple().hashCode());
        result = prime * result + ((getPowerCapacity() == null) ? 0 : getPowerCapacity().hashCode());
        result = prime * result + ((getVswr() == null) ? 0 : getVswr().hashCode());
        result = prime * result + ((getAmplitudeBalance() == null) ? 0 : getAmplitudeBalance().hashCode());
        result = prime * result + ((getPhaseBalance() == null) ? 0 : getPhaseBalance().hashCode());
        result = prime * result + ((getInsertionLoss() == null) ? 0 : getInsertionLoss().hashCode());
        result = prime * result + ((getIsolation() == null) ? 0 : getIsolation().hashCode());
        result = prime * result + ((getFrequencyRange() == null) ? 0 : getFrequencyRange().hashCode());
        result = prime * result + ((getVswrStopBand() == null) ? 0 : getVswrStopBand().hashCode());
        result = prime * result + ((getVswrPassBand() == null) ? 0 : getVswrPassBand().hashCode());
        result = prime * result + ((getStopBand() == null) ? 0 : getStopBand().hashCode());
        result = prime * result + ((getCutOffFrequency() == null) ? 0 : getCutOffFrequency().hashCode());
        result = prime * result + ((getPassBandInsertionLoss() == null) ? 0 : getPassBandInsertionLoss().hashCode());
        result = prime * result + ((getBreakdownVoltage() == null) ? 0 : getBreakdownVoltage().hashCode());
        result = prime * result + ((getInsulationResistance() == null) ? 0 : getInsulationResistance().hashCode());
        result = prime * result + ((getFlexureStrength() == null) ? 0 : getFlexureStrength().hashCode());
        result = prime * result + ((getDielectricLossBy20g() == null) ? 0 : getDielectricLossBy20g().hashCode());
        result = prime * result + ((getDielectricLossBy19g() == null) ? 0 : getDielectricLossBy19g().hashCode());
        result = prime * result + ((getPermittivityBy15g() == null) ? 0 : getPermittivityBy15g().hashCode());
        result = prime * result + ((getPermittivityBy19g() == null) ? 0 : getPermittivityBy19g().hashCode());
        result = prime * result + ((getDielectricStrength() == null) ? 0 : getDielectricStrength().hashCode());
        result = prime * result + ((getInsulationResistanceBy125() == null) ? 0 : getInsulationResistanceBy125().hashCode());
        result = prime * result + ((getInsulationResistanceBy25() == null) ? 0 : getInsulationResistanceBy25().hashCode());
        result = prime * result + ((getTemperatureAlterationRatio() == null) ? 0 : getTemperatureAlterationRatio().hashCode());
        result = prime * result + ((getDielectricLossBy1mhz() == null) ? 0 : getDielectricLossBy1mhz().hashCode());
        result = prime * result + ((getPermittivity() == null) ? 0 : getPermittivity().hashCode());
        result = prime * result + ((getPowderDensity() == null) ? 0 : getPowderDensity().hashCode());
        result = prime * result + ((getSpecificSurfacearea() == null) ? 0 : getSpecificSurfacearea().hashCode());
        result = prime * result + ((getD90() == null) ? 0 : getD90().hashCode());
        result = prime * result + ((getD50() == null) ? 0 : getD50().hashCode());
        result = prime * result + ((getD10() == null) ? 0 : getD10().hashCode());
        result = prime * result + ((getSinteringTemperature() == null) ? 0 : getSinteringTemperature().hashCode());
        result = prime * result + ((getSoakingTime() == null) ? 0 : getSoakingTime().hashCode());
        result = prime * result + ((getPerformance() == null) ? 0 : getPerformance().hashCode());
        result = prime * result + ((getPadMetallurgy() == null) ? 0 : getPadMetallurgy().hashCode());
        result = prime * result + ((getOutOfBandRejection1() == null) ? 0 : getOutOfBandRejection1().hashCode());
        result = prime * result + ((getOutOfBandRejection2() == null) ? 0 : getOutOfBandRejection2().hashCode());
        result = prime * result + ((getOutOfBandRejection3() == null) ? 0 : getOutOfBandRejection3().hashCode());
        result = prime * result + ((getOutOfBandRejection4() == null) ? 0 : getOutOfBandRejection4().hashCode());
        result = prime * result + ((getOutOfBandRejection5() == null) ? 0 : getOutOfBandRejection5().hashCode());
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getPdName() == null) ? 0 : getPdName().hashCode());
        return result;
    }
}