<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>dwCms后台管理系统-登录</title>
    <link rel="stylesheet" type="text/css" href="../../static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" type="text/css" href="../../static/css/login.css" />
</head>
<body class="beg-login-bg">
    <div class="beg-login-box">
        <header>
            <h1>易师后台管理系统</h1>
        </header>
        <div class="beg-login-main">
            <form action="login.jsp" class="layui-form" method="post">
                <div class="layui-form-item">
                    <label class="beg-login-icon">
                        <i class="layui-icon">&#xe612;</i>
                    </label>
                    <input type="text" lay-verify="required" name="name" autocomplete="off" placeholder="这里输入账号" class="layui-input" lay-verType="tips">
                </div>
                <div class="layui-form-item">
                    <label class="beg-login-icon">
                        <i class="layui-icon">&#xe642;</i>
                    </label>
                    <input type="password" lay-verify="required" name="password" autocomplete="off" placeholder="这里输入密码" class="layui-input" lay-verType="tips">
                </div>
                <div class="layui-form-item">
                    <div class="beg-pull">
                        <button type="button" onclick="login()" class="layui-btn layui-btn-normal" style="width:100%;" lay-submit lay-filter="formDemo" >
                            登　　录
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <footer>
            <p> </p>
        </footer>
    </div>
    <script type="text/javascript" src="../../static/javascript/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    <script type="text/javascript" src="../../static/javascript/login.js"></script>
</body>
<script language="javascript" type="text/javascript" >
    function  login() {
        window.location.href="/index"
    }
</script>
</html>