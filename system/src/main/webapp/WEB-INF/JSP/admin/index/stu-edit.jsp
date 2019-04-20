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
		<li class="layui-this">修改资料</li>
		<li>修改密码</li>
	</ul>
	<div class="layui-tab-content">
		<div class="layui-tab-item layui-show">
			<form class="layui-form" style="width: 90%;padding-top: 20px;">
				<div class="layui-form-item">
					<label class="layui-form-label">学号：</label>
					<div class="layui-input-block">
						<input type="text" name="stu_id" disabled autocomplete="off" class="layui-input layui-disabled" value="修改">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">学生姓名：</label>
					<div class="layui-input-block">
						<input type="text" name="stu_name" disabled autocomplete="off" class="layui-input layui-disabled" value="修改">
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">性别：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_sex" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">年龄：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_age" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">班级：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_class" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">学制：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_edu" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">民族：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_nation" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">出生地：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_antive" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">身份证号：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_proID" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">联系电话：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_phone" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">邮编：</label>
						<div class="layui-input-block">
							<input type="text" name="postcode" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">考生类型：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_style" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">邮箱：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_email" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">高中：</label>
						<div class="layui-input-block">
							<input type="text" name="stu_high" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">出生日期：</label>
						<div class="layui-input-block">
							<input type="date" name="stu_birth" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="2015-05-08">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">入学年份：</label>
						<div class="layui-input-block">
							<input type="date" name="school_year" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">毕业年份：</label>
						<div class="layui-input-block">
							<input type="date" name="graduat_year" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input"
								   value="修改">
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
		<div class="layui-tab-item">
			<form class="layui-form" v style="width: 90%;padding-top: 20px;">
				<div class="layui-form-item">
					<label class="layui-form-label">学号：</label>
					<div class="layui-input-block">
						<input type="text" name="stu_id" disabled autocomplete="off" class="layui-input layui-disabled" value="admin">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">姓名：</label>
					<div class="layui-input-block">
						<input type="text" name="stu_name" disabled autocomplete="off" class="layui-input layui-disabled" value="admin">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">旧密码：</label>
					<div class="layui-input-block">
						<input type="text" name="password1" required lay-verify="required" value="1234556" autocomplete="off"
							   class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码：</label>
					<div class="layui-input-block">
						<input type="password" name="password2" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
							   class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">重复密码：</label>
					<div class="layui-input-block">
						<input type="password" name="password3" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
							   class="layui-input">
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
<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script>
	//Demo
	layui.use(['form', 'element'], function() {
		var form = layui.form();
		var element = layui.element();
		form.render();

		// 监听指定开关
		form.on('switch(switchTest)', function(data){
			layer.msg('开关checked：'+ (this.checked ? '女' : '男'), {
				offset: '6px'
			});
		});
		//监听信息提交
		form.on('submit(adminInfo)', function(data) {
			layer.msg(JSON.stringify(data.field));
			return false;
		});
		//监听密码提交
		form.on('submit(adminPassword)', function(data) {
			layer.msg(JSON.stringify(data.field));
			return false;
		});
	});
</script>
</body>
</html>
