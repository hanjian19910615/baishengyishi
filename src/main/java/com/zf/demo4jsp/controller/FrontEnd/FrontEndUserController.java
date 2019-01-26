package com.zf.demo4jsp.controller.FrontEnd;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import java.util.List;
import java.util.Random;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zf.demo4jsp.entity.Coupon;
import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.CouponMapper;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class FrontEndUserController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private CouponMapper couponMapper;

    /**
     * 获取短信
     *@Param  String phone
     * @return
     */
    @RequestMapping("/shortMessage")
    public ModelAndView shortMessage(HttpServletRequest request1, HttpServletResponse response, String phone) throws ClientException {
        HttpSession session = request1.getSession();
        ModelAndView mv = new ModelAndView();
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化ascClient需要的几个参数
        final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
        //替换成你的AK
        final String accessKeyId = "LTAI56R93RdaJKbi";//你的accessKeyId
        final String accessKeySecret = "6mjkhJAJIuHxarnxxARCe6u4y2MU3C";//你的accessKeySecret
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为00+国际区号+号码，如“0085200000000”
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("百晟乾坤");
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        request.setTemplateCode("SMS_153992393");
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        //request.setTemplateParam("{\"code\":\"988756\"}");
        //String msgCode = getMsgCode();//生成随机数
       String msgCode = "1";
        session.setAttribute("yzm", msgCode);
        request.setTemplateParam("{\"code\":\"" + msgCode + "\"}");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            mv.addObject("成功");
        } else {
            mv.addObject("失败");
        }
        return mv;
    }
    /**
     * 根据手机号查询(快捷登录)用户接口
     *@Param  String phone
     *@Param  String yzm
     * @return
     */
    @RequestMapping("/checkPhomeNum")
    public ModelAndView checkPhomeNum(HttpServletRequest request, String phone, String yzm) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        yzm = "1";
        String ymz1 = "1";
       // String ymz1= (String)session.getAttribute("yzm");
        session.setAttribute("phone", phone);
        if (!yzm.equals(ymz1)) {
            mv.addObject("error", "0");//0代表错误
        } else if (phone != null) {
            UserInfo user = userInfoMapper.selectUserByPhone(phone);//根据手机号进行数据匹配
            if (user != null) {
                mv.addObject("count", "1");//1:代表有数据
                mv.addObject("user", user);//用户数据
            } else {
                mv.addObject("massage2", "0");//0:没有数据 可以注册
            }
        }
        return mv;
    }

    /**
     * 注册接口
     *@Param  String pwd
     * @return
     */
    @RequestMapping("/register")
    public ModelAndView register(String phone,String pwd) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
            UserInfo userInfo = userInfoMapper.selectUserByPhone(phone);//根据手机号进行数据匹配
            if(userInfo!=null){
                mv.addObject("userInfo", userInfo);//0注册成功
                mv.addObject("loginSuccess","1");
            }else{

                UserInfo user = new UserInfo();
                user.setPhone(phone);
                user.setPwd(pwd);
                int count = userInfoMapper.insert(user);
                if (count == 1) {
                    Coupon coupon = new Coupon();
                    //coupon.setUserid(userId);
                    coupon.setAmount("90");
                    int count1 = couponMapper.insert(coupon);
                    if(count1==1){
                        mv.addObject("couponSuccess","1");

                    }else{
                        mv.addObject("couponError","0");
                    }
                    mv.addObject("successInformation", "0");//0注册成功
                    UserInfo userInfo1 = userInfoMapper.selectUserByPhone(phone);//根据手机号进行数据匹配
                    mv.addObject("userInfo", userInfo1);//0注册成功
                } else {
                    mv.addObject("errorInformation", "1");//注册失败
                }
            }
        return mv;
    }

    /**
     * 登录接口
     *@Param  String phone
     * @Param  String pwd
     * @return
     */
    @RequestMapping("/loginUserinfo")
    public ModelAndView loginUserinfo(String phone,String pwd) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        UserInfo userInfo = userInfoMapper.login(phone,pwd);//根据手机号进行数据匹配
        if(userInfo!=null){//判断数据
            mv.addObject("userInfo", userInfo);
            mv.addObject("loginSuccess","1");//登录成功

        }else{
                mv.addObject("loginError","0");//登录失败
        }
        return mv;
    }

    /**
     * 查询易师列表接口
     * @return
     */
    @RequestMapping("/selectByYiShi")
    public ModelAndView selectByYiShi(String pageNum) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());

        if( pageNum.equals("0")){
            PageHelper.startPage(1 , 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }else{
            PageHelper.startPage(Integer.parseInt(pageNum) , 10);
             }
        List<UserInfo> userInfosList = userInfoMapper.selectByYiShi();//根据手机号进行数据匹配
        PageInfo<UserInfo> orderPageInfo = new PageInfo<>(userInfosList);//得到分页的结果对象
        List<UserInfo> pageList = orderPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("pages",orderPageInfo);//分页里面的数据 在前台展示
        mv.addObject("userInfos",pageList);//用户信息
        mv.addObject("count",userInfosList.size());//用户信息
        return mv;
    }
    /**
     * 修改昵称（用户名）
     * @return
     */
    @RequestMapping("/updatNickname")
    public ModelAndView updatNickname(String id ,String name) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(name);
        userInfo.setUserid(Integer.parseInt(id));
       int count  = userInfoMapper.updateByPrimaryKeySelective(userInfo);
       if(count==1){
           mv.addObject("updatNicknameSuccess",1);//用户信息
       }else{
           mv.addObject("updatNicknameError",0);
       }
        return mv;
    }


    /**
     * 生成随机的6位数，短信验证码
     * @return
     */
    private static String getMsgCode() {
        int n = 6;//随机数6位
        StringBuilder code = new StringBuilder();//随机
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            code.append(Integer.valueOf(ran.nextInt(10)).toString());//循环
        }
        return code.toString();//返回6位随机数
    }

    /**
     * 修改用户密码,手机号
     * @Param  String pwd
     * @Param  String phone
     * @Param  String userId
     * @return
     */
    @RequestMapping("/updatePwdOrPhone")
    public ModelAndView updatePwdOrPhone( String pwd,String phone, Integer userId,String yzm) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        UserInfo userInfo = new UserInfo();
            if(pwd!=null){//密码
                userInfo.setPwd(pwd);
            }else if(phone!=null){//手机号
                userInfo.setPhone(phone);
                yzm = "1";
                String ymz1 = "1";
                if (!yzm.equals(ymz1)) {
                    mv.addObject("yzmError", "0");//0代表错误
                }
            }
            userInfo.setUserid(userId);//用户编号
            int count = userInfoMapper.updateByPrimaryKeySelective(userInfo);
            if(count == 1){
                mv.addObject("success","1");
            }else{
                mv.addObject("error","0");
            }
           return mv;
    }
    /**
     * 修改昵称（用户名）
     * @return
     */
    @RequestMapping("/selectUserById")
    public ModelAndView selectUserById(String id ,String name) {
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView());
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(name);
        userInfo.setUserid(Integer.parseInt(id));
        int count  = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if(count==1){
            mv.addObject("updatNicknameSuccess",1);//用户信息
        }else{
            mv.addObject("updatNicknameError",0);
        }
        return mv;
    }
}
