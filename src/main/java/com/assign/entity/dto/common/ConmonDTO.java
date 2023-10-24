package com.assign.entity.dto.common;

import lombok.Data;

/**
 * ConmonDTO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/7.
 */
@Data
public class ConmonDTO {

    /**
     *页面大小
     */
    private int pageSize;

    /**
     * 游标
     */
    private int currentPage;
}
