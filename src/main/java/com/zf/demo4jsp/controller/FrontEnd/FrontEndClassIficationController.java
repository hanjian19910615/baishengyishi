package com.zf.demo4jsp.controller.FrontEnd;

import com.zf.demo4jsp.entity.ClassIfication;
import com.zf.demo4jsp.mapper.ClassIficationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;


@Controller
public class FrontEndClassIficationController {

    @Autowired
    private ClassIficationMapper classIficationMapper;

    /**
     * app端标签接口
     * @Param
     * @Param
     * @return
     */
    @RequestMapping("/classIficationList")
    public ModelAndView classIficationList(String parentid) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<ClassIfication> classIficationList = classIficationMapper.classIficationByIdAll(parentid);//查询全部数据
        if(classIficationList!=null){//判断数据
            mv.addObject("classIficationList", classIficationList);
        }
        return mv;
    }


}
