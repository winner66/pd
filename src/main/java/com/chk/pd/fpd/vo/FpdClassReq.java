package com.chk.pd.fpd.vo;

import com.chk.pd.pd.vo.TableRsp;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class FpdClassReq  implements Serializable {
    private static final long serialVersionUID = 1L;
//  宏科系列
    private Long id;
    private  String name;
    private  String code;
    private  String type;
    private  String  is_show;
    private Integer sort_order;
    private String   des;
//条件
    private String  key;
    private  List<TableRsp> list;

}
