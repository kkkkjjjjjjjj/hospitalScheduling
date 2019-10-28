$().ready(function() {
    validateRule();

    // $("#signupForm").validate();
});

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});

function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/StaffSchedulingDictionary/saveinfo",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();

                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
                parent.refresh;
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            xh : {
                required : true
            },
            jc : {
                required : true
            },
            xx : {
                required : true
            },
            wardName : {
                required : false
            },
            agree : "required"
        },
    })
}