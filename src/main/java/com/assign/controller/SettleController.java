package com.assign.controller;

import com.assign.entity.common.PageResult;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.settle.ShopeeSettlePayoutDTO;
import com.assign.entity.dto.settle.ShopeeSettleRequestDTO;
import com.assign.entity.dto.settle.ShopeeSettleResponseDTO;
import com.assign.entity.dto.shopee.OrderListResponseDTO;
import com.assign.entity.dto.shopee.ShopeeOrderRequestDTO;
import com.assign.service.settle.SettleService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * SettleController
 * Description:结算
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@RestController
@RequestMapping("/settle")
@AllArgsConstructor
public class SettleController {

    private final SettleService settleService;
    @ApiOperation(value = "查询虾皮订单", notes = "查询虾皮订单", httpMethod = "POST")
    @PostMapping("/list")
    public ResponseResult<List<ShopeeSettlePayoutDTO>> getList(@RequestBody ShopeeSettleRequestDTO params){
        return settleService.getList(params);
    }
}
