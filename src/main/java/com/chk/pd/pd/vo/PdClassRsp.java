package com.chk.pd.pd.vo;

import com.chk.pd.pd.domain.PdClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PdClassRsp {

    @JsonIgnore
    public static String OPERA_WX = "wx";
    @JsonIgnore
    public static String OPERA_FILE = "file";

    private Long id;

    private String name;

    private String icon;

    private List<PdClassRsp> children;

    //wx,pdf
    private String opera;

    private String fileUrl;

    public PdClassRsp() {
    }

    public PdClassRsp(Long id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.children = new ArrayList<>();
        this.opera = OPERA_WX;
    }

    public PdClassRsp(Long id, String name, String icon, String file) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.children = new ArrayList<>();
        this.opera = OPERA_FILE;
        this.fileUrl = file;
    }

    public PdClassRsp(PdClass pdClass) {
        this.id = pdClass.getId();
        this.name = pdClass.getShowName();
        this.icon = pdClass.getIconUrl();
        this.children = new ArrayList<>();
        this.opera = OPERA_WX;
    }
}
