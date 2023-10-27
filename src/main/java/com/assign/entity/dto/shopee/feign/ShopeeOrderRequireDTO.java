
package com.assign.entity.dto.shopee.feign;

import java.util.List;

import com.assign.entity.dto.common.ConmonDTO;
import com.assign.entity.dto.shopee.PackageList;
import com.assign.entity.dto.shopee.RecipientAddress;
import com.assign.entity.dto.shopee.ShopeeOrderDetailDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
@Data
public class ShopeeOrderRequireDTO extends ConmonDTO {

    @JsonProperty("actual_shipping_fee")
    @ApiModelProperty(value = "订单的实际运费（如果有的话）来自外部物流合作伙伴")
    private Double actualShippingFee;
    
    @JsonProperty("actual_shipping_fee_confirmed")
    @ApiModelProperty(value = "实际运费是否已确认")
    private Boolean actualShippingFeeConfirmed;
    
    @JsonProperty("buyer_cancel_reason")
    @ApiModelProperty(value = "取消原因")
    private String buyerCancelReason;
    
    @JsonProperty("buyer_cpf_id")
    @ApiModelProperty(value = "买家的税务和发票用途的巴西订单的CPF号码")
    private String buyerCpfId;
    
    @JsonProperty("buyer_user_id")
    @ApiModelProperty(value = "买家用户ID")
    private Long buyerUserId;
    
    @JsonProperty("buyer_username")
    @ApiModelProperty(value = "买家用户姓名")
    private String buyerUsername;
    
    @JsonProperty("cancel_by")
    @ApiModelProperty(value = "Could be one of buyer, seller, system or Ops")
    private String cancelBy;
    
    @JsonProperty("cancel_reason")
    @ApiModelProperty(value = "取消原因")
    private String cancelReason;
    
    @JsonProperty("checkout_shipping_carrier")
    @ApiModelProperty(value = "对于非蒙面订单，是买家为交付物品选择的物流服务提供商。对于蒙面订单，是买家为交付物品选择的物流服务类型。")
    private String checkoutShippingCarrier;

    @ApiModelProperty(value = "默认情况下返回。这个值表示订单是否为货到付款订单")
    @Expose
    private Boolean cod;//是否是货到付款
    
    @JsonProperty("create_time")
    @ApiModelProperty(value = "createTime")
    private Long createTime;
    
    @Expose
    @ApiModelProperty(value = "币别")
    private String currency;
    
    @JsonProperty("days_to_ship")
    @ApiModelProperty(value = "默认返回。卖家在Shopee上列出商品时设置的发货准备时间")
    private Long daysToShip;
    
    @Expose
    @ApiModelProperty(value = "仅适用于印度尼西亚订单。代发货人的姓名。")
    private String dropshipper;

    @ApiModelProperty(value = "")
    @JsonProperty("dropshipper_phone")
    private String dropshipperPhone;

    @ApiModelProperty(value = "估计的运费是由Shopee根据特定物流快递的标准计算得出的估算值。")
    @JsonProperty("estimated_shipping_fee")
    private Double estimatedShippingFee;

    @ApiModelProperty(value = "使用这个字段来指示订单是由Shopee履行还是由卖家履行。适用的值为：fulfilled_by_shopee（由Shopee履行）、fulfilled_by_cb_seller（由跨境卖家履行）、fulfilled_by_local_seller（由本地卖家履行）。")
    @JsonProperty("fulfillment_flag")
    private String fulfillmentFlag;

    @ApiModelProperty(value = "仅适用于跨境订单。该值指示订单是否包含需要在海关报关的商品。 \"T\" 表示是，将在运输标签上标记为 \"T\"；\"F\" 表示否，将在运输标签上标记为 \"P\"。此值仅在生成订单跟踪号之后才准确，请在获取跟踪号后捕获此值。")
    @JsonProperty("goods_to_declare")
    private Boolean goodsToDeclare;


    @ApiModelProperty(value = "给卖家的留言")
    @JsonProperty("message_to_seller")
    private String messageToSeller;

    @ApiModelProperty(value = "卖家为自己参考所做的备注")
    @Expose
    private String note;

    @ApiModelProperty(value = "noteUpdateTime")
    @JsonProperty("note_update_time")
    private Long noteUpdateTime;

    @ApiModelProperty(value = "Shopee's unique identifier for an order")
    @JsonProperty("order_sn")
    private String orderSn;

//    @ApiModelProperty(value = "")
//    @JsonProperty("invoice_data")
//    private InvoiceDTO invoiceData;

    @ApiModelProperty(value = "sku列表")
    @JsonProperty("item_list")
    private List<ShopeeOrderDetailDTO> shopeeOrderDetailDTO;

    @ApiModelProperty(value = "")
    @JsonProperty("order_status")
    private String orderStatus;

    @ApiModelProperty(value = "tt")
    @JsonProperty("package_list")
    private List<PackageList> packageList;

    @ApiModelProperty(value = "付款时间")
    @JsonProperty("pay_time")
    private Long payTime;

    @ApiModelProperty(value = "tt")
    @JsonProperty("pay_time_begin")
    private Long payTimeBegin;

    @ApiModelProperty(value = "tt")
    @JsonProperty("pay_time_end")
    private Long payTimeEnd;

    @ApiModelProperty(value = "付款方式")
    @JsonProperty("payment_method")
    private String paymentMethod;

    @ApiModelProperty(value = "取货时间")
    @JsonProperty("pickup_done_time")//取货时间
    private Long pickupDoneTime;

    @ApiModelProperty(value = "tt")
    @JsonProperty("recipient_address")
    private RecipientAddress recipientAddress;

    @ApiModelProperty(value = "地区")
    @Expose
    private String region;

    @ApiModelProperty(value = "Shopee为退货订单收取逆向运费。该字段的值将为非负数。")
    @JsonProperty("reverse_shipping_fee.")
    private Double reverseShippingFee;

    @ApiModelProperty(value = "截至寄出时间")
    @JsonProperty("ship_by_date")
    private Long shipByDate;

    @ApiModelProperty(value = "买家为订单选择的交付商品的物流服务提供商")
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;

    @ApiModelProperty(value = "用于指示是否将此订单拆分为履行订单（forder）级别。")
    @JsonProperty("split_up")
    private Boolean splitUp;

    @ApiModelProperty(value = "买家为订单支付的总金额。该金额包括商品的总销售价格、买家承担的运费，以及如有的Shopee促销抵消。此值仅在买家完成订单付款后才会返回。")
    @JsonProperty("total_amount")
    private Double totalAmount;

    @ApiModelProperty(value = "更新时间")
    @JsonProperty("update_time")
    private Long updateTime;

}
