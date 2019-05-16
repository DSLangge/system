<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>网站后台管理模版</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
    <script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">添加学生</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">学号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="stu_id" required lay-verify="number" placeholder="请输入学号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学生姓名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="stu_name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">性别：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_sex" required lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">年龄：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_age" required lay-verify="number" placeholder="请输入年龄" autocomplete="off" class="layui-input"
                            >
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">班级：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_class" required lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input"
                            >
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">学制：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_edu" required lay-verify="number" placeholder="请输入学制" autocomplete="off" class="layui-input"
                            >
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">民族：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_nation" required lay-verify="required" placeholder="请输入民族" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">出生地：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_antive" required lay-verify="required" placeholder="请输入出生地" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">身份证号：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_proID" required lay-verify="required" placeholder="请输入身份证号" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">联系电话：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_phone" required lay-verify="required" placeholder="请输入联系电话" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">邮编：</label>
                        <div class="layui-input-block">
                            <input type="text" name="postcode" required lay-verify="required" placeholder="请输入邮编" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">考生类型：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_style" required lay-verify="required" placeholder="请输入考生类型" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">邮箱：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_email" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">高中：</label>
                        <div class="layui-input-block">
                            <input type="text" name="stu_high" required lay-verify="required" placeholder="请输入高中名字" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">出生日期：</label>
                        <div class="layui-input-block">
                            <input type="date" name="stu_birth" required lay-verify="required" placeholder="请选择出生日期" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">入学年份：</label>
                        <div class="layui-input-block">
                            <input type="date" name="school_year" required lay-verify="required" placeholder="请选择入学年份" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">毕业年份：</label>
                        <div class="layui-input-block">
                            <input type="date" name="graduat_year" required lay-verify="required" placeholder="请选择毕业年份" autocomplete="off" class="layui-input">
                        </div>
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
                url : "addstudent",
                type : "post",
                data : {
                    stu_id : $("input[name='stu_id']").val(),
                    stu_name : $("input[name='stu_name']").val(),
                    stu_sex : $("input[name='stu_sex']").val(),
                    stu_age : $("input[name='stu_age']").val(),
                    stu_class : $("input[name='stu_class']").val(),
                    stu_edu : $("input[name='stu_edu']").val(),
                    stu_nation : $("input[name='stu_nation']").val(),
                    stu_antive : $("input[name='stu_antive']").val(),
                    stu_proID : $("input[name='stu_proID']").val(),
                    stu_phone : $("input[name='stu_phone']").val(),
                    postcode : $("input[name='postcode']").val(),
                    stu_style : $("input[name='stu_style']").val(),
                    stu_email : $("input[name='stu_email']").val(),
                    stu_high : $("input[name='stu_high']").val(),
                    stu_birth : $("input[name='stu_birth']").val(),
                    school_year : $("input[name='school_year']").val(),
                    graduat_year : $("input[name='graduat_year']").val()
                },
                success : function(data){
                    layer.msg(data)
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
