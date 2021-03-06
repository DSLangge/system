<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/3
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <li class="layui-this">修改用户组名</li>
        <li>用户组权限设置 </li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户组名：</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="id"  value="${usergroup.id}">
                        <input type="text" name="group_name" required lay-verify="required" placeholder="请输入用户组名" autocomplete="off" class="layui-input"
                        value="${usergroup.group_name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="usergroup">立即提交</button>
                    </div>
                </div>
            </form>
        </div>

        <div class="layui-tab-item">
            <form class="layui-form" v style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">当前组名：</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="id1"  value="${grouppower.id}">
                        <input type="hidden" name="id2"  value="${usergroup.id}">
                        <input type="text" name="teach_id" disabled autocomplete="off" class="layui-input layui-disabled" value="${usergroup.group_name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">权限分类：</label>
                    <div class="layui-input-block">
                        <select name="powertype" lay-verify="required" id="powertype">
                            <option value="">请选择权限分类</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="addpower">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" charset="utf-8"></script>
<script>
    $(function(){
        $.ajax({
            url : "getpower",
            type : "post",
            success : function(data){
                $("#powertype").empty();
                $("#powertype").append("<option value=''>请选择权限分类</option>");
                for(var i=0;i<data.length;i++){
                    $("#powertype").append('<option value='+data[i].id+'>'+data[i].po_name+'</option>');
                }
            }
        });
    });
    layui.use(['form','element'], function(){
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交
        form.on('submit(usergroup)', function(data){
            $.ajax({
                url : "editusergroup",
                type : "post",
                data : {
                    id: $("input[name='id']").val(),
                    group_name : $("input[name='group_name']").val()
                },
                success : function(data){
                    if(data=="200"){
                        layer.msg("修改用户组成功");
                    }else{
                        layer.msg("修改用户组失败")
                    }
                }
            });
            return false;
        });
        form.on('submit(addpower)', function(data){
            $.ajax({
                url : "addpower",
                type : "post",
                data : {
                    id : $("input[name='id1']").val(),
                    user_group_id: $("input[name='id2']").val(),
                    pow_id : $('#powertype').val()
                },
                success : function(data){
                    if(data=="200"){
                        layer.msg("用户组权限设置成功");
                    }else{
                        layer.msg("用户组权限设置失败")
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>

