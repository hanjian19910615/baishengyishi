package com.zf.demo4jsp.mapper.myMapper;

import com.zf.demo4jsp.entity.myEntity.EvaluateUser;
import com.zf.demo4jsp.entity.myEntity.yishiOrderEvaluate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="EvaluateUserMapper")
public interface EvaluateUserMapper {
    List<EvaluateUser>  selectEvaluateUser();

}
