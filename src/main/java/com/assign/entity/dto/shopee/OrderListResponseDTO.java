
package com.assign.entity.dto.shopee;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author shiyaqing
 */
@Data
public class OrderListResponseDTO {

    @SerializedName("more")
    private Boolean more;
    @SerializedName("next_cursor")
    private String nextCursor;
    @SerializedName("order_list")
    private List<Map<String,String>> orderList;

}
