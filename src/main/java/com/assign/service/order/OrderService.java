package com.assign.service.order;

import com.assign.entity.common.PageResult;
import com.assign.entity.dto.shopee.OrderListResponseDTO;
import com.assign.entity.dto.shopee.ShopeeOrderRequestDTO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.service.common.CommonService;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
 * @author shiyaqing
 */
public interface OrderService extends IService<ShopeeOrderPO> {

    Date getMaxUpdateDate(Integer shopId);

    PageResult<OrderListResponseDTO> getOrderList(ShopeeOrderRequestDTO params);

    void getPaymentTest();

    void getPaymentList();
}
