package com.zf.demo4jsp.controller.afterEnd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.yishiOrder;
import com.zf.demo4jsp.mapper.yishiOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EvaluateController {
    @Autowired
    private yishiOrderMapper yishiOrderMapper;

    //对易师进行评价
    @RequestMapping("/evaluateYiShi")
    public ModelAndView evaluateYiShi(String orderNumber ){
        ModelAndView mv = new ModelAndView();
        List<yishiOrder> orderList = yishiOrderMapper.selectyisiOrderAll();//查询全部数据 参数：username模糊查询
        mv.setViewName("yishiOrder/yishiOrder");

        return mv;//返回到用户管理页面
        }
//
//    //用户订单信息详情
//    @RequestMapping("/userorderById")
//    public ModelAndView userorderById(Integer id ){
//        ModelAndView mv = new ModelAndView();
//        Order order= orderMapper.selectByPrimaryKey(id);
//        mv.addObject("order",order);//数据回显
//        mv.setViewName("userOrder/userOrderDetails");
//        return mv;//返回到用户管理页面
//    }
}
