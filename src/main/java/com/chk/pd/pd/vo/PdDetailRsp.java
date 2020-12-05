package com.chk.pd.pd.vo;

import com.chk.pd.common.util.OrderRuleUtil;
import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.domain.PdClass;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdParam;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Data
public class PdDetailRsp {

    private static Logger log = LoggerFactory.getLogger(PdDetailRsp.class);

    private Long id;

    private PdClassVo pdClass = new PdClassVo();

    private PdModelVo pdModel = new PdModelVo();

    private PdInfoVo pdInfo = new PdInfoVo();

    private String rule;

    private Boolean selCapacity = false;
    private Boolean selTolerance = false;
    private Boolean selOutlet = false;

    private String ruleExp;
    private List<String> ruleDesc;

    @SneakyThrows
    public void setRuleExp(PdInfo pdInfo, List<PdParam> capacities) {
        String rule = getOrderRule();
        for (ParamType type : ParamType.values()) {
            String value = "";
            if (!type.name().equals("capacity")) {
                value = BeanUtils.getProperty(pdInfo, type.name());
                if (value == null){
                    value = "";
                }
                if (value.startsWith(";")) {
                    value = StringUtils.substringAfter(value, ";");
                }
                if (value.contains(";")) {
                    value = StringUtils.substringBefore(value, ";");
                }
            }else{
                if (capacities.size() > 0){
                    value = capacities.get(0).getCode();
                }
            }
            rule = StringUtils.replace(rule, type.value(), value + "||", 1);
        }
        rule = OrderRuleUtil.resetSingleModelExp(rule, pdInfo.getModel());
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
        String[] ss = OrderRuleUtil.getRuleDesc(rule);
        this.ruleDesc = Arrays.asList(ss);
    }

    private String getOrderRule() {
        String orderRule = this.getPdModel().getOrderRule();
        String[] s = StringUtils.split(orderRule, "__");
        if (s.length == 2) {
            if (StringUtils.isNotBlank(this.getPdInfo().getOutlet())) {
                orderRule = s[0];
            }
            if (StringUtils.isNotBlank(this.getPdInfo().getCapNum())) {
                orderRule = s[1];
            }
        }
        orderRule = replace(orderRule, "|", "");
        if (StringUtils.isBlank(this.pdInfo.getOutlet())) {
            orderRule = replace(orderRule, "-" + ParamType.outlet.value(), "");
            orderRule = replace(orderRule, ParamType.outlet.value(), "");
        }
        if (StringUtils.isBlank(this.pdInfo.getCapNum())) {
            orderRule = replace(orderRule, "-" + ParamType.capNum.value(), "");
            orderRule = replace(orderRule, ParamType.capNum.value(), "");
        }
        return orderRule;
    }

    public void setRule(PdInfo pdInfo, PdDetailReq req) {
        String rule = getOrderRule();
        String pd = replace(rule, "|", "");
        pd = replace(pd, ParamType.quality.value(), pdInfo.getQuality());
        pd = replace(pd, ParamType.std.value(), pdInfo.getStd());
        pd = replace(pd, ParamType.size.value(), pdInfo.getSize());
        pd = replace(pd, ParamType.temperature.value(), pdInfo.getTemperature());
        pd = replace(pd, ParamType.voltage.value(), pdInfo.getVoltage());
        pd = replace(pd, ParamType.model.value(), pdInfo.getModel());
        pd = OrderRuleUtil.resetSingleModel(pd, pdInfo.getModel());
        pd = replace(pd, ParamType.elecCode.value(), pdInfo.getElecCode());
        pd = replace(pd, ParamType.elecType.value(), pdInfo.getElecType());
        pd = replace(pd, ParamType.temperRange.value(), pdInfo.getTemperRange());
        pd = replace(pd, ParamType.capNum.value(), pdInfo.getCapNum());
        pd = replace(pd, ParamType.elecSer.value(), pdInfo.getElecSer());
        pd = replace(pd, ParamType.socStr.value(), pdInfo.getSocStr());
        pd = replace(pd, ParamType.packType.value(), pdInfo.getPackType());

        //以下是需要可搜索可选择的
        if (StringUtils.isNotBlank(req.getCapacityCode())) {
            pd = replace(pd, ParamType.capacity.value(), req.getCapacityCode());
        }
        if (StringUtils.isNotBlank(req.getTolerance())) {
            pd = replace(pd, ParamType.tolerance.value(), req.getTolerance());
        }
        if (StringUtils.isNotBlank(req.getOutlet())) {
            pd = replace(pd, ParamType.outlet.value(), req.getOutlet());
        }
//        pd = replace(pd, ParamType.wireMa.value(), "[" + (wireMa == null ? "" : wireMa) + "]");
//        pd = replace(pd, ParamType.wireSize.value(), "[" + (wireSize == null ? "" : wireSize) + "]");
        this.rule = pd;
    }

