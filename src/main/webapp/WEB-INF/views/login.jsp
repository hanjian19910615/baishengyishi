<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>

<head>
	<meta charset="UTF-8">
	<title>我的“书屋”</title>
	<link rel="stylesheet" href="../../static/css/index.css" />
</head>

<body>
<img src="../../static/img/bgImg.jpg" class="bgImg" />
<div class="content">
	<div class="bidTitle">我的“易师”登录</div>
	<div class="logCon">
		<div class="line"><span>账号:</span>
			<input class="bt_input" type="text" /></div>
		<div class="line"><span>密码:</span>
			<input class="bt_input" type="pwd" /></div>
		<button type="button" class="logingBut" onclick="login()">登录</button>
	</div>
</div>
</body>
<script language="javascript" type="text/javascript" >
	function  login() {
		window.location.href="/index"
	}
</script>
</html>