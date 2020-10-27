package com.chk.pd.pd.vo;

import lombok.Data;

import java.util.*;

@Data
public class PdParamRsp {
    //分类-型号
//    private List<List<Multi>> cm = new ArrayList<>();
    private Set<Item> cm = new LinkedHashSet<>();

    //质量等级
    private Set<Item> quality = new LinkedHashSet<>();

    //尺寸
    private List<List<Multi>> size = new ArrayList<>();

    //容量
    private List<List<Multi>> capacity = new ArrayList<>();

    //电压
    private Set<Item> voltage = new LinkedHashSet<>();

    //温度
    private Set<Item> temperature = new LinkedHashSet<>();

    //容量偏差
    private Set<Item> tolerance = new LinkedHashSet<>();

    //引出端
    private Set<Item> outlet = new LinkedHashSet<>();

    public PdParamRsp() {
        Item item = new Item("", "");
        Multi multi = new Multi("", "");
        multi.addC("", "");
//        List<Multi>  cmMulti = new ArrayList<>();
//        cm.add(cmMulti);
        List<Multi>  sizeMulti = new ArrayList<>();
        sizeMulti.add(multi);
        List<Multi> capMulti = new ArrayList<>();
        capMulti.add(multi);

        cm.add(item);
        quality.add(item);
        size.add(sizeMulti);
        capacity.add(capMulti);
        voltage.add(item);
        temperature.add(item);
        tolerance.add(item);
        outlet.add(item);
    }

    public Multi createMulti(String v, String t) {
        return new Multi(v, t);
    }

    public Item createItem(String v, String t) {
        return new Item(v, t);
    }

    @Data
    public class Multi {
        private String v;

        private String t;
        private Set<Item> c = new LinkedHashSet<>();

        public Multi(String v, String t) {
            this.v = v;
            this.t = t;
        }

        public void addC(String v, String t) {
            this.c.add(new Item(v, t));
        }
    }

    @Data
    public class Item {
        private String v;

        private String t;

        public Item(String v, String t) {
            this.v = v;
            this.t = t;
        }
    }
}

