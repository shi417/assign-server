package com.assign.feign.vo.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * AliCurrencyHeader
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Data
public class AliCurrencyHeader {

    @JsonProperty("Authorization")
    private String authorization;

}
