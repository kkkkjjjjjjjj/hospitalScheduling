// 基于准备好的dom，初始化echarts实例
var column = echarts.init(document.getElementById('column'));

$(function () {
    load();
    chartLoad();
});

function load() {

    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: "/chart/statisticalData", // 服务器数据的加载地址
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                dataType: "json", // 服务器返回的数据类型
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        // limit: params.limit,
                        // offset: params.offset,
                        wardName: $('#wardName').val(),
                        condition: $('#condition').val()
                        // name:$('#searchName').val(),
                        // username:$('#searchName').val()
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        field: 'condition',
                        title: '条件'
                    },
                    {
                        field: 'sum',
                        title: '数量'
                    },
                    {
                        field: 'proportion',
                        title: '比例',
                        formatter: function (value, row, index) {
                            return value.toFixed(2);
                        }
                    }
                ]
            });

}

function chartLoad() {
    $.ajax({
        cache: true,
        type: "GET",
        url: "/chart/statisticalData",
        data: {
            condition: "ward_name"
        },// 你的formid
        async: false,
        error: function (request) {
            alert("Connection error");
        },
        success: function (data) {
            console.log(data);
            var wardList = new Array();
            var numList = new Array();
            var pieList = new Array();
            for(var i=0;i<data.rows.length;i++){
                wardList[i] = data.rows[i].condition;
                numList[i] = data.rows[i].sum;
                var pie = new Object();
                pie.value = data.rows[i].sum;
                pie.name = data.rows[i].condition;
                pieList[i] = pie;
            }

            column.clear();
            var chartType = $("#chartType").val();
            if (chartType == 1){
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '人员信息统计'
                    },
                    tooltip: {},
                    xAxis: {
                        data: wardList
                    },
                    legend: {
                        data:['人数']
                    },
                    yAxis: {},
                    series: [{
                        name: '人数',
                        type: 'bar',
                        data: numList
                    }]
                };
            }else if (chartType == 2){
                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '人员信息统计'
                    },
                    tooltip: {},
                    xAxis: {
                        data: wardList
                    },
                    legend: {
                        data:['人数']
                    },
                    yAxis: {},
                    series: [{
                        name: '人数',
                        type: 'line',
                        data: numList
                    }]
                };
            }else if (chartType == 3) {
                var option = {
                    title: {
                        text: '人员信息统计',
                        x: 'left'
                    },
                    series: [
                        {
                            name: '人员信息统计',
                            type: 'pie',
                            data: pieList,
                            label: { //饼图图形上的文本标签
                                normal: {
                                    show: true,
                                    formatter: '{b}:{c}: ({d}%)'
                                }
                            }
                        }
                    ]
                };
            }
            // 使用刚指定的配置项和数据显示图表。
            column.setOption(option);
        }
    });
}

$("#chartType").change(function () {
    chartLoad();
});

function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function refresh() {
    $('#exampleTable').bootstrapTable('refresh');
}