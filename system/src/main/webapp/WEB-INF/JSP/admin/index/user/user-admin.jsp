<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/10
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
    <script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">修改资料</li>
        <li>修改密码</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">工号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user_id" disabled autocomplete="off" class="layui-input layui-disabled" value="${userlogin.user_id}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user_name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input"
                               value="${userlogin.user_name}">

                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="layui-tab-item">
            <form class="layui-form" v style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">工号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user_id1" disabled autocomplete="off" class="layui-input layui-disabled" value="${userlogin.user_id}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="user_name" disabled autocomplete="off" class="layui-input layui-disabled" value="${userlogin.user_name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">旧密码：</label>
                        <div class="layui-input-block">
                            <input type="text" name="password1" disabled autocomplete="off" class="layui-input layui-disabled" value="${userlogin.password}">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">新密码：</label>
                        <div class="layui-input-block">
                            <input type="password" name="password2" required lay-verify="required" placeholder="请输入新密码" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">重复密码：</label>
                        <div class="layui-input-block">
                            <input type="password" name="password3" required lay-verify="required" placeholder="请重复密码" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminPassword">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
    //Demo
    layui.use(['form', 'element'], function() {
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交
        form.on('submit(adminInfo)', function(data) {
            $.ajax({
                url : "edituser",
                type : "post",
                data : {
                    user_id : $("input[name='user_id']").val(),
                    user_name : $("input[name='user_name']").val()
                },
                success : function(data){
                    if(data=="200"){
                        layer.msg("修改成功");
                    }else{
                        layer.msg("修改失败")
                    }
                }
            });
            return false;
        });
        //监听密码提交
        form.on('submit(adminPassword)', function(data) {
            var password2 = $("input[name='password2']").val()
            var password3 = $("input[name='password3']").val()
            if (password2 != password3) {
                layer.msg("两次密码输入不一致，请重新输入")
                return false;
            }
            $.ajax({
                url: "edituser",
                type: "post",
                data: {
                    user_id: $("input[name='user_id1']").val(),
                    password: $("input[name='password2']").val()
                },
                success: function(data) {
                    if(data=="200"){
                        layer.msg("修改成功");
                    }else{
                        layer.msg("修改成功")
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
