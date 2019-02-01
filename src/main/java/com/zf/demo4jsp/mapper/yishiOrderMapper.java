package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.yishiOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component(value ="yishiOrderMapper")
public interface yishiOrderMapper {
    int insert(yishiOrder record);
    List<yishiOrder> selectyisiOrderAll();
    List<yishiOrder> selectyisiOrderById(@Param("yishiId")String yishiId, @Param("orderType")String orderType);
    List<yishiOrder> selectyisiOrderByToday(@Param("yishiId")String yishiId);
    List<yishiOrder> selectyisiOrderByYesterday(@Param("yishiId")String yishiId);
    List<yishiOrder> selectyisiOrderByLastMonth(@Param("yishiId")String yishiId);
    List<yishiOrder> selectyisiSolutionState(@Param("yishiId")String yishiId);
    List<yishiOrder> selectyisiSolutionStateAll(@Param("yishiId")String yishiId);


}
