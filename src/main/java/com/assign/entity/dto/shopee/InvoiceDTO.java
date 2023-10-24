package com.assign.entity.dto.shopee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class InvoiceDTO {
    // 发票号码，必须为9位数字
    @JsonProperty("number")
    private String invoiceNumber;

    // 发票系列号，必须为3位数字
    @JsonProperty("series_number")
    private String seriesNumber;

    // 发票访问密钥，必须为44位字符
    @JsonProperty("access_key")
    private String accessKey;

    // 发票开具日期，必须晚于订单支付日期
    @JsonProperty("issue_date")
    private Timestamp issueDate;

    // 发票总金额
    @JsonProperty("total_value")
    private float totalValue;

    // 发票商品总金额
    @JsonProperty("products_total_value")
    private float productsTotalValue;

    // 税务代码，必须为4位数字
    @JsonProperty("tax_code")
    private String taxCode;

}
