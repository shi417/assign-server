
package com.assign.entity.dto.shopee;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ImageInfo {

    @SerializedName("image_url")
    private String imageUrl;

}
