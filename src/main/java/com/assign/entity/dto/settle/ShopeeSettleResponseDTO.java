package com.assign.entity.dto.settle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ShopeeSettleResponseDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopeeSettleResponseDTO {

    @ApiModelProperty(value = "")
    private String orderSn;

    @ApiModelProperty(value = "结算时间")
    private Date releaseTime;

    @ApiModelProperty(value = "结算金额原币")
    private BigDecimal amount;

    @ApiModelProperty(value = "结算金额原币item求和所得")
    private BigDecimal amountSum;

    @ApiModelProperty(value = "币别")
    private String currency;

    @ApiModelProperty(value = "结算金额人民币")
    private BigDecimal curAmount;

    @ApiModelProperty(value = "结算金额人民币item求和所得")
    private BigDecimal curAmountSum;

    @ApiModelProperty(value = "sku详细信息")
    private List<ShopeeSettleDetailDTO> detailList;

}
