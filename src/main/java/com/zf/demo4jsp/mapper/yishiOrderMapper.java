package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.yishiOrder;

public interface yishiOrderMapper {
    int insert(yishiOrder record);

    int insertSelective(yishiOrder record);
}