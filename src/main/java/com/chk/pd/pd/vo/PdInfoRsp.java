package com.chk.pd.pd.vo;

import com.chk.pd.common.util.OrderRuleUtil;
import com.chk.pd.common.vo.ParamType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class PdInfoRsp {

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

    //pd info
    private Long id;
    @JsonIgnore
    private String model;
    @JsonIgnore
    private String std;
    @JsonIgnore
    private String quality;
    @JsonIgnore
    private String size;
    @JsonIgnore
    private String temperature;
    @JsonIgnore
    private String voltage;
    @JsonIgnore
    private String capacityMin;
    @JsonIgnore
    private String capacityMax;
    @JsonIgnore
    private Integer capacityMinIdx;
    @JsonIgnore
    private Integer capacityMaxIdx;
    @JsonIgnore
    private String tolerance;
    @JsonIgnore
    private String outlet;
    @JsonIgnore
    private String elecCode;
    @JsonIgnore
    private String capNum;
    @JsonIgnore
    private String elecType;
    @JsonIgnore
    private String temperRange;
    @JsonIgnore
    private String wireMa;
    @JsonIgnore
    private String wireSize;
    @JsonIgnore
    private String elecSer;
    @JsonIgnore
    private String socStr;
    @JsonIgnore
    private String packType;
    @JsonIgnore
    private String pin;

    private String title;

    private String desc;

    public String getTitle() {
        return pmName;
    }

    //根据数据看， 出现在订货标识中 但是值是null的数据：引出端形式和电容数量
    //电容、精度、引出端、引线材质、引线长短是多个取值
    public String getDesc() {
        if (StringUtils.isBlank(orderRule)) {
            return "";
        }
        //单层芯片2种订货标识 __ 分割, 一个有引出端， 一个有电容
        String[] s = StringUtils.split(orderRule, "__");
        if (s.length == 2) {
            if (StringUtils.isNotBlank(outlet)) {
                orderRule = s[0];
            }
            if (StringUtils.isNotBlank(capNum)) {
                orderRule = s[1];
            }
        }
        desc = replace(orderRule, "|", "");
        desc = replace(desc, ParamType.std.value(), std);
        desc = replace(desc, ParamType.quality.value(), OrderRuleUtil.getQa(quality));
        desc = replace(desc, ParamType.model.value(), model);
        desc = OrderRuleUtil.resetSingleModel(desc, model);
        desc = replace(desc, ParamType.size.value(), size);
        desc = replace(desc, ParamType.temperature.value(), temperature);
        desc = replace(desc, ParamType.voltage.value(), voltage);

        desc = replace(desc, ParamType.elecCode.value(), elecCode);
        desc = replace(desc, ParamType.elecType.value(), elecType);
        desc = replace(desc, ParamType.temperRange.value(), temperRange);

        desc = replace(desc, ParamType.wireMa.value(), buildMuit(wireMa));
        desc = replace(desc, ParamType.wireSize.value(), buildMuit(wireSize));
        desc = replace(desc, ParamType.elecSer.value(), elecSer);
        desc = replace(desc, ParamType.socStr.value(), socStr);
        desc = replace(desc, ParamType.packType.value(), packType);
        desc = replace(desc, ParamType.pin.value(), buildMuit(pin));

        if (StringUtils.isBlank(capNum)) {
            desc = replace(desc, "-" + ParamType.capNum.value(), "");
            desc = replace(desc, ParamType.capNum.value(), "");
        } else {
            desc = replace(desc, ParamType.capNum.value(), capNum);
        }

        if (req != null && StringUtils.isNotBlank(req.getCapacity())) {
            desc = replace(desc, ParamType.capacity.value(), req.getCapacityCode());
        } else {
            if (StringUtils.equals(capacityMin, capacityMax)) {
                desc = replace(desc, ParamType.capacity.value(), capacityMin);
            }
            desc = replace(desc, ParamType.capacity.value(), "[" + (capacityMin == null ? "" : capacityMin) + "~" + (capacityMax == null ? "" : capacityMax) + "]");
        }
        if (req != null && StringUtils.isNotBlank(req.getTolerance())) {
            desc = replace(desc, ParamType.tolerance.value(), req.getTolerance());
        } else {
            desc = replace(desc, ParamType.tolerance.value(), buildMuit(tolerance));
        }

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

//    public String getRule() {
//        return desc;
//    }
}
