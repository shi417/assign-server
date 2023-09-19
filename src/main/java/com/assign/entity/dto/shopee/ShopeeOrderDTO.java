
package com.assign.entity.dto.shopee;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ShopeeOrderDTO {

    @SerializedName("actual_shipping_fee")
    private Double actualShippingFee;
    @SerializedName("actual_shipping_fee_confirmed")
    private Boolean actualShippingFeeConfirmed;
    @SerializedName("buyer_cancel_reason")
    private String buyerCancelReason;
    @SerializedName("buyer_cpf_id")
    private String buyerCpfId;
    @SerializedName("buyer_user_id")
    private Long buyerUserId;
    @SerializedName("buyer_username")
    private String buyerUsername;
    @SerializedName("cancel_by")
    private String cancelBy;
    @SerializedName("cancel_reason")
    private String cancelReason;
    @SerializedName("checkout_shipping_carrier")
    private String checkoutShippingCarrier;
    @Expose
    private Boolean cod;
    @SerializedName("create_time")
    private Long createTime;
    @Expose
    private String currency;
    @SerializedName("days_to_ship")
    private Long daysToShip;
    @Expose
    private String dropshipper;
    @SerializedName("dropshipper_phone")
    private String dropshipperPhone;
    @SerializedName("estimated_shipping_fee")
    private Double estimatedShippingFee;
    @SerializedName("fulfillment_flag")
    private String fulfillmentFlag;
    @SerializedName("goods_to_declare")
    private Boolean goodsToDeclare;
    @SerializedName("invoice_data")
    private InvoiceDTO invoiceData;
    @SerializedName("item_list")
    private List<ShopeeDetailDTO> shopeeDetailDTO;
    @SerializedName("message_to_seller")
    private String messageToSeller;
    @Expose
    private String note;
    @SerializedName("note_update_time")
    private Long noteUpdateTime;
    @SerializedName("order_sn")
    private String orderSn;
    @SerializedName("order_status")
    private String orderStatus;
    @SerializedName("package_list")
    private List<PackageList> packageList;
    @SerializedName("pay_time")
    private Long payTime;
    @SerializedName("payment_method")
    private String paymentMethod;
    @SerializedName("pickup_done_time")
    private Long pickupDoneTime;
    @SerializedName("recipient_address")
    private RecipientAddress recipientAddress;
    @Expose
    private String region;
    @SerializedName("reverse_shipping_fee.")
    private Double reverseShippingFee;
    @SerializedName("ship_by_date")
    private Long shipByDate;
    @SerializedName("shipping_carrier")
    private String shippingCarrier;
    @SerializedName("split_up")
    private Boolean splitUp;
    @SerializedName("total_amount")
    private Double totalAmount;
    @SerializedName("update_time")
    private Long updateTime;

}
