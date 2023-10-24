package com.assign.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName shopee_order_detail
 */
@TableName(value ="shopee_order_detail")
@Data
public class ShopeeOrderDetailPO implements Serializable {
    /**
     * 
     */
    @TableId
    private Long itemId;

    /**
     * 
     */
    private Boolean addOnDeal;

    /**
     * 
     */
    private Integer addOnDealId;

    /**
     * 
     */
    private String itemName;

    /**
     * 
     */
    private String itemSku;

    /**
     * 
     */
    private Integer mainItem;

    /**
     * 
     */
    private BigDecimal modelDiscountedPrice;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 
     */
    private String modelName;

    /**
     * 
     */
    private BigDecimal modelOriginalPrice;

    /**
     * 
     */
    private Integer modelQuantity;

    /**
     * 
     */
    private Integer modelQuantityPurchased;

    /**
     * 
     */
    private String modelSku;

    /**
     * 
     */
    private Integer orderItemId;

    /**
     * 
     */
    private Integer promotionGroupId;

    /**
     * 
     */
    private Integer promotionId;

    /**
     * 
     */
    private String promotionType;

    /**
     * 
     */
    private BigDecimal weight;

    /**
     * 
     */
    private Integer wholesale;

    /**
     * 
     */
    private String orderSn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShopeeOrderDetailPO other = (ShopeeOrderDetailPO) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getAddOnDeal() == null ? other.getAddOnDeal() == null : this.getAddOnDeal().equals(other.getAddOnDeal()))
            && (this.getAddOnDealId() == null ? other.getAddOnDealId() == null : this.getAddOnDealId().equals(other.getAddOnDealId()))
            && (this.getItemName() == null ? other.getItemName() == null : this.getItemName().equals(other.getItemName()))
            && (this.getItemSku() == null ? other.getItemSku() == null : this.getItemSku().equals(other.getItemSku()))
            && (this.getMainItem() == null ? other.getMainItem() == null : this.getMainItem().equals(other.getMainItem()))
            && (this.getModelDiscountedPrice() == null ? other.getModelDiscountedPrice() == null : this.getModelDiscountedPrice().equals(other.getModelDiscountedPrice()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelOriginalPrice() == null ? other.getModelOriginalPrice() == null : this.getModelOriginalPrice().equals(other.getModelOriginalPrice()))
            && (this.getModelQuantity() == null ? other.getModelQuantity() == null : this.getModelQuantity().equals(other.getModelQuantity()))
            && (this.getModelQuantityPurchased() == null ? other.getModelQuantityPurchased() == null : this.getModelQuantityPurchased().equals(other.getModelQuantityPurchased()))
            && (this.getModelSku() == null ? other.getModelSku() == null : this.getModelSku().equals(other.getModelSku()))
            && (this.getOrderItemId() == null ? other.getOrderItemId() == null : this.getOrderItemId().equals(other.getOrderItemId()))
            && (this.getPromotionGroupId() == null ? other.getPromotionGroupId() == null : this.getPromotionGroupId().equals(other.getPromotionGroupId()))
            && (this.getPromotionId() == null ? other.getPromotionId() == null : this.getPromotionId().equals(other.getPromotionId()))
            && (this.getPromotionType() == null ? other.getPromotionType() == null : this.getPromotionType().equals(other.getPromotionType()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getWholesale() == null ? other.getWholesale() == null : this.getWholesale().equals(other.getWholesale()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getAddOnDeal() == null) ? 0 : getAddOnDeal().hashCode());
        result = prime * result + ((getAddOnDealId() == null) ? 0 : getAddOnDealId().hashCode());
        result = prime * result + ((getItemName() == null) ? 0 : getItemName().hashCode());
        result = prime * result + ((getItemSku() == null) ? 0 : getItemSku().hashCode());
        result = prime * result + ((getMainItem() == null) ? 0 : getMainItem().hashCode());
        result = prime * result + ((getModelDiscountedPrice() == null) ? 0 : getModelDiscountedPrice().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelOriginalPrice() == null) ? 0 : getModelOriginalPrice().hashCode());
        result = prime * result + ((getModelQuantity() == null) ? 0 : getModelQuantity().hashCode());
        result = prime * result + ((getModelQuantityPurchased() == null) ? 0 : getModelQuantityPurchased().hashCode());
        result = prime * result + ((getModelSku() == null) ? 0 : getModelSku().hashCode());
        result = prime * result + ((getOrderItemId() == null) ? 0 : getOrderItemId().hashCode());
        result = prime * result + ((getPromotionGroupId() == null) ? 0 : getPromotionGroupId().hashCode());
        result = prime * result + ((getPromotionId() == null) ? 0 : getPromotionId().hashCode());
        result = prime * result + ((getPromotionType() == null) ? 0 : getPromotionType().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getWholesale() == null) ? 0 : getWholesale().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", addOnDeal=").append(addOnDeal);
        sb.append(", addOnDealId=").append(addOnDealId);
        sb.append(", itemName=").append(itemName);
        sb.append(", itemSku=").append(itemSku);
        sb.append(", mainItem=").append(mainItem);
        sb.append(", modelDiscountedPrice=").append(modelDiscountedPrice);
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", modelOriginalPrice=").append(modelOriginalPrice);
        sb.append(", modelQuantity=").append(modelQuantity);
        sb.append(", modelQuantityPurchased=").append(modelQuantityPurchased);
        sb.append(", modelSku=").append(modelSku);
        sb.append(", orderItemId=").append(orderItemId);
        sb.append(", promotionGroupId=").append(promotionGroupId);
        sb.append(", promotionId=").append(promotionId);
        sb.append(", promotionType=").append(promotionType);
        sb.append(", weight=").append(weight);
        sb.append(", wholesale=").append(wholesale);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}