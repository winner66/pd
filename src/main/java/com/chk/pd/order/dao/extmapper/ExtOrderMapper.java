package com.chk.pd.order.dao.extmapper;

import com.chk.pd.order.vo.OrderItemRsp;
import com.chk.pd.order.vo.OrderTmpRsp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtOrderMapper {
    public List<OrderTmpRsp> listOrderTmp(@Param("uid") Long uid);

    public List<OrderItemRsp> listOrderItem(@Param("uid") Long uid, @Param("oid") Long oid);

}
