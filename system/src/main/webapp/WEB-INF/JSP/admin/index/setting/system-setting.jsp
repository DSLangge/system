<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/2
  Time: 20:42
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
    <title>系统维护</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
</head>

<body>
<div class="layui-tab page-content-wrap">
    <ul class="layui-tab-title">
        <li class="layui-this">站点设置</li>
        <li>版本信息</li>
    </ul>
    <div class="layui-tab-content">
        <!--站点配置-->
        <div class="layui-tab-item layui-show">
            <form class="layui-form" style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">网站名称：</label>
                    <div class="layui-input-block">
                        <input type="text" name="webname" autocomplete="off" class="layui-input" value="面向高校的辅导员管理系统">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">网站域名：</label>
                    <div class="layui-input-block">
                        <input type="text" name="domain" autocomplete="off" class="layui-input" value="www.123456.com">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">站长邮箱：</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" required lay-verify="required" placeholder="请输入联系邮箱" autocomplete="off" class="layui-input" value="451469185@qq.com">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">备案信息：</label>
                    <div class="layui-input-block">
                        <input type="text" name="icp" required lay-verify="required" placeholder="请输入备案信息" autocomplete="off" class="layui-input" value="豫ICP备12345678号-1">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">版权信息：</label>
                    <div class="layui-input-block">
                        <input type="text" name="copyright" required lay-verify="required" placeholder="请输入版权信息" autocomplete="off" class="layui-input" value="中原工学院 软件学院 RB移动153 © 2019">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">高校动态：</label>
                    <div class="layui-input-block">
                        <a class="layui-input" href="https://www.zut.edu.cn/" target="_blank">查看本校最新动态</a>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="siteInfo">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
        <!--邮箱配置-->
        <div class="layui-tab-item">
            <form class="layui-form"  style="width: 90%;padding-top: 20px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">服务器：</label>
                    <div class="layui-input-block">
                        <input type="text" name="smtp" placeholder="请输入邮件服务器" autocomplete="off" class="layui-input" value="451469185@qq.com">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">端口：</label>
                    <div class="layui-input-block">
                        <input type="text" name="port" placeholder="请输入邮件发送端口" autocomplete="off" class="layui-input" value="80">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">发件人：</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" placeholder="请输入发件人地址" autocomplete="off" class="layui-input" value="451469185@qq.com">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">名称：</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" placeholder="请输入发件人名称" autocomplete="off" class="layui-input" value="DSL管理员">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">版本信息：</label>
                    <div class="layui-input-block">
                        <a class="layui-input" href="https://github.com/DSLangge/system/commits/master" target="_blank">https://github.com/</a>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">当前版本：</label>
                    <div class="layui-input-block">
                        <a class="layui-input" href="https://github.com/DSLangge/system/commit/960f288f64fdf143af12ecc606c78db9a509c58b" target="_blank">V1.0</a>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="emailInfo">立即提交</button>
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
        form.on('submit(siteInfo)', function(data) {
            layer.msg("请加qq：451469185");
            return false;
        });
        //监听seo提交
        form.on('submit(emailInfo)', function(data) {
            layer.msg("请加qq：451469185");
            return false;
        });
    });
</script>
</body>

</html>
