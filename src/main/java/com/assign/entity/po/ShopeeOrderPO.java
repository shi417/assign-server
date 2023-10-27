package com.assign.entity.po;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * shopee_order
 * @TableName shopee_order
 */
@Data
@TableName("shopee_order")
public class ShopeeOrderPO implements Serializable {
    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 订单的实际运费（如果有的话）来自外部物流合作伙伴
     */
    private Double actualShippingFee;

    /**
     * 实际运费是否已确认
     */
    private Integer actualShippingFeeConfirmed;

    /**
     * 取消原因
     */
    private String buyerCancelReason;

    /**
     * 买家的税务和发票用途的巴西订单的CPF号码
     */
    private String buyerCpfId;

    /**
     * 买家用户ID
     */
    private Long buyerUserId;

    /**
     *
     */
    private String buyerUsername;

    /**
     * Could be one of buyer, seller, system or Ops
     */
    private String cancelBy;

    /**
     * 取消原因
     */
    private String cancelReason;

    /**
     * 对于非蒙面订单，是买家为交付物品选择的物流服务提供商。对于蒙面订单，是买家为交付物品选择的物流服务类型。
     */
    private String checkoutShippingCarrier;

    /**
     * 默认情况下返回。这个值表示订单是否为货到付款订单
     */
    private Integer cod;

    /**
     * 0
     */
    private Long createTime;

    /**
     * 币别
     */
    private String currency;

    /**
     * 默认返回。卖家在Shopee上列出商品时设置的发货准备时间
     */
    private Long daysToShip;

    /**
     * 仅适用于印度尼西亚订单。代发货人的姓名。
     */
    private String dropshipper;

    /**
     *
     */
    private String dropshipperPhone;

    /**
     * 估计的运费是由Shopee根据特定物流快递的标准计算得出的估算值。
     */
    private Double estimatedShippingFee;

    /**
     * 使用这个字段来指示订单是由Shopee履行还是由卖家履行。适用的值为：fulfilled_by_shopee（由Shopee履行）、fulfilled_by_cb_seller（由跨境卖家履行）、fulfilled_by_local_seller（由本地卖家履行）。
     */
    private String fulfillmentFlag;

    /**
     * 仅适用于跨境订单。该值指示订单是否包含需要在海关报关的商品。 "T" 表示是，将在运输标签上标记为 "T"；"F" 表示否，将在运输标签上标记为 "P"。此值仅在生成订单跟踪号之后才准确，请在获取跟踪号后捕获此值。
     */
    private Integer goodsToDeclare;

    /**
     * 给卖家的留言。
     */
    private String messageToSeller;

    /**
     * 卖家为自己参考所做的备注。
     */
    private String note;

    /**
     * 0
     */
    private Date noteUpdateTime;

    /**
     * Shopee's unique identifier for an order
     */
    private String orderSn;

    /**
     *
     */
    private String orderStatus;

    /**
     * 付款时间
     */
    private Long payTime;

    /**
     * 付款方式
     */
    private String paymentMethod;

    /**
     * 取件时间
     */
    private Long pickupDoneTime;

    /**
     * 地区
     */
    private String region;

    /**
     * Shopee为退货订单收取逆向运费。该字段的值将为非负数。
     */
    private Double reverseShippingFee;

    /**
     * 寄出包裹的截止日期
     */
    private Long shipByDate;

    /**
     * 买家为订单选择的交付商品的物流服务提供商。
     */
    private String shippingCarrier;

    /**
     * 用于指示是否将此订单拆分为履行订单（forder）级别。
     */
    private Integer splitUp;

    /**
     * 买家为订单支付的总金额。该金额包括商品的总销售价格、买家承担的运费，以及如有的Shopee促销抵消。此值仅在买家完成订单付款后才会返回。
     */
    private Double totalAmount;

    /**
     * 更新时间
     */
    private Long updateTime;

    private Long shopId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}