package com.assign.enumm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    UNPAID("UNPAID","订单未支付"),
    READY_TO_SHIP("READY_TO_SHIP","订单待发货"),
    PROCESSED("PROCESSED","卖家已操作发货"),
    RETRY_SHIP("RETRY_SHIP","3pl揽收失败，需要重新重新发货"),
    SHIPPED("SHIPPED","3pl揽收成功"),
    TO_CONFIRM_RECEIVE("TO_CONFIRM_RECEIVE","等待买家确认签收"),
    IN_CANCEL("IN_CANCEL","买家提交取消申请待处理"),
    CANCELLED("CANCELLED","订单已取消"),
    TO_RETURN("TO_RETURN","买家提交退货申请待处理"),
    COMPLETED("COMPLETED","订单已完成"),
    UNKNOWN("UNKNOWN","未知");

    private String code;

    private String desc;
}
