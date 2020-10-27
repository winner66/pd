package com.chk.pd.pd.vo;

import lombok.Data;

@Data
public class PdDetailReq {
    private Long id;

    private String capacity;

    private String tolerance;

    private String outlet;

    private String capacityCode;
}
