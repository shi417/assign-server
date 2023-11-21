package com.assign.feign.vo.settle;

import com.assign.feign.vo.CommonRequestVO;
import lombok.Data;

/**
 * ShopeeSettleDetailVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class ShopeeSettleDetailRequestVO extends CommonRequestVO {
    private String order_sn;
}
