<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 2019/5/17
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>网站数据</title>
    <link rel="stylesheet" type="text/css" href="static/admin/layui/css/layui.css" />
    <link rel="stylesheet" type="text/css" href="static/admin/css/admin.css" />
</head>
<body>
<div class="wrap-container welcome-container">
    <div class="row">
        <div class="welcome-left-container col-lg-11">
            <div class="data-show">
                <ul class="clearfix">
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-org f-l">
                                <span class="iconfont">&#xe609;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">通知数</p>
                                <p><span class="color-org" id="adv"></span></p>
                            </div>
                        </a>
                    </li>
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-blue f-l">
                                <span class="iconfont">&#xe602;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">信息数</p>
                                <p><span class="color-blue" id="inf"></span></p>
                            </div>
                        </a>
                    </li>
                    <li class="col-sm-12 col-md-4 col-xs-12">
                        <a href="javascript:;" class="clearfix">
                            <div class="icon-bg bg-green f-l">
                                <span class="iconfont">&#xe605;</span>
                            </div>
                            <div class="right-text-con">
                                <p class="name">留言数</p>
                                <p><span class="color-green" id="lea"></span></p>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <!--图表-->
            <div class="chart-panel panel panel-default">
                <div class="panel-body" id="chart" style="height: 376px;">
                </div>
            </div>

        </div>
    </div>
</div>
<script src="static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/admin/lib/echarts/echarts.js"></script>
<script type="text/javascript">
    layui.use(['layer', 'jquery'], function() {
        var layer = layui.layer;
        var $ = layui.jquery;
        //图表
        var myChart;
        require.config({
            paths: {
                echarts: 'static/admin/lib/echarts'
            }
        });
        require(
            [
                'echarts',
                'echarts/chart/bar',
                'echarts/chart/line',
                'echarts/chart/map'
            ],
            function(ec) {
                //--- 折柱 ---
                myChart = ec.init(document.getElementById('chart'));
                myChart.showLoading();
                $.ajax({
                    url: "dataanalyz",
                    type: "post",
                    success: function(data) {
                        var adv=$("#adv");
                        adv.html(data[0].Monday+data[0].Tuesday+data[0].Wednesday+data[0].Thursday+data[0].Friday+data[0].Saturday+data[0].Sunday);
                        var inf=$("#inf");
                        inf.html(data[1].Monday+data[1].Tuesday+data[1].Wednesday+data[1].Thursday+data[1].Friday+data[1].Saturday+data[1].Sunday);
                        var lea=$("#lea");
                        lea.html(data[2].Monday+data[2].Tuesday+data[2].Wednesday+data[2].Thursday+data[2].Friday+data[2].Saturday+data[2].Sunday);
                        myChart.hideLoading();
                        myChart.setOption({
                            title: {
                                text: "数据统计",
                                textStyle: {
                                    color: "rgb(85, 85, 85)",
                                    fontSize: 18,
                                    fontStyle: "normal",
                                    fontWeight: "normal"
                                }
                            },
                            tooltip: {
                                trigger: "axis"
                            },
                            legend: {
                                data: ["通知", "信息", "留言"],
                                selectedMode: false,
                            },
                            toolbox: {
                                show: true,
                                feature: {
                                    dataView: {
                                        show: false,
                                        readOnly: true
                                    },
                                    magicType: {
                                        show: true,
                                        type: ["line", "bar", "stack", "tiled"]
                                    },
                                    restore: {
                                        show: true
                                    },
                                    saveAsImage: {
                                        show: true
                                    },
                                    mark: {
                                        show: true
                                    }
                                }
                            },
                            calculable: false,
                            xAxis: [{
                                type: "category",
                                boundaryGap: false,
                                data: ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
                            }],
                            yAxis: [{
                                type: "value"
                            }],
                            grid: {
                                x2: 30,
                                x: 50
                            },
                            series: [{
                                name: "通知",
                                type: "line",
                                smooth: true,
                                itemStyle: {
                                    normal: {
                                        areaStyle: {
                                            type: "default"
                                        }
                                    }
                                },
                                data: [data[0].Monday, data[0].Tuesday, data[0].Wednesday, data[0].Thursday,data[0].Friday, data[0].Saturday, data[0].Sunday]
                            },
                                {
                                    name: "信息",
                                    type: "line",
                                    smooth: true,
                                    itemStyle: {
                                        normal: {
                                            areaStyle: {
                                                type: "default"
                                            }
                                        }
                                    },
                                    data: [data[1].Monday, data[1].Tuesday, data[1].Wednesday, data[1].Thursday,data[1].Friday, data[1].Saturday, data[1].Sunday]
                                },
                                {
                                    name: "留言",
                                    type: "line",
                                    smooth: true,
                                    itemStyle: {
                                        normal: {
                                            areaStyle: {
                                                type: "default"
                                            },
                                            color: "rgb(110, 211, 199)"
                                        }
                                    },
                                    data: [data[2].Monday, data[2].Tuesday, data[2].Wednesday, data[2].Thursday,data[2].Friday, data[2].Saturday, data[2].Sunday]
                                }
                            ]
                        });
                    }
                });
            }
        );
        $(window).resize(function() {
            myChart.resize();
        })
    });
</script>
</body>
</html>

