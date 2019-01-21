package com.zf.demo4jsp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.HotAsk;
import com.zf.demo4jsp.entity.Opinion;
import com.zf.demo4jsp.mapper.HotAskMapper;
import com.zf.demo4jsp.mapper.OpinionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OpinionController {
    @Autowired
    private OpinionMapper opinionMapper;

    //意见与反馈
    @RequestMapping("/opinionList")
    public ModelAndView opinionList(String pageNum, String opinioncontact ){
        ModelAndView mv = new ModelAndView();
            if( pageNum !=null){
                PageHelper.startPage(Integer.parseInt(pageNum) , 10);
            }else{
                PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
            }
            List<Opinion> opinionList = opinionMapper.opinionAll(opinioncontact);//查询全部数据 参数：username模糊查询
            PageInfo<Opinion> opinionPageInfo = new PageInfo<>(opinionList);//得到分页的结果对象
            List<Opinion> pageList = opinionPageInfo.getList();//得到分页中的person条目对象
            mv.addObject("pages",opinionPageInfo);//分页里面的数据 在前台展示
            mv.addObject("opinions",pageList);//用户信息
            mv.addObject("opinioncontact",opinioncontact);//数据回显
            mv.setViewName("opinion");
            return mv;//返回到用户管理页面
        }


}
