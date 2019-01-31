package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Agency;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="AgencyMapper")
public interface AgencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Agency record);

    Agency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Agency record);

}