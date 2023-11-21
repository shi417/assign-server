package com.assign.entity.dto.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ShopeeSettlePayoutDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopeeSettlePayoutDTO {
    @ApiModelProperty("The exchange rate.")
    private String exchangeRate;

    @ApiModelProperty("The settlement amount.")
    private Long fromAmount;

    @ApiModelProperty("The settlement currency of orders.")
    private String fromCurrency;

    @ApiModelProperty("pay_service")
    private String payService;

    @ApiModelProperty("Seller's account to receive the payout.")
    private String payeeId;

    @ApiModelProperty("The actual amount of payout.")
    private Double payoutAmount;

    @ApiModelProperty("The actual currency of payout.")
    private String payoutCurrency;

    @ApiModelProperty("The time of payout.")
    private Long payoutTime;

    @ApiModelProperty("结算具体订单")
    List<ShopeeSettleResponseDTO> orderSettles;
}
