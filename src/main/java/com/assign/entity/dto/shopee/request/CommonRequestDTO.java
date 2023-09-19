package com.assign.entity.dto.shopee.request;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CommonRequestDTO {
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
