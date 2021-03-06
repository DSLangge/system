<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="renderer" content="webkit">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>高校辅导员管理系统</title>
		<link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="static/admin/css/admin.css"/>
	</head>
	<body>
		<div class="main-layout" id='main-layout'>
			<!--侧边栏-->
			<div class="main-layout-side">
				<div class="m-logo"></div>
				<ul class="layui-nav layui-nav-tree" lay-filter="leftNav">
				  <li class="layui-nav-item layui-nav-itemed">
				    <a href="javascript:;"><i class="iconfont">&#xe607;</i>用户基本管理</a>
				    <dl class="layui-nav-child">
				      <dd><a href="javascript:;" data-url="/userSystem" data-id='1' data-text="系统用户"><span class="l-line"></span>系统用户</a></dd>
				      <dd><a href="javascript:;" data-url="/teacherSystem" data-id='2' data-text="辅导员用户"><span class="l-line"></span>辅导员用户</a></dd>
					  <dd><a href="javascript:;" data-url="/studentSystem" data-id='3' data-text="学生用户"><span class="l-line"></span>学生用户</a></dd>
				    </dl>
				  </li>
				  <li class="layui-nav-item">
				    <a href="javascript:;"><i class="iconfont">&#xe609;</i>通知事件管理</a>
				    <dl class="layui-nav-child">
						<dd><a href="javascript:;" data-url="/adviceSystem" data-id='4' data-text="事务列表"><span class="l-line"></span>事务列表</a></dd>
				    </dl>
				  </li>
				  <li class="layui-nav-item">
					<a href="javascript:;" data-url="/evaluSystem" data-id='5' data-text="评价管理"><i class="iconfont">&#xe60e;</i>评价管理</a>
				  </li>
				  <li class="layui-nav-item">
					  <a href="javascript:;"><i class="iconfont">&#xe605;</i>信息发布及留言反馈</a>
					  <dl class="layui-nav-child">
						  <dd><a href="javascript:;" data-url="/informSystem" data-id='6' data-text="信息管理"><span class="l-line"></span>信息管理</a></dd>
						  <dd><a href="javascript:;" data-url="/leabackSystem" data-id='7' data-text="留言管理"><span class="l-line"></span>留言管理</a></dd>
					  </dl>
				  </li>
				   <li class="layui-nav-item">
				    <a href="javascript:;" data-url="/usergroupSystem" data-id='8' data-text="系统用户权限管理"><i class="iconfont">&#xe600;</i>系统用户权限管理</a>
				  </li>
				  <li class="layui-nav-item">
				    <a href="javascript:;" data-url="/illegalSystem" data-id='9' data-text="安全管理"><i class="iconfont">&#xe60a;</i>安全管理</a>
				  </li>
				  <li class="layui-nav-item">
					  <a href="javascript:;"><i class="iconfont">&#xe60b;</i>系统维护</a>
					  <dl class="layui-nav-child">
						  <dd><a href="javascript:;" data-url="/systemSetSystem" data-id='10' data-text="系统设置"><span class="l-line"></span>系统设置</a></dd>
						  <dd><a href="javascript:;" data-url="/dataAnalyzSystem" data-id='11' data-text="数据维护"><span class="l-line"></span>数据维护</a></dd>
					  </dl>
				  </li>
				</ul>
			</div>
			<!--右侧内容-->
			<div class="main-layout-container">
				<!--头部-->
				<div class="main-layout-header">
					<div class="menu-btn" id="hideBtn">
						<a href="javascript:;">
							<span class="iconfont">&#xe60e;</span>
						</a>
					</div>
					<ul class="layui-nav" lay-filter="rightNav">
					  <li class="layui-nav-item">
						  <a href="javascript:;" data-url="/adminSystem" data-id='12' data-text="个人信息">${userlogin.user_name}</a>
					  </li>
					  <li class="layui-nav-item"><a href="javascript:login_out();">注销</a></li>
					</ul>
				</div>
				<!--主体内容-->
				<div class="main-layout-body">
					<!--tab 切换-->
					<div class="layui-tab layui-tab-brief main-layout-tab" lay-filter="tab" lay-allowClose="true">
					  <ul class="layui-tab-title">
					    <li class="layui-this welcome">后台主页</li>
					  </ul>
					  <div class="layui-tab-content">
					    <div class="layui-tab-item layui-show" style="background: #f5f5f5;">
					    	<!--1-->
					    	<iframe src="/welComeSystem" width="100%" height="100%" name="iframe" scrolling="auto" class="iframe" framborder="0"></iframe>
					    	<!--1end-->
					    </div>
					  </div>
					</div>
				</div>
			</div>
			<!--遮罩-->
			<div class="main-mask">
				
			</div>
		</div>
		<script type="text/javascript">
			function login_out(){
				layer.confirm('真的要退出么？', function(index){
					window.location.href="user_loginOut";
					layer.close(index);
				});
			}
		</script>
		<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
		<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
		<script src="static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script src="static/admin/js/main.js" type="text/javascript" charset="utf-8"></script>
		
	</body>
</html>
