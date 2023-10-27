package com.assign.mapper;

import com.assign.entity.dto.shopee.ShopeeDetailResponseDTO;
import com.assign.entity.po.ShopeeOrderDetailPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shiyaqing
* @description 针对表【shopee_order_detail】的数据库操作Mapper
* @createDate 2023-09-23 12:30:00
* @Entity com.assign.entity.po.ShopeeOrderDetailPO
*/
@Mapper
public interface ShopeeOrderDetailMapper extends BaseMapper<ShopeeOrderDetailPO> {

    int deleteByPrimaryKey(Long id);

    int insert(ShopeeOrderDetailPO record);

    int insertSelective(ShopeeOrderDetailPO record);

    ShopeeOrderDetailPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopeeOrderDetailPO record);

    int updateByPrimaryKey(ShopeeOrderDetailPO record);

    List<ShopeeDetailResponseDTO> selectByOrderSn(@Param("orderSn") String orderSn);
}
