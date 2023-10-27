package com.assign.entity.dto.shopee.feign;

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
public class OrderListRequestVO extends CommonRequestVO {
    // 时间范围字段，可选值包括 "create_time" 和 "update_time"


    @SerializedName("time_range_field")
    private String time_range_field;

    // 起始时间，用于指定日期范围的开始日期
    @SerializedName("time_from")
    private long time_from;

    // 结束时间，用于指定日期范围的结束日期
    @SerializedName("time_to")
    private long time_to;

    // 每页的最大条目数，控制每次请求返回的最大数据条目数
    @SerializedName("page_size")
    private int page_size;

    // 游标，用于指定当前请求返回的起始数据条目
    @SerializedName("cursor")
    private String cursor;

    // 订单状态过滤器，用于检索订单，可选值包括 "UNPAID/READY_TO_SHIP/PROCESSED/SHIPPED/COMPLETED/IN_CANCEL/CANCELLED/INVOICE_PENDING"
    @SerializedName("order_status")
    private String order_status;

    // 响应中的可选字段，可选值包括 "order_status"
    @SerializedName("response_optional_fields")
    private String response_optional_fields;

    // 兼容参数，用于在迁移期间支持PENDING状态，为true表示支持，为false表示不支持
    @SerializedName("request_order_status_pending")
    private boolean request_order_status_pending;
}
