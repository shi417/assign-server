package com.assign.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    UNPAID("待支付","UNPAID"),
    READY_TO_SHIP("待出库","READY_TO_SHIP"),
    PROCESSED("运输中","PROCESSED"),
    SHIPPED("运输完成","SHIPPED"),
    COMPLETED("已签收","COMPLETED"),
    IN_CANCEL("取消中","IN_CANCEL"),
    CANCELLED("已取消","CANCELLED"),
    INVOICE_PENDING("发票获取中","INVOICE_PENDING");

    private final String desc;

    private final String code;

    public static String getDescByCode(String code) {
        for (OrderStatusEnum e : OrderStatusEnum.values()) {
            if (e.code.equals(code)) {
                return e.desc;
            }
        }
        return null; // 如果没有匹配的代码，可以返回null或其他默认值
    }
}
