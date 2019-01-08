package com.zf.demo4jsp.controller;

import com.zf.demo4jsp.entity.QuestionsAndAnswers;
import com.zf.demo4jsp.mapper.QuestionsAndAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import java.util.List;


@Controller
public class FrontEndQuestionsAndAnswersController {
    @Autowired
    private QuestionsAndAnswersMapper questionsAndAnswersMapper;

    /**
     * app端首页问答
     * @return mv
     */
    @RequestMapping("/questionsAndAnswersList")
    public ModelAndView questionsAndAnswersList() {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<QuestionsAndAnswers> questionsAndAnswersList = questionsAndAnswersMapper.selectQuestionsandanswersList();//查询全部数据
        if(questionsAndAnswersList!=null){//判断数据
            mv.addObject("questionsAndAnswersList", questionsAndAnswersList);
        }
        return mv;
    }

}
