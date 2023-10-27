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
     * 0:待采购, 1:采购完成,2:已发货
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
    private Integer operatorId;

    /**
     * 执行人
     */
    private Integer executorId;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AssignPO other = (AssignPO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEcOrderNo() == null ? other.getEcOrderNo() == null : this.getEcOrderNo().equals(other.getEcOrderNo()))
            && (this.getEcProductId() == null ? other.getEcProductId() == null : this.getEcProductId().equals(other.getEcProductId()))
            && (this.getEcItemId() == null ? other.getEcItemId() == null : this.getEcItemId().equals(other.getEcItemId()))
            && (this.getEcItemName() == null ? other.getEcItemName() == null : this.getEcItemName().equals(other.getEcItemName()))
            && (this.getBuyOrderNo() == null ? other.getBuyOrderNo() == null : this.getBuyOrderNo().equals(other.getBuyOrderNo()))
            && (this.getBuyUrl() == null ? other.getBuyUrl() == null : this.getBuyUrl().equals(other.getBuyUrl()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getAgencyPrice() == null ? other.getAgencyPrice() == null : this.getAgencyPrice().equals(other.getAgencyPrice()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getExecutorId() == null ? other.getExecutorId() == null : this.getExecutorId().equals(other.getExecutorId()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEcOrderNo() == null) ? 0 : getEcOrderNo().hashCode());
        result = prime * result + ((getEcProductId() == null) ? 0 : getEcProductId().hashCode());
        result = prime * result + ((getEcItemId() == null) ? 0 : getEcItemId().hashCode());
        result = prime * result + ((getEcItemName() == null) ? 0 : getEcItemName().hashCode());
        result = prime * result + ((getBuyOrderNo() == null) ? 0 : getBuyOrderNo().hashCode());
        result = prime * result + ((getBuyUrl() == null) ? 0 : getBuyUrl().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getAgencyPrice() == null) ? 0 : getAgencyPrice().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getExecutorId() == null) ? 0 : getExecutorId().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", ecOrderNo=").append(ecOrderNo);
        sb.append(", ecProductId=").append(ecProductId);
        sb.append(", ecItemId=").append(ecItemId);
        sb.append(", ecItemName=").append(ecItemName);
        sb.append(", buyOrderNo=").append(buyOrderNo);
        sb.append(", buyUrl=").append(buyUrl);
        sb.append(", price=").append(price);
        sb.append(", agencyPrice=").append(agencyPrice);
        sb.append(", type=").append(type);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", executorId=").append(executorId);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}