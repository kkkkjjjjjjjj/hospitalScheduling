// 兼容性代码
function autoHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            iframe.width = iframeWin.document.documentElement.scrollWidth || iframeWin.document.body.scrollWidth;
        }
    }
}
window.onload = function() {
    autoHeight(document.getElementById('information'));
    lobd();
}

function lobd() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : "/BasicInformation/todayInfoList", // 服务器数据的加载地址
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
                        name : $('#searchName').val()
                    };
                },
                onClickRow:function (row,$element) {
                    $('.info').removeClass('info');
                    $($element).addClass('info');
                    $("#information").attr("src","/BasicInformation/edit?id="+row.id);
                },
                columns : [
                    {
                        title : '工号',
                        field : 'id',
                    },
                    {
                        title : '姓名',
                        field : 'name',
                    }]
            });
}

function relobd() {
    $('#exampleTable').bootstrapTable("refresh")
}

function refreshs(){
    refresh();
}



