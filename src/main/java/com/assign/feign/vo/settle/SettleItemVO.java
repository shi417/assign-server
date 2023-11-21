package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SettleItemVO {

    @JsonProperty("activity_id")
    private Long activityId;
    @JsonProperty("activity_type")
    private String activityType;
    @JsonProperty("ams_commission_fee")
    private Long amsCommissionFee;
    @JsonProperty("discount_from_coin")
    private Long discountFromCoin;
    @JsonProperty("discount_from_voucher_seller")
    private Long discountFromVoucherSeller;
    @JsonProperty("discount_from_voucher_shopee")
    private Long discountFromVoucherShopee;
    @JsonProperty("discounted_price")
    private Long discountedPrice;
    @JsonProperty("is_b2c_shop_item")
    private Boolean isB2cShopItem;
    @JsonProperty("is_main_item")
    private Boolean isMainItem;
    @JsonProperty("item_id")
    private Long itemId;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("item_sku")
    private String itemSku;
    @JsonProperty("model_id")
    private Long modelId;
    @JsonProperty("model_name")
    private String modelName;
    @JsonProperty("model_sku")
    private String modelSku;
    @JsonProperty("original_price")
    private Long originalPrice;
    @JsonProperty("quantity_purchased")
    private Long quantityPurchased;
    @JsonProperty("seller_discount")
    private Long sellerDiscount;
    @JsonProperty("shopee_discount")
    private Long shopeeDiscount;
}
