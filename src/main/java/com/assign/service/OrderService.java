package com.assign.service;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * @author shiyaqing
 */
public interface OrderService extends IService<ShopeeOrderPO>{

    Date getMaxUpdateDate();

    List<ShopeeOrderPO> getOrderList(ShopeeOrderDTO params);
}
