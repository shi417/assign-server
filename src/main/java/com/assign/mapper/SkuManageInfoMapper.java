package com.assign.mapper;

import com.assign.entity.po.SkuManageInfoPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 小史
* @description 针对表【sku_manage_info(sku检索表)】的数据库操作Mapper
* @createDate 2023-10-29 17:19:01
* @Entity com.assign.entity.po.SkuManageInfoPO
*/
@Mapper
public interface SkuManageInfoMapper extends BaseMapper<SkuManageInfoPO> {

    int deleteByPrimaryKey(Long id);

    int insert(SkuManageInfoPO record);

    int insertSelective(SkuManageInfoPO record);

    SkuManageInfoPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuManageInfoPO record);

    int updateByPrimaryKey(SkuManageInfoPO record);

}
