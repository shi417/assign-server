package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * PayoutInfoVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class PayoutResponseVO {

    @JsonProperty("payout_info")
    private PayoutInfoVO payoutInfo;

    @JsonProperty("escrow_list")
    private List<EscrowInfoVO> escrowList;
}
