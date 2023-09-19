package com.assign.controller;

import com.assign.entity.po.OrderPO;
import com.assign.service.IOrderService;
import com.assign.task.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderTask orderTask;

    @GetMapping
    public List<OrderPO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderPO> getOrderById(@PathVariable Long id) {
        OrderPO orderPO = orderService.getOrderById(id);
        if (orderPO != null) {
            return ResponseEntity.ok(orderPO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/doClaim")
    public void doClaim(@RequestParam("orderCode")String orderCode,@RequestParam("userCode")String userCode){
        orderService.doAssign(orderCode,userCode);
    }

    @PostMapping("/doOrderTask")
    public void doOrderTask(){
        orderTask.fetchOrders();
    }

}

