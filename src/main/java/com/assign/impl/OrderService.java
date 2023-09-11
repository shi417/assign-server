package com.assign.impl;

import com.assign.entity.Order;
import com.assign.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public void doClaim(String orderCode, String userCode) {

    }
}
