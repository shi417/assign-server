package com.assign.entity.dto.shopee;

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

    private String skuDes;

    private String type;

    private String assignUser;

    private String assignStatus;

    private BigDecimal modelDiscountedPrice;

}
