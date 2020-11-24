package com.chk.pd.config;

import java.util.Date;

/*
举例  消息实体
 */
public class CategoryChangedCommand  extends  Command{
    Long CategoryId;

    Long SkuId;

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public Long getSkuId() {
        return SkuId;
    }

    public void setSkuId(Long skuId) {
        SkuId = skuId;
    }

    public CategoryChangedCommand(Long categoryId, Long skuId) {
        super(111L,new Date().getTime());
        CategoryId = categoryId;
        SkuId = skuId;
    }
}
