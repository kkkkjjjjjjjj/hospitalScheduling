var prefix = "/schedul"
$(function() {
    load();
    lobd();
    locd();
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
                pageSize : 5, // 如果设置了分页，每页数据条数
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
                        //wardName : $('#chartType').val(),
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
                    ,
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.name
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.name
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
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
                pageSize : 5, // 如果设置了分页，每页数据条数
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

function locd() {
    $('#exampleTa')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/listListen", // 服务器数据的加载地址
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
                pageSize : 5, // 如果设置了分页，每页数据条数
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
                        monday : $("#mondy").val()
                    };
                },
                columns : [
                    {
                        title : '  ',
                        field : 'ting'
                    },
                    {
                        title : '一',
                        field : 'listenMon',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '二',
                        field : 'listenTues',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '三',
                        field : 'listenWed',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '四',
                        field : 'listenThu',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '五',
                        field : 'listenFri',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '六',
                        field : 'listenSat',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    },
                    {
                        title : '七',
                        field : 'listenSun',
                        align : 'center',
                        formatter : function(value, row, index) {
                            return formatListen(value);
                        }
                    }
                    ,
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.name
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.name
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
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
function formatListen(value) {
    var str = "";
    for(var i=0;i<value.length;i++){
        var listen = value[i].jc;
        if(!isEmpty(listen)) str = str + listen;
    }
    console.log(value);
    return str;
}



function edit(name) {
    layer.open({
        type : 2,
        title : '用户修改',
        maxmin : true,
        shadeClose : true, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + name // iframe的url
    });
}


function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
}
