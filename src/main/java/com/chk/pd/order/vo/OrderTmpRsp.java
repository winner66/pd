package com.chk.pd.order.vo;

import com.chk.pd.order.domain.OrderTmp;
import com.chk.pd.order.domain.Orders;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.util.List;

@Data
public class OrderTmpRsp extends OrderTmp {

    private String pcIcon;

    public OrderTmpRsp() {
    }

    @SneakyThrows
    public OrderTmpRsp(OrderTmp tmp) {
        BeanUtils.copyProperties(this, tmp);
    }
}
