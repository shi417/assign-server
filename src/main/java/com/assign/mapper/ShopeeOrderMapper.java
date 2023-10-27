package com.assign.mapper;

import com.assign.entity.po.ShopeeOrderPO;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
* @author shiyaqing
* @description 针对表【shopee_order(shopee_order)】的数据库操作Mapper
* @createDate 2023-09-19 16:52:14
* @Entity com.assign.entity.po.ShopeeOrderPO
*/
@Mapper
public interface ShopeeOrderMapper extends BaseMapper<ShopeeOrderPO>{

    int deleteByPrimaryKey(Long id);

    int insert(ShopeeOrderPO record);

    int insertSelective(ShopeeOrderPO record);

    ShopeeOrderPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopeeOrderPO record);

    int updateByPrimaryKey(ShopeeOrderPO record);

    Date selectMaxUpdateDate();

    Long getMaxUpdateDate(@Param("shopId") Integer shopId);
}
