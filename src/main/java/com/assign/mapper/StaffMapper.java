package com.assign.mapper;

import com.assign.entity.po.StaffPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 小史
* @description 针对表【staff(staff info)】的数据库操作Mapper
* @createDate 2023-10-28 14:05:59
* @Entity com.assign.entity.po.StaffPO
*/
@Mapper
public interface StaffMapper extends BaseMapper<StaffPO> {

    int deleteByPrimaryKey(Long id);

    int insert(StaffPO record);

    int insertSelective(StaffPO record);

    StaffPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StaffPO record);

    int updateByPrimaryKey(StaffPO record);

    StaffPO selectByUserCode(@Param("userCode") String userCode);
}
