package com.assign.feign.vo.settle;

import com.assign.feign.vo.CommonRequestVO;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * ShopeePaymentRequestVO
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/7.
 */
@Data
public class ShopeePaymentRequestVO extends CommonRequestVO {
    @SerializedName("page_size")
    private Integer page_size;

    @SerializedName("page_no")
    private Integer page_no;

    @SerializedName("payout_time_from")
    private Long payout_time_from;

    @SerializedName("payout_time_to")
    private Long payout_time_to;

    @SerializedName("release_time_from")
    private Long release_time_from;

    @SerializedName("release_time_to")
    private Long release_time_to;

}
