package com.assign.service.order.impl;

import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.mapper.ShopeeOrderDetailMapper;
import com.assign.service.common.impl.CommonServiceImpl;
import com.assign.service.order.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderDetailServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/23.
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<ShopeeOrderDetailMapper, ShopeeOrderDetailPO>
        implements OrderDetailService {
    @Autowired
    private ShopeeOrderDetailMapper shopeeOrderDetailMapper;
}
