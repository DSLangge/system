<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/4/30
  Time: 21:11
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
        <li class="layui-this">留言反馈</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">反馈内容：</label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入事务内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="adminInfo">立即提交</button>
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
        form.on('submit(adminInfo)', function(data){
            $.ajax({
                url : "addleaback",
                type : "post",
                data : {
                    back_per_id : "10001",
                    back_msg : $("textarea").val(),
                    back_id : ${back_id}
                },
                success : function(data){
                    if(data=="200"){
                        layer.msg("反馈成功");
                    }else{
                        layer.msg("反馈失败")
                    }
                }
            });
            alert($("textarea").val())
            return false;
        });
    });
</script>
</body>
</html>

