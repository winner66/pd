package com.chk.pd.common.vo;

public enum ClassType {
    LLPF("LTCC低通滤波器", "LTCC低通滤波器"),
    LBPF("LTCC带通滤波器","LTCC带通滤波器"),
    LHPF("LTCC高通滤波器","LTCC高通滤波器"),
    JLTC("功分器","功分器"),
    CS("陶瓷介质基片","陶瓷介质基片"),
    RawPorcelainWith("生瓷带","生瓷带"),
    SizingMaterial("浆料","浆料"),
    Porcelain("瓷料","瓷料");

    private String value;
    private String title;

    ClassType(String value,String title) {
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
