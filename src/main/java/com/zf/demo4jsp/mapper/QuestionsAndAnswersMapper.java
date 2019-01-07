package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.QuestionsAndAnswers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value ="QuestionsAndAnswersMapper")
public interface QuestionsAndAnswersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    int insert(QuestionsAndAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    int insertSelective(QuestionsAndAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    QuestionsAndAnswers selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuestionsAndAnswers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table questionsandanswers
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuestionsAndAnswers record);

    List<QuestionsAndAnswers> selectQuestionsandanswersAll(String questions);
}