package com.chk.pd.config;

public class CategoryChangedHandler<CategoryChangedCommand> extends CommandHandler<CategoryChangedCommand> {
    // 根据 skuId  不同， categoryId 不同
    @Override
    public void CommandHandle(CategoryChangedCommand t) {
//        sku 类别变化，修改对应listing的类别
    }
}
