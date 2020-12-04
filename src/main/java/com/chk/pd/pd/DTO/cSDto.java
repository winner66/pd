package com.chk.pd.pd.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class cSDto implements Serializable {
    //
    private static final long serialVersionUID = 1L;
    private String filterType;

    private String materialCode;

    private String lengthWidthCode;

    private String thicknessCode;

    private String surfaceCode;
}
