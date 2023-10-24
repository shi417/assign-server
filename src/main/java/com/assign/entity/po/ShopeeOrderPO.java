package com.assign.entity.po;


import java.io.Serializable;
import java.util.Date;

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
     * root_id
     */
    private String id;

    /**
     * 0
     */
    private Double actualShippingFee;

    /**
     * false
     */
    private Integer actualShippingFeeConfirmed;

    /**
     * 
     */
    private String buyerCancelReason;

    /**
     * 
     */
    private String buyerCpfId;

    /**
     * 0
     */
    private Long buyerUserId;

    /**
     * 
     */
    private String buyerUsername;

    /**
     * 
     */
    private String cancelBy;

    /**
     * 
     */
    private String cancelReason;

    /**
     * 
     */
    private String checkoutShippingCarrier;

    /**
     * false
     */
    private Integer cod;

    /**
     * 0
     */
    private Long createTime;

    /**
     * 
     */
    private String currency;

    /**
     * 0
     */
    private Long daysToShip;

    /**
     * 
     */
    private String dropshipper;

    /**
     * 
     */
    private String dropshipperPhone;

    /**
     * 0
     */
    private Double estimatedShippingFee;

    /**
     * 
     */
    private String fulfillmentFlag;

    /**
     * false
     */
    private Integer goodsToDeclare;

    /**
     * 
     */
    private String messageToSeller;

    /**
     * 
     */
    private String note;

    /**
     * 0
     */
    private Date noteUpdateTime;

    /**
     * 
     */
    private String orderSn;

    /**
     * 
     */
    private String orderStatus;

    /**
     * 0
     */
    private Long payTime;

    /**
     * 
     */
    private String paymentMethod;

    /**
     * 0
     */
    private Long pickupDoneTime;

    /**
     * 
     */
    private String region;

    /**
     * 0
     */
    private Double reverseShippingFee;

    /**
     * 0
     */
    private Long shipByDate;

    /**
     * 
     */
    private String shippingCarrier;

    /**
     * false
     */
    private Integer splitUp;

    /**
     * 0
     */
    private Double totalAmount;

    /**
     * 0
     */
    private Long updateTime;

    private static final long serialVersionUID = 1L;


}