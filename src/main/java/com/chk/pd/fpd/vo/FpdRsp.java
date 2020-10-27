package com.chk.pd.fpd.vo;

import com.chk.pd.pd.vo.PdInfoRsp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FpdRsp {
    private List<PdInfoRsp> pdInfos;

    private List<Pmap> pmaps = new ArrayList<>();

    public void addPmap(String type, Integer pos, Integer bit, String fcode, String code){
        this.pmaps.add(new Pmap(type, pos, bit, fcode, code));
    }

    @Data
    public class Pmap {
        private String type;
        private Integer pos;
        private Integer bit;
        private String fcode;
        private String code;

        public Pmap(String type, Integer pos, Integer bit, String fcode, String code) {
            this.type = type;
            this.pos = pos;
            this.bit = bit;
            this.fcode = fcode;
            this.code = code;
        }
    }
}
