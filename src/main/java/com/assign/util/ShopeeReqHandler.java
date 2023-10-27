package com.assign.util;

import com.assign.entity.dto.shopee.feign.CommonRequestVO;
import com.assign.entity.po.TokensPO;
import com.assign.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * ShopeeUtil
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/13.
 */
@Component
public class ShopeeReqHandler {

    @Value("${shopee.partnerId}")
    private int partnerId;

    @Value("${shopee.key}")
    private String key;

    @Autowired
    private TokenService tokenService;
    public  Map<String, Object> getShopeeReqHeaders(Integer shopId,String path){
        Map<String,Object> headers = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        headers.put("partner_id",partnerId);
        headers.put("timestamp",timestamp);
        TokensPO token =  tokenService.getTokenById(shopId);
        headers.put("access_token",token.getAccessToken());
        headers.put("shop_id",shopId);
        headers.put("sign",getSign(path,timestamp,token,shopId));
        return headers;
    }

    public String getSign(String path, long timestamp, TokensPO token, Integer shopId) {
        String tmpPartnerKey = key;
        String tmpBaseString = String.format("%s%s%s%s%s", partnerId, path, timestamp,token.getAccessToken(),shopId);
        byte[] partnerKey;
        byte[] baseString;
        String sign = "";
        try {
            baseString = tmpBaseString.getBytes("UTF-8");
            partnerKey = tmpPartnerKey.getBytes("UTF-8");
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(partnerKey, "HmacSHA256");
            mac.init(secret_key);
            sign = String.format("%064x",new BigInteger(1,mac.doFinal(baseString)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sign;
    }


    public void initCommonParam(CommonRequestVO dto, int shopId, String path){
        dto.setPartner_id(partnerId);
        TokensPO token =  tokenService.getTokenById(shopId);
        dto.setAccess_token(token.getAccessToken());
        dto.setShop_id(shopId);
        long timestamp = System.currentTimeMillis()/1000;
        dto.setTimestamp(timestamp);
        dto.setSign(getSign(path,timestamp, token, shopId));
    }

}
