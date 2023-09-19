package com.assign.entity.po;

import com.assign.util.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderPO {

    private Long id;

    private String orderNumber;
    private String customerName;
    // 其他订单信息（日期、产品等）

    private OrderStatusEnum status;

    private String content;

    private String claimStatus;
    // 省略构造函数、Getter和Setter等
}

