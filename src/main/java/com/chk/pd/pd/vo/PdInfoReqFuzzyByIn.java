package com.chk.pd.pd.vo;

import com.chk.pd.common.util.IKUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
@Data
public class PdInfoReqFuzzyByIn {

    private String filterType;
    private List<String>  modelCode ;
    private String  key ;

//    ？
    private List<String>  cm ;
    private List<Long> sizeId ;
//    以下：模糊查询
    private List<String>  clzqa ;
//    pd_class_id
    private List<String>  clz ;
//    quality
    private List<String>  quality;
    private List<String>  size  ;
    private List<String> temperature  ;
    private List<String>  voltage ;
    private List<String>  capacity ;
    private List<String> tolerance  ;
    private List<String>  outlet ;
    private List<String>  capacityCode;



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


}
