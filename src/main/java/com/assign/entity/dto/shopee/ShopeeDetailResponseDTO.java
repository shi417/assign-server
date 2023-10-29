package com.assign.entity.dto.shopee;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ShopeeDetailResponseDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/27.
 */
@Data
public class ShopeeDetailResponseDTO {

    @ApiModelProperty(value = "sku")
    private String skuDes;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "认领人")
    private String assignUser;

    @ApiModelProperty(value = "认领状态 0:未认领 1:待采购, 2:采购完成,3:已发货")
    private String assignStatus;

    @ApiModelProperty(value = "折扣价")
    private BigDecimal modelDiscountedPrice;

    @ApiModelProperty(value = "原价")
    private BigDecimal modelOriginalPrice;

    @ApiModelProperty(value = "商品唯一识别码")
    private Long itemId;

    @ApiModelProperty(value = "商品id")
    private Long id;

}
