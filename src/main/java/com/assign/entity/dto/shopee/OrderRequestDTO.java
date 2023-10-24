package com.assign.entity.dto.shopee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * OrderRequestDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/19.
 */
@Data
public class OrderRequestDTO {
    // 时间范围字段，可选值包括 "create_time" 和 "update_time"
    @JsonProperty("time_range_field")
    private String timeRangeField;

    // 起始时间，用于指定日期范围的开始日期
    @JsonProperty("time_from")
    private long timeFrom;

    // 结束时间，用于指定日期范围的结束日期
    @JsonProperty("time_to")
    private long timeTo;

    // 每页的最大条目数，控制每次请求返回的最大数据条目数
    @JsonProperty("page_size")
    private int pageSize;

    // 游标，用于指定当前请求返回的起始数据条目
    @JsonProperty("cursor")
    private String cursor;

    // 订单状态过滤器，用于检索订单，可选值包括 "UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING"
    @JsonProperty("order_status")
    private String orderStatus;

    // 响应中的可选字段，可选值包括 "order_status"
    @JsonProperty("response_optional_fields")
    private String responseOptionalFields;

    // 兼容参数，用于在迁移期间支持PENDING状态，为true表示支持，为false表示不支持
    @JsonProperty("request_order_status_pending")
    private boolean requestOrderStatusPending;
}
