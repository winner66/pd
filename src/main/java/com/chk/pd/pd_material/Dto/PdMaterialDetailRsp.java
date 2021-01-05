package com.chk.pd.pd_material.Dto;

import com.chk.pd.common.util.OrderRuleUtil;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.pd.vo.CasRsp;
import com.chk.pd.pd.vo.PdDetailReq;
import com.chk.pd.pd.vo.PdDetailRsp;
import com.chk.pd.pd.vo.SelRsp;
import com.chk.pd.pd_material.Enum.materialRuleEnum;
import com.chk.pd.pd_material.domain.PdInfoMaterial;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
@Data
public class PdMaterialDetailRsp {
    private static Logger log = LoggerFactory.getLogger(PdDetailRsp.class);

    private Long id;

    private PdClassVo pdClass = new PdClassVo();

    private PdModelVo pdModel = new PdModelVo();

    private PdInfoVo pdInfo = new PdInfoVo();

    private String rule;
    private String ruleExp;
    private List<String> ruleDesc;

    @SneakyThrows
    public void setRuleExp(PdInfoMaterial pdInfo) {
        String rule = getOrderRule();
        for (materialRuleEnum type : materialRuleEnum.values()) {
            String value = "";
            if("CS".equals(type.value())){
                value="CS";

            }else{
                value = BeanUtils.getProperty(pdInfo, type.value());
                if (value == null){
                    value = "";
                }
                if (value.startsWith(";")) {
                    value = StringUtils.substringAfter(value, ";");
                }
                if (value.contains(";")) {
                    value = StringUtils.substringBefore(value, ";");
                }
            }

            rule = StringUtils.replace(rule, type.title(), value + "||", 1);
//            StringUtils.re
        }
//        rule = OrderRuleUtil.resetSingleModelExp(rule, pdInfo.getModel());
        String[] ss = StringUtils.split(rule, "||");
        for (int i = 0; i < ss.length; i++) {
            ss[i] = OrderRuleUtil.ruleIdxMap.get(i + 1) + "__" + ss[i];
        }
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].contains("__ ")){
                ss[i] = " " + ss[i].replace("__ ", "");
            }
            if (ss[i].contains("__-")){
                ss[i] = "- " + ss[i].replace("__-", "");
            }
            ss[i] = ss[i].replace("__", "");
            ss[i] += " ";
        }
        this.ruleExp = StringUtils.join(ss, "");
    }

    public void setRuleDesc(){
        String rule = getOrderRule();
        String[] ss = OrderRuleUtil.getMaterialRuleDesc(rule);
        this.ruleDesc = Arrays.asList(ss);
    }

    private String getOrderRule() {
        String orderRule = this.getPdModel().getOrderRule();
        String[] s = StringUtils.split(orderRule, "__");
        if (s.length == 2) {
            if (StringUtils.isNotBlank(this.getPdInfo().getOutlet())) {
                orderRule = s[0];
            }
        }
        orderRule = replace(orderRule, "|", "");
        if (StringUtils.isBlank(this.pdInfo.getOutlet())) {
            orderRule = replace(orderRule, "-" + ParamType.outlet.value(), "");
            orderRule = replace(orderRule, ParamType.outlet.value(), "");
        }

        return orderRule;
    }

    public void setRule(PdInfoMaterial pdInfo, PdDetailReq req) {
        String rule = getOrderRule();
        String pdrule = replace(rule, "|", "");

            pdrule = replace(pdrule, "|", "");
            pdrule = replace(pdrule, materialRuleEnum.std.title(), pdInfo.getStd());
            pdrule = replace(pdrule, materialRuleEnum.quality.title(), OrderRuleUtil.getQa(pdInfo.getQuality()));
            pdrule = replace(pdrule, materialRuleEnum.bandwidth.title(), pdInfo.getBandwidth());
            pdrule = replace(pdrule, materialRuleEnum.centerFrequency.title(), pdInfo.getCenterFrequency());
            pdrule = replace(pdrule, materialRuleEnum.cutOffFrequency.title(),pdInfo.getCutOffFrequency() );
            pdrule = replace(pdrule, materialRuleEnum.CS.title(),materialRuleEnum.CS.value() );
            pdrule = replace(pdrule, materialRuleEnum.lengthWidthCode.title(),pdInfo.getLengthWidthCode() );
//            pdrule = replace(pdrule, materialRuleEnum.HK.title(),materialRuleEnum.HK.value() );
            pdrule = replace(pdrule, materialRuleEnum.materialCode.title(),pdInfo.getMaterialCode());
//            1850～2200   1850M/2200M  DC~80---
            pdrule = replace(pdrule, materialRuleEnum.passBandRange.title(),pdInfo.getPassBandRange());
//            通带频率范围
            pdrule = replace(pdrule, materialRuleEnum.passBandRange2.title(),pdInfo.getFrequencyRange());
//            频率范围
             pdrule = replace(pdrule, materialRuleEnum.frequencyRange.title(),pdInfo.getFrequencyRange() );
            pdrule = replace(pdrule, materialRuleEnum.type.title(),pdInfo.getModel());
            pdrule = replace(pdrule, materialRuleEnum.surfaceCode.title(),pdInfo.getSurfaceCode());
            pdrule = replace(pdrule, materialRuleEnum.thicknessCode.title(),pdInfo.getThicknessCode());
            pdrule = replace(pdrule, materialRuleEnum.size1.title(),pdInfo.getSize());
            this.rule = pdrule;
    }

    public String replace(final String text, final String searchString, final String replacement) {
        String replace = replacement == null ? "" : replacement;
        return StringUtils.replace(text, searchString, replace);
    }

    public PdMaterialDetailRsp() {
    }

    public PdMaterialDetailRsp(PdClass pdClass, PdModel pdModel, PdInfoMaterial  pdInfo, PdParam size, PdParam quality,  PdDetailReq req) {
        try {
            pdInfo.setQuality(OrderRuleUtil.getQa(pdInfo.getQuality()));
            BeanUtils.copyProperties(this.pdClass, pdClass);
            BeanUtils.copyProperties(this.pdModel, pdModel);
            BeanUtils.copyProperties(this.pdInfo, pdInfo);
            this.id = Long.valueOf(pdInfo.getId().toString());
            this.pdModel.setCode(this.pdInfo.getModel());
            this.pdModel.setCompany("宏科");

            if (StringUtils.isNotBlank(this.pdModel.getObjectUrl())) {
                String[] urls = StringUtils.split(this.pdModel.getObjectUrl(), ",");
                this.pdModel.getObjectUrls().addAll(Arrays.asList(urls));
            }

            this.pdInfo.setSizeDesc(size == null ? "" : size.getName() == null ? "" : size.getName().replace("|", "\n"));
//            this.pdInfo.setS

            if (StringUtils.isNotBlank(this.pdInfo.getQuality())) {
                if (!"国军标".equals(this.pdInfo.getQuality())){
                    this.pdInfo.setQuality(String.format(this.pdInfo.getQuality() + "[%s]", quality == null ? "" : quality.getName() == null ? "" : quality.getName()));
                }
            }
            this.setRule(pdInfo, req);
            this.setRuleExp(pdInfo);
            this.setRuleDesc();
        } catch (Exception e) {
            log.error("创建PdDetailRsp出错", e);
        }
    }





    @Data
    public class PdClassVo {
        private String name;
    }

    @Data
    public class PdModelVo {

        private String name;

        private String code;

        private String voltage;

        private String ohm;

        private String tan;

        private String otherParam;

        private String purpose;

        private String feature;

        private String contact;

        private String phone;

        private String orderRule;

        private String manualUrl;

        private String sizeUrl;

        private String orderRuleUrl;

        //        实物照片
        private String objectUrl;
        //        特性曲线图
        private String chartUrl;

        private String company;

        private List<String> objectUrls = new ArrayList<>();
    }

    @Data
    public class PdInfoVo {

        //尺寸描述
        private String sizeDesc;

        private Integer id;
        private Integer pdModelId;

        private String std;

        private String quality;

        private String model;

        private String size;

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
    }
}
