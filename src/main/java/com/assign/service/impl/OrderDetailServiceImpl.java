package com.assign.service.impl;

import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.mapper.ShopeeOrderDetailMapper;
import com.assign.mapper.ShopeeOrderMapper;
import com.assign.service.OrderDetailService;
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
