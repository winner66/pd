package com.chk.pd.pd.vo;

import com.chk.pd.common.util.IKUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Data
public class PdInfoReq {
    //搜索分类
    private String searchType;

    private String filterType;
    private String clzqa;
    private Long clz;
    private List<String> qas;
    private String key;
    private Long cm;
    private String modelCode;
    private String quality;
    private String size;
    private Long sizeId;
    private String temperature;
    private String voltage;

    private String capacity;
    private String tolerance;
    private String outlet;
    private String capacityCode;

//    滤波器
    private  String centerFrequency;
    private  String bandwidth;
    private  String passBandRange;
    //3dB截止频率
    private String cutOffFrequency;
//    功分器
private String frequencyRange;
//    陶瓷介质
    private String surfaceCode;
    private String thicknessCode;
    private String lengthWidthCode;
    private String materialCode;

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

    public String getSynVoltage() {
        try {
            if (StringUtils.isNotBlank(voltage)) {
                String unit = voltage.replaceAll("[0-9]", "");
                Integer number = Integer.valueOf(voltage.replaceAll("[^0-9]", ""));
                //K->1000
                if (StringUtils.startsWith(unit.toUpperCase(), "K")) {
                    unit = unit.substring(1);
                    String syn = (number * 1000) + unit;
                    return syn;
                } else {
                    //1000->K
                    if (number >= 1000) {
                        String syn = (number / 1000) + "K" + unit;
                        return syn;
                    }
                }
            }
        } catch (Exception e) {

        }
        return voltage;
    }

//    public Long getSizeId(){
//        if (NumberUtils.isCreatable(size)) {
//            return Long.valueOf(size);
//        }else{
//            return null;
//        }
//    }

    public void setKey(String key) {
        if (StringUtils.isBlank(key)) {
            return;
        }
        key = StringUtils.replaceAll(key, "\\+", " ");
        key = StringUtils.replaceAll(key, "\\-", " ");
        this.key = IKUtil.analyzWithSymbol(key, "+");
    }

    //modelId__qa1,qa2
    public void setClzqa(String clzqa) {
//        clz = Long.valueOf(clzqa);
        this.clzqa = clzqa;
        if (StringUtils.isNotBlank(clzqa)) {
            String[] s = StringUtils.split(clzqa, "__");
            if (s.length == 1) {
                clz = Long.valueOf(s[0]);
            } else {
                clz = Long.valueOf(s[0]);
                String[] ss = StringUtils.split(s[1], ",");
                qas = Arrays.asList(ss);
            }
        }
    }

}
