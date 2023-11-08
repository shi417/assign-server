package com.assign.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.common.PageResult;
import com.assign.entity.dto.shopee.OrderListResponseDTO;
import com.assign.entity.dto.shopee.ShopeeDetailResponseDTO;
import com.assign.entity.dto.shopee.ShopeeOrderRequestDTO;
import com.assign.entity.dto.shopee.feign.ShopeePaymentRequestVO;
import com.assign.entity.dto.shopee.feign.ShopeeShopRequestVO;
import com.assign.entity.dto.shopee.feign.ShopeeShopVO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.feign.ShopeeOrderFeignServer;
import com.assign.mapper.ShopeeOrderDetailMapper;
import com.assign.mapper.ShopeeOrderMapper;
import com.assign.service.AssignService;
import com.assign.service.OrderService;
import com.assign.constants.CommonConsts;
import com.assign.util.OrderStatusEnum;
import com.assign.util.ShopeeReqHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
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
@RequiredArgsConstructor
public class OrderServiceImpl  extends ServiceImpl<ShopeeOrderMapper,ShopeeOrderPO>
        implements OrderService {


    private final ShopeeOrderMapper shopeeOrderMapper;

    private final ShopeeOrderDetailMapper shopeeOrderDetailMapper;

    private final ShopeeReqHandler shopeeReqHandler;

    private  final ShopeeOrderFeignServer shopeeOrderFeignServer;

    private final AssignService assignService;

    @Override
    public Date getMaxUpdateDate(Integer shopId) {
        Long max = shopeeOrderMapper.getMaxUpdateDate(shopId);
        if (max == null){
            return null;
        }
        return new Date(max*1000);
    }

    @Override
    public PageResult<OrderListResponseDTO> getOrderList(ShopeeOrderRequestDTO params) {
        PageResult<OrderListResponseDTO> result = new PageResult<>();
        QueryWrapper<ShopeeOrderPO> queryWrapper =  new QueryWrapper<>();
        if (StringUtils.isNotEmpty(params.getOrderStatus())){
            queryWrapper.lambda().eq(ShopeeOrderPO::getOrderStatus, params.getOrderStatus());
        }
        if (StringUtils.isNotEmpty(params.getOrderSn())){
            queryWrapper.lambda().eq(ShopeeOrderPO::getOrderSn, params.getOrderSn());
        }
        if (params.getPayTimeStart() != null && params.getPayTimeEnd() != null){
            queryWrapper.lambda().between(ShopeeOrderPO::getPayTime, params.getPayTimeStart().getTime(),params.getPayTimeEnd().getTime());
        }
        if (params.getPageSize() > 100){
            params.setPageSize(CommonConsts.MAX_PAGE_SIZE);
        }
        Page<ShopeeOrderPO> page = new Page<>(params.getCurrentPage(),params.getPageSize());
        IPage<ShopeeOrderPO> pageRes = shopeeOrderMapper.selectPage(page,queryWrapper);
        List<ShopeeOrderPO> shopeeOrderPOS = pageRes.getRecords();
        List<OrderListResponseDTO> orders = new ArrayList<>();
        shopeeOrderPOS.forEach(o ->{
            OrderListResponseDTO d = new OrderListResponseDTO();
            d.setOrderSn(o.getOrderSn());
            d.setPayTime(o.getPayTime() == null ? null:new Date(o.getPayTime()));
            d.setOrderTime(new Date(o.getCreateTime()));
            d.setSite(o.getRegion());
            d.setCurrency(o.getCurrency());
            ShopeeShopRequestVO shopeeShopRequestVO = new ShopeeShopRequestVO();
            shopeeReqHandler.initCommonParam(shopeeShopRequestVO,o.getShopId().intValue(), ShopeePathConstants.GET_SHOP_INFO);
            ShopeeShopVO shopInfo = shopeeOrderFeignServer.getShopInfo(shopeeShopRequestVO);
            d.setShopName(shopInfo.getShopName());
            d.setTotalAmount(o.getTotalAmount());
            d.setStatus(OrderStatusEnum.getDescByCode(o.getOrderStatus()));
            d.setShipByDate(o.getShipByDate() == null ? null :new Date(o.getShipByDate()));
            List<ShopeeDetailResponseDTO> details = shopeeOrderDetailMapper.selectByOrderSn(o.getOrderSn());
            d.setItemList(details);
            orders.add(d);
        });
        result.setData(orders);
        result.setTotalNum(page.getTotal());
        return result;
    }

    @Override
    public void getPaymentTest() {
        ShopeePaymentRequestVO param = new ShopeePaymentRequestVO();
        param.setPage_no(1);
        param.setPage_size(20);
        LocalDate today = LocalDate.now();
        LocalDate lastMonthFirstDay = today.minusMonths(1).withDayOfMonth(1);

        Long t = lastMonthFirstDay.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        param.setPayout_time_from(t);
        LocalDate lastMonthLastDay = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).lengthOfMonth());
        t = lastMonthLastDay.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() ;
        param.setPayout_time_to(t);
        shopeeReqHandler.initCommonParam(param,992185921, ShopeePathConstants.GET_PAYMENT_INFO);
        String payment = shopeeOrderFeignServer.getPayment(param);
        System.out.println(payment);
    }

}
