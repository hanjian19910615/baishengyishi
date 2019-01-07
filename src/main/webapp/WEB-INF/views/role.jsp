<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../../static/css/amazeui.min.css">
    <link rel="stylesheet" href="../../static/css/admin.css">
    <link rel="stylesheet" href="../../static/css/pagination.css">
    <!-- CDN 依赖文件 -->
    <script type="text/javascript" src="../../static/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/js/underscore.js"></script>
    <script type="text/javascript" src="../../static/js/pagination.build.js"></script>
    <link rel="stylesheet" href="../../static/css/myAlert.css" />
    <script type="text/javascript" src="../../static/js/myAlert.js" ></script>
    <link rel="stylesheet" type="text/css" href="../../static/css/xcConfirm.css"/>
    <script src="../../static/js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../static/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>

    <style type="text/css">
        .sgBtn{width: 135px; height: 35px; line-height: 35px; margin-left: 10px; margin-top: 10px; text-align: center; background-color: #0095D9; color: #FFFFFF; float: left; border-radius: 5px;}
    </style>
</head>
<body>
<div class="admin-content-body"style="" >
    <div class="am-cf am-padding am-padding-bottom-0" >
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input id="roleName" class="am-form-field" placeholder="请输入用户名称" type="text" value="${roleName}">
                <span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" id="btnsearch" onclick="search()">
										搜索
									</button> </span>
            </div>
        </div>
    </div>
    <div class="am-g" style="margin-top: 5px;">
        <div class="am-u-sm-12">
            <form class="am-form">
                <table class="am-table am-table-striped am-table-hover table-main">
                    <thead>
                    <tr>
                        <th>用户名称 </th>
                        <th>用户昵称 </th>
                        <th>性别</th>
                        <th>电话</th>
                        <th>城市</th>
                        <th>地址</th>
                        <th class="table-title"> 角色描述 </th>
                        <th class="table-set">操作 </th>
                    </tr>
                    </thead>
                    <tbody id="tUser">

                    <c:forEach items="${userInfos}" var="s" varStatus="st">
                    <tr>
                        <input type="hidden" id="userid" name="userid" value="${s.userid}"/>
                        <td><a href="javascript:void(0)">${s.username}</a></td>
                        <td>${s.nickname}</td>
                        <c:if test="${s.sex==1}"><td>男</c:if></td>
                        <c:if test="${s.sex==2}"><td>女</c:if></td>
                        <td>${s.phone}</td>
                        <td>${s.city}</td>
                        <td>${s.address}</td>
                        <c:if test="${s.state==1}"><td>易师</c:if></td>
                        <c:if test="${s.state==2}"><td>普通用户</c:if></td>
                        <c:if test="${s.state==3}"><td>超级管理员</c:if></td>

                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit">
                                        <span class="am-icon-pencil-square-o"></span>查看</button>
                                    <button disabled="true" type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delUser(${s.userid})">
                                    <span class="am-icon-trash-o"></span> 审核</button></div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <div class="pagination" style="align-content: center"></div>
            </form>
        </div>
    </div>
</div>
</div>
<!-- content end -->
</div>
</div>

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../../static/js/jquery-1.11.3.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="../../static/myplugs/js/plugs.js"></script>
<script>
    $(function() {
        //onloadUserInfo();
        $("#chkAll").chkAll({
        });
        $(".btnedit").click(function() {

            $.jq_Panel({
                title: "修改角色",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "editRole.html"
            });
        });

        $(".btnAdd").click(function() {

            $.jq_Panel({
                title: "添加角色",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "editRole.html"
            });

        });
    });
    function sharesysfun(id) {
        location.href = "shareRole.html";
    }
    //分页数据
    $(document).ready(function () {
        new pagination({
            pagination:$('.pagination'),
            maxPage: 7, //最大页码数,支持奇数，左右对称
            startPage: 1,    //默认第一页
            currentPage: ${pages.pageNum},      //当前页码
            totalItemCount:  ${pages.size} ,    //项目总数,大于0，显示页码总数
            totalPageCount: ${pages.pages},     //总页数
            callback:function(pageNum){
                window.location.href = "/userInfo?pageNum="+pageNum;
            }
        });
    });
    //模糊查询
    function search(){
        var username=document.getElementById("roleName").value ;
        window.location.href = "/userInfo?username="+username;
    }
    //删除用户
    function delUser(id){
        // var txt=  "提示文字，提示文字，提示文字，提示文字，提示文字，提示文字";
        // window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.confirm);
        $.ajax({
            type:"GET",
            url:"/delUserInfo?userid="+id,
            dataType:"json",
            success:function(data){
            if(data.success){
                window.location.href = "/userInfo";
            }else{
                $("#searchResult").html("出现错误：" + data.msg);
            }
        },

    });
    }
</script>
</body>
</html>