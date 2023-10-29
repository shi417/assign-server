package com.assign.entity.dto.assign;

import com.assign.entity.dto.common.CommonDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AssignRequestDTO extends CommonDTO {

    private Long id;

    /**
     * 0:未认领 1:待采购, 2:采购完成,3:已发货
     */
    @ApiModelProperty("0:未认领 1:待采购, 2:采购完成,3:已发货")
    private Integer status;

    /**
     * 电商平台订单号
     */
    @ApiModelProperty("电商平台订单号")
    private String ecOrderNo;

    @ApiModelProperty("商品id")
    private Long ecItemId;

    /**
     * sku描述
     */
    @ApiModelProperty("sku描述")
    private String ecItemName;

    /**
     * 货源订单号
     */
    @ApiModelProperty("货源订单号")
    private String buyOrderNo;

    /**
     * 货源链接
     */
    @ApiModelProperty("货源链接")
    private String buyUrl;

    /**
     * 货代价格
     */
    @ApiModelProperty("货代价格")
    private Integer agencyPrice;


    /**
     * 操作人
     */
    @ApiModelProperty("操作人")
    private Long operatorId;

    /**
     * 执行人
     */
    @ApiModelProperty("执行人")
    private Long executorId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdAtBegin;

    private Date createdAtEnd;

    @ApiModelProperty("货源 0 pdd 1 淘宝 2 1688 3 其他")
    private Integer source;


}
