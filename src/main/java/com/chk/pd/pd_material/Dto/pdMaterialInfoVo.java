package com.chk.pd.pd_material.Dto;

import com.chk.pd.common.util.OrderRuleUtil;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.vo.PdInfoReq;
import com.chk.pd.pd_material.Enum.materialRuleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
@Data
public class pdMaterialInfoVo {

@JsonIgnore
private PdInfoReq req;

@JsonIgnore
private Long pcId;
@JsonIgnore
private String pcName;

private String pcIcon;

//pd model
@JsonIgnore
private Long pmId;
@JsonIgnore
private String pmName;
@JsonIgnore
private String pmCode;
@JsonIgnore
private String orderRule;
private String title;


private String desc;
//    pd_ material
private Integer id;
@JsonIgnore
private Integer pdModelId;
@JsonIgnore
private String std;
@JsonIgnore
private String quality;
@JsonIgnore
private String model;
@JsonIgnore
private String size;
@JsonIgnore
private String searchKey;
@JsonIgnore
private String surfaceCode;
@JsonIgnore
private String thicknessCode;
@JsonIgnore
private String lengthWidthCode;
@JsonIgnore
private String materialCode;
@JsonIgnore
private String centerFrequency;
@JsonIgnore
private String passBandRange;
@JsonIgnore
private String other;
@JsonIgnore
private String ripple;
@JsonIgnore
private String powerCapacity;
@JsonIgnore
private String vswr;
@JsonIgnore
private String amplitudeBalance;
@JsonIgnore
private String phaseBalance;
@JsonIgnore
private String insertionLoss;
@JsonIgnore
private String isolation;
@JsonIgnore
private String frequencyRange;
@JsonIgnore
private String vswrStopBand;
@JsonIgnore
private String vswrPassBand;
@JsonIgnore
private String stopBandBy20;
@JsonIgnore
private String cutOffFrequency;
@JsonIgnore
private String breakdownVoltage;
@JsonIgnore
private String insulationResistance;
@JsonIgnore
private String flexureStrength;
@JsonIgnore
private String dielectricLossBy20g;
@JsonIgnore
private String dielectricLossBy19g;
@JsonIgnore
private String permittivityBy15g;
@JsonIgnore
private String permittivityBy19g;
@JsonIgnore
private String dielectricStrength;
@JsonIgnore
private String insulationResistanceBy125;
@JsonIgnore
private String insulationResistanceBy25;
@JsonIgnore
private String temperatureAlterationRatio;
@JsonIgnore
private String dielectricLossBy1mhz;
@JsonIgnore
private String permittivity;
@JsonIgnore
private String powderDensity;
@JsonIgnore
private String specificSurfacearea;
@JsonIgnore
private String d90;
@JsonIgnore
private String d50;
@JsonIgnore
private String d10;
@JsonIgnore
private String sinteringTemperature;
@JsonIgnore
private String soakingTime;
@JsonIgnore
private String performance;
@JsonIgnore
private String padMetallurgy;
@JsonIgnore
private String outOfBandRejection1;
@JsonIgnore
private String outOfBandRejection2;
@JsonIgnore
private String outOfBandRejection3;
@JsonIgnore
private String outOfBandRejection4;
@JsonIgnore
private String outOfBandRejection5;
@JsonIgnore
private String materialType;
@JsonIgnore
private String ratedCurrent;
@JsonIgnore
private String bandwidth;
@JsonIgnore
private String stopBandBy40;
@JsonIgnore
private String passBandInsertionLossBy13;
@JsonIgnore
private String passBandInsertionLossBy20typ;
@JsonIgnore
private String materialType2;
@JsonIgnore
private String basisMaterial;
@JsonIgnore
private String outlet;
@JsonIgnore
private String evaluatingScope;
@JsonIgnore
private String appearance;




public String getTitle() {
        return pmName;
        }

//根据数据看， 出现在订货标识中 但是值是null的数据：引出端形式和电容数量
//电容、精度、引出端、引线材质、引线长短是多个取值
public String getDesc() {

        if(!StringUtils.isBlank(orderRule)&&orderRule!=null&&orderRule!=""){
        desc = replace(orderRule, "|", "");
        desc = replace(desc, materialRuleEnum.std.title(), std);
        desc = replace(desc, materialRuleEnum.quality.title(), OrderRuleUtil.getQa(quality));
        desc = replace(desc, materialRuleEnum.bandwidth.title(), bandwidth);
        desc = replace(desc, materialRuleEnum.centerFrequency.title(),centerFrequency  );
        desc = replace(desc, materialRuleEnum.cutOffFrequency.title(),cutOffFrequency );
        desc = replace(desc, materialRuleEnum.CS.title(),materialRuleEnum.CS.value() );
        desc = replace(desc, materialRuleEnum.lengthWidthCode.title(),lengthWidthCode );
//            desc = replace(desc, materialRuleEnum.HK.title(),materialRuleEnum.HK.value() );
        desc = replace(desc, materialRuleEnum.materialCode.title(),materialCode);
        desc = replace(desc, materialRuleEnum.passBandRange2.title(),frequencyRange);
        desc = replace(desc, materialRuleEnum.frequencyRange.title(),frequencyRange );
        desc = replace(desc, materialRuleEnum.passBandRange.title(),passBandRange);
        desc = replace(desc, materialRuleEnum.size.title(),size);
        desc = replace(desc, materialRuleEnum.size1.title(),size);
        desc = replace(desc, materialRuleEnum.surfaceCode.title(),surfaceCode);
        desc = replace(desc, materialRuleEnum.thicknessCode.title(),thicknessCode);
        desc = replace(desc, materialRuleEnum.type.title(),model);
        if (StringUtils.isBlank(outlet)) {
        desc = replace(desc, "-" + ParamType.outlet.value(), "");
        desc = replace(desc, ParamType.outlet.value(), "");
        } else {
        if (req != null && StringUtils.isNotBlank(req.getOutlet())) {
        desc = replace(desc, ParamType.outlet.value(), req.getOutlet());
        } else {
        desc = replace(desc, ParamType.outlet.value(), buildMuit(outlet));
        }
        }
        }else{
        desc=model;
        }
        return desc;
        }

public String replace(final String text, final String searchString, final String replacement) {
        String replace = replacement == null ? "" : replacement;
        return StringUtils.replace(text, searchString, replace);
        }

private String buildMuit(String name) {
        if (StringUtils.isBlank(name)) {
        return "[]";
        }
        if (StringUtils.contains(name, ";")) {
        return "[" + name + "]";
        }
        return name;
        }
        }
