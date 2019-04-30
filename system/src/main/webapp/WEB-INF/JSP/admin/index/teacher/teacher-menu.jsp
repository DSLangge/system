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
            <option value="teach_sex">性别</option>
            <option value="entry_time">入职时间</option>0
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
        <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i> 添加</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i> 删除</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon layui-icon-edit"></i> 编辑</button>
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
            ,url:'/teacher'
            ,toolbar: '#toolbarDemo'
            ,title: '教师信息'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'teach_id', title:'教师工号', width:125, fixed: 'left', unresize: true, sort: true,align:'center'}
                ,{field:'teach_name', title:'教师姓名', width:110,align:'center'}
                ,{field:'teach_sex', title:'性别', width:80,align:'center'}
                ,{field:'password', title:'密码', width:100,align:'center'}
                ,{field:'entry_time', title:'入职时间', width:110,align:'center'}
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
                case 'add':
                    layer.open({
                        type: 2,
                        area: ['1000px', '400px'],
                        content: ['teacheradd', 'no']//添加修改路径
                    });
                    break;
                case 'delete':
                    var data = checkStatus.data;
                    var batdel="";//批量删除参数
                    if(data.length===0){
                        layer.msg('请选择一个用户');
                        break;
                    }
                    var n=data.length-1;
                    $.each(data,function(index,ele){
                        if(index<n){
                            batdel+=ele.teach_id+"-";
                        }else{
                            batdel+=ele.teach_id;
                        }
                    });
                    layer.confirm('真的要删除么？', function(index){
                        $.ajax({
                            url : "delete",
                            type : "post",
                            data : {
                                batdel : batdel,
                                type: "teacher"
                            },
                            success : function(data){
                                layer.msg(data)
                            }
                        });
                        layer.close(index);
                    });
                    break;
                case 'edit':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg("只能选择一个用户哟~");
                        break;
                    }
                    $.each(data,function(index,ele){
                        layer.open({
                            type: 2,
                            area: ['1000px', '400px'],
                            content: ['teacheredit?teach_id='+ele.teach_id, 'no']//添加修改路径
                        });
                    });
                    break;
            };
        });
    });
</script>

</body>
</html>