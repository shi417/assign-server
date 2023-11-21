package com.assign.service.assign;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.assign.AssignRequestDTO;
import com.assign.entity.po.AssignPO;
import com.assign.service.common.CommonService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * AssignService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/27.
 */
public interface AssignService extends IService<AssignPO> {
    ResponseResult<Page<AssignPO>> selectPage(AssignRequestDTO params);

    public ResponseResult<Object> saveOrUpdate(AssignRequestDTO params);
}
