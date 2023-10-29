package com.assign.service.impl;

import cn.hutool.core.convert.Convert;
import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.assign.AssignRequestDTO;
import com.assign.entity.dto.staff.StaffDTO;
import com.assign.entity.po.AssignPO;
import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.entity.po.SkuManageInfoPO;
import com.assign.entity.po.StaffPO;
import com.assign.mapper.AssignMapper;
import com.assign.mapper.ShopeeOrderDetailMapper;
import com.assign.service.AssignService;
import com.assign.service.OrderService;
import com.assign.service.SkuManageInfoService;
import com.assign.service.StaffService;
import com.assign.util.UserUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AssignServiceImpl extends ServiceImpl<AssignMapper, AssignPO>
        implements AssignService {

    private final AssignMapper assignMapper;

    private final StaffService staffService;

    private final SkuManageInfoService skuManageInfoService;

    private final ShopeeOrderDetailMapper shopeeOrderDetailMapper;
    @Override
    public ResponseResult<Page<AssignPO>> selectPage(AssignRequestDTO params) {
        if (params.getPageSize() != null && params.getPageSize() > 100){
            params.setPageSize(100);
        }
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
        if (params.getEcItemId() == null ){
            return ResponseResult.failed("商品id为空");
        }
        AssignPO po = Convert.convert(AssignPO.class, params);
        StaffDTO loginStaff = UserUtils.getLoginStaff();
        StaffPO staffPO = staffService.selectByUserCode(loginStaff.getCode());
        ShopeeOrderDetailPO detail = shopeeOrderDetailMapper.selectByItemId(po.getEcItemId(),po.getEcOrderNo());
        po.setOperatorName(staffPO.getName());
        po.setOperatorId(staffPO.getId());
        po.setExecutorId(params.getExecutorId());
        po.setExecutorName(staffService.getById(po.getExecutorId()).getName());
        po.setType(po.getOperatorId() == po.getExecutorId() ? 0:1);
        po.setEcItemName(detail.getModelSku());
        po.setQuality(detail.getModelQuantityPurchased());
        if (po.getBuyUrl() != null){
            skuManageInfoService.handleUrl(po);
        }else {
            SkuManageInfoPO sku = skuManageInfoService.getBySkuInfo(po);
            if (sku != null){
                po.setBuyUrl(sku.getUrl());
                po.setPrice(sku.getPrice());
            }
        }
        AssignPO assignPO = assignMapper.selectByItemId(params.getEcItemId());
        if (assignPO != null){
            log.info("认领信息已存在执行更新itemId:{}",po.getEcItemId());
            po.setId(assignPO.getId());
        }
        this.saveOrUpdate(po);
        return ResponseResult.success();
    }

}
