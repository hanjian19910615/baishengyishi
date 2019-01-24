<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>北京百晟乾坤咨询有限公司</title>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"> 后台管理</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${userInfo.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" ><a href="javascript:;" onclick="goBack()" >退了</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../../static/userInfo.jsp">普通用户列表</a></dd>
                        <dd><a href="../../static/yishiInfo.jsp">易师列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../../static/userOrder.jsp">用户订单</a></dd>
                        <dd><a href="role.html">易师订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">活动管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="member.jsp">首页</a></dd>
                        <dd><a href="member.jsp">提问</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">命理运势管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="control.html">消息推送</a></dd>
                        <dd><a href="control.html">消息录入</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">客服管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html">意见反馈</a></dd>
                        <dd><a href="upload.html">订单咨询</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公众号管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html">公众号信息</a></dd>
                        <dd><a href="upload.html">消息推送</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">八字管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html"></a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">问答管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html">11</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">标签管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">易师审核管理</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">财务</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html">代金券</a></dd>
                        <dd><a href="upload.html">金币</a></dd>
                        <dd><a href="upload.html">账单</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field">
                <legend >控 制 台</legend>
                <div class="layui-field-box" style="background: url(../../static/image/sunmin.jpg); height: 550px">
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../static/javascript/jquery.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../static/javascript/index.js"></script>
</body>
<script type="text/javascript">
    //返回登录页面
    function goBack(){
        window.location.href="/login";
    }
</script>
</html>