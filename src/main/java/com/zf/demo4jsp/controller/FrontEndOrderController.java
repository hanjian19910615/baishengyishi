package com.zf.demo4jsp.controller;

import com.zf.demo4jsp.entity.Order;
import com.zf.demo4jsp.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import java.util.List;



@Controller
public class FrontEndOrderController {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * app端订单接口
     * @Param  String userId
     * @return
     */
    @RequestMapping("/orderList")
    public ModelAndView orderList(String userId,String paymentStatus ) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<Order> orderList = orderMapper.selectOrderByUserIdAll(userId,paymentStatus);//查询全部数据
        if(orderList!=null){//判断数据
            mv.addObject("orderList", orderList);
        }
        return mv;
    }
    /**
     * app端订单详细接口
     * @Param  String userId
     * @return
     */
    @RequestMapping("/orderById")
    public ModelAndView orderList(int id ) {

        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Order order = orderMapper.selectByPrimaryKey(id);//查询全部数据
        if(order!=null){//判断数据
            mv.addObject("order", order);
        }
        return mv;
    }

}
