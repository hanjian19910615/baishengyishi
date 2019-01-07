<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <%--<link rel="stylesheet" href="../static/css/app.css">--%>
</head>
<body>
<div class="admin-content-body"style="" >
    <div class="am-cf am-padding am-padding-bottom-0" >
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <%--<div class="am-u-sm-12 am-u-md-6">--%>
            <%--<div class="am-btn-toolbar">--%>
                <%--<div class="am-btn-group am-btn-group-xs">--%>
                    <%--<button type="button" class="am-btn am-btn-default btnAdd">--%>
                        <%--<span class="am-icon-plus"></span> 新增--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input id="roleName" class="am-form-field" placeholder="请输入角色名称" type="text">
                <span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" id="btnsearch">
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
                        <input type="hidden" id="${s.id}" name="${s.id}"/>
                    <tr>

                        <td><a href="javascript:void(0)">张三</a></td>
                        <td>爱吃番薯</td>
                        <td>男</td>
                        <td>1369856325</td>
                        <td>呼和浩特市</td>
                        <td>赛罕区海亮广场</td>
                        <td>普通用户</td>
                        <td>
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs"><button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" onclick="sharesysfun(701);" class="am-btn am-btn-default am-btn-xs am-hide-sm-only"><span class="am-icon-copy"></span> 分配权限</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only" onclick="delUser(701,1)"><span class="am-icon-trash-o"></span> 删除</button></div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>

                  </tbody>
                </table>
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
        onloadUserInfo();
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
    function onloadUserInfo() {
        window.location.href = "/userInfo";
    }

</script>
</body>

</html>