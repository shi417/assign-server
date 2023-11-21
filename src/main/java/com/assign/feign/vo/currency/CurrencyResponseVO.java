
package com.assign.feign.vo.currency;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CurrencyResponseVO {

    @JsonProperty("showapi_fee_num")
    private Long showapiFeeNum;
    @JsonProperty("showapi_res_body")
    private ShowapiResBody showapiResBody;
    @JsonProperty("showapi_res_code")
    private Long showapiResCode;
    @JsonProperty("showapi_res_error")
    private String showapiResError;
    @JsonProperty("showapi_res_id")
    private String showapiResId;

}
