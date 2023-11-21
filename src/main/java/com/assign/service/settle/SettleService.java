package com.assign.service.settle;

import com.assign.entity.common.PageResult;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.settle.ShopeeSettlePayoutDTO;
import com.assign.entity.dto.settle.ShopeeSettleRequestDTO;
import com.assign.entity.dto.settle.ShopeeSettleResponseDTO;
import com.assign.service.common.CommonService;

import java.util.List;

/**
 * SettleService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
public interface SettleService extends CommonService {
    ResponseResult<List<ShopeeSettlePayoutDTO>> getList(ShopeeSettleRequestDTO params);
}
