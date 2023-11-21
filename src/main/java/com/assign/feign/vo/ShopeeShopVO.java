package com.assign.feign.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ShopeeShopVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/27.
 */
@Data
public class ShopeeShopVO {

    @JsonProperty("shop_name")
    private String shopName;

    @JsonProperty("region")
    private String region;

    /**
     *  BANNED, FROZEN, NORMAL.
     */
    @JsonProperty("status")
    private String status;
}
