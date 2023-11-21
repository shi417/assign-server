package com.assign.feign.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * ShopeeSimpleVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/10/27.
 */
@Data
public class ShopeeSimpleVO {
    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("next_cursor")
    private String nextCursor;
    @JsonProperty("order_list")
    private List<Map<String,String>> orderList;
}
