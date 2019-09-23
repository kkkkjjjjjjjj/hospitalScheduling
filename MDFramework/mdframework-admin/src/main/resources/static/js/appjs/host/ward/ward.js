var prefix = "/ward"
$(document).ready(function() {
    load();
});

var load = function() {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                method : 'get',
                url : prefix + '/list', // 请求数据的ajax的url
                ajaxParams : {}, // 请求数据的ajax的data属性
                striped : true, // 是否各行渐变色
                bordered : true, // 是否显示边框
                //	toolbar : '#exampleToolbar',
                columns : [
                    {
                        title : '工号',
                        field : 'userName',
                    },
                    {
                        title : '姓名',
                        field : 'name'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(item, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + item.userName
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + item.userName
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;
                        }
                    } ]
            });
}

