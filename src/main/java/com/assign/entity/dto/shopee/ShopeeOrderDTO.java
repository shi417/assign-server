
package com.assign.entity.dto.shopee;

import java.util.List;

import com.assign.entity.dto.common.ConmonDTO;
import com.assign.entity.dto.shopee.request.CommonRequestDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
@Data
public class ShopeeOrderDTO extends ConmonDTO {

    @JsonProperty("actual_shipping_fee")
    @ApiModelProperty(value = "订单的实际运费（如果有的话）来自外部物流合作伙伴")
    private Double actualShippingFee;
    @JsonProperty("actual_shipping_fee_confirmed")
    private Boolean actualShippingFeeConfirmed;
    @JsonProperty("buyer_cancel_reason")
    private String buyerCancelReason;
    @JsonProperty("buyer_cpf_id")
    private String buyerCpfId;
    @JsonProperty("buyer_user_id")
    private Long buyerUserId;
    @JsonProperty("buyer_username")
    private String buyerUsername;
    @JsonProperty("cancel_by")
    private String cancelBy;
    @JsonProperty("cancel_reason")
    private String cancelReason;
    @JsonProperty("checkout_shipping_carrier")
    private String checkoutShippingCarrier;
    @Expose
    private Boolean cod;//是否是货到付款
    @JsonProperty("create_time")
    private Long createTime;
    @Expose
    private String currency;
    @JsonProperty("days_to_ship")
    private Long daysToShip;
    @Expose
    private String dropshipper;
    @JsonProperty("dropshipper_phone")
    private String dropshipperPhone;
    @JsonProperty("estimated_shipping_fee")
    private Double estimatedShippingFee;
    @JsonProperty("fulfillment_flag")
    private String fulfillmentFlag;
    @JsonProperty("goods_to_declare")
    private Boolean goodsToDeclare;
    @JsonProperty("invoice_data")
    private InvoiceDTO invoiceData;
    @JsonProperty("item_list")
    private List<ShopeeOrderDetailDTO> shopeeOrderDetailDTO;
    @JsonProperty("message_to_seller")
    private String messageToSeller;
    @Expose
    private String note;
    @JsonProperty("note_update_time")
    private Long noteUpdateTime;
    @JsonProperty("order_sn")
    private String orderSn;
    @JsonProperty("order_status")
    private String orderStatus;
    @JsonProperty("package_list")
    private List<PackageList> packageList;
    @JsonProperty("pay_time")
    private Long payTime;
    @JsonProperty("pay_time_begin")
    private Long payTimeBegin;
    @JsonProperty("pay_time_end")
    private Long payTimeEnd;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("pickup_done_time")//取货时间
    private Long pickupDoneTime;
    @JsonProperty("recipient_address")
    private RecipientAddress recipientAddress;
    @Expose
    private String region;
    @JsonProperty("reverse_shipping_fee.")
    private Double reverseShippingFee;
    @JsonProperty("ship_by_date")// 截至寄出时间
    private Long shipByDate;
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;
    @JsonProperty("split_up")
    private Boolean splitUp;
    @JsonProperty("total_amount")
    private Double totalAmount;
    @JsonProperty("update_time")
    private Long updateTime;

}
