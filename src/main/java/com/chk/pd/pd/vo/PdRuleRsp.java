package com.chk.pd.pd.vo;

import com.chk.pd.common.vo.ParamType;
import com.chk.pd.pd.domain.PdInfo;
import com.chk.pd.pd.domain.PdModel;
import com.chk.pd.pd.domain.PdParam;
import com.chk.pd.common.util.OrderRuleUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Deprecated
@Data
public class PdRuleRsp {

    private Long id;

    @JsonIgnore
    private String std;

    @JsonIgnore
    private String quality;

    @JsonIgnore
    private String size;

    @JsonIgnore
    private String sizeDesc;

    @JsonIgnore
    private String temperature;

    @JsonIgnore
    private String voltage;

    @JsonIgnore
    private String capacity;

    @JsonIgnore
    private String tolerance;

    @JsonIgnore
    private String outlet;

    private List<String> capacities = new ArrayList<>();

    private List<String> tolerances = new ArrayList<>();

    private List<String> outlets = new ArrayList<>();

    @JsonIgnore
    private String pmCode;

    private String pmOrderRule;

    private String pdExp;

    private String pd;

    private String pdTemplate;

    private Boolean showCapacity = true;
    private Boolean showTolerance = true;
    private Boolean showOutlet = true;

    public PdRuleRsp() {
    }

    public PdRuleRsp(PdModel pdModel, PdInfo pdInfo, List<PdParam> tolerances, List<PdParam> outlets, List<PdParam> capacities) {
        try {
            BeanUtils.copyProperties(this, pdInfo);
            this.pmCode = StringUtils.split(pdModel.getCode(), "|")[0];
            this.pmOrderRule = pdModel.getOrderRule();
            for (PdParam tolerance : tolerances) {
                this.getTolerances().add(tolerance.getCode());
            }
            for (PdParam outlet : outlets) {
                this.getOutlets().add(outlet.getCode());
            }
            for (PdParam capacity : capacities) {
                this.getCapacities().add(capacity.getCode());
            }
        } catch (Exception e) {
        }
        showCapacity = pmOrderRule.contains(ParamType.capacity.value()) && this.getCapacities().size() > 0;
        showTolerance = pmOrderRule.contains(ParamType.tolerance.value()) && this.getTolerances().size() > 0;
        showOutlet = pmOrderRule.contains(ParamType.outlet.value()) && this.getOutlets().size() > 0;
    }

    public String getOrderRule() {
        String[] ss = OrderRuleUtil.getRules(pmOrderRule);
        for (int i = 0; i < ss.length; i++) {
            ss[i] = OrderRuleUtil.ruleIdxMap.get(i + 1) + ss[i] + "";
        }
        String result = StringUtils.join(ss, "");
        return result;
    }

    public String getPdExp() {
        String exp = getOrderRule();
        pdExp = getPd(exp, true);
        return pdExp;
    }

    public String getPd() {
        pd = getPd(this.pmOrderRule, false);
        return pd;
    }

    public String getPdTemplate() {
        pdTemplate = getPd();
        return pdTemplate;
    }

    public String getPd(String rule, boolean exp) {
        String pd = StringUtils.replace(rule, "|", "");
        pd = StringUtils.replace(pd, ParamType.quality.value(), quality);
        pd = StringUtils.replace(pd, ParamType.std.value(), std);
        pd = StringUtils.replace(pd, ParamType.size.value(), size);
        pd = StringUtils.replace(pd, ParamType.temperature.value(), temperature);
        pd = StringUtils.replace(pd, ParamType.voltage.value(), voltage);
        pd = StringUtils.replace(pd, ParamType.model.value(), StringUtils.split(pmCode, "|")[0]);
        pd = StringUtils.replace(pd, ParamType.capacity.value(), exp ? capacities.size() > 1 ? this.capacities.get(1) : "" : ParamType.capacity.value());
        pd = StringUtils.replace(pd, ParamType.tolerance.value(), exp ? tolerances.size() > 1 ? this.tolerances.get(1) : "" : ParamType.tolerance.value());
        pd = StringUtils.replace(pd, ParamType.outlet.value(), exp ? outlets.size() > 1 ? this.outlets.get(1) : "" : ParamType.outlet.value());
        return pd;
    }
}
