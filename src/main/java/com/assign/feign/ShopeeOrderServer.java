package com.assign.feign;

import com.assign.common.mdoel.ShopeeResult;
import com.assign.entity.dto.shopee.request.OrderDetailRequestDTO;
import com.assign.entity.dto.shopee.request.OrderListRequestDTO;
import com.assign.entity.dto.shopee.ShopeeOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ShopeeOrderServer
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/12.
 */
@FeignClient(name = "shopeeOrderServer", url = "${shopee.url}")
public interface ShopeeOrderServer {


    @GetMapping(value = "/api/v2/order/get_order_list" , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    String fetchOrderList(@SpringQueryMap OrderListRequestDTO reqParams);

    @GetMapping(value = "/api/v2/order/get_order_list" , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    ShopeeResult<List<ShopeeOrderDTO>> fetchOrderDetail(@RequestHeader Map<String, Object> headerMap, @RequestParam OrderDetailRequestDTO reqParams);

//    @PostMapping(value = "/api/v2/public/get_shops_by_partner")
//    Object fetchShopList(@RequestHeader Map<String, String> headerMap,@RequestParam Map<String, String> reqParams,@RequestBody OrderReqBodyDTO reqBody);

}
