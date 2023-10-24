package com.assign.task;

import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.dto.shopee.OrderListResponseDTO;
import com.assign.entity.dto.shopee.ShopeeOrderDetailDTO;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import com.assign.entity.dto.shopee.request.CommonRequestDTO;
import com.assign.entity.dto.shopee.request.OrderDetailRequestDTO;
import com.assign.entity.dto.shopee.request.OrderListRequestDTO;
import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.entity.po.TokensPO;
import com.assign.feign.ShopeeOrderServer;
import com.assign.service.OrderDetailService;
import com.assign.service.OrderService;
import com.assign.service.ITokenService;
import com.assign.util.ShopeeReqHandler;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.jcodec.common.StringUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 增量同步虾皮订单
 * @author shiyaqing
 */
@Component
@Slf4j
@Data
@RequiredArgsConstructor
public class OrderTask {

    private final ShopeeOrderServer shopeeOrderServer;

    private final ITokenService tokenService;

    private final ShopeeReqHandler shopeeReqHandler;

    private final OrderService orderService;

    private final OrderDetailService orderDetailService;

    @Value("${shopee.order.batchSize}")
    private int batchSize;

    @Value("${shopee.partnerId}")
    private int partnerId;

    private int pageSize = 100; // 每页数量
    private int totalDays = 1000; // 总天数

    private int days = 14; //最多相隔15天这里直接以14天遍历
    private int pageNumber = 1; // 初始页码

//    @Scheduled(fixedRate = 300000) // 每5分钟执行一次，以毫秒为单位

