<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="../../static/layui/css/layui.css">
</head>
<div class="layui-container">  
    <div >
        <div class="layui-col-lg12">
            <fieldset class="layui-elem-field">
                <legend style=" color: #5FB878">订单管理 - 用户订单 - 查看详情</legend>
                <div class="layui-field-box">
                    <form class="layui-form" action="">

                        <div class="layui-form-item">
                            <label class="layui-form-label">订单号</label>
                            <div class="layui-input-inline">
                            <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="${order.ordernumber}" disabled="disabled">
                        </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">订单名称</label>
                            <div class="layui-input-inline">
                                <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="${order.ordername}" disabled="disabled">
                            </div>
                            <label class="layui-form-label">订单金额</label>
                            <div class="layui-input-inline">
                                <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="${order.orderamount}"disabled="disabled" style="color: brown">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">支付状态</label>
                            <div class="layui-input-inline">
                                <c:if test="${order.paymentstatus==1}"> <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="支付成功" disabled="disabled"></c:if>
                                <c:if test="${order.paymentstatus==3}"> <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="待支付" disabled="disabled"></c:if>
                            </div>
                            <label class="layui-form-label">订单类型</label>
                            <div class="layui-input-inline">
                                <c:if test="${order.ordertype==1}"><input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="提问"disabled="disabled"></c:if>
                                <c:if test="${order.ordertype==2}"><input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="亲测"disabled="disabled"></c:if>

                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">解决状态</label>
                            <div class="layui-input-inline">
                                <c:if test="${order.solutionstate==1}"><input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="已解决" disabled="disabled"></c:if>
                                <c:if test="${order.solutionstate==0}"><input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="未解决" disabled="disabled"></c:if>
                            </div>
                            <label class="layui-form-label">用户类型</label>
                            <div class="layui-input-inline">
                                <input type="text"  required lay-verify="required"  autocomplete="off" class="layui-input" value="普通用户"disabled="disabled">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">问题描述</label>
                            <div class="layui-input-block">
                            <textarea name="desc" placeholder="请输入内容" class="layui-textarea" disabled="disabled">
                                ${order.ordertypemx}
                            </textarea>
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">易师回答</label>
                            <div class="layui-input-block">
                            <textarea name="desc" placeholder="请输入内容" class="layui-textarea" disabled="disabled">
                                ${order.yishianswers}
                            </textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                            <button class="layui-btn"  onclick="goback()">返 回</button>

                            </div>
                        </div>
                    </form>
                </div>
            </fieldset>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../../static/javascript/jquery.min.js"></script>
<script type="text/javascript" src="../../../static/layui/layui.js"></script>
<script type="text/javascript" src="../../../static/javascript/dw_form_submit.js"></script>
</body>
<script language="javascript">
   function goback(){
       window.close();
   }

</script>
</html>