    public String replace(final String text, final String searchString, final String replacement) {
        String replace = replacement == null ? "" : replacement;
        return StringUtils.replace(text, searchString, replace);
    }

    public PdDetailRsp() {
    }

    public PdDetailRsp(PdClass pdClass, PdModel pdModel, PdInfo pdInfo, PdParam size, PdParam quality, PdParam temperature, List<PdParam> tolerances, List<PdParam> outlets, List<PdParam> capacities, PdDetailReq req) {
        try {
            pdInfo.setQuality(OrderRuleUtil.getQa(pdInfo.getQuality()));
            BeanUtils.copyProperties(this.pdClass, pdClass);
            BeanUtils.copyProperties(this.pdModel, pdModel);
            BeanUtils.copyProperties(this.pdInfo, pdInfo);
            this.id = pdInfo.getId();
            this.pdModel.setCode(this.pdInfo.getModel());
            this.pdModel.setCompany("宏科");

//            if (StringUtils.isNotBlank(this.pdModel.getOrderRuleUrl())) {
//                String[] urls = StringUtils.split(this.pdModel.getOrderRuleUrl(), ",");
//                //单层芯片有两种订货标识
//                String[] s = StringUtils.split(this.pdModel.getOrderRule(), "__");
//                if (s.length == 2 && urls.length >= 2) {
//                    if (StringUtils.isNotBlank(this.getPdInfo().getOutlet())) {
//                        this.pdModel.getObjectUrls().add(urls[0]);
//                    }
//                    if (StringUtils.isNotBlank(this.getPdInfo().getCapNum())) {
//                        this.pdModel.getObjectUrls().add(urls[1]);
//                    }
//                }else {
//                    this.pdModel.getObjectUrls().addAll(Arrays.asList(urls));
//                }
//            }
            if (StringUtils.isNotBlank(this.pdModel.getObjectUrl())) {
                String[] urls = StringUtils.split(this.pdModel.getObjectUrl(), ",");
                this.pdModel.getObjectUrls().addAll(Arrays.asList(urls));
            }

            this.pdInfo.setSizeDesc(size == null ? "" : size.getName() == null ? "" : size.getName().replace("|", "\n"));

            if (StringUtils.isNotBlank(this.pdInfo.getQuality())) {
                if (!"国军标".equals(this.pdInfo.getQuality())){
                    this.pdInfo.setQuality(String.format(this.pdInfo.getQuality() + "[%s]", quality == null ? "" : quality.getName() == null ? "" : quality.getName()));
                }
            }
            if (StringUtils.isNotBlank(this.pdInfo.getTemperature())) {
                this.pdInfo.setTemperature(String.format(this.pdInfo.getTemperature() + "[%s]", temperature == null ? "" : temperature.getName() == null ? "" : temperature.getName()));
            }
            setVoltage();
            setTolerance(tolerances, req);
            setOutlet(outlets, req);
            setCapacity(capacities, req);
            setWireMa();
            setWireSize();
            setPin();
            this.setRule(pdInfo, req);

            this.setRuleExp(pdInfo, capacities);
            this.setRuleDesc();

//            CasRsp casRsp = this.pdInfo.getCapacities().get(0);
//            CasRsp c = casRsp.getChildren().get(0);
//            casRsp.getChildren().clear();
//            casRsp.getChildren().add(c);
//            this.pdInfo.getCapacities().clear();
//            this.pdInfo.getCapacities().add(casRsp);
//
//            SelRsp selRsp = this.pdInfo.getTolerances().get(0);
//            this.pdInfo.getTolerances().clear();
//            this.pdInfo.getTolerances().add(selRsp);
//
//            SelRsp selRsp1 = this.pdInfo.getOutlets().get(0);
//            this.pdInfo.getOutlets().clear();
//            this.pdInfo.getOutlets().add(selRsp1);

        } catch (Exception e) {
            log.error("创建PdDetailRsp出错", e);
        }
    }

    private void setPin() {
        if (StringUtils.isNotBlank(this.pdInfo.getPin())) {
            String[] ss = StringUtils.split(this.pdInfo.getPin(), ";");
            for (String s : ss) {
                this.pdInfo.getPins().add(new SelRsp(s, s));
            }
        }
    }

    private void setWireMa() {
        if (StringUtils.isNotBlank(this.pdInfo.getWireMa())) {
            String[] ss = StringUtils.split(this.pdInfo.getWireMa(), ";");
            for (String s : ss) {
                this.pdInfo.getWireMas().add(new SelRsp(s, s));
            }
        }
    }

    private void setWireSize() {
        if (StringUtils.isNotBlank(this.pdInfo.getWireSize())) {
            String[] ss = StringUtils.split(this.pdInfo.getWireSize(), ";");
            for (String s : ss) {
                this.pdInfo.getWireSizes().add(new SelRsp(s, s));
            }
        }
    }

