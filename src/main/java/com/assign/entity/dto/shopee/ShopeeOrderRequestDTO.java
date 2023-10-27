package com.assign.entity.dto.shopee;

import com.assign.entity.dto.common.ConmonDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ShopeeOrderRequestDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/26.
 */
@Data
public class ShopeeOrderRequestDTO extends ConmonDTO {

    @ApiModelProperty(value = "订单号")
    private String orderSn;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "创建日期开始")
    private Date createTimeStart;

    @ApiModelProperty(value = "创建日期结束")
    private Date createTimeEnd;

    @ApiModelProperty(value = "付款日期开始")
    private Date payTimeStart;

    @ApiModelProperty(value = "付款日期结束")
    private Date payTimeEnd;

}
