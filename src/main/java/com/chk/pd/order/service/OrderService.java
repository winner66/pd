package com.chk.pd.order.service;

import com.chk.pd.common.bean.UserContext;
import com.chk.pd.common.util.SnowflakeIdWorker;
import com.chk.pd.common.vo.PageReq;
import com.chk.pd.order.dao.OrderDao;
import com.chk.pd.order.domain.OrderFlow;
import com.chk.pd.order.domain.OrderItem;
import com.chk.pd.order.domain.OrderTmp;
import com.chk.pd.order.domain.Orders;
import com.chk.pd.order.vo.*;
import com.chk.pd.pub.dao.UserDao;
import com.chk.pd.pub.domain.SysDict;
import com.chk.pd.pub.service.MailService;
import com.chk.pd.pub.service.PubService;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Autowired
    private PubService pubService;

    private Logger log = LoggerFactory.getLogger(OrderService.class);

    public List<OrderRsp> listOrders(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        Long uid = UserContext.get().getId();
        List<Orders> orders = orderDao.listOrders(uid);
        List<OrderRsp> rsp = new ArrayList<>();
        for (Orders order : orders) {
            rsp.add(new OrderRsp(order));
        }
        return rsp;
    }

    @SneakyThrows
    @Transactional
    public Map<String, Object> saveOrder(OrderReq orderReq) {

        List<OrderTmp> tmps = orderDao.listOrderTmps(UserContext.get().getId(), orderReq.getTmpIds());
        Orders order = new Orders();
        BeanUtils.copyProperties(order, orderReq);
        order.setId(SnowflakeIdWorker.nextID());
        order.setStatus(OrderStatus.handel.value());
//        order.setTitle("title");
        order.setUid(UserContext.get().getId());
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        setOpUser(order);
        orderDao.getOrdersMapper().insert(order);

        OrderFlow orderFlow = createFirstOrderFlow(order);
        orderDao.getFlowMapper().insert(orderFlow);

        for (OrderTmp tmp : tmps) {
            OrderItem item = new OrderItem();
            BeanUtils.copyProperties(item, tmp);
            item.setId(SnowflakeIdWorker.nextID());
            item.setOrderId(order.getId());
            orderDao.getItemMapper().insert(item);
            orderDao.getTmpMapper().deleteByPrimaryKey(tmp.getId());
        }

        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("items", tmps);
        return result;

//        UserAddress userAddress = userDao.getUserAddress(UserContext.get().getId());
//        if (userAddress == null){
//            userAddress = new UserAddress();
//        }
//        userAddress.setName(orderReq.getContact());
//        userAddress.setMobile(order.getPhone());
//        userDao.saveUserAddress(userAddress);
    }

    private void setOpUser(Orders order){
        Long opUserId = 1L;
        String opUser = "系统管理员";
        List<SysDict> dicts = pubService.listDict("清单初始处理人");
        if (dicts.size() == 0){
            log.warn("未配置清单初始处理人，清单分配到ID=1的系统管理员");
        }else{
            String value = dicts.get(0).getValue();
            String[] v = StringUtils.split(value, ",");
            try {
                if (v.length == 2 && NumberUtils.isCreatable(v[0])) {
                    opUserId = Long.valueOf(v[0]);
                    opUser = v[1];
                }else{
                    log.warn("清单初始处理人{}配置错误，清单分配到ID=1的系统管理员", value);
                }
            }catch (Exception e){
                log.warn("清单初始处理人{}配置错误，清单分配到ID=1的系统管理员", value);
            }
        }
        order.setOpUserId(opUserId);
        order.setOpUser(opUser);
    }

    private OrderFlow createFirstOrderFlow(Orders order){
        OrderFlow orderFlow = new OrderFlow();
        orderFlow.setId(SnowflakeIdWorker.nextID());
        orderFlow.setOrderId(order.getId());
        orderFlow.setIdx(1);
        orderFlow.setOpUserId(0L);
        orderFlow.setOpUser("系统");
        orderFlow.setOpDatetime(new Date());
        orderFlow.setOpDesc("发送邮件，分配处理人");
        return orderFlow;
    }

    public void sendOrderMail(Orders order, List<OrderTmp> tmps){
        try {
            List<SysDict> dicts = pubService.listDict("清单发送邮箱");
            if (dicts.size() == 0){
                log.warn("未配置基础数据：清单发送邮箱，本清单不发送邮件");
            }
            List<String> to = new ArrayList<>();
            for (SysDict dict : dicts) {
                String[] tos = dict.getValue().split(",");
                to.addAll(Arrays.asList(tos));
            }
//            mailService.sendSimpleMail(to.toArray(new String[]{}), "你有新的清单需要处理", tmps.toString());
//            String title = "你有新的清单需要处理 - "+ order.getType();
            String title = order.getType();
            String content = createMailContent(order, tmps);
            mailService.sendHtmlMail(to.toArray(new String[]{}), title, content);
        } catch (Exception e) {
            log.error("发送邮件出错", e);
        }
    }

    private String createMailContent(Orders order, List<OrderTmp> tmps){
        String content = OrderMail.content;
        content=replace(content,"{{清单}}", order.getType());
        content=replace(content,"{{联系人}}", order.getContact());
        content=replace(content,"{{联系方式}}", order.getPhone());
        content=replace(content,"{{公司}}", order.getCompany());
        content=replace(content,"{{备注}}", order.getDescr());
        content=replace(content,"{{日期}}", new DateTime(order.getCreateTime()).toString("yyyy-MM-dd"));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tmps.size();i++){
            sb.append("<tr>");
            sb.append("<td width='5%'>").append(i).append("</td>");
            sb.append("<td width='60%'>").append(tmps.get(i-1).getFlag()).append("</td>");
            sb.append("<td width='10%'>").append(tmps.get(i-1).getNum()).append("</td>");
            sb.append("<td width='25%'>").append(tmps.get(i-1).getDescr()).append("</td>");
            sb.append("</tr>");
        }
        content=replace(content, "{{清单明细}}", sb.toString());
        return content;
    }

    private String replace(String text, String s1, String s2){
        if (s2 == null){
            s2 = "";
        }
        return StringUtils.replace(text, s1, s2);
    }

    public List<OrderItemRsp> listItem(Long orderId, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<OrderItemRsp> items = this.orderDao.getExtOrderMapper().listOrderItem(UserContext.get().getId(), orderId);
//        List<OrderItemRsp> rsp = new ArrayList<>();
//        for (OrderItem item : items) {
//            rsp.add(new OrderItemRsp(item));
//        }
        return items;
    }

    public List<OrderTmpRsp> listTmp(PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<OrderTmpRsp> rsp = this.orderDao.getExtOrderMapper().listOrderTmp(UserContext.get().getId());
//        List<OrderTmp> tmps = this.orderDao.listOrderTmps(UserContext.get().getId(), null);
//        List<OrderTmpRsp> rsp = new ArrayList<>();
//        for (OrderTmp tmp : tmps) {
//            rsp.add(new OrderTmpRsp(tmp));
//        }
        return rsp;
    }

    @Transactional
    public void updateTmpNum(OrderTmpReq tmpReq){
        OrderTmp tmp = new OrderTmp();
        tmp.setId(tmpReq.getId());
        tmp.setNum(tmpReq.getNum());
        tmp.setDescr(tmpReq.getDescr());
        orderDao.getTmpMapper().updateByPrimaryKeySelective(tmp);
    }

    @SneakyThrows
    @Transactional
    public void saveTmp(OrderTmpReq tmpReq){
        OrderTmp tmp = new OrderTmp();
        BeanUtils.copyProperties(tmp, tmpReq);
        tmp.setUid(UserContext.get().getId());
        if (tmp.getId()== null){
            tmp.setId(SnowflakeIdWorker.nextID());
            tmp.setCreateTime(new Date());
            tmp.setUpdateTime(new Date());
            this.orderDao.getTmpMapper().insert(tmp);
        }else{
            tmp.setUpdateTime(new Date());
            this.orderDao.getTmpMapper().updateByPrimaryKey(tmp);
        }
    }

    @Transactional
    public void deleteTmp(Long tmpId){
        this.orderDao.getTmpMapper().deleteByPrimaryKey(tmpId);
    }
}
