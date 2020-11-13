package com.chk.pd.pd.vo;

import lombok.Data;

@Data
public class TableRsp {
     private  String title;
    private   String value;

    public TableRsp(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
