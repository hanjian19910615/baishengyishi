<!DOCTYPE HTML>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>北京百晟乾坤咨询服务有限公司</title>
<link href="../../static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%--<script src="../../static/js/login.js"></script>--%>
<script src="../../static/js/jquery.min.js"></script>
</head>
<body>
<!-- contact-form -->
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>Login Form</h1>
		 <div class="alert-close"> </div> 			
	</div>
		<form action="/index" method="post" id="logonForm">
			<li>
				<input type="text" id="userName" class="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Username';}"><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input type="password" id="pwd"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"> <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="submit" id="logon" value="登 录" >
				<h4><a href="#"></a></h4>
						  <div class="clear"></div>
			</div>
		</form>
		</div>					
	</div>
	</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
</div>

</body>
<script language="javascript" type="text/javascript" >
	$("#logon").click(function(){
		var f = document.getElementsByTagName("form")[0];
		var username=document.getElementById("userName").value ;
		var pwd=document.getElementById("pwd").value ;
		if(username==""|| pwd==""  ){
			alert("请输入！")
			return;
		}else{
			f.action=f.action+"?username="+username+"&pwd="+pwd;
		}


	});
</script>
</html>
