<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/2
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>usergroup</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div class="demoTable">
    <div class="layui-form" style="float: left;">
        <select name="searchtype" lay-verify="required" id="searchtype">
            <option value="group_name">用户组名称</option>
            <option value="po_name">用户组权限</option>
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
        <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i> 添加用户组</button>
        <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon layui-icon-delete"></i> 删除用户组</button>
        <button class="layui-btn layui-btn-sm" lay-event="edit"><i class="layui-icon layui-icon-edit"></i> 编辑用户组</button>
        <button class="layui-btn layui-btn-sm" lay-event="select"><i class="layui-icon layui-icon-group"></i> 查看用户组</button>
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
            ,url:'/usergroup'
            ,toolbar: '#toolbarDemo'
            ,title: '用户组表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:80, fixed: 'left',align:'center'}
                ,{field:'group_name', title:'用户组名称', width:130, fixed: 'left',align:'center'}
                ,{field:'sum', title:'人数', width:80,align:'center'}
                ,{field:'po_name', title:'用户组权限', width:130,align:'center'}
            ]]
            ,id: 'testReload'
            ,height: 'full'
            ,page: true
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
                        area: ['500px', '240px'],
                        content: ['usergroupadd', 'no']
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
                            batdel+=ele.id+"-";
                        }else{
                            batdel+=ele.id;
                        }
                    });
                    layer.confirm('真的要删除么？', function(index){
                        $.ajax({
                            url : "delete",
                            type : "post",
                            data : {
                                batdel : batdel,
                                type: "usergroup"
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
                        layer.msg('请选择一个');
                        break;
                    }
                    $.each(data,function(index,ele){
                        layer.open({
                            type: 2,
                            area: ['500px', '240px'],
                            content: ['usergroupedit?id='+ele.id, 'no']
                        });
                    });
                    break;
                case 'select':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg('请选择一个');
                        break;
                    }
                    // $.each(data,function(index,ele){
                    //     layer.open({
                    //         type: 2,
                    //         area: ['1000px', '400px'],
                    //         content: ['usergroupedit?id='+ele.id, 'no']
                    //     });
                    // })
                    layer.msg('权限管理编辑');
                    break;
            };
        });
    });
</script>
</body>
</html>
