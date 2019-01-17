package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Opinion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="OpinionMapper")
public interface OpinionMapper {
    int insert(Opinion record);

    int insertSelective(Opinion record);

    List<Opinion> selectOpinion();
}