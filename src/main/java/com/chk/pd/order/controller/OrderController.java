package com.chk.pd.order.controller;

import com.chk.pd.common.vo.PageReq;
import com.chk.pd.common.vo.Response;
import com.chk.pd.order.domain.OrderTmp;
import com.chk.pd.order.domain.Orders;
import com.chk.pd.order.service.OrderService;
import com.chk.pd.order.vo.*;
import com.chk.pd.pub.service.PubService;
import com.chk.pd.pub.vo.DictVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PubService pubService;

    @GetMapping("list-order")
    public Response<List<OrderRsp>> listOrder(PageReq pageReq) {
        List<OrderRsp> rps = orderService.listOrders(pageReq);
        return Response.ok(rps);
    }

    @PostMapping("save-order")
    public Response saveOrder(@RequestBody OrderReq orderReq){
        Map<String, Object> result = orderService.saveOrder(orderReq);
        Orders order = (Orders) result.get("order");
        List<OrderTmp> tmps = (List<OrderTmp>) result.get("items");
        orderService.sendOrderMail(order, tmps);
        return Response.ok();
    }

    @GetMapping("list-item")
    public Response<List<OrderItemRsp>> listItem(Long orderId, PageReq pageReq){
        List<OrderItemRsp> rsp = orderService.listItem(orderId, pageReq);
        return Response.ok(rsp);
    }

    @GetMapping("list-tmp")
    public Response<List<OrderTmpRsp>> listTmp(PageReq pageReq){
        List<OrderTmpRsp> rsp = orderService.listTmp(pageReq);
        return Response.ok(rsp);
    }

    @PostMapping("update-tmp-num")
    public Response updateTmpNum(@RequestBody OrderTmpReq tmpReq){
        orderService.updateTmpNum(tmpReq);
        return Response.ok();
    }
//保存
    @PostMapping("save-tmp")
    public Response saveTmp(@RequestBody OrderTmpReq tmpReq){
        orderService.saveTmp(tmpReq);
        return Response.ok();
    }
//清除
    @PostMapping("delete-tmp")
    public Response deleteTmp(@RequestBody OrderTmpReq tmpReq){
        orderService.deleteTmp(tmpReq.getId());
        return Response.ok();
    }

    @GetMapping("get-order-rel-info")
    public Response getOrderRelInfo(){
        PageReq pageReq =  new PageReq();
        pageReq.setPageNum(1);
        pageReq.setPageSize(1);
        List<OrderRsp> rsp = orderService.listOrders(pageReq);

        Map result = new HashMap<>();
        if (rsp.size() > 0){
            result.put("address", rsp.get(0));
        }else{
            result.put("address", new OrderRsp());
        }
        List<DictVo> types = pubService.getOrderType();
        result.put("orderType", types);
        return Response.ok(result);
    }
}
