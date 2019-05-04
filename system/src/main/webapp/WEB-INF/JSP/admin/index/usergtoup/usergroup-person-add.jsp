<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/4
  Time: 17:50
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
    <title>aaaa</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
    <script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">用户组添加用户</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户工号：</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="user_group_id"  value="${userGroupIdadd}">
                        <input type="text" name="per_id" required lay-verify="required" placeholder="请输入被添加人工号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">角色分类：</label>
                    <div class="layui-input-block">
                        <select name="powertype" lay-verify="required" id="powertype">
                            <option value="2">辅导员</option>
                            <option value="3">学生</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="usergroup">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','element'], function(){
        var form = layui.form();
        var element = layui.element();
        form.render();
        //监听信息提交
        form.on('submit(usergroup)', function(data){
            $.ajax({
                url : "addusergroupperson",
                type : "post",
                data : {
                    user_group_id: $("input[name='user_group_id']").val(),
                    per_id: $("input[name='per_id']").val(),
                    per_pow : $("#powertype").val()
                },
                success : function(data){
                    if(data=="200"){
                        layer.msg("添加用户成功");
                    }else{
                        layer.msg("添加用户失败")
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>

