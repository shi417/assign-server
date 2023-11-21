package com.assign.service.waihui.impl;

import com.assign.feign.AliCurrencyFeignServer;
import com.assign.feign.vo.currency.AliCurrencyHeader;
import com.assign.feign.vo.currency.CurrencyList;
import com.assign.feign.vo.currency.CurrencyResponseVO;
import com.assign.feign.vo.currency.ShowapiResBody;
import com.assign.service.waihui.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CurrencyServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Service
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    @Value("${ali.waihui.AppKey}")
    private String appKey;

    @Value("${ali.waihui.AppSecret}")
    private String appSecret;

    @Value("${ali.waihui.AppCode}")
    private String appCode;

    @Autowired
    private AliCurrencyFeignServer aliCurrencyFeignServer;

    @Override
    public BigDecimal getRate(String currencyCode) {
        AliCurrencyHeader header = new AliCurrencyHeader();
        header.setAuthorization("APPCODE "+appCode);
        Map<String, String> querys = new HashMap<>();
        querys.put("code", currencyCode);
        CurrencyResponseVO currencyResponseVO = aliCurrencyFeignServer.fetchCurrencyList(header, querys);
        ShowapiResBody showapiResBody = currencyResponseVO.getShowapiResBody();
        List<CurrencyList> currencyList = showapiResBody.getCurrencyList();
        if (currencyList == null || currencyList.isEmpty()){
            throw new RuntimeException("未获取到汇率");
        }
        CurrencyList currency = currencyList.get(0);
        BigDecimal zhesuan = new BigDecimal(currency.getZhesuan());
        BigDecimal base = new BigDecimal(100);
        return base.divide(zhesuan);
    }
}
