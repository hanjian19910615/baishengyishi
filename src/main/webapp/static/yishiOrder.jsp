<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title></title>
  <link rel="stylesheet" href="../../static/layui/css/layui.css">
  <link rel="stylesheet" href="../../static/css/global.css">
  <link rel="stylesheet" href="../../static/icheck/minimal/red.css">
    <link rel="stylesheet" href="../../static/css/pagination.css">

</head>
<body class="layui-layout-body">
<script type="text/javascript" src="../../static/javascript/jquery.min.js"></script>
<script type="text/javascript" src="../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../static/icheck/icheck.js"></script>
<script type="text/javascript" src="../../static/javascript/dw.js"></script>
<script type="text/javascript" src="../../static/javascript/underscore.js"></script>
<script type="text/javascript" src="../../static/javascript/pagination.build.js"></script>
</body>

<script>
    //分页数据
    $(document).ready(function () {
      yihsiOrder();
    });
function yihsiOrder(){
  window.location.href="/ysorderList"
}
</script>
</html>