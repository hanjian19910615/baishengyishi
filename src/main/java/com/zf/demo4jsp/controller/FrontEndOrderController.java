package com.zf.demo4jsp.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.zf.demo4jsp.entity.Order;
import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.OrderMapper;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;


@Controller
public class FrontEndOrderController {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * app端订单接口
     * @Param  String pwd
     * @return
     */
    @RequestMapping("/orderList")
    public ModelAndView orderList(String userId) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<Order> orderList = orderMapper.selectOrderByUserIdAll(userId);//查询全部数据
        if(orderList!=null){//判断数据
            mv.addObject("orderList", orderList);
        }
        return mv;
    }

}
