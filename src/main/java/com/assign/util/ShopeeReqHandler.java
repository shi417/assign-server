package com.assign.util;

import com.assign.entity.po.TokensPO;
import com.assign.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
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
    private ITokenService tokenService;
    public  Map<String, Object> getShopeeReqHeaders(Integer shopId,String path){
        Map<String,Object> headers = new HashMap<>();
        long timestamp = System.currentTimeMillis();
        headers.put("partner_id",partnerId);
        headers.put("timestamp",timestamp);
        TokensPO token =  tokenService.getTokenById(shopId);
        headers.put("access_token",token.getAccessToken());
        headers.put("shop_id",shopId);
        headers.put("sign",getSign(path,timestamp));
        return headers;
    }

    public String getSign(String path,long timestamp) {
        try {
            String data = String.format("%s%s%s",partnerId,path,timestamp);
            Mac hmacSha256 = null;
            hmacSha256 = Mac.getInstance("HmacSHA256");
            // 使用密钥初始化HMAC实例
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            hmacSha256.init(secretKey);
            // 计算哈希值
            byte[] hashBytes = hmacSha256.doFinal(data.getBytes());
            // 将哈希值转换为十六进制字符串
            StringBuilder hexHash = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = String.format("%02x", b);
                hexHash.append(hex);
            }
            return hexHash.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
