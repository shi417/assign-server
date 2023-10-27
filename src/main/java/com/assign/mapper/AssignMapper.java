package com.assign.mapper;

import com.assign.entity.po.AssignPO;

/**
* @author shiyaqing
* @description 针对表【assign(assign info)】的数据库操作Mapper
* @createDate 2023-10-27 15:58:20
* @Entity generator.domain.Assign
*/
public interface AssignMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AssignPO record);

    int insertSelective(AssignPO record);

    AssignPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AssignPO record);

    int updateByPrimaryKey(AssignPO record);

}
