package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * EscrowInfoVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class EscrowInfoVO {

    @JsonProperty("escrow_release_time")
    private Long escrowReleaseTime;

    @JsonProperty("order_sn")
    private String orderSn;

    @JsonProperty("payout_amount")
    private BigDecimal amount;
}
