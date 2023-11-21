package com.assign.service.staff;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.StaffPO;
import com.assign.service.common.CommonService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface StaffService extends IService<StaffPO> {
    StaffPO selectByUserCode(String username);

    ResponseResult<List<StaffPO>> selectPage(StaffDTO params);
}
