package com.assign.mapper;

import com.assign.entity.po.TokensPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author shiyaqing
* @description 针对表【tokens(token info)】的数据库操作Mapper
* @createDate 2023-09-18 16:12:29
* @Entity com.assign.entity.po.TokensPO
*/
@Mapper
public interface TokensMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TokensPO record);

    int insertSelective(TokensPO record);

    TokensPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TokensPO record);

    int updateByPrimaryKey(TokensPO record);

    List<TokensPO> getTokens();

    List<Integer> getShopIds();

    TokensPO getTokenById(Integer shopId);
}
