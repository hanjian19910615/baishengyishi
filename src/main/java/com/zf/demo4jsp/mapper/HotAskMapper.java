package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.HotAsk;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="HotAskMapper")
public interface HotAskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HotAsk record);

    int insertSelective(HotAsk record);

    HotAsk selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HotAsk record);

    int updateByPrimaryKey(HotAsk record);

    //app
   List<HotAsk> selectByAll();
}