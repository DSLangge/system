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
    <div class="layui-form" style="float: left;">
        <select name="searchtype" lay-verify="required" id="searchtype">
            <option value="teach_id">教师工号</option>
            <option value="teach_name">教师姓名</option>
        </select>
    </div>
    <div class="layui-inline">
        <input class="layui-input" name="id" id="searchcontent" autocomplete="off">
    </div>
    <div class="layui-btn" data-type="reload">搜索</div>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <%--<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i> 添加</button>--%>
        <%--<button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i> 删除</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon layui-icon-edit"></i> 编辑</button>--%>
            <button class="layui-btn layui-btn-sm" lay-event="addevalu"><i class="layui-icon layui-icon-survey"></i> 添加评价</button>
            <button class="layui-btn layui-btn-sm" lay-event="detail"><i class="layui-icon layui-icon-search"></i> 查看详情</button>
            <button class="layui-btn layui-btn-sm" lay-event="scorelist"><i class="layui-icon layui-icon-chart-screen"></i> 生成总表</button>
    </div>
</script>


<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#test'
            ,url:'evalu'
            ,toolbar: '#toolbarDemo'
            ,title: '教师信息'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'teach_id', title:'教师工号', width:125, fixed: 'left', unresize: true, sort: true,align:'center'}
                ,{field:'teach_name', title:'教师姓名', width:110,align:'center'}
                ,{field:'user_count', title:'系统管理员评价统计', width:160,align:'center'}
                ,{field:'teach_count', title:'辅导员评价统计', width:160,align:'center'}
                ,{field:'stu_count', title:'学生评价统计', width:160,align:'center'}
                ,{field:'del', title:'状态', width:60,align:'center'}
            ]]
            ,page: true
            ,height: 'full'
            ,id: 'testReload'
            ,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });


        var $ = layui.$, active = {
            reload: function(){
                var searchcontent = $('#searchcontent');
                var searchtype = $('#searchtype');
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        searchcontent: searchcontent.val(),
                        searchtype: searchtype.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });


        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'addevalu':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg("请选择一个用户进行评价~");
                        break;
                    }
                    $.each(data,function(index,ele){
                        layer.open({
                            type: 2,
                            area: ['1000px', '400px'],
                            content: ['evaluadd?teach_id='+ele.teach_id],
                            end: function(){
                                location.reload();
                            }
                        });
                    });
                    break;
                case 'detail':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg("只能选择一个用户");
                        break;
                    }
                    $.each(data,function(index,ele){
                        layer.open({
                            type: 2,
                            title: ' 查看详情',
                            area: ['600px', '300px'],
                            content: ['evaludetail?teach_id='+ele.teach_id]
                        });
                    });
                    break;
                case 'scorelist':
                    layer.confirm('若存在评价人数为零的列，总体评价将不再显示。确定生成？', function(index){
                        layer.open({
                            type: 2,
                            area: ['1200px', '400px'],
                            content: ['evaludetailmenuSystem', 'no']
                        });
                        layer.close(index);
                    });
                    break;
            };
        });
    });
</script>

</body>
</html>