function findPassword() {
    if ($('.newPassword').val() == '') {
        $('.newPassword_small').html("<i class='fa fa-times'></i> 请先输入新密码");
        return false;
    }else if ($('.userEmailFind').val() == '') {
        $('.userEmailFind_small').html("<i class='fa fa-times'></i> 请先输入新密码");
        return false;
    }else{
        $.ajax({
            type: "PUT",//数据发送的方式（post 或者 get）
            url: "/UserManagement/findPassword",//要发送的后台地址
            data: {
                password: $('.newPassword').val(),
                userEmail: $('.userEmailFind').val()
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType: "JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if (data.code == 0) {
                    // $('.userPhone_small').html(data.msg);
                    // return false;
                } else {
                    location.reload();
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("修改密码错误");//弹出错误信息
            }
        })
    }

}