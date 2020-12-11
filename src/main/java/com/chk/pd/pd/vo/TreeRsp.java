package com.chk.pd.pd.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeRsp {

    private  String title;
    private   String value;
    private  List<TreeRsp> children;
    private  boolean hasChildren;


    public TreeRsp(String title, String value) {
        this.title = title;
        this.value = value;
    }
    public TreeRsp(String title, String value,Boolean hasChildren) {
        this.title = title;
        this.value = value;
        this.hasChildren=hasChildren;
        if(hasChildren){
            children= new ArrayList<>();
        }
    }
    public  void setChild(Boolean is){
        if(is){
            if(this.children==null){
                children= new ArrayList<>();
                this.hasChildren=is;
            }
        }
    }

}
