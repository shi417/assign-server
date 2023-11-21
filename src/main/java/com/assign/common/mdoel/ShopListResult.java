package com.assign.common.mdoel;

import com.assign.feign.vo.shop.AuthedShopListVO;
import lombok.Data;

import java.util.List;

/**
 * ShopResult
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopListResult {

    private String request_id;

    private String more;

    private String error;

    private String message;

    private List<AuthedShopListVO> authed_shop_list;
}
