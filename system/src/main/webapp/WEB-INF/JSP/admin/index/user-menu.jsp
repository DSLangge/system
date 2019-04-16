<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>layui</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="layui/css/layui.css"  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="demoTable">
	搜索ID：
	<div class="layui-inline">
		<input class="layui-input" name="id" id="demoReload" autocomplete="off">
	</div>
	<button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
	<%--<div class="layui-btn-container">--%>
		<%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
		<%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
		<%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
	<%--</div>--%>
</script>

<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
	layui.use('table', function(){
		var table = layui.table;

		table.render({
			elem: '#test'
			,url:'/user'
			,toolbar: '#toolbarDemo'
			,title: '用户数据表'
			,cols: [[
				{type: 'checkbox', fixed: 'left'}
				,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true}
				,{field:'user_id', title:'user_id', width:120, edit: 'text'}
				,{field:'user_name', title:'user_name', width:120, edit: 'text'}
				,{field:'password', title:'password', width:120, edit: 'text'}
				,{field:'del', title:'del', width:120, edit: 'text'}
				// ,{field:'username', title:'用户名', width:120, edit: 'text'}
				// ,{field:'email', title:'邮箱', width:150, edit: 'text', templet: function(res){
				// 		return '<em>'+ res.email +'</em>'
				// 	}}
				// ,{field:'sex', title:'性别', width:80, edit: 'text', sort: true}
				// ,{field:'city', title:'城市', width:100}
				// ,{field:'sign', title:'签名'}
				// ,{field:'experience', title:'积分', width:80, sort: true}
				// ,{field:'ip', title:'IP', width:120}
				// ,{field:'logins', title:'登入次数', width:100, sort: true}
				// ,{field:'joinTime', title:'加入时间', width:120}
				,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
			]]
			,page: true
			,id: 'testReload'
			,response: {
				statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
			}
		});


		var $ = layui.$, active = {
			reload: function(){
				var demoReload = $('#demoReload');

				//执行重载
				table.reload('testReload', {
					page: {
						curr: 1 //重新从第 1 页开始
					}
					,where: {
						id: demoReload.val()
					}
				});
			}
		};

		$('.demoTable .layui-btn').on('click', function(){
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});


		// //头工具栏事件
		// table.on('toolbar(test)', function(obj){
		// 	var checkStatus = table.checkStatus(obj.config.id);
		// 	switch(obj.event){
		// 		case 'getCheckData':
		// 			var data = checkStatus.data;
		// 			layer.alert(JSON.stringify(data));
		// 			break;
		// 		case 'getCheckLength':
		// 			var data = checkStatus.data;
		// 			layer.msg('选中了：'+ data.length + ' 个');
		// 			break;
		// 		case 'isAll':
		// 			layer.msg(checkStatus.isAll ? '全选': '未全选');
		// 			break;
		// 	};
		// });

		//监听行工具事件
		table.on('tool(test)', function(obj){
			var data = obj.data;
			//console.log(obj)
			if(obj.event === 'del'){
				layer.confirm('真的删除行么', function(index){
					obj.del();
					layer.close(index);
				});
			} else if(obj.event === 'edit'){
				layer.prompt({
					formType: 2
					,value: data.email
				}, function(value, index){
					obj.update({
						email: value
					});
					layer.close(index);
				});
			}
		});
	});
</script>

</body>
</html>