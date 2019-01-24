package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="EvaluateMapper")
public interface EvaluateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluate record);

    Evaluate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluate record);
}