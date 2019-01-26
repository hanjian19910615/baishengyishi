package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value ="CouponMapper")
public interface CouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coupon record);

    Coupon selectByUserId(String id);

}