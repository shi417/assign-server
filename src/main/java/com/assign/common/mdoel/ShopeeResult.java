package com.assign.common.mdoel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * ShopeeResult
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/19.
 */
@Data
public class ShopeeResult<T> {
    private String error;

    private String message;

    @JsonProperty("request_id")
    private String requestId;

    private T response;
}
