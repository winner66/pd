package com.chk.pd.pd_material.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *生瓷带
 */
@Data
public class PDRawPorcelainWithInfoEntity extends baseMaterialEntiey  implements Serializable {
//    生瓷带
private static final long serialVersionUID = 1L;
    private String pdname;
//    介电常数 @1.9G

    private String permittivityBy1_9G;
//    介电常数 @15G

    private String permittivityBy15G;
//    介电损耗@1.9G

    private String dielectricLossBy1_9G;
//    介电常数 @15G

    private String dielectricLossBy20G;
//    抗弯强度

    private String flexureStrength;
//    绝缘电阻

    private String insulationResistance;
//    击穿电压
    private String breakdownVoltage;

}
