package com.assign.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.po.AssignPO;
import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.entity.po.SkuManageInfoPO;
import com.assign.mapper.ShopeeOrderDetailMapper;
import com.assign.mapper.SkuManageInfoMapper;
import com.assign.service.SkuManageInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkuManageInfoServiceImpl extends ServiceImpl<SkuManageInfoMapper, SkuManageInfoPO>
        implements SkuManageInfoService {


    private final SkuManageInfoMapper skuManageInfoMapper;

    private static final Integer MAX_NUM = 3;

    @Override
    public SkuManageInfoPO getBySkuInfo(AssignPO po) {

        QueryWrapper<SkuManageInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SkuManageInfoPO::getSkuDesc, po.getEcItemName());
        queryWrapper.orderByDesc("update_at");
        List<SkuManageInfoPO> skuManageInfoPOS = skuManageInfoMapper.selectList(queryWrapper);
        if (!skuManageInfoPOS.isEmpty()) {
            return skuManageInfoPOS.get(0);
        }
        return null;
    }

    @Override
    public void handleUrl(AssignPO po) {
        QueryWrapper<SkuManageInfoPO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SkuManageInfoPO::getSkuDesc, po.getEcItemName());
        queryWrapper.orderByDesc("update_at");
        List<SkuManageInfoPO> skuManageInfoPOS = skuManageInfoMapper.selectList(queryWrapper);
        if (skuManageInfoPOS.size() < MAX_NUM && !skuManageInfoPOS.isEmpty()) {//小于允许最大的数量
            SkuManageInfoPO skuManageInfoPO = skuManageInfoPOS.get(0);
            skuManageInfoPO.setId(null);
            skuManageInfoPO.setPrice(po.getPrice());
            skuManageInfoPO.setUrl(po.getBuyUrl());
            skuManageInfoPO.setSource(po.getSource());
            skuManageInfoMapper.insertSelective(skuManageInfoPO);
        }else if (skuManageInfoPOS.size() == MAX_NUM){
            SkuManageInfoPO skuManageInfoPO = skuManageInfoPOS.get(0);
            skuManageInfoPO.setPrice(po.getPrice());
            skuManageInfoPO.setUrl(po.getBuyUrl());
            skuManageInfoPO.setSource(po.getSource());
            skuManageInfoMapper.updateByPrimaryKey(skuManageInfoPO);
        }

    }
}