    /**
     * 全量更新订单
     */
    public void fetchAllOrders() {
        //获取token
        List<Integer> shopIds =  tokenService.getShopIds();
        for (Integer shopId : shopIds) {
            List<ShopeeOrderDTO> allOrders = new ArrayList<>();
            Date curr = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(curr);
            //创店最早日期
            LocalDate createLocal = LocalDate.of(2022, 12, 1);
            Date createShopDate = Date.from(createLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            while (true){
                c.add(Calendar.DAY_OF_MONTH,-days);
                //每14天一循环，虾皮要求
                Date from = c.getTime();
                //当前游标
                String cursor = "";
                doRequire(allOrders,shopId,from,curr,cursor);
                curr = from;
               if(curr.before(createShopDate)){
                   log.info("shopId全量任务结束 :{},curr日期:{}",shopId,curr);
                   break;
               }
            }
            batchInsertOrder(allOrders);
        }
        log.info("所有店铺均已更新完成。");

    }
    private void doRequire(List<ShopeeOrderDTO> allOrders, Integer shopId, Date from, Date to, String cursor) {
        while(true){
            OrderListRequestDTO request = genListRequestParam(shopId,from,to,cursor);
            log.info("请求订单request:{}",request);
            ShopeeResult<OrderListResponseDTO> result = shopeeOrderServer.fetchOrderList(request);
            log.info("ListResult:{}",result);
            List<Map<String, String>> orderList = result.getResponse().getOrderList();
            String sns = orderList.stream()
                    .map(order -> order.get("order_sn"))
                    .collect(Collectors.joining(","));
            OrderListResponseDTO data = result.getResponse();
            OrderDetailRequestDTO detailRequestDTO = genDetailRequestParam(shopId);
            detailRequestDTO.setOrder_sn_list(sns);
            detailRequestDTO.setResponse_optional_fields("item_list,pay_time,create_time,total_amount,buyer_cancel_reason,buyer_user_id,buyer_username,cancel_reason,cancelBy");
            ShopeeResult<Map<String,List<ShopeeOrderDTO>>> detailResult = shopeeOrderServer.fetchOrderDetail(detailRequestDTO);
            allOrders.addAll(detailResult.getResponse() !=null? detailResult.getResponse().get("order_list") : new ArrayList<>());
            log.info("DetailResult:{}",detailResult);
            if (StringUtils.isEmpty(data.getNextCursor())){
                break;
            }
            cursor = data.getNextCursor();
        }
    }

    private void batchInsertOrder(List<ShopeeOrderDTO> allOrders) {
        List<ShopeeOrderPO> pos = new ArrayList<>();
        List<ShopeeOrderDetailDTO> detailList = new ArrayList<>();
        for (ShopeeOrderDTO order : allOrders){
            detailList.addAll(order.getShopeeOrderDetailDTO());
            ShopeeOrderPO po = new ShopeeOrderPO();
            BeanUtils.copyProperties(order,po);
            po.setId(po.getOrderSn());
            pos.add(po);
        }
        log.info("order入库size:{}",pos.size());
        orderService.saveOrUpdateBatch(pos);
        List<ShopeeOrderDetailPO> details = new ArrayList<>();
        for (ShopeeOrderDetailDTO detailDTO : detailList){
            ShopeeOrderDetailPO po = new ShopeeOrderDetailPO();
            BeanUtils.copyProperties(detailDTO,po);
            details.add(po);
        }
        orderDetailService.saveOrUpdateBatch(details);
    }

    private OrderDetailRequestDTO genDetailRequestParam(int shopId) {
        OrderDetailRequestDTO dto = new OrderDetailRequestDTO();
        initCommonParam(dto,shopId,ShopeePathConstants.GET_ORDER_DETAIL);
        return dto;
    }


    private void initCommonParam(CommonRequestDTO dto,int shopId,String path){
        dto.setPartner_id(partnerId);
        TokensPO token =  tokenService.getTokenById(shopId);
        dto.setAccess_token(token.getAccessToken());
        dto.setShop_id(shopId);
        long timestamp = System.currentTimeMillis()/1000;
        dto.setTimestamp(timestamp);
        dto.setSign(shopeeReqHandler.getSign(path,timestamp, token, shopId));
    }


    private OrderListRequestDTO genListRequestParam(Integer shopId, Date from, Date to, String cursor) {
        OrderListRequestDTO dto = new OrderListRequestDTO();
        dto.setTime_range_field("update_time");
        dto.setTime_from((from.getTime()/1000));
        dto.setTime_to(to.getTime()/1000);
        dto.setPage_size(pageSize);
        dto.setCursor(cursor);
        initCommonParam(dto,shopId,ShopeePathConstants.GET_ORDER_LIST);
        return dto;
    }


    /**
     * 增量更新订单表
     */
    @Scheduled(fixedRate = 300000) // 每5分钟执行一次，以毫秒为单位
    public void fetchOrders() {
        List<Integer> shopIds =  tokenService.getShopIds();
        for (Integer shopId : shopIds) {
            List<ShopeeOrderDTO> allOrders = new ArrayList<>();
            Date curr = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(curr);
            //创店最早日期
            Date maxUpdateDate = orderService.getMaxUpdateDate();
            if(maxUpdateDate == null){
                fetchAllOrders();
                return;
            }
            long millisecondsDifference = curr.getTime() - maxUpdateDate.getTime();
            // 计算天数差（毫秒转天）
            long daysDiff = TimeUnit.DAYS.convert(millisecondsDifference, TimeUnit.MILLISECONDS);

            if(daysDiff >= 15){
                while (true){
                    c.add(Calendar.DAY_OF_MONTH,-days);
                    //每14天一循环，虾皮要求
                    Date from = c.getTime();
                    //当前游标
                    String cursor = "";
                    doRequire(allOrders,shopId,from,curr,cursor);
                    curr = from;
                    if(curr.before(maxUpdateDate)){
                        break;
                    }
                }
            }else{
                doRequire(allOrders,shopId,maxUpdateDate,curr,"");
            }
            batchInsertOrder(allOrders);
            log.info("shopId增量任务结束 :{},curr日期:{}",shopId,curr);
        }
    }
}
