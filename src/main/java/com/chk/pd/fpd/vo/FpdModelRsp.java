package com.chk.pd.fpd.vo;

import com.chk.pd.fpd.domain.FpdModel;
import com.chk.pd.common.util.OrderRuleUtil;
import lombok.Data;

@Data
public class FpdModelRsp {
    private Long id;
    private String name;
    private String code;
    private String orderRule;

    public FpdModelRsp() {
        this.name = "";
        this.code = "";
    }

    public FpdModelRsp(FpdModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.code = model.getCode();
        this.orderRule = buildRule(model);
    }

    public String getTitle(){
        return name;
    }

    public String getValue(){
        return code;
    }

    public String buildRule(FpdModel model) {
        StringBuilder sb = new StringBuilder();
        String[] rules = OrderRuleUtil.getRules(model.getOrderRule());
        String[] bits = model.getOrderRuleBit().split(",");
        String[] poses = model.getOrderRulePos().split(",");
        for (int i = 0; i < rules.length; i++) {
            String bit = i >= bits.length ? "" : bits[i];
            String pos = i >= poses.length ? "" : poses[i];
            sb.append(rules[i] + "(位置" + pos + ";长度" + bit + ")");
        }
        return sb.toString();
    }
}
