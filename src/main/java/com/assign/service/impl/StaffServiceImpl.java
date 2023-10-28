package com.assign.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.entity.po.StaffPO;
import com.assign.mapper.StaffMapper;
import com.assign.service.StaffService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffPO>
        implements StaffService {
    private final StaffMapper staffMapper;
    @Override
    public StaffPO selectByUserCode(String userCode) {
        return staffMapper.selectByUserCode(userCode);
    }

    @Override
    public ResponseResult<List<StaffPO>> selectPage(StaffDTO params) {

        QueryWrapper<StaffPO> queryWrapper =  new QueryWrapper<>();
        if (StringUtils.isNotEmpty(params.getCode())){
            queryWrapper.lambda().eq(StaffPO::getCode, params.getCode());
        }
        List<StaffPO> staffPOS = staffMapper.selectList(queryWrapper);
        return ResponseResult.success(staffPOS);
    }
}
