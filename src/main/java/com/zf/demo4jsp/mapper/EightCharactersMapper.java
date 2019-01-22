package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.EightCharacters;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="EightCharactersMapper")
public interface EightCharactersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EightCharacters record);

    int insertSelective(EightCharacters record);

    EightCharacters selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EightCharacters record);

    int updateByPrimaryKey(EightCharacters record);

    List<EightCharacters> selectEightcharactersByUserIdAll(String userId);
}