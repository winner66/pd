package com.chk.pd.order.vo;

import com.chk.pd.order.domain.Orders;
import lombok.Data;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;

@Data
public class OrderRsp extends Orders {

    public String getFormatCreateDate(){
        if (this.getCreateTime() != null){
            return new DateTime(this.getCreateTime()).toString("yyyy-MM-dd");
        }else{
            return "";
        }
    }

    public OrderRsp() {
    }

    @SneakyThrows
    public OrderRsp(Orders orders) {
        BeanUtils.copyProperties(this, orders);
    }
}
