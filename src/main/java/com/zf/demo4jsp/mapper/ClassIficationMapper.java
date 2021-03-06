package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.ClassIfication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="ClassIficationMapper")
public interface ClassIficationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    int insert(ClassIfication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    int insertSelective(ClassIfication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    ClassIfication selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClassIfication record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table classification
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClassIfication record);

    List<ClassIfication> selectClassIficationAll(String name);
    //app端
    List<ClassIfication>  classIficationByIdAll( String parentid);
}