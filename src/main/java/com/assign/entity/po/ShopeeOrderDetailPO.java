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
     * 指示此商品是否属于附加套餐的
     */
    private Integer addOnDeal;

    /**
     * 用于区分购物车和订单中商品组的唯一标识符，例如 AddOnDeal。
     */
    private Integer addOnDealId;

    /**
     *
     */
    private String itemName;

    /**
     * sku名称
     */
    private String itemSku;

    /**
     * 用于指示该商品是主商品还是子商品。True表示主商品，false表示子商品。
     */
    private Integer mainItem;

    /**
     * 商品在列表货币中的折扣后价格。如果没有折扣，此值将与model_original_price相同。在捆绑交易商品的情况下，此值将返回为0，因为捆绑交易折扣不会按商品/型号级别拆分。由于技术限制，如果不将其配置为0，则该值将返回捆绑交易之前的价格。如果您想计算捆绑交易商品的商品级别折扣价格，请调用GetEscrowDetails。
     */
    private BigDecimal modelDiscountedPrice;

    /**
     * Shopee对一个型号的独特标识符
     */
    private Integer modelId;

    /**
     *
     */
    private String modelName;

    /**
     * 商品在列表货币中的原价。
     */
    private BigDecimal modelOriginalPrice;

    /**
     * 同一买家从同一列表/商品中同时购买的相同商品的数量。
     */
    private Integer modelQuantity;

    /**
     * 同一买家从同一列表/商品中同时购买的相同商品的数量
     */
    private Integer modelQuantityPurchased;

    /**
     *
     */
    private String modelSku;

    /**
     * 订单商品的标识。对于同一捆绑交易促销中的商品，order_item_id 应该共享相同的标识，比如 1、2。对于不在捆绑交易促销中的商品，order_item_id 应该与item_id相同。
     */
    private Integer orderItemId;

    /**
     * 产品促销的标识。
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
     * 重量
     */
    private BigDecimal weight;

    /**
     *
     */
    private Integer wholesale;

    /**
     * 订单唯一标识
     */
    private String orderSn;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}