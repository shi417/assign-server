
package com.assign.feign.vo.currency;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class CurrencyList {

    @JsonProperty("chao_in")
    private String chaoIn;
    @JsonProperty("chao_out")
    private String chaoOut;
    @Expose
    private String code;
    @Expose
    private String day;
    @JsonProperty("hui_in")
    private String huiIn;
    @JsonProperty("hui_out")
    private String huiOut;
    @Expose
    private String name;
    @Expose
    private String time;
    @Expose
    private String zhesuan;


}
