package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.MessageLists;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="MessageListsMapper")
public interface MessageListsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageLists record);


    MessageLists selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageLists record);

    List<MessageLists> selectMessageListsByState();

    List<MessageLists> selectMessageListsByAll();
}