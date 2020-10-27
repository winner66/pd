package com.chk.pd.order.vo;

import com.chk.pd.order.domain.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderReq extends Orders {

    private List<Long> tmpIds;

}
