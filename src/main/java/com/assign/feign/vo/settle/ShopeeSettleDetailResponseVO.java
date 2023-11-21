package com.assign.feign.vo.settle;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * ShopeeSettleDetailResponseVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopeeSettleDetailResponseVO {

    @JsonProperty("order_sn")
    private String orderSn;

    @JsonProperty("buyer_user_name")
    private String buyerUserName;

    @JsonProperty("order_income")
    private OrderIncomeVO orderIncome;
}
