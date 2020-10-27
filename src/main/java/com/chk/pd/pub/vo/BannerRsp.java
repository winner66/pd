package com.chk.pd.pub.vo;

import com.chk.pd.pub.domain.SysDict;
import lombok.Data;

@Data
public class BannerRsp {
    private String url;

    public BannerRsp(SysDict dict) {
        this.url = dict.getValue();
    }

}
