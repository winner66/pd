package com.chk.pd.pd_material.Enum;

public enum materialTypeEnum {



    CS("6","陶瓷介质基片"),
    RawPorcelainWith("8","生瓷带"),
//    细分
    LTCC("1","LLTC滤波器"),
    JBPF("9","介质滤波器"),
    SizingMaterial("7"," 浆料"),
    JLTC("4","功分器"),
    Porcelain("10","瓷料");


    private String value;

    private String title;

    materialTypeEnum(String value,String title) {
        this.value = value;
        this.title = title;
    }

    public String title(){
        return title;
    }

    public String value(){
        return value;
    }

}