    private void setCapacity(List<PdParam> capacities, PdDetailReq req) {
        if (StringUtils.isNotBlank(req.getCapacityCode())) {
            String name = "";
            for (PdParam capacity : capacities) {
                if (capacity.getCode().equals(req.getCapacityCode())) {
                    name = capacity.getGp();
                }
            }
            this.pdInfo.setCapacity(req.getCapacityCode() + "[" + name + "]");
        } else {
//                for (PdParam capacity : capacities) {
//                    this.pdInfo.getCapacities().add(new SelRsp(capacity.getCode() + "[" + capacity.getGp() + "]", capacity.getCode()));
//                }
            if (capacities.size() > 0) {
                this.selCapacity = true;
            }
            Map<String, List<PdParam>> map = new HashMap<>();
            for (PdParam capacity : capacities) {
                List<PdParam> pdParams = map.get(capacity.getGp());
                if (pdParams == null) {
                    pdParams = new ArrayList<>();
                    map.put(capacity.getGp(), pdParams);
                }
                pdParams.add(capacity);
            }
            for (Map.Entry<String, List<PdParam>> entry : map.entrySet()) {
                String gp = entry.getKey();
                List<PdParam> ps = entry.getValue();
                CasRsp cas = new CasRsp(gp, gp, true);
                for (PdParam p : ps) {
                    //这里用code作为value方便些
                    cas.getChildren().add(new CasRsp(p.getCode(), p.getCode(), false));
                }
                this.pdInfo.getCapacities().add(cas);
            }
        }
    }

    private void setOutlet(List<PdParam> outlets, PdDetailReq req) {
        if (StringUtils.isNotBlank(req.getOutlet())) {
            String name = "";
            for (PdParam outlet : outlets) {
                if (outlet.getCode().equals(req.getOutlet())) {
                    name = outlet.getName();
                    break;
                }
            }
            this.pdInfo.setOutlet(req.getOutlet() + "[" + name + "]");
        } else {
            if (outlets.size() > 0){
                this.selOutlet = true;
            }
            for (PdParam outlet : outlets) {
                this.pdInfo.getOutlets().add(new SelRsp(outlet.getCode() + "[" + (outlet.getName() == null ? "" : outlet.getName()) + "]", outlet.getCode()));
            }
        }
    }

    private void setTolerance(List<PdParam> tolerances, PdDetailReq req) {
        //之前选了参数值，不需要选择
        if (StringUtils.isNotBlank(req.getTolerance())) {
            String name = "";
            for (PdParam tolerance : tolerances) {
                if (tolerance.getCode().equals(req.getTolerance())) {
                    name = tolerance.getName();
                    break;
                }
            }
            this.pdInfo.setTolerance(req.getTolerance() + "[" + name + "]");
        } else {
            if (tolerances.size() > 0){
                this.selTolerance = true;
            }
            for (PdParam tolerance : tolerances) {
                this.pdInfo.getTolerances().add(new SelRsp(tolerance.getCode() + "[" + (tolerance.getName() == null ? "" : tolerance.getName()) + "]", tolerance.getCode()));
            }
        }
    }

    private void setVoltage() {
        if ("0".equals(this.pdInfo.getVoltage())) {
            this.pdInfo.setVoltage("0[50V]");
        }
        if ("1".equals(this.pdInfo.getVoltage())) {
            this.pdInfo.setVoltage("1[100V]");
        }
        if ("10".equals(this.pdInfo.getVoltage())) {
            this.pdInfo.setVoltage("10[100V]");
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
        //型号
        private String model;
        //执行标准
        private String std;
        //质量等级
        private String quality;
        //尺寸
        private String size;
        //尺寸描述
        private String sizeDesc;

        private String temperature;
        //电压
        private String voltage;
        //        容量
        private String capacity;

        private String capacityMin;

        private String capacityMax;
        //        精度偏差
        private String tolerance;
        //      引出端形式
        private String outlet;
        //电极材料代码
        private String elecCode;
        //电容数量
        private String capNum;
        //电路形式
        private String elecType;
        //        工作温度范围
        private String temperRange;
        //        引线材质
        private String wireMa;
        ///引线长短
        private String wireSize;
        //        电流系列
        private String elecSer;
        //端头结构
        private String socStr;
        //包装方式
        private String packType;
        //引脚形状
        private String pin;

        private List<CasRsp> capacities = new ArrayList<>();

        private List<SelRsp> tolerances = new ArrayList<>();

        private List<SelRsp> outlets = new ArrayList<>();

        private List<SelRsp> wireMas = new ArrayList<>();

        private List<SelRsp> wireSizes = new ArrayList<>();

        private List<SelRsp> pins = new ArrayList<>();
    }

}
