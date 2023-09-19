
package com.assign.entity.dto.shopee;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ShopeeDetailDTO {

    @SerializedName("add_on_deal")
    private Boolean addOnDeal;
    @SerializedName("add_on_deal_id")
    private Long addOnDealId;
    @SerializedName("image_info")
    private ImageInfo imageInfo;
    @SerializedName("item_id")
    private Long itemId;
    @SerializedName("item_name")
    private String itemName;
    @SerializedName("item_sku")
    private String itemSku;
    @SerializedName("main_item")
    private Boolean mainItem;
    @SerializedName("model_discounted_price")
    private Long modelDiscountedPrice;
    @SerializedName("model_id")
    private Long modelId;
    @SerializedName("model_name")
    private String modelName;
    @SerializedName("model_original_price")
    private Long modelOriginalPrice;
    @SerializedName("model_quantity")
    private Long modelQuantity;
    @SerializedName("model_quantity_purchased")
    private Long modelQuantityPurchased;
    @SerializedName("model_sku")
    private String modelSku;
    @SerializedName("order_item_id")
    private Long orderItemId;
    @SerializedName("product_location_id")
    private List<String> productLocationId;
    @SerializedName("promotion_group_id")
    private Long promotionGroupId;
    @SerializedName("promotion_id")
    private Long promotionId;
    @SerializedName("promotion_type")
    private String promotionType;
    @Expose
    private Double weight;
    @Expose
    private Boolean wholesale;

}
