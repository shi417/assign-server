
package com.assign.entity.dto.shopee;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author shiyaqing
 */
@Data
public class OrderListResponseDTO {

    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("next_cursor")
    private String nextCursor;
    @JsonProperty("order_list")
    private List<Map<String,String>> orderList;

}
