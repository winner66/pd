package com.chk.pd.pd.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class jLTCDto implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    private String filterType;

    //    类型
    private String type;
    //   质量等级
    private String quality;
    //    尺寸
    private String size;
    //    通带范围
    private String passBandRange;
}
