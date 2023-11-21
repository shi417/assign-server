package com.assign.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ShopEnum
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/9/13.
 */
@Getter
@AllArgsConstructor
public enum ShopEnum {
    MY("马来西亚"),
    BR("巴西"),
    TH_1("泰国一店"),
    TH_2("泰国二店"),
    TW("台湾"),
    SG("新加坡"),
    PH("菲律宾"),
    VN("越南"),
    MX("墨西哥");

    private final String desc;

}
