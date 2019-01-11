package com.zf.demo4jsp.controller;

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
//    /**
//     * app端订单详细接口
//     * @Param  String userId
//     * @return
//     */
//    @RequestMapping("/orderById")
//    public ModelAndView orderList(int id ) {
//
//        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
//        Order order = orderMapper.selectByPrimaryKey(id);//查询全部数据
//        if(order!=null){//判断数据
//            mv.addObject("order", order);
//        }
//        return mv;
//    }
//
//    /**
//     * app端订单详细接口
//     * @Param  String userId
//     * @return
//     */
//    @RequestMapping("/delOrder")
//    public ModelAndView delOrder(Integer orderId ) {
//        Integer id=orderId;
//        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
//        Order order = orderMapper.selectByPrimaryKey(id);//查询全部数据
//        if(order!=null){//判断数据
//            order.setDisableenable(0);
//            order.setId(id);
//            int count = orderMapper.updateByPrimaryKeySelective(order);//(假删除)删除订单 修改订单状态为0
//            if(count==1){
//                mv.addObject("delSuccess", "1");
//            }else{
//                mv.addObject("delError", "0");
//            }
//        }
//        return mv;
//    }



}
