
package com.assign.entity.dto.shopee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class RecipientAddress {

    @Expose
    private String city;
    @Expose
    private String district;
    @SerializedName("full_address")
    private String fullAddress;
    @Expose
    private String name;
    @Expose
    private String phone;
    @Expose
    private String region;
    @Expose
    private String state;
    @Expose
    private String town;
    @Expose
    private String zipcode;

}
