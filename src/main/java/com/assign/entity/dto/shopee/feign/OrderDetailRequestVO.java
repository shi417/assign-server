package com.assign.entity.dto.shopee.feign;

import com.alibaba.nacos.shaded.com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class OrderDetailRequestVO extends CommonRequestVO {
    @SerializedName("order_sn_list")
    private String order_sn_list;

    @SerializedName("response_optional_fields")
    private String response_optional_fields;

    @SerializedName("request_order_status_pending")
    private Boolean request_order_status_pending;
}
