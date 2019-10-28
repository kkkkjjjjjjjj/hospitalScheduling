
$().ready(function() {
    validateRule();
    // $("#signupForm").validate();
});

$.validator.setDefaults({
    submitHandler : function() {
        update();
        xx();
    }
});
function update() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/BasicInformation/update",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            alert("Connection error");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg(data.msg);
                parent.reLobd();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);
            } else {
                parent.layer.msg(data.msg);
            }
        }
    });

}

/**
 * 校验规格对应input标签的name属性
 */
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            id : {
                required : true
            },
            name : {
                required : true,
            },
            byDate:{
                required : true,
            },
            agree : "required"
        },
    })
}

function xx(){
    parent.location.relobd();
}


