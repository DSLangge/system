<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/4/29
  Time: 22:44
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
    <title>通知发布</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
    <script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">事务通知</li>
        <li>文件通知</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">事务标题：</label>
                    <div class="layui-input-block">
                        <input type="hidden" name="id"  value="${adviceNote.id}">
                        <input type="text" name="adv_title" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
                        value="${adviceNote.adv_title}">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">通知内容：</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入事务内容" class="layui-textarea">${adviceNote.adv_msg}</textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="advsubmit">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
    layui.use(['form', 'element'], function() {
        var form = layui.form;
        var element = layui.element;
        form.render();
        //监听信息提交
        form.on('submit(advsubmit)', function(data) {
            $.ajax({
                url: "editadv",
                type: "post",
                data: {
                    id: $("input[name='id']").val(),
                    adv_title: $("input[name='adv_title']").val(),
                    adv_msg: $("textarea").val()
                },
                success: function(data) {
                    if(data=="200"){
                        layer.msg("修改事务成功");
                    }else{
                        layer.msg("修改事务失败")
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>

