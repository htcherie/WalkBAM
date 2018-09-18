

$(function(){function show(){var mydate = new Date(); var str = "" + mydate.getFullYear() + "-"; str += (mydate.getMonth()+1); return str; } $(".Years").text(show()); });
var myChart1 = echarts.init(document.getElementById('chart-panel'));
option1 = {
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart1.setOption(option1);

var myChart3 =  echarts.init(document.getElementById('Canvas3'));




$.get('dashboard.action').done(function (data) {

    myChart3.setOption({
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['总金额','订单数']
        },
        xAxis: [
            {
                type: 'category',
                data: data["weeks"],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '总金额',
                min: 0,
                max: 50000,
                interval: 10000,
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                name: '订单数',
                min: 0,
                max: 100,
                interval: 20,
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name:'总金额',
                type:'bar',
                yAxisIndex: 0,
                data:data["weeksTotal"]
            },
            {
                name:'订单数',
                type:'line',
                yAxisIndex: 1,
                data:data["weeksOrder"]
            }
        ]
    });
});

