<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>北京百晟乾坤咨询服务有限公司</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../../static/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/vendor.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/theme.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/utility.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/custom.css">
    <link rel="shortcut icon" href="../../static/images/favicon.ico">
    <style>
        .nav li {
            border-bottom: 1px solid #eee;
        }
    </style>
</head>
<body style="overflow:hidden">
<!-- Start: Header -->
<header class="navbar navbar-fixed-top">
    <div class="navbar-branding"> <span id="toggle_sidemenu_l" class="glyphicons glyphicons-show_lines"></span>
        <a class="navbar-brand" style="padding-top: 7px;">后台管理</a>
    </div>
    <div class="navbar-left">
        <div class="navbar-divider"></div>
        <div id="settings_menu">
            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="javascript:void(0);"><span class="glyphicons glyphicons-bell text-purple mr15"></span>Users</a>
                </li>
                <li>
                    <a href="javascript:void(0);"><span class="glyphicons glyphicons-notes text-blue mr15"></span>Servers</a>
                </li>
                <li>
                    <a href="javascript:void(0);"><span class="glyphicons glyphicons-facebook text-orange mr15"></span>Crons</a>
                </li>
            </ul>
        </div>

    </div>
    <div class="navbar-right">

        <div class="navbar-menus">
            <div class="btn-group" id="alert_menu">
                <button type="button" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicons glyphicons-bell"></span> <b>4</b> </button>
            </div>
            <div class="btn-group" id="comment_menu">
            </div>
        </div>
    </div>
</header>
<!-- End: Header -->
<!-- Start: Main -->
<div id="main">
    <!-- Start: Sidebar -->
    <aside id="sidebar_left">
        <div class="user-info">
            <div class="media">
                <a class="pull-left" href="#">
                    <div class="media-object border border-purple br64 bw2 p2"> <img class="br64" src="../../static/img/timg.gif" alt="..."> </div>
                </a>
                <div class="mobile-link"> <span class="glyphicons glyphicons-show_big_thumbnails"></span> </div>
                <div class="media-body">
                    <h5 class="media-heading mt5 mbn fw700 cursor">${userInfo.username}<span class="caret ml5"></span></h5>
                    <div class="media-links fs11">
                        <a href="#"><c:if test="${userInfo.state==3}">超级管理员</c:if></a><i class="fa fa-circle text-muted fs3 p8 va-m"></i>
                        <a href="javascript:;" onclick="goBack()" >退出</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="user-divider"></div>
        <div class="user-menu">
            <div class="row text-center mb15">
                <div class="col-xs-4">
                    <a href="dashboard.html"> <span class="glyphicons glyphicons-home fs22 text-blue2"></span>
                        <h5 class="fs11">Home</h5>
                    </a>
                </div>
                <div class="col-xs-4">
                    <a href="messages.html"> <span class="glyphicons glyphicons-inbox fs22 text-orange2"></span>
                        <h5 class="fs11">Inbox</h5>
                    </a>
                </div>
                <div class="col-xs-4">
                    <a href="tables.html"> <span class="glyphicons glyphicons-bell fs22 text-purple2"></span>
                        <h5 class="fs11">Data</h5>
                    </a>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-xs-4 text-center">
                    <a href="timeline.html"> <span class="glyphicons glyphicons-imac fs22 text-grey3"></span>
                        <h5 class="fs11">Views</h5>
                    </a>
                </div>
                <div class="col-xs-4">
                    <a href="profile.html"> <span class="glyphicons glyphicons-settings fs22 text-green2"></span>
                        <h5 class="fs11">Settings</h5>
                    </a>
                </div>
                <div class="col-xs-4">
                    <a href="gallery.html"> <span class="glyphicons glyphicons-restart fs22 text-light6"></span>
                        <h5 class="fs11">Images</h5>
                    </a>
                </div>
            </div>
        </div>
        <div class="sidebar-menu">
            <ul class="nav sidebar-nav">
                <li>
                    <a class="accordion-toggle" href="../../static/role.jsp" target="right"> <span class="glyphicons glyphicons-settings"></span><span class="sidebar-title">用户管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/bazi.jsp" target="right"> <span class="glyphicons glyphicons-user"></span><span class="sidebar-title">八字管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/order.jsp" target="right"><span class="glyphicons glyphicons-user"></span><span class="sidebar-title">订单管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/yishiOrder.jsp"  target="right"><span class="glyphicons glyphicons-user"></span><span class="sidebar-title">易师订单</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/questionsandanswers.jsp" target="right"><span class="glyphicons glyphicons-tags"></span><span class="sidebar-title">问答管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/classIfication.jsp" target="right"><span class="glyphicons glyphicons-circle_question_mark"></span><span class="sidebar-title">标签管理</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/hostAsk.jsp" target="right"><span class="glyphicons glyphicons-circle_arrow_right"></span><span class="sidebar-title">热门提问</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/opinion.jsp"  target="right"><span class="glyphicons glyphicons-user"></span><span class="sidebar-title">意见与反馈</span><span class="caret"></span></a>
                </li>
                <li>
                    <a class="accordion-toggle" href="../../static/activity.jsp"  target="right"><span class="glyphicons glyphicons-user"></span><span class="sidebar-title">活动管理</span><span class="caret"></span></a>
                </li>
            </ul>
        </div>
    </aside>
    <!-- End: Sidebar -->
    <!-- Start: Content -->
    <div style="position: absolute;left: 230px;width:88%;">
        <iframe scrolling="yes" frameborder="0" name="right" src="../../static/role.jsp" width="100%" height="900"></iframe>
    </div>
</div>
<script type="text/javascript" src="../../static/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../../static/myplugs/js/plugs.js"></script>
<script type="text/javascript">
    //添加编辑弹出层
    function updatePwd(title, id) {
        $.jq_Panel({
            title: title,
            iframeWidth: 500,
            iframeHeight: 300,
            url: "updatePwd.html"
        });
    }
    //返回登录页面
    function goBack(){
        window.location.href="/login";
    }

function fn(){
    window.location.href="/order";
}
</script>
</body>

</html>