package com.zf.demo4jsp.controller;

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
            return "main";
        }
    }

    //用户信息
    @RequestMapping("/userInfo")
    public String userInfo(Model model, HttpServletRequest request, @Param("pageNum") String pageNum, @Param("username") String username) {
        if (pageNum != null) {
            PageHelper.startPage(Integer.parseInt(pageNum), 10);
        } else {
            PageHelper.startPage(1, 10);//没有pageNum参数 默认第一页  pageSize每页10条数据
        }
        List<UserInfo> userInfoList = userInfoMapper.selectUserInfoAll(username);//查询全部数据 参数：username模糊查询
        PageInfo<UserInfo> userInfoPageInfo = new PageInfo<>(userInfoList);//得到分页的结果对象
        List<UserInfo> pageList = userInfoPageInfo.getList();//得到分页中的person条目对象
        model.addAttribute("pages", userInfoPageInfo);//分页里面的数据 在前台展示
        model.addAttribute("userInfos", pageList);//用户信息
        model.addAttribute("sname", username);//数据回显
        return "role";//返回到用户管理页面
    }


}
