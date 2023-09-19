package com.assign.entity.po;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * token info
 * @TableName tokens
 */
@Data
@Entity
public class TokensPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 主体id
     */
    @Column(name = "object_id") // 指定数据库字段名
    private Long objectId;

    /**
     * 1 shop,2 merchant
     */
    @Column(name = "object_type") // 指定数据库字段名
    private Integer objectType;

    /**
     *
     */
    @Column(name = "refresh_token") // 指定数据库字段名
    private String refreshToken;

    /**
     *
     */
    @Column(name = "access_token") // 指定数据库字段名
    private String accessToken;

    /**
     * 创建时间
     */
    @Column(name = "created_at") // 指定数据库字段名
    private Date createdAt;

    /**
     * 修改时间
     */
    @Column(name = "updated_at") // 指定数据库字段名
    private Date updatedAt;

    /**
     *
     */
    @Column(name = "deleted_at") // 指定数据库字段名
    private Date deletedAt;

    private static final long serialVersionUID = 1L;


}