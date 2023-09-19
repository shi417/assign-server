package com.assign.service.impl;

import com.assign.entity.dto.shopee.ShopeeDetailDTO;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.po.OrderPO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.mapper.ShopeeOrderMapper;
import com.assign.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ShopeeOrderMapper shopeeOrderMapper;

    @Override
    public List<OrderPO> getAllOrders() {
        return null;
    }

    @Override
    public OrderPO getOrderById(Long id) {
        return null;
    }

    @Override
    public void doAssign(String orderCode, String userCode) {

    }

    @Override
    public Date getOrderMaxDate() {
        return shopeeOrderMapper.selectMaxUpdateDate();
    }

    @Override
    public void batchInsertOrders(List<ShopeeOrderDTO> orderDTOS) {
        for (ShopeeOrderDTO order : orderDTOS){
            ShopeeOrderPO po = new ShopeeOrderPO();
            BeanUtils.copyProperties(order,po);
            shopeeOrderMapper.insert(po);
            List<ShopeeDetailDTO> shopeeDetailDTO = order.getShopeeDetailDTO();

        }
    }
}
