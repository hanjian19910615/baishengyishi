<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/pagination.css">
    <!-- CDN 依赖文件 -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/underscore.js"></script>
    <script type="text/javascript" src="js/pagination.build.js"></script>
    <link rel="stylesheet" href="css/myAlert.css" />
    <script type="text/javascript" src="js/myAlert.js" ></script>
    <link rel="stylesheet" type="text/css" href="css/xcConfirm.css"/>
    <script src="js/jquery-1.9.1.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>

    <style type="text/css">
        .sgBtn{width: 135px; height: 35px; line-height: 35px; margin-left: 10px; margin-top: 10px; text-align: center; background-color: #0095D9; color: #FFFFFF; float: left; border-radius: 5px;}
    </style>
</head>
<body>
<div class="admin-content-body"style="" >
    <div class="am-cf am-padding am-padding-bottom-0" >
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">问答管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input id="orderName" class="am-form-field" placeholder="请输入问题名称" type="text" value="${sname}">
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
                        <th>订单号 </th>
                        <th>订单名称 </th>
                        <th>订单金额</th>
                        <th>订单时间</th>
                        <th>订单人</th>
                        <th>支付状态</th>
                        <th class="table-set">操作 </th>
                    </tr>
                    </thead>
                    <tbody id="tUser">

                    <c:forEach items="${orders}" var="s" varStatus="st">
                    <tr>
                        <input type="hidden" id="userid" name="userid" value="${s.userid}"/>
                        <td><a href="javascript:void(0)"></a>${s.ordernumber}</td>
                        <td>${s.ordername}</td>
                         <td>${s.orderamount}</td>
                        <td ><fmt:formatDate value="${s.ordertime}" pattern="yyyy-MM-dd" /> </td>
                        <td>${s.userid}</td>
                        <c:if test="${s.paymentstatus==1}"><td>成功</c:if></td>
                        <c:if test="${s.paymentstatus==2}"><td>失败</c:if></td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit">
                                        <span class="am-icon-pencil-square-o"></span> 新增</button>
                                    <button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit">
                                    <span class="am-icon-pencil-square-o"></span> 编辑</button>
                                    <button type="button" onclick="sharesysfun(701);" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
                                        <span class="am-icon-copy">
                                    </span> 分配权限</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delUser(${s.userid})">
                                    <span class="am-icon-trash-o"></span> 删除</button></div>
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
<script src="js/jquery-1.11.3.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
<script>
    $(function() {
        onloadQuestionsandanswers();
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
    function onloadQuestionsandanswers() {
        window.location.href = "/questionsAndAnswers";
    }
</script>
</body>
</html>