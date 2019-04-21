<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/11
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>高校辅导员管理系统登录</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css"/>
    <script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/common.css" />
</head>
<body>
<header class="herd">
    <div class="w1190" style="height: 100%;">
        <div class="head_img"></div>
    </div>

</header>


<div class="bac">
    <div class="w1190 posir" style="height: 100%;">
        <div class="bac_login" >
            <form class="layui-form" action="user_login" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-rate-solid"></i>用户名</label>
                    <div class="layui-input-block">
                        <input type="text" name="userid" required  lay-verify="required" placeholder="请输入学工号" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-rate-solid"></i>密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux ">辅助文字</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-rate-solid"></i>身份选择</label>
                    <div class="layui-input-block">
                        <select name="power" lay-verify="required">
                            <option value="0">学生</option>
                            <option value="1">老师</option>
                            <option value="2">系统管理员</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-rate-solid"></i>验证码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="verify" required lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                        <a href="javascript:change();" class="img">
                            <img id="img" alt="无图片" src="verify" style="position: absolute;top: 0px;right: -115px;height: 38px"></a>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即登录</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

            <script>
                function change() {
                    document.getElementById("img").src ="verify?r="+Math.random();
                }
                //Demo
                layui.use('form', function(){
                    var form = layui.form;

                    //监听提交
                    form.on('submit(formDemo)', function(data){

                        return true;
                    });
                });
            </script>
        </div>
    </div>
</div>

<footer class="fot ">
    <p>版权所有：中原工学院 软件学院 RB移动153  未经授权本站内容禁止私自转载使用！</p>
</footer>
</body>

</html>
