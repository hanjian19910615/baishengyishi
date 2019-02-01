package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Slideshow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="SlideshowMapper")
public interface SlideshowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Slideshow record);

    Slideshow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Slideshow record);

    List<Slideshow> selectSlideshowByType(@Param("imagetype") String imagetype);

}