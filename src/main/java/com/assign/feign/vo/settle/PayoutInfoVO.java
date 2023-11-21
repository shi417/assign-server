package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * PayoutInfoVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class PayoutInfoVO {

    @JsonProperty("exchange_rate")
    private String exchangeRate;

    @JsonProperty("from_amount")
    private Long fromAmount;

    @JsonProperty("from_currency")
    private String fromCurrency;

    @JsonProperty("pay_service")
    private String payService;

    @JsonProperty("payee_id")
    private String payeeId;

    @JsonProperty("payout_amount")
    private Double payoutAmount;

    @JsonProperty("payout_currency")
    private String payoutCurrency;

    @JsonProperty("payout_time")
    private Long payoutTime;
}
