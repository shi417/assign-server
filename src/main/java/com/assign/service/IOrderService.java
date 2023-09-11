package com.assign.service;

import com.assign.entity.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    void doClaim(String orderCode, String userCode);
}
