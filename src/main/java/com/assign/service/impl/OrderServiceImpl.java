package com.assign.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.mapper.ShopeeOrderMapper;
import com.assign.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/12.
 */
@Service
@Slf4j
public class OrderServiceImpl  extends ServiceImpl<ShopeeOrderMapper,ShopeeOrderPO>
        implements OrderService {

    @Autowired
    private ShopeeOrderMapper shopeeOrderMapper;

    @Override
    public Date getMaxUpdateDate() {
        Long max = shopeeOrderMapper.getMaxUpdateDate();
        return new Date(max*1000);
    }

    @Override
    public List<ShopeeOrderPO> getOrderList(ShopeeOrderDTO params) {
        QueryWrapper<ShopeeOrderPO> queryWrapper =  new QueryWrapper<>();
        if (StringUtils.isNotEmpty(params.getOrderStatus())){
            queryWrapper.lambda().eq(ShopeeOrderPO::getOrderStatus, params.getOrderStatus());
        }
        if (StringUtils.isNotEmpty(params.getOrderSn())){
            queryWrapper.lambda().eq(ShopeeOrderPO::getOrderSn, params.getOrderSn());
        }
        IPage<ShopeeOrderPO> page = new Page<>(params.getCurrentPage(),params.getPageSize());
        return shopeeOrderMapper.selectList(page, queryWrapper);
    }


}
