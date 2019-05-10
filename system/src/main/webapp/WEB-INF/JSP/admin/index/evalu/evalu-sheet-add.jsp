<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/4/25
  Time: 23:10
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
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<form class="layui-form" style="width: 90%;padding-top: 20px;">
    <ul style="margin-left: 100px;">
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">1.是否经常对学生进行思想、安全、心里健康、行为规范等方面的集中教育。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test10"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">2.辅导员工作是否做到奖惩公平、客观公正。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test11"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">3.辅导员是否坚持与学生谈心制度。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test12"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">4.是否及时像学生传达院、系的会议精神和信息。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test13"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">5.是否按要求经常性的检查学生各项出勤。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test14"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">6.是否经常走访学生寝室，关心学生的思想、学习与生活。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test15"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">7.是否经常深入学生课堂，了解学生到课和上课情况。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test16"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">8.是否经常督查学生寝室卫生，指导学生参加“星级寝室”评比活动。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test17"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">9.是否有计划地组织学生开展有益活动。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test18"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item">
                <div class="layui-form-item">10.是否及时解决学生提出的问题或给予及时的答复。</div>
                <label class="layui-form-label">评分：</label>
                <div class="layui-input-block">
                    <div id="test19"></div>
                </div>
            </div>
        </li>
        <li>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">评价信息：</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入评价信息" lay-verify="required" class="layui-textarea"></textarea>
                </div>
            </div>
        </li>
    </ul>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="evaluInfo">提交评分</button>
        </div>
    </div>
</form>

<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form'], function() {
        var form = layui.form;
        form.on('submit(evaluInfo)', function(data) {
            var a=(Number($("#test10 > span").text())+Number($("#test11 > span").text())+Number($("#test12 > span").text())+Number($("#test13 > span").text())+
                Number($("#test14 > span").text())+Number($("#test15 > span").text())+Number($("#test16 > span").text())+Number($("#test17 > span").text())+
                Number($("#test18 > span").text())+Number($("#test19 > span").text()))/10;
            $.ajax({
                url: "addevalu",
                type: "post",
                data: {
                    teach_id: ${teach_id},
                    score: a,
                    user_id: ${userlogin.user_id},
                    pow_id: "1",
                    evalu_msg : $("textarea").val()
                },
                success: function(data) {
                    switch(data){
                        case "200":
                            layer.msg("添加成功");
                            break;
                        case "0":
                            layer.msg("添加失败");
                            break;
                        case "50":
                            layer.msg("您已评价，不能重复评价");
                            break;
                        case "45":
                            layer.msg("已被其他管理员评价，不能重复评价");
                            break;
                    }
                }
            });
            return false;
        });
    });
    layui.use(['rate'], function() {
        var rate = layui.rate;
        //主题色
        rate.render({
            elem: '#test10',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#F00000',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test11',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#FFCC00',
            setText: function(value) {
                this.span.text(value);
            }
        });

        rate.render({
            elem: '#test12',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#339933',
            setText: function(value) {
                this.span.text(value);
            }
        })
        rate.render({
            elem: '#test13',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#FFCC33',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test14',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#333399',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test15',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#FF0033',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test16',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#006633',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test17',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#FFFF00',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test18',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#FF0033',
            setText: function(value) {
                this.span.text(value);
            }
        });
        rate.render({
            elem: '#test19',
            value: 0,
            length: 10,
            text: true,
            half: true,
            theme: '#006699',
            setText: function(value) {
                this.span.text(value);
            }
        })

    });
</script>
</body>
</html>

