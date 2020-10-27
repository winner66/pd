package com.chk.pd.order.dao;

import com.chk.pd.order.dao.extmapper.ExtOrderMapper;
import com.chk.pd.order.dao.mapper.OrderFlowMapper;
import com.chk.pd.order.dao.mapper.OrderItemMapper;
import com.chk.pd.order.dao.mapper.OrderTmpMapper;
import com.chk.pd.order.dao.mapper.OrdersMapper;
import com.chk.pd.order.domain.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderTmpMapper tmpMapper;

    @Autowired
    private OrderItemMapper itemMapper;

    @Autowired
    private ExtOrderMapper extOrderMapper;

    @Autowired
    private OrderFlowMapper flowMapper;

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    public OrderTmpMapper getTmpMapper() {
        return tmpMapper;
    }

    public OrderItemMapper getItemMapper() {
        return itemMapper;
    }

    public ExtOrderMapper getExtOrderMapper() {
        return extOrderMapper;
    }

    public OrderFlowMapper getFlowMapper() {
        return flowMapper;
    }

    public List<Orders> listOrders(Long uid){
        OrdersExample exp = new OrdersExample();
        exp.createCriteria().andUidEqualTo(uid);
        exp.setOrderByClause("id desc");
        List<Orders> orders = ordersMapper.selectByExample(exp);
        return orders;
    }

    public List<OrderTmp> listOrderTmps(Long uid, List<Long> tmpIds){
        OrderTmpExample exp = new OrderTmpExample();
        OrderTmpExample.Criteria cri = exp.createCriteria();
        cri.andUidEqualTo(uid);
        if (CollectionUtils.isNotEmpty(tmpIds)){
            cri.andIdIn(tmpIds);
        }
        exp.setOrderByClause("id desc");
        List<OrderTmp> temps = tmpMapper.selectByExample(exp);
        return temps;
    }

    public List<OrderTmp> listOrderTmps(List<Long> ids){
        OrderTmpExample exp = new OrderTmpExample();
        exp.createCriteria().andIdIn(ids);
        exp.setOrderByClause("id asc");
        List<OrderTmp> temps = tmpMapper.selectByExample(exp);
        return temps;
    }

    public List<OrderItem> listOrderItem(Long orderId){
        OrderItemExample exp = new OrderItemExample();
        exp.createCriteria().andOrderIdEqualTo(orderId);
        exp.setOrderByClause("id asc");
        List<OrderItem> orderItems = itemMapper.selectByExample(exp);
        return orderItems;
    }


}
