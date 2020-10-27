package com.chk.pd.pub.vo;

import com.chk.pd.pub.domain.SysDict;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

@Data
public class DictVo extends SysDict {

    @SneakyThrows
    public DictVo(SysDict dict) {
        BeanUtils.copyProperties(this, dict);
    }

    public String getTitle(){
        return getName();
    }
}
