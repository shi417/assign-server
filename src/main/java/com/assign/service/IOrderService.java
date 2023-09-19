package com.assign.service;

import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.po.OrderPO;

import java.util.Date;
import java.util.List;

public interface IOrderService {

    List<OrderPO> getAllOrders();

    OrderPO getOrderById(Long id);

    void doAssign(String orderCode, String userCode);

    Date getOrderMaxDate();

    void batchInsertOrders(List<ShopeeOrderDTO> orderDTOS);
}
