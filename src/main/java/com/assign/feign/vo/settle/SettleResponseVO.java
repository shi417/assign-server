package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * SettleResponseVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class SettleResponseVO {

    @JsonProperty("payout_list")
    private List<PayoutResponseVO> payoutList;
    private boolean more;
}
