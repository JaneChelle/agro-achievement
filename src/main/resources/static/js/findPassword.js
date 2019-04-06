

//邮箱的格式是否正确
function checkEmail() {
    var userEmailFind = $('.userEmailFind').val();
    $('.userEmails').val(userEmailFind);
    var pattern = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    var isPhone = 1;
    if(userEmailFind == '') {
        $(".userEmailFind_small").html("<i class='fa fa-times'></i> 请先输入邮箱号");
        isPhone = 0;
        return isPhone;
    }else if(!pattern.test(userEmailFind)){
        $(".userEmailFind_small").html("<i class='fa fa-times'></i> 请输入正确的邮箱号");
        isPhone = 0;
        return isPhone;
    }else{
        //正确检测邮箱是否存在
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/LogUser/checkEmail",//要发送的后台地址
            data: {
                userEmail : userEmailFind
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code == -1){
                    $('.userEmailFind_small').html("<i class='fa  fa-check'></i>");
                    // 邮箱存在发送验证码
                    isPhone = 1;
                }else {
                    $('.userEmailFind_small').html("<i class='fa fa-times'> 该邮箱还未注册");
                    isPhone = 0;
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("检测邮箱是否存在失败");//弹出错误信息
                isPhone = 0;
            }
        });
        return isPhone;
    }
}
var information = $('.userEmailFind_small').text();
// 发送验证码
function sendEmail() {
    var userEmailFind = $('.userEmailFind').val();
    var email = 1;
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/UserManagement/sendEmail",//要发送的后台地址
        data: {
            userEmail : userEmailFind
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}

        success: function (data) {//ajax请求成功后触发的方法
            console.log("成功");
            email = 1;
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("发送验证码失败!");//弹出错误信息
            email = 0;
        }
    });
    return email;
}

//倒计时
function resetCode(){
    $('#J_getCode').hide();
    $('#J_second').html('60');
    $('#J_resetCode').show();
    var second = 60;
    var timer = null;
    timer = setInterval(function(){
        second -= 1;
        if(second >0 ){
            $('#J_second').html(second);
        }else{
            clearInterval(timer);
            $('#J_getCode').show();
            $('#J_resetCode').hide();
        }
    },1000);
}
/*获取验证码*/
function getCode(e){
    console.log("11111111");
    if(checkEmail()){
        console.log(checkEmail())
        console.log("22222");
        $(".userEmailFind_small").html("<i class='fa fa-check'>");
        sendEmail(); //发送验证码
        console.log("3333");
        resetCode(); //倒计时
        console.log("444");
    }else{
        // $('.userEmailFind').focus();
    }

}

//邮箱验证码对与错
function emailPassword() {
    var code = 1;
    if($('.userCode').val() != ''){
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/UserManagement/contrastCode",//要发送的后台地址
            data: {
                userEmail : $('.userEmailFind').val(),
                userCode : $('.userCode').val(),
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==0){
                    $('.userCode_small').html("<i class='fa fa-check'>" + data.msg);
                    code = 1;
                }else {
                    $('.userCode_small').html("<i class='fa fa-times'></i>" + data.msg);
                    code = 0;
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
                code = 0;
            }
        });
        return code;
    }else{
        $('.userCode_small').html("<i class='fa fa-times'></i> 请输入您获取的验证码");
        return false;
    }
    console.log($('.userCode').val())

}

$('.findPassWord').on('click',function () {
    if(!emailPassword()){
        alert('验证码错误');
    }else if($('.userEmails').val() !=$('.userEmailFind').val()){
        console.log($('.userEmails').val())
        console.log($('.userEmailFind').val())
    alert(" 11111111111");
    }else {

        window.location.href = '/UserManagement/toPassword'
    }
});

// 重置密码
function lookPassword() {
    $.ajax({
        type: "GET",//数据发送的方式（post 或者 get）
        url: "/UserManagement/findPassword",//要发送的后台地址
        data: {
            userEmail : $('.newemails').val(),
            password : $('.newPassword').val(),
        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
        dataType:"JSON",
        success: function (data) {//ajax请求成功后触发的方法
            console.log(data);
            if(data.code==0){
               alert("重置成功");
               window.location.href = '/LogUser/toLogin';
            }
            else {
                window.location.href = '/LogUser/toLogin';
            }
        },
        error: function (msg) {//ajax请求失败后触发的方法
            alert("网络故障");//弹出错误信息

        }
    });
}