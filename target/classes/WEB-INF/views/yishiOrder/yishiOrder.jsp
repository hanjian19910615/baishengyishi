<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title></title>
    <link rel="stylesheet" href="../../../static/layui/css/layui.css">
    <link rel="stylesheet" href="../../../static/css/global.css">
    <link rel="stylesheet" href="../../../static/icheck/minimal/red.css">
    <link rel="stylesheet" href="../../../static/css/pagination.css">

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
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../../../static/userInfo.jsp">普通用户列表</a></dd>
                        <dd><a href="../../../static/yishiInfo.jsp">易师列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../../../static/userOrder.jsp">用户订单</a></dd>
                        <dd><a href="../../../static/yishiOrder.jsp">易师订单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">会员管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="../member.jsp">会员列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">开发者工具</a>
                    <dl class="layui-nav-child">
                        <dd><a href="control.html">一键生成</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">集成Demo</a>
                    <dl class="layui-nav-child">
                        <dd><a href="upload.html">文件上传</a></dd>
                        <dd><a href="upload.html">Execel导出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <fieldset class="layui-elem-field">
                <legend>订单管理 - 易师订单列表</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="">
                        <div class="layui-form-item" style="text-align:center;">
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input autocomplete="off" class="layui-input" placeholder="请输入名称" type="text" id="username" >
                                </div>
                            </div>
                            <div class="layui-inline" style="text-align:left;">
                                <div class="layui-input-inline">
                                    <button class="layui-btn" onclick="search()"><i class="layui-icon">&#xe615;</i>查询</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <hr>
                    <hr>
                    <table class="layui-table">
                        <colgroup>
                            <col width="150">
                            <col width="150">
                            <col width="200">
                            <col>
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th >订单号</th>
                            <th >订单名称</th>
                            <th>订单金额</th>
                            <th>订单时间</th>
                            <th>订单人</th>
                            <th>订单类型</th>
                            <th>支付状态</th>
                            <th>回复状态</th>
                            <th>易师名字</th>
                            <th style="text-align:center;">操作</th>
                        </tr>
                        </thead>
                        <c:forEach items="${yishiorders}" var="s" varStatus="st">
                            <tbody>
                            <tr>
                                <td><a href="javascript:void(0)"></a>${s.ordernumber}</td>
                                <td>${s.ordername}</td>
                                <td>${s.orderamount}</td>
                                <td ><fmt:formatDate value="${s.ordertime}" pattern="yyyy-MM-dd" /> </td>
                                <td>${s.username}</td>
                                <c:if test="${s.ordertype==1}"><td>提问</td></c:if>
                                <c:if test="${s.ordertype==2}"><td>亲测</td></c:if>
                                <c:if test="${s.paymentstatus==1}"><td>支付成功!待评价</c:if></td>
                                <c:if test="${s.paymentstatus==2}"><td>支付失败</c:if></td>
                                <c:if test="${s.paymentstatus==3}"><td>待支付</c:if></td>
                                <c:if test="${s.solutionstate==0}"><td>未回复</c:if></td>
                                <c:if test="${s.solutionstate==1}"><td>已回复</c:if></td>
                                <td>${s.yishiname}</td>
                                <td class="text-center">
                                    <div class="layui-btn-group">

                                        <button class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="/userorderById?id=${s.id}" dw-title="新增用户" dw-width="100%" dw-height="100%" >
                                            <i class="layui-icon">&#xe654;</i>查看评价
                                                <%--<button class="layui-btn layui-btn-xs layui-btn-normal dw-dailog" dw-url="/userorderById?id=${s.id}" dw-title="">--%>
                                                <%--<i class="layui-icon">&#xe642;</i>查看--%>
                                        </button>

                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <div class="pagination"></div>
                </div>
            </fieldset>
        </div>
    </div>

    <%--<div class="layui-footer">--%>
    <%----%>
    <%--</div>--%>
</div>
<script type="text/javascript" src="../../../static/javascript/jquery.min.js"></script>
<script type="text/javascript" src="../../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../../static/icheck/icheck.js"></script>
<script type="text/javascript" src="../../../static/javascript/dw.js"></script>
<script type="text/javascript" src="../../../static/javascript/underscore.js"></script>
<script type="text/javascript" src="../../../static/javascript/pagination.build.js"></script>
</body>

<script>
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
                window.location.href = "/order?pageNum="+pageNum+"&state=1";
            }
        });
    });
    //模糊查询
    function search(){
        var username=document.getElementById("username").value ;
        //alert(username);
        window.location.href = "/yishiInfo?username="+username+"&state=1";
    }

</script>
</html>