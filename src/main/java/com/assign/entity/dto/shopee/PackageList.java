
package com.assign.entity.dto.shopee;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageList {

    @JsonProperty("item_list")
    private List<ShopeeOrderDetailDTO> shopeeOrderDetailDTO;
    @JsonProperty("logistics_status")
    private String logisticsStatus;
    @JsonProperty("package_number")
    private String packageNumber;
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;

}
