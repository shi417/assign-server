package com.assign.entity.dto.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ShopeeSettleDetailDTO
 * Description:
 * Version: \
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopeeSettleDetailDTO {
    @ApiModelProperty("activity_id")
    private Long activityId;
    @ApiModelProperty("activity_type")
    private String activityType;
    @ApiModelProperty("ams_commission_fee")
    private BigDecimal amsCommissionFee;
    @ApiModelProperty("The offset of this item when the buyer consumed Shopee Coins upon checkout. In case of bundle deal item, this value will return 0. Due to technical restriction, this field will return incorrect value under bundle deal case if we don’t configure it to 0.")
    private BigDecimal discountFromCoin;
    @ApiModelProperty("The offset of this item when the buyer use seller-specific voucher. In case of bundle deal item, this value will return 0. Due to technical restriction, this field will return incorrect value under bundle deal case if we don’t configure it to 0.")
    private BigDecimal discountFromVoucherSeller;
    @ApiModelProperty("The offset of this item when the buyer use Shopee voucher. In case of bundle deal item, this value will return 0. Due to technical restriction, this field will return incorrect value under bundle deal case if we don’t configure it to 0.")
    private BigDecimal discountFromVoucherShopee;
    @ApiModelProperty("The after-discount price of the item in the listing currency. It returns the subtotal of that specific item if quantity exceeds 1. If there is no discount, this value will be the same as that of original_price.")
    private BigDecimal discountedPrice;
    @ApiModelProperty("is_b2c_shop_item")
    private Boolean isB2cShopItem;
    @ApiModelProperty("is_main_item")
    private Boolean isMainItem;
    @ApiModelProperty("item_id")
    private Long itemId;
    @ApiModelProperty("item_name")
    private String itemName;
    @ApiModelProperty("item_sku")
    private String itemSku;
    @ApiModelProperty("model_id")
    private Long modelId;
    @ApiModelProperty("model_name")
    private String modelName;
    @ApiModelProperty("model_sku")
    private String modelSku;
    @ApiModelProperty("The original price of the item before ANY promotion/discount in the listing currency. It returns the subtotal of that specific item if quantity exceeds 1.")
    private BigDecimal originalPrice;
    @ApiModelProperty("quantity_purchased")
    private Long quantityPurchased;
    @ApiModelProperty("The discount provided by seller for this item")
    private BigDecimal sellerDiscount;
    @ApiModelProperty("The discount provided by Shopee for this item")
    private BigDecimal shopeeDiscount;
}
