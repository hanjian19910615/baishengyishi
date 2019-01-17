package com.zf.demo4jsp.controller;

import com.zf.demo4jsp.entity.Opinion;
import com.zf.demo4jsp.entity.QuestionsAndAnswers;
import com.zf.demo4jsp.mapper.OpinionMapper;
import com.zf.demo4jsp.mapper.QuestionsAndAnswersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;


@Controller
public class FrontEndOpinionController {

    @Autowired
    private OpinionMapper opinionMapper;

    /**
     * app意见反馈添加
     *
     * @return mv
     */
    @RequestMapping("/addOpinion")
    public ModelAndView addOpinion(String opinioncontact,String contactinformation) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Opinion opinion = new Opinion();
        opinion.setContactinformation(contactinformation);
        opinion.setOpinioncontact(opinioncontact);
        int count = opinionMapper.insertSelective(opinion);
        if(count==1){
            mv.addObject("opinionSuccess", "1");//1代表成功
        }else {
            mv.addObject("yzmError", "0");//0代表错误
        }
        return mv;
    }

    /**
     * app意见反馈添加
     *
     * @return mv
     */
    @RequestMapping("/selectOpinion")
    public ModelAndView selectOpinion() {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<Opinion> opinions = opinionMapper.selectOpinion();
        if(opinions!=null){
            mv.addObject("opinions", opinions);//1代表成功
        }else {
            mv.addObject("opinions", opinions);//0代表错误
        }
        return mv;
    }


}
