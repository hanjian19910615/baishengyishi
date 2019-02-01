package com.zf.demo4jsp.controller.FrontEnd;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.Order;
import com.zf.demo4jsp.entity.Slideshow;
import com.zf.demo4jsp.entity.yishiOrder;
import com.zf.demo4jsp.mapper.OrderMapper;
import com.zf.demo4jsp.mapper.yishiOrderMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * app普通用户端订单接口
 *
 * @return
 */
@Controller
public class FrontEndYiShiOrderController {

    @Autowired
    private yishiOrderMapper yishiOrderMapper;

    /**
     * app端易师订单接口
     * @return
     * @Param Order record
     */
    @RequestMapping("/yishiOrderList")
    public ModelAndView yishiOrderList(String pageNum,  String yishiId ,String orderType,String dateStr){
        int dateStr1 =Integer.parseInt(dateStr);//强转
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if( pageNum !=null){
            PageHelper.startPage(Integer.parseInt(pageNum) , 10);
        }else{
            PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        if(dateStr1==1){
            List<yishiOrder> todayOrderList=yishiOrderMapper.selectyisiOrderByToday(yishiId);
            PageInfo<yishiOrder> todayOrderPageInfo = new PageInfo<>(todayOrderList);//得到分页的结果对象
            List<yishiOrder> pageList = todayOrderPageInfo.getList();//得到分页中的person条目对象
            if(pageList.size()>0){//今天
                mv.addObject("pages",todayOrderPageInfo);//分页里面的数据 在前台展示
                mv.addObject("yishiOrders",pageList);//用户信息
                mv.addObject("code",0);//成功
            }else{
                mv.addObject("errorMessage",1);//错误没数据
            }
        }else if(dateStr1==2){//昨天
            List<yishiOrder> yesterdayOrderList=yishiOrderMapper.selectyisiOrderByYesterday(yishiId);
            PageInfo<yishiOrder> yesterdayOrderPageInfo = new PageInfo<>(yesterdayOrderList);//得到分页的结果对象
            List<yishiOrder> pageList = yesterdayOrderPageInfo.getList();//得到分页中的person条目对象
            if(pageList.size()>0){
                mv.addObject("pages",yesterdayOrderPageInfo);//分页里面的数据 在前台展示
                mv.addObject("yishiOrders",pageList);//用户信息
                mv.addObject("code",0);//成功
            }else{
                mv.addObject("errorMessage",1);//错误没数据
            }
        }else if(dateStr1==3){//上月
            List<yishiOrder> lastMonthOrderList=yishiOrderMapper.selectyisiOrderByLastMonth(yishiId);
            PageInfo<yishiOrder> lastMonthOrderPageInfo = new PageInfo<>(lastMonthOrderList);//得到分页的结果对象
            List<yishiOrder> pageList = lastMonthOrderPageInfo.getList();//得到分页中的person条目对象
            if(pageList.size()>0){
                mv.addObject("pages",lastMonthOrderPageInfo);//分页里面的数据 在前台展示
                mv.addObject("yishiOrders",pageList);//用户信息
                mv.addObject("code",0);//成功
            }else{
                mv.addObject("errorMessage",1);//错误没数据
            }
        }else{//0查全部
            List<yishiOrder> yishiOrderList = yishiOrderMapper.selectyisiOrderById(yishiId,orderType);//查询全部数据 参数：username模糊查询
            PageInfo<yishiOrder> yishiOrderPageInfo = new PageInfo<>(yishiOrderList);//得到分页的结果对象
            List<yishiOrder> pageList = yishiOrderPageInfo.getList();//得到分页中的person条目对象
            if(pageList.size()>0){
                mv.addObject("pages",yishiOrderPageInfo);//分页里面的数据 在前台展示
                mv.addObject("yishiOrders",pageList);//用户信息
                mv.addObject("code",0);//成功
            }else{
                mv.addObject("errorMessage",1);//错误没数据
            }
        }
        return mv;//返回到用户管理页面
    }
    /**
     * app首页易师轮播图
     * @return
     * @Param
     */
    @RequestMapping("/selectyisiSolutionState")
    public ModelAndView selectyisiSolutionState(String yishiId){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<yishiOrder> yishiOrders=yishiOrderMapper.selectyisiSolutionState(yishiId);
        if(yishiOrders.size()>0){
            mv.addObject("code","0");
            mv.addObject("data",yishiOrders);
        }else{
            mv.addObject("error","1");
        }
        return mv;

    }
    /**
     * app首页易师全部排行
     * @return
     * @Param
     */
    @RequestMapping("/selectyisiSolutionStateAll")
    public ModelAndView selectyisiSolutionStateAll(String pageNum,String yishiId){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<yishiOrder> MessageLists = yishiOrderMapper.selectyisiSolutionStateAll(yishiId);//查询全部数据 参数：username模糊查询
        PageInfo<yishiOrder> MessageListsPageInfo = new PageInfo<>(MessageLists);//得到分页的结果对象
        List<yishiOrder> pageList = MessageListsPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("data", pageList);//用户信息
        mv.addObject("code","0");

        return mv;

    }

}
