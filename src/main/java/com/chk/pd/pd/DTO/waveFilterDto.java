package com.chk.pd.pd.DTO;

import lombok.Data;

import java.io.Serializable;
@Data
public class waveFilterDto implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    private String filterType;

//    类型
    private String type;
//   质量等级
    private String quality;
//    尺寸
    private String size;
//3dB截止频率
    private String cutOffFrequency;
//    带宽
    private String bandwidth;
//    中心频率
    private String centerFrequency;
    //    通带范围
    private String passBandRange;

}
