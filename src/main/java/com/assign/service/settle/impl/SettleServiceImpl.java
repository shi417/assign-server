package com.assign.service.settle.impl;

import cn.hutool.core.convert.Convert;
import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.common.PageResult;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.settle.ShopeeSettleDetailDTO;
import com.assign.entity.dto.settle.ShopeeSettlePayoutDTO;
import com.assign.entity.dto.settle.ShopeeSettleRequestDTO;
import com.assign.entity.dto.settle.ShopeeSettleResponseDTO;
import com.assign.feign.ShopeeFeignServer;
import com.assign.feign.vo.settle.*;
import com.assign.service.common.impl.CommonServiceImpl;
import com.assign.service.settle.SettleService;
import com.assign.service.waihui.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SettleServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Service
@AllArgsConstructor
public class SettleServiceImpl extends CommonServiceImpl implements SettleService {

    private final ShopeeFeignServer shopeeFeignServer;

    private final CurrencyService currencyService;
    @Override
    public ResponseResult<List<ShopeeSettlePayoutDTO>> getList(ShopeeSettleRequestDTO params) {
        ShopeePaymentRequestVO query = new ShopeePaymentRequestVO();
        query.setPage_no(params.getCurrentPage());
        query.setPage_size(params.getPageSize());
        query.setPayout_time_from(params.getReleaseTimeFrom().getTime()/1000);
        query.setPayout_time_to(params.getReleaseTimeTo().getTime()/1000);
        initCommonParam(query,params.getShopId(), ShopeePathConstants.GET_PAYMENT_INFO);
        ShopeeResult<SettleResponseVO> paymentResult = shopeeFeignServer.getPayment(query);
        if (paymentResult.getResponse() == null){
            return ResponseResult.failed(paymentResult.getMessage());
        }
        //先获取结算条目
        List<PayoutResponseVO> payoutList = paymentResult.getResponse().getPayoutList();
        List<ShopeeSettlePayoutDTO> res = payoutList.stream()
                .map(payoutItem -> {
                    ShopeeSettlePayoutDTO payoutRes = Convert.convert(ShopeeSettlePayoutDTO.class, payoutItem);
                    List<ShopeeSettleResponseDTO> ssrdList = payoutItem.getEscrowList().stream()
                            .map(row -> {
                                ShopeeSettleResponseDTO ssrd = new ShopeeSettleResponseDTO();
                                ssrd.setAmount(row.getAmount());
                                ssrd.setCurrency(payoutItem.getPayoutInfo().getFromCurrency());
                                ssrd.setOrderSn(row.getOrderSn());

                                ShopeeSettleDetailRequestVO dQuery = new ShopeeSettleDetailRequestVO();
                                dQuery.setOrder_sn(row.getOrderSn());
                                initCommonParam(dQuery, params.getShopId(), ShopeePathConstants.GET_ESCROW_DETAIL);
                                ShopeeResult<ShopeeSettleDetailResponseVO> escrowDetailRes = shopeeFeignServer.getEscrowDetail(dQuery);
                                ShopeeSettleDetailResponseVO orderDetail = escrowDetailRes.getResponse();
                                OrderIncomeVO orderIncome = orderDetail.getOrderIncome();
                                List<SettleItemVO> settleItemVOS = orderIncome.getSettleItemVOS();
                                List<ShopeeSettleDetailDTO> detailList = settleItemVOS.stream()
                                        .map(item -> Convert.convert(ShopeeSettleDetailDTO.class, item))
                                        .collect(Collectors.toList());
//                                ssrd.setReleaseTime(new Date(row.get * 1000));
                                ssrd.setDetailList(detailList);
                                ssrd.setAmount( new BigDecimal(orderIncome.getEscrowAmount()));
                                return ssrd;
                            })
                            .collect(Collectors.toList());
                    payoutRes.setOrderSettles(ssrdList);
                    payoutRes.setExchangeRate(payoutItem.getPayoutInfo().getExchangeRate());
                    return payoutRes;
                })
                .collect(Collectors.toList());

        //获取到列表后需要填充sku信息

        return ResponseResult.success(res);
    }

}
