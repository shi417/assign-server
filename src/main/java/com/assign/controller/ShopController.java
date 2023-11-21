package com.assign.controller;

import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shop.ShopeeShopDTO;
import com.assign.service.shop.ShopService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ShopController
 * Description:虾皮商店
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@RestController
@RequestMapping("/shop")
@AllArgsConstructor
public class ShopController {


    private final ShopService shopService;
    @ApiOperation(value = "查询所有店铺", notes = "查询所有店铺", httpMethod = "POST")
    @GetMapping("/allList")
    public ResponseResult<List<ShopeeShopDTO>> getAllList(){
        return shopService.getAllList();
    }
}
