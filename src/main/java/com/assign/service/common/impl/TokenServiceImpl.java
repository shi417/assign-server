package com.assign.service.common.impl;

import com.assign.entity.po.TokensPO;
import com.assign.mapper.TokensMapper;
import com.assign.service.common.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TokenServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/18.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokensMapper tokensMapper;
    @Override
    public TokensPO getTokenById(Integer shopId) {
        return tokensMapper.getTokenById(shopId);
    }

    @Override
    public List<Integer> getShopIds() {
        return tokensMapper.getShopIds();
    }
}
