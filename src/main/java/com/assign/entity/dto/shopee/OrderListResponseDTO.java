
package com.assign.entity.dto.shopee;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shiyaqing
 */
@Data
public class OrderListResponseDTO {

    @ApiModelProperty(value = "Shopee's unique identifier for an order")
    private String orderSn;
    @ApiModelProperty(value = "状态 中文描述")
    private String status;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "站点")
    private String site;

    @ApiModelProperty(value = "金额")
    private Double totalAmount;

    @ApiModelProperty(value = "下单时间")
    private Date orderTime;

    @ApiModelProperty(value = "支付时间")
    private Date payTime;

    @ApiModelProperty(value = "截止日期")
    private Date shipByDate;
    @JsonProperty("order_list")
    private List<ShopeeDetailResponseDTO> itemList;

}
