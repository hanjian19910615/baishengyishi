package com.zf.demo4jsp.controller;

import com.zf.demo4jsp.entity.EightCharacters;
import com.zf.demo4jsp.entity.Evaluate;
import com.zf.demo4jsp.mapper.EightCharactersMapper;
import com.zf.demo4jsp.mapper.EvaluateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

//评价
@Controller
public class FrontEndEvaluateController {

    @Autowired
    private EvaluateMapper evaluateMapper;
    /**
     * app端用户添加评价
     *
     * @return
     * @Param Order record
     */
    @RequestMapping("/addEvaluate")
    public ModelAndView addEvaluate(String content,String userId ,
                                    String userName,String yishiId,
                                    String yishiName,String evaluationValue,
                                    String starLevel,String orderNumber) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
         Evaluate evaluate = new Evaluate();
         evaluate.setContent(content);//内容
         evaluate.setUserid(userId);//用户id
         evaluate.setUsername(userName);//用户名
         evaluate.setYishiid(yishiId);//易师id
         evaluate.setYishiname(yishiName);//易师名称
         evaluate.setEvaluationvalue(evaluationValue);//评价
         evaluate.setCreatetime("");//时间
         evaluate.setStarlevel(starLevel);//星级评价
         evaluate.setOrdernumber(orderNumber);
        int count = evaluateMapper.insert(evaluate);
        if(count==1){
            mv.addObject("success","1");
        }else{
            mv.addObject("error","0");
        }
        return mv;
    }



}
