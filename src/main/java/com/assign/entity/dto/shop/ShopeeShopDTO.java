package com.assign.entity.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ShopeeShopDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */

@Data
public class ShopeeShopDTO {

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "地区")
    private String region;

    /**
     *  BANNED, FROZEN, NORMAL.
     */
    @ApiModelProperty(value = "状态  BANNED, FROZEN, NORMAL")
    private String status;
}
