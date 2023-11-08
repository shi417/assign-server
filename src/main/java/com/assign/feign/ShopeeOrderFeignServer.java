package com.assign.feign;

import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.dto.shopee.feign.*;
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
public interface ShopeeOrderFeignServer {


    @GetMapping(value = ShopeePathConstants.GET_ORDER_LIST , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    ShopeeResult<ShopeeSimpleVO> fetchOrderList(@SpringQueryMap OrderListRequestVO reqParams);

    @GetMapping(value = ShopeePathConstants.GET_ORDER_DETAIL , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    ShopeeResult<Map<String,List<ShopeeOrderRequireDTO>>> fetchOrderDetail(@SpringQueryMap OrderDetailRequestVO reqParams);

    @GetMapping(value = ShopeePathConstants.GET_SHOP_INFO , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    ShopeeShopVO getShopInfo(@SpringQueryMap ShopeeShopRequestVO reqParams);

    @GetMapping(value = ShopeePathConstants.GET_PAYMENT_INFO , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    String getPayment(@SpringQueryMap ShopeePaymentRequestVO reqParams);
//    @PostMapping(value = "/api/v2/public/get_shops_by_partner")
//    Object fetchShopList(@RequestHeader Map<String, String> headerMap,@RequestParam Map<String, String> reqParams,@RequestBody OrderReqBodyDTO reqBody);

}
