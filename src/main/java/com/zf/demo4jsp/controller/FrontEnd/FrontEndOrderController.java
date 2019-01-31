package com.zf.demo4jsp.controller.FrontEnd;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.zf.demo4jsp.entity.Order;
import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.entity.yishiOrder;
import com.zf.demo4jsp.mapper.OrderMapper;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import com.zf.demo4jsp.mapper.yishiOrderMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * app普通用户端订单接口
 *
 * @return
 */
@Controller
public class FrontEndOrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private yishiOrderMapper yishiOrderMapper;

    /**
     * app端订单接口
     *
     * @return
     * @Param String userId
     * @Param String paymentStatus
     */
    @RequestMapping("/orderList")
    public ModelAndView orderList(String userId, String paymentStatus) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        List<Order> orderList = orderMapper.selectOrderByUserIdAll(userId, paymentStatus);//查询全部数据
        if (orderList != null) {//判断数据
            mv.addObject("orderList", orderList);
        }
        return mv;
    }

    /**
     * app端订单详细接口
     *
     * @return
     * @Param String userId
     */
    @RequestMapping("/orderById")
    public ModelAndView orderById(int id) {

        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Order order = orderMapper.selectByPrimaryKey(id);//查询全部数据
        if (order != null) {//判断数据
            mv.addObject("order", order);
        }
        return mv;
    }

    /**
     * app端删除订单接口
     *
     * @return
     * @Param String userId
     */
    @RequestMapping("/delOrder")
    public ModelAndView delOrder(Integer orderId) {
        Integer id = orderId;
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        Order order = orderMapper.selectByPrimaryKey(id);//查询全部数据
        if (order != null) {//判断数据
            order.setDisableenable(0);
            order.setId(id);
            int count = orderMapper.updateByPrimaryKeySelective(order);//(假删除)删除订单 修改订单状态为0
            if (count == 1) {
                mv.addObject("delSuccess", "1");
            } else {
                mv.addObject("delError", "0");
            }
        }
        return mv;
    }

    /**
     * app端用户添加订单接口
     *
     * @return
     * @Param Order record
     */
    @RequestMapping("/addOrder")
    public ModelAndView addOrder(HttpServletRequest request, String userInfoStr,String yishiStr) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        System.out.println("======"+yishiStr);
        Order order = new Order();
        yishiOrder  ysOrder = new yishiOrder();
        HttpSession session = request.getSession();
        System.out.println(userInfoStr);
        String[] array= userInfoStr.split(",");
        String msgCode = getMsgCodeRandom();//生成随机数
        order.setOrdernumber(msgCode);
        for (int i = 0; i < array.length; i++) {
            //用户订单信息
            order.setUserid(array[0]);//订单人id
            order.setUsername(array[1]);//订单人名称
            order.setOrdername(array[2]);//订单名称
            order.setOrderamount(array[3]);//订单金额
            order.setPaymentstatus(array[4]);//订单状态
            order.setUsertype(array[5]);//用户类型
            order.setOrdertypemx(array[6]);//订单明细
            order.setDisableenable(1);
            order.setSolutionstate(0);
            order.setOrdertime(new Date());
            //易师订单信息
            ysOrder.setOrdernumber(msgCode);//订单号
            ysOrder.setOrderamount("");//易师的金额
            ysOrder.setOrdername(array[2]);//订单名称
            ysOrder.setOrdertime(order.getOrdertime());//订单时间
            ysOrder.setUserid(array[0]);//订单人id
            ysOrder.setUsername(array[1]);//订单人名称
            ysOrder.setPaymentstatus("0");//支付状态 已支付
            ysOrder.setSolutionstate("0");//解决状态 未解决
            ysOrder.setOrdertype("1");//订单类型 1提问 2亲测
        }
        order.setOrdertype("1");
        session.setAttribute("ordNum",order.getOrdernumber());
        int count =orderMapper.insert(order);
        if (count==1){
            String[] yishiArray= yishiStr.split("-");
            for (int i = 0; i < yishiArray.length; i++) {
                System.out.println(yishiArray[i]);
                UserInfo u = userInfoMapper.selectByPrimaryKey(Integer.parseInt(yishiArray[i]));
                ysOrder.setYishiid(String.valueOf(u.getUserid()));
                ysOrder.setYishiname(u.getUsername());
                ysOrder.setOrderamount(u.getYishiamount());
               int count1 =  yishiOrderMapper.insert(ysOrder);
            }
           mv.addObject("添加订单成功");
           String ordNum= (String)session.getAttribute("ordNum");
           Order order1=orderMapper.selectOrderByorderNumber(ordNum);
           if(order1!=null){
               mv.addObject("orderInfo",order1);
           }
        }else {
            mv.addObject("orderError","添加订单失败");
        }
        return mv;
    }

    /**
     * app端统计用户未解决订单接口
     * @Param String userId
     * @return count
     */
    @RequestMapping("/countOrderSolutionState")
    public ModelAndView countOrderSolutionState(String userId) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        int count = orderMapper.selectCountOrderBySolutionState(userId);//查询全部数据
        if (count >0) {//判断数据
            mv.addObject("count",count);//条数
        } else {
            mv.addObject("countOrderError", "0");
        }
        return mv;
    }

    /**
     * app端统计用户已下单未支付订单接口
     * @Param String userId
     * @return count
     */
    @RequestMapping("/countOrderPaymentStatus")
    public ModelAndView countOrderPaymentStatus(String paymentStatus  ) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        int count = orderMapper.selectCountOrderBypaymentStatus(paymentStatus);//查询全部数据
        if (count >0) {//判断数据
            mv.addObject("count",count);//条数
        } else {
            mv.addObject("countOrderError", "0");
        }
        return mv;
    }
    /**
     * app端支付宝和微信支付
     * @Param String userId
     * @return count
     */
    @RequestMapping("/pay")
    public ModelAndView  pay(int payStatus,String totalAmount,String outTradeNo,String subject){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if(payStatus==1){//支付宝
            String APP_ID="2019011262875331";
            String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDEMpmTgWN1RGqnGlqv0RhGn5fZiZOEPjS9NU3QQKPUBehO+0SnB9OBgrWH3Bsg3qLiKTW1eA5afdpa9pK5YO1clspes6iOriWKg0NhhrpAKgPZUzYn7yqMnzI8K4GEzF3kIP9qtavy2FzvtDqvbnww9VLZUduSt/H/DBYzr6pCmK3BFJP+mn9kTEw7dXgV9qZTcgUXvIQPMAvlHLN9nV/dnfRcHB1Eh52aXJ9Xzyqxv2lQ42EWXG7TBCWDwbfbLYpewKNqpbERiI2g8AiP8z99LVEa/bxgGpwagmmel8ynDhAzpZ4uMuKqmBNgSVu5rEEcqm9TTrWa+w9RNjHsEe4ZAgMBAAECggEAbqlvsCBJ3eniEjCuN/7DJ4p61stfdjaz/oijRDRBc6SFXI8jMOccKC92fpPqhUauLsw5rAp0ZhwYXjg3l/IQz6mJqZLCHwAg0pipF8grI2fPVfQ2Vp3yrPBaIFAVtLakurjV9/VScB4ThWxtsWerCt5EhalDJOU1zLqfhzWs3fRMsURKu0EYz+NITgOa5BBoJEeQpvq1RJ6jxfICD0DvAqMss7Wilmwv1YDc41N+uFMBumDvqUpCZEA34oRXByVv4oCD7QemvCtPUDZO4KdwRQxlY7cEY3+I3Oo1K75DRS22uNhUCpODKQIyAjvnRK+RZhgImQtVF/jdGbhCCD0GEQKBgQDuydTKun2jkQL+Z8NgU4I8bAWUfZk07TI0XBl51fvh19viXVRjkiiNnkBMVoQHVQ+f5tEi6oj8de3kUk8z0AEsw13Zwwos5Yvm4wqNozThv79oT6wqDAtQHjs/s8sitli2vTuC6YNH6atFwOVFmoPqSCkaYMxqn4Rge9KB2qy/XQKBgQDSVuBMPmL1NRD/pKwfq7djc54vnBaiQAARuA1JswX1T0xiKInWWp0EEzykh8bMi62JH15YuM0nV+jNRsa2PjX20c91j9eacgRXmc92pus5FH+oAzmi7pvsQ/L9sQRrsrDgVQwWTavfnevVYhLOPPkNLhjV5iXA+fC3VYBONuyJ7QKBgQDXMGPnXjCjGqeMBI55XEhdkytkKdvLaoZ30RfUSBZ57EFnuZu3L5wEI7zmDoFk6i7udt+5i4pvmQcNX2+ozaaBZH5LJA0jcKmnJKv6AD5Dwr0Hj+Ui7z+yr8vNGIXTfmhsJhRfYXjBcb67WZ5EH38JvoXsE5ej7qUpHe0SwLI0sQKBgQCb3WzQktpZwj0aczhpL6HxvFdYCF5tVOe4OZ7/If4kTeLYShn6EaOQxYCGm2ahZE/v8KLFNAwyP15v3yaZHXh3sfn9r92gwSSelYe68O4Vmi8OnXU0W4SHi8KgY3BXLk8LrXoLfPsD9c4wjUBKO7yCG8qjlqwbWBscf+tYCjM18QKBgCoCvQ/l8bp9rMBeWWNU8SkSlADddaf3Ib7MPlsdmmsoGLO0Qpimgg66ADzTUaEozx2ojK9glwVkIi6WY0LXidjceDwTDNT0jst2bSnEulLHb5yvQ//wX424AdZsgHBeU5m3LAixAwSrysI7axWJUIgiMP6qm++qYVDaQ9LLjc/Q";
            String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxDKZk4FjdURqpxpar9EYRp+X2YmThD40vTVN0ECj1AXoTvtEpwfTgYK1h9wbIN6i4ik1tXgOWn3aWvaSuWDtXJbKXrOojq4lioNDYYa6QCoD2VM2J+8qjJ8yPCuBhMxd5CD/arWr8thc77Q6r258MPVS2VHbkrfx/wwWM6+qQpitwRST/pp/ZExMO3V4FfamU3IFF7yEDzAL5RyzfZ1f3Z30XBwdRIedmlyfV88qsb9pUONhFlxu0wQlg8G32y2KXsCjaqWxEYiNoPAIj/M/fS1RGv28YBqcGoJpnpfMpw4QM6WeLjLiqpgTYElbuaxBHKpvU061mvsPUTYx7BHuGQIDAQAB";
            //签名方式
            String sign_type="RSA2";
            //编码格式
            String CHARSET="utf-8";
            //正式环境支付宝网关，如果是沙箱环境需更改成https://openapi.alipaydev.com/gateway.do
            String url="https://openapi.alipay.com/gateway.do";
            //实例化客户端
            AlipayClient alipayClient = new DefaultAlipayClient(url, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY,sign_type);
            //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
            //SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
            model.setBody("易师");
            model.setSubject(subject);
            //请保证OutTradeNo值每次保证唯一
            model.setOutTradeNo(outTradeNo);
            model.setTimeoutExpress("30m");
            model.setTotalAmount(totalAmount);
            model.setProductCode("QUICK_MSECURITY_PAY");
            request.setBizModel(model);
            request.setNotifyUrl("商户外网可以访问的异步地址");
            try {
                //这里和普通的接口调用不同，使用的是sdkExecute
                AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
                String orderString=response.getBody();
                System.out.println(orderString);//就是orderString 可以直接给客户端请求，无需再做处理。
                mv.addObject("orderString",orderString);
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
        }else{//微信支付

        }
        return mv;
    }

    /**
     * app支付宝或者微信返回的resltMessage修改订单状态
     * @Param String userId
     * @return count
     */
    @RequestMapping("/updateOrederPaymentstatus")
    public ModelAndView  updateOrederPaymentstatus(String resltMessage,String orderNumber){
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        if(resltMessage.equals("9000")){
            Order record = new Order();
            record.setPaymentstatus("1");
            record.setOrdernumber(orderNumber);
            int count = orderMapper.updateOrederPaymentstatus(record);
            if(count==1){
                mv.addObject("success","修改支付信息成功");
            }else{
                mv.addObject("error","修改支付信息失败");
            }
        }
        return mv;
    }
    /**
     * 生成随机的6位数，短信验证码
     * @return
     */
    private static String getMsgCodeRandom() {
        int n = 10;//随机数6位
        StringBuilder code = new StringBuilder();//随机
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());//循环
        }
        return code.toString();//返回6位随机数
    }
}
