package com.zf.demo4jsp.mapper.myMapper;

import com.zf.demo4jsp.entity.myEntity.yishiOrderEvaluate;
import com.zf.demo4jsp.entity.yishiOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="yishiOrderEvaluateMapper")
public interface yishiOrderEvaluateMapper {

    List<yishiOrderEvaluate>  selectyisiStarLevelRanking();

    List<yishiOrderEvaluate> selectyisiRanking();
    List<yishiOrderEvaluate>  selectyisiOrderNumberRanking();

}
