package com.assign.service.common.impl;

import com.assign.constants.ShopeePathConstants;
import com.assign.feign.vo.CommonRequestVO;
import com.assign.feign.vo.settle.ShopeePaymentRequestVO;
import com.assign.service.common.CommonService;
import com.assign.util.ShopeeReqHandler;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * ShopeeCommonServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ShopeeReqHandler shopeeReqHandler;

    protected void initCommonParam(CommonRequestVO query, Integer shopId, String path) {
        shopeeReqHandler.initCommonParam(query,shopId, path);
    }
}
