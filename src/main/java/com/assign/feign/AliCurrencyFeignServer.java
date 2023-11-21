package com.assign.feign;

import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.AliCurrencyConstants;
import com.assign.feign.vo.ShopeeSimpleVO;
import com.assign.feign.vo.currency.AliCurrencyHeader;
import com.assign.feign.vo.currency.CurrencyResponseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

/**
 * AliCurrencyFeignService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@FeignClient(name = "AliCurrencyFeignServer", url = "${ali.currency.url}")
public interface AliCurrencyFeignServer {

    @GetMapping(value = AliCurrencyConstants.WAIHUI_LIST , headers = {"content-type=application/json", "userAgent=PC"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    CurrencyResponseVO fetchCurrencyList(@RequestHeader AliCurrencyHeader header, @SpringQueryMap Map<String,String> reqParams);
}
