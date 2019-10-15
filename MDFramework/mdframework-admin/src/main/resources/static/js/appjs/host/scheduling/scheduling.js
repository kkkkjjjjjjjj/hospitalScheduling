var prefix = "/schedul"
$(function() {
    load();
    lobd();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                // showRefresh : true,
                // showToggle : true,
                // showColumns : true,
                iconSize : 'outline',
                // toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
                // "server"
                queryParams : function(params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        offset : params.offset,
                        name : $('#searchName').val(),
                        monday : $("#monday").val()
                    };
                },
                columns : [
                    {
                        title : '层级',
                        field : 'userName'
                    },
                    {
                        title : '姓名',
                        field : 'name'
                    },
                    {
                        title : '一',
                        field : 'schedulMon',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '二',
                        field : 'schedulTues',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '三',
                        field : 'schedulWed',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '四',
                        field : 'schedulThu',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '五',
                        field : 'schedulFri',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '六',
                        field : 'schedulSat',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '七',
                        field : 'schedulSun',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    }

                    ]
            });
}
function lobd() {
    $('#examTablea')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                // showRefresh : true,
                // showToggle : true,
                // showColumns : true,
                iconSize : 'outline',
                // toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
                // "server"
                queryParams : function(params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        offset : params.offset,
                        name : $('#searchName').val(),
                        monday : $("#mondaya").val()
                    };
                },
                columns : [
                    {
                        title : '层级',
                        field : 'userName'
                    },
                    {
                        title : '姓名',
                        field : 'name'
                    },
                    {
                        title : '一',
                        field : 'schedulMon',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '二',
                        field : 'schedulTues',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '三',
                        field : 'schedulWed',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '四',
                        field : 'schedulThu',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '五',
                        field : 'schedulFri',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '六',
                        field : 'schedulSat',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    },
                    {
                        title : '七',
                        field : 'schedulSun',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatSchedul(value);
                        }
                    }

                ]
            });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}

function formatSchedul(value) {
    var str = "";
    for(var i=0;i<value.length;i++){
        var schedul = value[i].jc;
        if(!isEmpty(schedul)) str = str + schedul;
    }
    console.log(value);
    return str;
}