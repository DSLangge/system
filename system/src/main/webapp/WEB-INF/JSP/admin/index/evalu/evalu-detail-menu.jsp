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

<table class="layui-hide" id="test" lay-filter="test"></table>

<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'evaludetailmenu'
            ,toolbar: true
            ,title: '总表信息'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'teach_id', title:'教师工号', width:125, fixed: 'left', unresize: true, sort: true,align:'center'}
                ,{field:'teach_name', title:'教师姓名', width:110,align:'center'}
                ,{field:'user_score', title:'系统管理员评分', width:160,align:'center'}
                ,{field:'teach_score', title:'辅导员评分', width:140,align:'center'}
                ,{field:'stu_score', title:'学生评分', width:120,align:'center'}
                ,{field:'score', title:'总分', width:120,align:'center'}
                ,{field:'evalu_msg', title:'总体评价',align:'center'}
            ]]
            ,page: true
            ,height: 'full'
            ,id: 'testReload'
            ,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });
    });
</script>

</body>
</html>