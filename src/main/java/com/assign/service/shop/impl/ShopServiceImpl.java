package com.assign.service.shop.impl;

import com.assign.common.mdoel.ShopListResult;
import com.assign.common.mdoel.ShopeeResult;
import com.assign.constants.ShopeePathConstants;
import com.assign.entity.common.ResponseResult;
import com.assign.entity.dto.shop.ShopeeShopDTO;
import com.assign.feign.ShopeeFeignServer;
import com.assign.feign.vo.CommonRequestVO;
import com.assign.feign.vo.ShopeeShopRequestVO;
import com.assign.feign.vo.ShopeeShopVO;
import com.assign.feign.vo.shop.AuthedShopListVO;
import com.assign.service.common.impl.CommonServiceImpl;
import com.assign.service.shop.ShopService;
import com.assign.util.ShopeeReqHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ShopServiceImpl
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
@Service
@AllArgsConstructor
public class ShopServiceImpl  implements ShopService {

    private  final ShopeeFeignServer shopeeFeignServer;

    private final ShopeeReqHandler shopeeReqHandler;
    @Override
    public ResponseResult<List<ShopeeShopDTO>> getAllList() {
        CommonRequestVO param = new CommonRequestVO();
        long timestamp = System.currentTimeMillis() / 1000;
        param.setSign(shopeeReqHandler.getSign(ShopeePathConstants.GET_SHOPS_BY_PARTNER,timestamp,null,0));
        param.setPartner_id(shopeeReqHandler.getPartnerId());
        param.setTimestamp(timestamp);
        param.setShop_id(null);
        ShopListResult res = shopeeFeignServer.getAllShops(param);
        if (res.getAuthed_shop_list() == null || res.getAuthed_shop_list().isEmpty()){
            return ResponseResult.failed("获取店铺列表失败:"+res.getMessage());
        }
        List<AuthedShopListVO> response = res.getAuthed_shop_list();
        List<ShopeeShopDTO> shopDTOs = new ArrayList<>();
        for (AuthedShopListVO shop : response){
            ShopeeShopRequestVO shopParam = new ShopeeShopRequestVO();
            shopeeReqHandler.initCommonParam(shopParam,shop.getShopId(), ShopeePathConstants.GET_SHOP_INFO);
            ShopeeShopVO shopInfo = shopeeFeignServer.getShopInfo(shopParam);
            ShopeeShopDTO dto = new ShopeeShopDTO();
            dto.setShopName(shopInfo.getShopName());
            dto.setShopId(shop.getShopId());
            dto.setRegion(shopInfo.getRegion());
            dto.setStatus(shopInfo.getStatus());
            shopDTOs.add(dto);
        }
        return ResponseResult.success(shopDTOs);
    }
}
