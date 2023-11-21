
package com.assign.feign.vo.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class ShowapiResBody {

    @JsonProperty("list")
    private List<CurrencyList> currencyList;

    private Long listSize;

    @JsonProperty("ret_code")
    private Long retCode;

}
