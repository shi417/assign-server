package com.assign.service;

import com.assign.entity.po.TokensPO;

import java.util.List;

/**
 * ITokenService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/18.
 */
public interface TokenService {
    TokensPO getTokenById(Integer shopId);

    List<Integer> getShopIds();
}
