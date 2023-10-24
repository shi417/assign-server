package com.assign.controller;

import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.service.OrderService;
import com.assign.task.OrderTask;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTask orderTask;

    @PostMapping("/list")
    public ResponseResult<Object> getList(ShopeeOrderDTO params){
        if (params.getPayTimeBegin() != null && params.getPayTimeEnd() != null ){
            long abs = Math.abs(params.getPayTimeEnd() * 1000 - params.getPayTimeBegin() * 1000);
            long daysDiff = abs / (1000 * 60 * 60 * 24);
            if (daysDiff > 90){
                return new ResponseResult<>("201","日期相差不能大于90天");
            }
        }
        List<ShopeeOrderPO> list = orderService.getOrderList(params);
        ResponseResult<Object> res = new ResponseResult<>();
        res.setData(list);
        return res;
    }


    @PostMapping("/doOrderTask")
    public void doOrderTask(){
        orderTask.fetchOrders();
    }

    public static void main(String[] args) {
        int p = 0;

        while (p == 200){//一页最多200条
            p++;
            System.out.println("p:"+p);
        }
    }

}

