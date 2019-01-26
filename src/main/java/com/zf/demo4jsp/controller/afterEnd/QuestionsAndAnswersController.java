package com.zf.demo4jsp.controller.afterEnd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.QuestionsAndAnswers;
import com.zf.demo4jsp.mapper.QuestionsAndAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuestionsAndAnswersController {
    @Autowired
    private QuestionsAndAnswersMapper questionsAndAnswersMapper;

    //问答信息
    @RequestMapping("/questionsAndAnswers")
    public ModelAndView questionsAndAnswers(String pageNum,  String questions ){
        ModelAndView mv = new ModelAndView();
            if( pageNum !=null){
                PageHelper.startPage(Integer.parseInt(pageNum) , 10);
            }else{
                PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
            }
            List<QuestionsAndAnswers> questionsAndAnswersList = questionsAndAnswersMapper.selectQuestionsandanswersAll(questions);//查询全部数据 参数：username模糊查询
            PageInfo<QuestionsAndAnswers> questionsAndAnswersPageInfo = new PageInfo<>(questionsAndAnswersList);//得到分页的结果对象
            List<QuestionsAndAnswers> pageList = questionsAndAnswersPageInfo.getList();//得到分页中的person条目对象
            mv.addObject("pages",questionsAndAnswersPageInfo);//分页里面的数据 在前台展示
            mv.addObject("questionsAndAnswers",pageList);//用户信息
            mv.addObject("questions",questions);//数据回显
            mv.setViewName("questionsandanswers");
            return mv;//返回到用户管理页面
        }


}
