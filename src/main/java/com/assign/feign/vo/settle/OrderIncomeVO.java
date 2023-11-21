package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

/**
 * OrderIncomeVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class OrderIncomeVO {
    @JsonProperty("actual_shipping_fee")
    private Long actualShippingFee;
    @JsonProperty("buyer_paid_shipping_fee")
    private Long buyerPaidShippingFee;
    @JsonProperty("buyer_total_amount")
    private Long buyerTotalAmount;
    @JsonProperty("buyer_transaction_fee")
    private Long buyerTransactionFee;
    @JsonProperty("campaign_fee")
    private Long campaignFee;
    @Expose
    private Long coins;
    @JsonProperty("commission_fee")
    private Long commissionFee;
    @JsonProperty("cost_of_goods_sold")
    private Long costOfGoodsSold;
    @JsonProperty("credit_card_promotion")
    private Long creditCardPromotion;
    @JsonProperty("credit_card_transaction_fee")
    private Long creditCardTransactionFee;
    @JsonProperty("cross_border_tax")
    private Long crossBorderTax;
    @JsonProperty("delivery_seller_protection_fee_premium_amount")
    private Long deliverySellerProtectionFeePremiumAmount;
    @JsonProperty("drc_adjustable_refund")
    private Long drcAdjustableRefund;
    @JsonProperty("escrow_amount")
    private Long escrowAmount;
    @JsonProperty("escrow_amount_after_adjustment")
    private Long escrowAmountAfterAdjustment;
    @JsonProperty("escrow_tax")
    private Long escrowTax;
    @JsonProperty("estimated_shipping_fee")
    private Long estimatedShippingFee;
    @JsonProperty("final_escrow_product_gst")
    private Long finalEscrowProductGst;
    @JsonProperty("final_escrow_shipping_gst")
    private Long finalEscrowShippingGst;
    @JsonProperty("final_product_protection")
    private Long finalProductProtection;
    @JsonProperty("final_product_vat_tax")
    private Long finalProductVatTax;
    @JsonProperty("final_return_to_seller_shipping_fee")
    private Long finalReturnToSellerShippingFee;
    @JsonProperty("final_shipping_fee")
    private Long finalShippingFee;
    @JsonProperty("final_shipping_vat_tax")
    private Long finalShippingVatTax;
    @JsonProperty("fsf_seller_protection_fee_claim_amount")
    private Long fsfSellerProtectionFeeClaimAmount;
    @JsonProperty("items")
    private List<SettleItemVO> settleItemVOS;
    @JsonProperty("order_ams_commission_fee")
    private Long orderAmsCommissionFee;
    @JsonProperty("order_chargeable_weight")
    private Long orderChargeableWeight;
    @JsonProperty("original_cost_of_goods_sold")
    private Long originalCostOfGoodsSold;
    @JsonProperty("original_price")
    private Long originalPrice;
    @JsonProperty("original_shopee_discount")
    private Long originalShopeeDiscount;
    @JsonProperty("payment_promotion")
    private Long paymentPromotion;
    @JsonProperty("reverse_shipping_fee")
    private Long reverseShippingFee;
    @JsonProperty("rsf_seller_protection_fee_claim_amount")
    private Long rsfSellerProtectionFeeClaimAmount;
    @JsonProperty("rsf_seller_protection_fee_premium_amount")
    private Long rsfSellerProtectionFeePremiumAmount;
    @JsonProperty("seller_coin_cash_back")
    private Long sellerCoinCashBack;
    @JsonProperty("seller_discount")
    private Long sellerDiscount;
    @JsonProperty("seller_lost_compensation")
    private Long sellerLostCompensation;
    @JsonProperty("seller_return_refund")
    private Long sellerReturnRefund;
    @JsonProperty("seller_shipping_discount")
    private Long sellerShippingDiscount;
    @JsonProperty("seller_transaction_fee")
    private Long sellerTransactionFee;
    @JsonProperty("seller_voucher_code")
    private List<Object> sellerVoucherCode;
    @JsonProperty("service_fee")
    private Long serviceFee;
    @JsonProperty("shipping_fee_discount_from_3pl")
    private Long shippingFeeDiscountFrom3Pl;
    @JsonProperty("shopee_discount")
    private Long shopeeDiscount;
    @JsonProperty("shopee_shipping_rebate")
    private Long shopeeShippingRebate;
    @JsonProperty("total_adjustment_amount")
    private Long totalAdjustmentAmount;
    @JsonProperty("voucher_from_seller")
    private Long voucherFromSeller;
    @JsonProperty("voucher_from_shopee")
    private Long voucherFromShopee;
}
