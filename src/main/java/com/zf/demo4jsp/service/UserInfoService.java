package com.zf.demo4jsp.service;

import com.zf.demo4jsp.entity.UserInfo;
import com.zf.demo4jsp.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    public void userInfoAll(Model model){
//       List<UserInfo> userInfo=userInfoMapper.selectUserInfoAll();
//        model.addAttribute("userInfos",userInfo);
//    }
}
