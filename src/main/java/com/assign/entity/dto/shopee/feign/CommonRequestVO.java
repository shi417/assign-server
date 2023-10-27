package com.assign.entity.dto.shopee.feign;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CommonRequestVO {
    @SerializedName("partner_id")
    private int partner_id;
    @SerializedName("timestamp")
    private long timestamp;
    @SerializedName("access_token")
    private String access_token;
    @SerializedName("shop_id")
    private int shop_id;
    @SerializedName("sign")
    private String sign;
}
