package com.zf.demo4jsp.mapper;

import com.zf.demo4jsp.entity.UserInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@Mapper
@Component(value ="UserInfoMapper")
public interface UserInfoMapper  {

    int insert(UserInfo record);
    UserInfo selectByPrimaryKey(Integer userid);
    int updateByPrimaryKeySelective(UserInfo record);
    UserInfo getUserInfoByNameAndPwd(Model model, HttpServletRequest request, @Param("username") String username, @Param("pwd") String pwd );
    List<UserInfo> selectUserInfoAll(@Param("username")String username,@Param("state")int state);
    int deleteByPrimaryKey(Integer userid);
    //----------------------------------app端-----------------------------------------------------
   //根据手机号查询数据（无的话进行注册）
    UserInfo selectUserByPhone(String phone );
    UserInfo login(@Param("phone")String phone ,@Param("pwd")String pwd);
    //查询全部易师
    List<UserInfo> selectByYiShi();
}