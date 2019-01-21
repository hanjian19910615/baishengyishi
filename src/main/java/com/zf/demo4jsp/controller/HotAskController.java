package com.zf.demo4jsp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.HotAsk;
import com.zf.demo4jsp.entity.Order;
import com.zf.demo4jsp.mapper.HotAskMapper;
import com.zf.demo4jsp.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotAskController {
    @Autowired
    private HotAskMapper hotAskMapper;

    //订单信息信息
    @RequestMapping("/hotAskList")
    public ModelAndView hotAskList(String pageNum, String orderName ){
        ModelAndView mv = new ModelAndView();
            if( pageNum !=null){
                PageHelper.startPage(Integer.parseInt(pageNum) , 10);
            }else{
                PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
            }
            List<HotAsk> hotAskList = hotAskMapper.selectByAll();//查询全部数据 参数：username模糊查询
            PageInfo<HotAsk> hotAskPageInfo = new PageInfo<>(hotAskList);//得到分页的结果对象
            List<HotAsk> pageList = hotAskPageInfo.getList();//得到分页中的person条目对象
            mv.addObject("pages",hotAskPageInfo);//分页里面的数据 在前台展示
            mv.addObject("hotAsks",pageList);//用户信息
            mv.addObject("orderName",orderName);//数据回显
            mv.setViewName("hotAsk");
            return mv;//返回到用户管理页面
        }


}
