
package com.assign.entity.dto.shopee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ImageInfo {

    @JsonProperty("image_url")
    private String imageUrl;

}
