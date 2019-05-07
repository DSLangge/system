<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/7
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>评价</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
</head>
<body>
<fieldset class="layui-elem-field">
    <legend>评分统计</legend>
    <div class="layui-field-box">
        <div class="layui-form">
            <table class="layui-table" style="text-align: center">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                </colgroup>
                <thead>
                <tr>
                    <th style="text-align: center;">系统管理评分</th>
                    <th style="text-align: center;">辅导员评分</th>
                    <th style="text-align: center;">学生评分</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        <c:if test="${evaluDetailDTO.user_score==null}">暂无评价</c:if>
                        ${evaluDetailDTO.user_score}分
                    </td>
                    <td>
                        <c:if test="${evaluDetailDTO.teach_score==null}">暂无评价</c:if>
                        ${evaluDetailDTO.teach_score}分
                    </td>
                    <td>
                        <c:if test="${evaluDetailDTO.stu_score==null}">暂无评价</c:if>
                        ${evaluDetailDTO.stu_score}分
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</fieldset>
<fieldset class="layui-elem-field">
    <legend>评价</legend>
        <div class="layui-field-box">
        <div class="layui-form" style="text-align: center;">
            <c:if test="${evaluDetailDTO.evalu_msg==null}">暂无评价</c:if>
            ${evaluDetailDTO.evalu_msg}
        </div>
    </div>
</fieldset>
<script src="layui/layui.js" charset="utf-8"></script>
</body>
</html>

