package com.chk.pd.order.vo;

import com.chk.pd.order.domain.OrderItem;
import com.chk.pd.order.domain.Orders;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

@Data
public class OrderItemRsp extends OrderItem {

    private String pcIcon;

    public OrderItemRsp() {
    }

    @SneakyThrows
    public OrderItemRsp(OrderItem item) {
        BeanUtils.copyProperties(this, item);
    }
}
