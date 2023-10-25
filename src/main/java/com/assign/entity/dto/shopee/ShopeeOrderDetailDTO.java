
package com.assign.entity.dto.shopee;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class ShopeeOrderDetailDTO {

    @JsonProperty("add_on_deal")
    private Boolean addOnDeal;
    @JsonProperty("add_on_deal_id")
    private Long addOnDealId;
    @JsonProperty("image_info")
    private ImageInfo imageInfo;
    @JsonProperty("item_id")
    private Long itemId;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("item_sku")
    private String itemSku;
    @JsonProperty("main_item")
    private Boolean mainItem;
    @JsonProperty("model_discounted_price")
    private Long modelDiscountedPrice;
    @JsonProperty("model_id")
    private Long modelId;
    @JsonProperty("model_name")
    private String modelName;
    @JsonProperty("model_original_price")
    private Long modelOriginalPrice;
    @JsonProperty("model_quantity")
    private Long modelQuantity;
    @JsonProperty("model_quantity_purchased")
    private Long modelQuantityPurchased;
    @JsonProperty("model_sku")
    private String modelSku;
    @JsonProperty("order_item_id")
    private Long orderItemId;
    @JsonProperty("product_location_id")
    private List<String> productLocationId;
    @JsonProperty("promotion_group_id")
    private Long promotionGroupId;
    @JsonProperty("promotion_id")
    private Long promotionId;
    @JsonProperty("promotion_type")
    private String promotionType;
    @Expose
    private Double weight;
    @Expose
    private Boolean wholesale;

    private String orderSn;
}
