package com.assign.mapper;

import com.assign.entity.po.AssignPO;
import com.assign.entity.po.ShopeeOrderPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author shiyaqing
* @description 针对表【assign(assign info)】的数据库操作Mapper
* @createDate 2023-10-27 15:58:20
* @Entity generator.domain.Assign
*/
@Mapper
public interface AssignMapper extends BaseMapper<AssignPO> {

    int deleteByPrimaryKey(Long id);

    int insert(AssignPO record);

    int insertSelective(AssignPO record);

    AssignPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssignPO record);

    int updateByPrimaryKey(AssignPO record);

    AssignPO selectByItemId(@Param("itemId") Long ecItemId);
}
