package com.chk.pd.common.vo;

import lombok.Data;

@Data
public class PageReq {
    private int pageNum = 1;

    private int pageSize = 20;

    public int getPageNum() {
        return pageNum < 1 ? 1 : pageNum;
    }

    public int getPageSize() {
        return pageSize > 20 ? 20 : pageSize;
    }
}
