package com.assign.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * staff info
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class StaffPO implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

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

    /**
     * 
     */
    private String code;

    /**
     * 密码（先用明文）
     */
    private String password;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}