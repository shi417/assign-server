
package com.assign.entity.dto.shopee;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PackageList {

    @SerializedName("item_list")
    private List<ShopeeDetailDTO> shopeeDetailDTO;
    @SerializedName("logistics_status")
    private String logisticsStatus;
    @SerializedName("package_number")
    private String packageNumber;
    @SerializedName("shipping_carrier")
    private String shippingCarrier;

}
