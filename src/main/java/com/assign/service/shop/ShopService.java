package com.assign.service.shop;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shop.ShopeeShopDTO;
import com.assign.service.common.CommonService;

import java.util.List;
import java.util.Map;

/**
 * ShopService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
public interface ShopService  {
    ResponseResult<List<ShopeeShopDTO>> getAllList();
}
