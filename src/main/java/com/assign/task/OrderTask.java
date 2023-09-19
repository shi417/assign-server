package com.assign.task;

import com.assign.constants.ShopeePathConstants;
import com.assign.entity.dto.shopee.request.OrderListRequestDTO;
import com.assign.entity.po.TokensPO;
import com.assign.feign.ShopeeOrderServer;
import com.assign.service.IOrderService;
import com.assign.service.ITokenService;
import com.assign.util.ShopeeReqHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 增量同步虾皮订单
 */
@Component
@Slf4j
public class OrderTask {

    @Autowired
    private ShopeeOrderServer shopeeOrderServer;

    @Autowired
    private ITokenService tokenService;

    @Autowired
    private ShopeeReqHandler shopeeReqHandler;

    @Autowired
    private IOrderService orderService;

    @Value("${shopee.order.batchSize}")
    private int batchSize;

    @Value("${shopee.partnerId}")
    private int partnerId;

    @Scheduled(fixedRate = 300000) // 每5分钟执行一次，以毫秒为单位
    public void fetchOrders() {
        List<Integer> shopIds =  tokenService.getShopIds();
        for (Integer shopId : shopIds) {
//            log.info("获取请求header:{}",headers);
            OrderListRequestDTO request = genListRequestParam(shopId);
            // 执行任务代码
            String result = shopeeOrderServer.fetchOrderList(request);
            log.info("result:{}",result);
//            OrderListResponseDTO response = result.getResponse();
//            log.info("获取shopId :{},orderIds:{}",shopId,response);
//            List<Map<String,String>> orderSns = response.getOrderList();
//            List<List<Map<String, String>>> batches = batchProcess(orderSns);
//            for (List<Map<String, String>> batch : batches) {
//                List<String> sns = new ArrayList<>();
//                batch.forEach(map -> {
//                    String orderSnValue = map.get("order_sn");
//                    if (orderSnValue != null) {
//                        sns.add(orderSnValue);
//                    }
//                });
//                String s = sns.stream().collect(() -> new StringJoiner(","), StringJoiner::add, StringJoiner::merge).toString();
//                headers = shopeeReqHandler.getShopeeReqHeaders(shopId, ShopeePathConstants.GET_ORDER_DETAIL);
//                OrderDetailRequestDTO detailRequestDTO = new OrderDetailRequestDTO();
//                detailRequestDTO.setOrderSnList(s);
//                ShopeeResult<List<ShopeeOrderDTO>> detailResult = shopeeOrderServer.fetchOrderDetail(headers, detailRequestDTO);
//                log.info("获取shopId :{},orderDetails:{}",shopId,detailResult);
//                orderService.batchInsertOrders(detailResult.getResponse());
//            }
        }
    }

    private List<List<Map<String, String>>> batchProcess(List<Map<String, String>> orderSns) {
        List<List<Map<String, String>>> batches = new ArrayList<>();
        for (int i = 0; i < orderSns.size(); i += batchSize) {
            int end = Math.min(i + batchSize, orderSns.size());
            batches.add(orderSns.subList(i, end));
        }
        return batches;
    }

    private OrderListRequestDTO genListRequestParam(Integer shopId) {
        OrderListRequestDTO dto = new OrderListRequestDTO();
        Date maxDate = orderService.getOrderMaxDate();
        if (maxDate == null) {
            Date d = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.YEAR,-20);
            maxDate = c.getTime();
        }
        dto.setTime_range_field("update_time");
        dto.setTime_from((maxDate.getTime()));
        dto.setTime_to(System.currentTimeMillis());
        dto.setPage_size(999999);
        dto.setCursor("");
        dto.setPartner_id(partnerId);
        TokensPO token =  tokenService.getTokenById(shopId);
        dto.setAccess_token(token.getAccessToken());
        dto.setShop_id(shopId);
        long timestamp = System.currentTimeMillis();
        dto.setTimestamp(timestamp);
        dto.setSign(shopeeReqHandler.getSign(ShopeePathConstants.GET_ORDER_LIST,timestamp));
        return dto;
    }

}
