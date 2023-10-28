package com.assign.service.impl;

import cn.hutool.core.convert.Convert;
import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.assign.AssignRequestDTO;
import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.AssignPO;
import com.assign.entity.po.StaffPO;
import com.assign.mapper.AssignMapper;
import com.assign.service.AssignService;
import com.assign.service.OrderService;
import com.assign.service.StaffService;
import com.assign.util.UserUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * AssignServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/27.
 */
@Service
@AllArgsConstructor
public class AssignServiceImpl extends ServiceImpl<AssignMapper, AssignPO>
        implements AssignService {

    private final AssignMapper assignMapper;

    private final StaffService staffService;

    private final OrderService orderService;
    @Override
    public ResponseResult<Page<AssignPO>> selectPage(AssignRequestDTO params) {
        QueryWrapper<AssignPO> queryWrapper =  new QueryWrapper<>();
        if (StringUtils.isNotEmpty(params.getEcOrderNo())){
            queryWrapper.lambda().eq(AssignPO::getEcOrderNo, params.getEcOrderNo());
        }
        if (params.getExecutorId() != null){
            queryWrapper.lambda().eq(AssignPO::getEcOrderNo, params.getEcOrderNo());
        }
        queryWrapper.lambda().isNotNull(AssignPO::getDeletedAt);
        Page<AssignPO> page = new Page<>(params.getCurrentPage(),params.getPageSize());
        Page<AssignPO> assignPOPage = assignMapper.selectPage(page, queryWrapper);
        return ResponseResult.success(assignPOPage);
    }

    @Override
    public ResponseResult<Object> saveOrUpdate(AssignRequestDTO params){
        if (StringUtils.isEmpty(params.getEcOrderNo()) ){
            return ResponseResult.failed("虾皮订单号为空");
        }
        AssignPO po = Convert.convert(AssignPO.class, params);
        StaffDTO loginStaff = UserUtils.getLoginStaff();
        StaffPO staffPO = staffService.selectByUserCode(loginStaff.getCode());
        po.setOperatorName(staffPO.getName());
        po.setOperatorId(staffPO.getId());
        po.setExecutorId(params.getExecutorId());
        return null;
    }

}
