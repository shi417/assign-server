package com.assign.task;

import cn.hutool.core.convert.Convert;
import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.dto.shopee.ShopeeOrderDetailDTO;
import com.assign.entity.po.ShopeeOrderDetailPO;
import com.assign.entity.po.ShopeeOrderPO;
import com.assign.feign.ShopeeFeignServer;
import com.assign.feign.vo.OrderDetailRequestVO;
import com.assign.feign.vo.OrderListRequestVO;
import com.assign.feign.vo.ShopeeOrderRequireDTO;
import com.assign.feign.vo.ShopeeSimpleVO;
import com.assign.service.order.OrderDetailService;
import com.assign.service.order.OrderService;
import com.assign.service.common.TokenService;
import com.assign.util.ShopeeReqHandler;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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

    private final ShopeeFeignServer shopeeOrderServer;

    private final TokenService tokenService;

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
            List<ShopeeOrderRequireDTO> allOrders = new ArrayList<>();
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
            batchInsertOrder(allOrders, shopId);
        }
        log.info("所有店铺均已更新完成。");

    }
    private void doRequire(List<ShopeeOrderRequireDTO> allOrders, Integer shopId, Date from, Date to, String cursor) {
        while(true){
            OrderListRequestVO request = genListRequestParam(shopId,from,to,cursor);
            log.info("请求订单request:{}",request);
            ShopeeResult<ShopeeSimpleVO> result = shopeeOrderServer.fetchOrderList(request);
            log.info("ListResult:{}",result);
            ShopeeSimpleVO data = result.getResponse();

            List<ShopeeOrderRequireDTO> orderRequests = getShopeeOrderRequire(data,shopId);

            allOrders.addAll(orderRequests);
            log.info("DetailResult:{}",orderRequests);
            if (StringUtils.isEmpty(data.getNextCursor())){
                break;
            }
            cursor = data.getNextCursor();
        }
    }

    private List<ShopeeOrderRequireDTO> getShopeeOrderRequire(ShopeeSimpleVO data, Integer shopId) {
        List<Map<String, String>> orderList = data.getOrderList();
        Integer size = orderList.size();
        List<ShopeeOrderRequireDTO> res = new ArrayList<>();
        int startIndex = 0;
        while (true){
            int endIndex = startIndex + 50;
            if (endIndex > size){
                endIndex = size;
            }
            List<Map<String, String>> temp = orderList.subList(startIndex, endIndex);
            String sns = temp.stream()
                    .map(order -> order.get("order_sn"))
                    .collect(Collectors.joining(","));
            OrderDetailRequestVO detailRequestDTO = genDetailRequestParam(shopId);
            detailRequestDTO.setOrder_sn_list(sns);
            detailRequestDTO.setResponse_optional_fields("item_list,pay_time,create_time,total_amount,buyer_cancel_reason,buyer_user_id,buyer_username,cancel_reason,cancelBy,model_discounted_price,model_original_price");
            ShopeeResult<Map<String,List<ShopeeOrderRequireDTO>>> detailResult = shopeeOrderServer.fetchOrderDetail(detailRequestDTO);
            if (detailResult.getResponse() != null){
                res.addAll(detailResult.getResponse().get("order_list"));
            }
            startIndex = endIndex;
            if (endIndex >= size){
                break;
            }
        }
        return res;
    }

    private void batchInsertOrder(List<ShopeeOrderRequireDTO> allOrders, Integer shopId) {
        List<ShopeeOrderPO> pos = new ArrayList<>();
        List<ShopeeOrderDetailDTO> detailList = new ArrayList<>();
        for (ShopeeOrderRequireDTO order : allOrders){
            order.getShopeeOrderDetailDTO().forEach(e ->{
                e.setOrderSn(order.getOrderSn());
            });
            detailList.addAll(order.getShopeeOrderDetailDTO());
            ShopeeOrderPO po = new ShopeeOrderPO();
            BeanUtils.copyProperties(order,po);
            po.setId(po.getOrderSn());
            po.setShopId(Long.valueOf(shopId));
            pos.add(po);
        }
        log.info("order入库size:{}",pos.size());
        orderService.saveOrUpdateBatch(pos);
        List<ShopeeOrderDetailPO> details = new ArrayList<>();
        for (ShopeeOrderDetailDTO detailDTO : detailList){
            ShopeeOrderDetailPO po = Convert.convert(ShopeeOrderDetailPO.class,detailDTO);
            details.add(po);

        }
        log.info("更新明细:{}",details.size());
        try{
            orderDetailService.saveOrUpdateBatch(details);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private OrderDetailRequestVO genDetailRequestParam(int shopId) {
        OrderDetailRequestVO dto = new OrderDetailRequestVO();
        shopeeReqHandler.initCommonParam(dto,shopId,ShopeePathConstants.GET_ORDER_DETAIL);
        return dto;
    }



    private OrderListRequestVO genListRequestParam(Integer shopId, Date from, Date to, String cursor) {
        OrderListRequestVO dto = new OrderListRequestVO();
        dto.setTime_range_field("update_time");
        dto.setTime_from((from.getTime()/1000));
        dto.setTime_to(to.getTime()/1000);
        dto.setPage_size(pageSize);
        dto.setCursor(cursor);
        shopeeReqHandler.initCommonParam(dto,shopId,ShopeePathConstants.GET_ORDER_LIST);
        return dto;
    }


    /**
     * 增量更新订单表
     */
//    @Scheduled(fixedRate = 300000) // 每5分钟执行一次，以毫秒为单位
    public void fetchOrders() {
        List<Integer> shopIds =  tokenService.getShopIds();
        for (Integer shopId : shopIds) {
            List<ShopeeOrderRequireDTO> allOrders = new ArrayList<>();
            Date curr = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(curr);
            //创店最早日期
            Date maxUpdateDate = orderService.getMaxUpdateDate(shopId);
            if(maxUpdateDate == null){
                LocalDate createLocal = LocalDate.of(2022, 12, 1);
                maxUpdateDate = Date.from(createLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
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
            batchInsertOrder(allOrders,shopId);
            log.info("shopId增量任务结束 :{},curr日期:{}",shopId,curr);
        }
    }
}
