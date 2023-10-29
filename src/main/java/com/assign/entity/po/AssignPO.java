package com.assign.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * assign info
 * @TableName assign
 */
@TableName(value ="assign")
@Data
public class AssignPO implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 0:未认领 1:待采购, 2:采购完成,3:已发货
     */
    private Integer status;

    /**
     * 电商平台订单号
     */
    private String ecOrderNo;

    /**
     * 电商平台 商品id
     */
    private String ecProductId;

    /**
     * 订单明细id
     */
    private Long ecItemId;

    /**
     * sku描述
     */
    private String ecItemName;

    /**
     * 货源订单号
     */
    private String buyOrderNo;

    /**
     * 货源链接
     */
    private String buyUrl;

    /**
     * 平台总价格
     */
    private Integer price;

    /**
     * 货代价格
     */
    private Integer agencyPrice;

    /**
     * 0:自主认领， 1:他人分配
     */
    private Integer type;

    /**
     * 操作人
     */
    private Long operatorId;

    /**
     * 操作人
     */
    private String operatorName;

    /**
     * 执行人
     */
    private Long executorId;

    /**
     * 执行人
     */
    private String executorName;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 
     */
    private Date deletedAt;

    private Integer source;

    private Integer quality;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}