package com.zf.demo4jsp.controller.afterEnd;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserInfoMapper userInfoMapper;

    //登录首页方法
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转首页方法
     *
     * @Author:HJ
     * @Date:2018/12/10 15:42
     * @Description：TODO
     * @Version:1.0
     */

    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request, @Param("username") String username, @Param("pwd") String pwd) {
        username = "admin";
        pwd = "123456";
        UserInfo userInfo = userInfoMapper.getUserInfoByNameAndPwd(model, request, username, pwd);
        if (userInfo == null) {//用户信息为空返回登录页面
            return "login";
        } else {
            model.addAttribute("userInfo", userInfo);
            return "index";
        }
    }

    //用户信息
    @RequestMapping("/userInfo")
    public ModelAndView userInfo( @Param("pageNum") String pageNum, @Param("username") String username,int state) {
        ModelAndView mv = new ModelAndView();
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<UserInfo> userInfoList = userInfoMapper.selectUserInfoAll(username,state);//查询全部数据 参数：username模糊查询
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);//得到分页的结果对象
        List<UserInfo> pageList = userInfoPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("pages", userInfoPageInfo);//分页里面的数据 在前台展示
        mv.addObject("userInfos", pageList);//用户信息
        mv.addObject("sname", username);//数据回显
        if(state==1){
            mv.addObject("user/ysInfos");
        }else{
            mv.addObject("user/userInfo");
        }

        return mv;//返回到用户管理页面
    }
    //用户信息
    @RequestMapping("/yishiInfo")
    public ModelAndView yishiInfo( @Param("pageNum") String pageNum, @Param("username") String username,int state) {
        ModelAndView mv = new ModelAndView();
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<UserInfo> userInfoList = userInfoMapper.selectUserInfoAll(username,state);//查询全部数据 参数：username模糊查询
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);//得到分页的结果对象
        List<UserInfo> pageList = userInfoPageInfo.getList();//得到分页中的person条目对象
        mv.addObject("pages", userInfoPageInfo);//分页里面的数据 在前台展示
        mv.addObject("yishiInfos", pageList);//用户信息
        mv.addObject("sname", username);//数据回显
        mv.addObject("yishiInfo");
        return mv;//返回到用户管理页面
    }

    //删除
    @RequestMapping("/deleteUserInfo")
    public ModelAndView deleteUserInfo(Integer userid) {
        ModelAndView mv = new ModelAndView();
        int count = userInfoMapper.deleteByPrimaryKey(userid);
        if(count==1){
            mv.addObject("countSuccess", 1);//数据回显
        }else{
            mv.addObject("countError", 2);//数据回显
        }
        return mv;//返回到用户管理页面
    }


}
