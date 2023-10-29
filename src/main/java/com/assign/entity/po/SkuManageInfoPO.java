package com.assign.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku检索表
 * @TableName sku_manage_info
 */
@TableName(value ="sku_manage_info")
@Data
public class SkuManageInfoPO implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 简介
     */
    private String introduction;

    /**
     * sku货号
     */
    private String skuDesc;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 备注
     */
    private String content;

    /**
     * 来源
     */
    private Integer source;

    /**
     * 链接
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

    private Integer isBase;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}