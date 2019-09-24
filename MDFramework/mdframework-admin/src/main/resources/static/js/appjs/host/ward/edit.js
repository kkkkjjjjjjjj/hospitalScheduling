$().ready(function() {
    validateRule();
    // $("#signupForm").validate();
});

$.validator.setDefaults({
    submitHandler : function() {
        update();
    }
});
function update() {
    $("#roleIds").val(getCheckedRoles());
    $.ajax({
        cache : true,
        type : "POST",
        url : "/ward/update",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            alert("Connection error");
        },
        success : function(r) {
            if (r.code == 0) {
                parent.layer.msg(r.msg);
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.msg(r.msg);
            }

        }
    });

}
// function getCheckedRoles() {
//     var adIds = "";
//     $("input:checkbox[name=role]:checked").each(function(i) {
//         if (0 == i) {
//             adIds = $(this).val();
//         } else {
//             adIds += ("," + $(this).val());
//         }
//     });
//     return adIds;
// }
// function setCheckedRoles() {
//     var roleIds = $("#roleIds").val();
//
//     var adIds = "";
//     $("input:checkbox[name=role]:checked").each(function(i) {
//         if (0 == i) {
//             adIds = $(this).val();
//         } else {
//             adIds += ("," + $(this).val());
//         }
//     });
//     return adIds;
// }

/**
 * 校验规格对应input标签的name属性
 */
// function validateRule() {
//     var icon = "<i class='fa fa-times-circle'></i> ";
//     $("#signupForm").validate({
//         rules : {
//             name : {
//                 required : true
//             },
//             username : {
//                 required : true,
//                 minlength : 2
//             },
//             password : {
//                 required : true,
//                 minlength : 6
//             },
//             confirm_password : {
//                 required : true,
//                 minlength : 6,
//                 equalTo : "#password"
//             },
//             email : {
//                 required : true,
//                 email : true
//             },
//             topic : {
//                 required : "#newsletter:checked",
//                 minlength : 2
//             },
//             agree : "required"
//         },
//     })
// }