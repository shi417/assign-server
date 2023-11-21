package com.assign.feign.vo;

import com.google.gson.annotations.SerializedName;
import io.swagger.models.auth.In;
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
    private Integer shop_id;
    @SerializedName("sign")
    private String sign;
}
