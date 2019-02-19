package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.AstrologyFortune;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="AstrologyFortuneMapper")
public interface AstrologyFortuneMapper {
    int insert(AstrologyFortune record);

    int insertSelective(AstrologyFortune record);

    List<AstrologyFortune> selectAllAstrologyFortune();
}