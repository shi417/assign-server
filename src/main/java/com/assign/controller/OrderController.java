package com.assign.controller;

import com.assign.entity.common.PageResult;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shopee.OrderListResponseDTO;
import com.assign.entity.dto.shopee.ShopeeOrderRequestDTO;
import com.assign.entity.dto.shopee.feign.ShopeeOrderRequireDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.service.OrderService;
import com.assign.task.OrderTask;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "查询虾皮订单", notes = "查询虾皮订单", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseResult<PageResult<OrderListResponseDTO>> getList(@RequestBody ShopeeOrderRequestDTO params){
        if (params.getPayTimeStart() != null && params.getPayTimeEnd() != null ){
            long millisecondsDifference = params.getPayTimeStart().getTime() - params.getPayTimeEnd().getTime();
            long daysDifference = millisecondsDifference / (1000 * 60 * 60 * 24);
            if (daysDifference > 90){
                return  ResponseResult.failed("日期相差不能大于90天");
            }
        }
        PageResult<OrderListResponseDTO> list = orderService.getOrderList(params);
        ResponseResult<PageResult<OrderListResponseDTO>> res = new ResponseResult<>();
        res.setData(list);
        return res;
    }


    @PostMapping("/doOrderTask")
    public void doOrderTask(){
//        orderTask.fetchOrders();
        new Thread( new Runnable() {
            @Override
            public void run() {
                orderTask.fetchAllOrders();
            }
        }).start();
    }


}

