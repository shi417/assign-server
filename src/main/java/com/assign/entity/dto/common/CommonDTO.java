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
public class CommonDTO {

    /**
     *页面大小
     */
    private Integer pageSize;

    /**
     * 游标
     */
    private Integer currentPage;
}
