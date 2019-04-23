<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/4/22
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
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
            <option value="inf_title">事务标题</option>
            <option value="inf_msg">事务信息</option>
            <%--暂定发布人ID 可改发布人姓名--%>
            <option value="pre_id">发布人ID</option>

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


<script type="text/html" id="checkbox_inf_pub">
    <%-- 报错无所谓~可忽略 --%>
    <input type="checkbox" name="inf_pub" value="{{d.id}}" lay-skin="switch" lay-text="已发布|未发布" lay-filter="inf_pubDemo" {{ d.inf_pub == 1 ? 'checked' : '' }}>
</script>


<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use('table', function(){
        var table = layui.table
        ,form = layui.form;
        table.render({
            elem: '#test'
            ,url:'/inform'
            ,toolbar: '#toolbarDemo'
            ,title: '用户数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'事务序号', width:110, fixed: 'left',align:'center'}
                ,{field:'inf_title', title:'事务标题', width:110, fixed: 'left',align:'center'}
                ,{field:'inf_msg', title:'事务信息', width:200,align:'center'}
                ,{field:'pre_id', title:'发布人工号', width:110,align:'center'}
                ,{field:'inf_creatime', title:'创建时间', width:160,align:'center'}
                ,{field:'inf_updatime', title:'更新时间', width:160,align:'center'}
                ,{field:'inf_pubtime', title:'发布时间', width:160,align:'center'}
                ,{field:'inf_pub', title:'是否发布', width:110, templet: '#checkbox_inf_pub', unresize: true,align:'center'}
                ,{field:'del', title:'状态', width:60,align:'center'}
            ]]
            ,page: true
            ,height: 'full'
            ,id: 'testReload'
            ,response: {
                statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
            }
        });

        //监听发布操作按钮操作
        form.on('switch(inf_pubDemo)', function(obj){
            var id=this.value;
            if(obj.elem.checked){
                layer.confirm('确定发布本条通知？', function(index){
                    // $.ajax({
                    //     url : "delete",
                    //     type : "post",
                    //     data : {
                    //         batdel : batdel,
                    //         type: "inform"
                    //     },
                    //     success : function(data){
                    //         layer.msg(data)
                    //     }
                    // });
                    // layer.close(index);
                    layer.msg("您需要发布通知的ID为："+id);
                });
            }else{
                layer.msg("取消发布");
            }
            layer.tips(this.value + ' ' + this.name + '：'+ obj.elem.checked, obj.othis);
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
                    layer.msg("通知添加");
                    // layer.open({
                    //     type: 2,
                    //     area: ['1400px', '600px'],
                    //     content: ['studentadd', 'no']//添加修改路径
                    // });
                    break;
                case 'delete':
                    var data = checkStatus.data;
                    var batdel="";//批量删除参数
                    if(data.length===0){
                        layer.msg('请至少选择一条通知');
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
                        // $.ajax({
                        //     url : "delete",
                        //     type : "post",
                        //     data : {
                        //         batdel : batdel,
                        //         type: "inform"
                        //     },
                        //     success : function(data){
                        //         layer.msg(data)
                        //     }
                        // });
                        // layer.close(index);
                    });
                    break;
                case 'edit':
                    var data = checkStatus.data;
                    if(data.length!=1){
                        layer.msg("只能选择一个用户哟~");
                        break;
                    }
                    layer.msg("通知编辑");
                    // $.each(data,function(index,ele){
                    //     layer.open({
                    //         type: 2,
                    //         area: ['1400px', '600px'],
                    //         content: ['studentedit?stu_id='+ele.stu_id, 'no']//添加修改路径
                    //     });
                    // });
                    break;
            };
        });
    });
</script>

</body>
</html>
