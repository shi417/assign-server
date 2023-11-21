
package com.assign.feign.vo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class AuthedShopListVO {

    @JsonProperty("auth_time")
    private Long authTime;
    @JsonProperty("expire_time")
    private Long expireTime;
    @JsonProperty
    private String region;
    @JsonProperty("shop_id")
    private Integer shopId;
    @JsonProperty("sip_affi_shop_list")
    private List<Object> sipAffiShopList;


}
