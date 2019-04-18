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
            <option value="stu_id">学号</option>
            <option value="stu_name">姓名</option>
            <option value="stu_age">年龄</option>
            <option value="stu_edu">学制</option>
            <option value="stu_nation">民族</option>
            <option value="stu_style">考生类型</option>
            <option value="stu_antive">出生地</option>
            <option value="stu_high">高中</option>
            <option value="stu_high">入学年份</option>
            <option value="stu_high">高中</option>
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
            ,url:'/student'
            ,toolbar: '#toolbarDemo'
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'stu_id', title:'学生学号', width:125, fixed: 'left',align:'center'}
                ,{field:'stu_name', title:'姓名', width:75, fixed: 'left',align:'center'}
                ,{field:'stu_sex', title:'性别', width:80,align:'center'}
                ,{field:'password', title:'密码', width:80,align:'center'}
                ,{field:'stu_age', title:'年龄', width:60,align:'center'}
                ,{field:'stu_edu', title:'学制', width:60,align:'center'}
                ,{field:'stu_nation', title:'民族', width:60,align:'center'}
                ,{field:'stu_birth', title:'出生日期', width:110,align:'center'}
                ,{field:'stu_proID', title:'身份证号', width:100,align:'center'}
                ,{field:'stu_phone', title:'联系电话', width:120,align:'center'}
                ,{field:'postcode', title:'邮编', width:80,align:'center'}
                ,{field:'stu_style', title:'考生类型', width:110,align:'center'}
                ,{field:'stu_email', title:'邮箱', width:110,align:'center'}
                ,{field:'stu_high', title:'高中', width:110,align:'center'}
                ,{field:'stu_antive', title:'出生地', width:110,align:'center'}
                ,{field:'school_year', title:'入学年份', width:110,align:'center'}
                ,{field:'graduat_year', title:'毕业年份', width:110}
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

                    break;
                case 'delete':
                    var data = checkStatus.data;
                    var batdel="(";//批量删除参数
                    if(data.length===0){
                        layer.msg('请选择一个用户');
                        break;
                    }
                    var n=data.length-1;
                    $.each(data,function(index,ele){
                        if(index<n){
                            batdel+=ele.id+",";
                        }else{
                            batdel+=ele.id+")";
                        }
                    })
                    layer.msg(batdel);
                    break;
                case 'edit':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg("只能选择一个用户哟~");
                        break;
                    }
                    layer.open({
                        type: 2,
                        area: ['500px', '500px'],
                        content: ['admin-info.html', 'no']//添加修改路径
                    });
                    break;
            };
        });
    });
</script>

</body>
</html>