//验证用户名
var count =1;
function checkName(){
    var preg = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
    if($('.userName').val() == ""){
        $('.userName_small').html( "<i class='fa fa-times'></i> 请先输入需要注册的用户名");
        count = 0;
        return count;
    }else if(!(preg.test($('.userName').val()))){
        $('.userName_small').html( "<i class='fa fa-times'></i> 账号只能输入、英文、数字");
        count = 0;
        return count;
    }else{
        //检测用户名是否存在
        $.ajax({
            type: "GET",
            url: "/LogUser/checkName",
            data: {
                userName : $('.userName').val()
            },
            dataType:"JSON",
            success: function (data) {
                if(data.code==-1){
                    $('.userName_small').html("<i class='fa fa-times'></i>" + data.msg);
                    count = 0;
                }else {
                    $('.userName_small').html("<i class='fa fa-check'>");
                    count = 1;
                }
            },
            error: function (msg) {
                alert(msg);//弹出错误信息
                count =0;
            }
        });
        return count;
    }
}

//密码
function userPassWord(){
    if($(".userPassWord").val() == ""){
        $('.pWord_small').html("<i class='fa fa-times'></i> 请先输入密码");
        return false;
    }else{
        $('.pWord_small').html("<i class='fa fa-check'>");
        return true;
    }
}

//确认密码
function surePword(){
    var passWord = $(".userPassWord").val();
    var surePassword = $(".surePassword").val();
    if(surePassword.length <= 0)
    {
        $('.passWord_small').html("<i class='fa fa-times'></i> 请先确认密码");
        return false;
    }
    else if( passWord == surePassword){
        $('.passWord_small').html("<i class='fa fa-check'>");
        return true;
    }else {
        $('.passWord_small').html("<i class='fa fa-times'></i> 两次密码不同");
        return false;
    }
}

//验证手机号码格式是否正确
var flag = 1;
function checkPhone(){
    var phone = $('.telPhone').val();
    if(phone.length <= 0) {
        $(".userPhone_small").html("<i class='fa fa-times'></i> 请先输入手机号");
        flag = 0;
        return flag;
    }else if(/^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\d{8}$/g.test(phone)){
        //	3.检测收手机号是否存在
        $.ajax({
            type: "GET",
            url: "/LogUser/checkPhone",
            data: {
                userPhone : phone
            },
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==-1){
                    $('.userPhone_small').html("<i class='fa fa-times'></i>" + data.msg);
                    flag = 0;
                }else {
                    $('.userPhone_small').html("<i class='fa fa-check'>");
                    flag = 1;
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
                flag = 0;
            }
        });
        return flag;
    }else{
        $(".userPhone_small").html("<i class='fa fa-times'></i> 手机格式不正确");
        flag = 0;
        return flag;
    }
}


//邮箱的格式是否正确
var isPhone = 1;
function checkEmail() {
    var mailbox = $('.mailbox').val();
    var pattern = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    if(mailbox == '') {
        $(".userEmail_small").html("<i class='fa fa-times'></i> 请先输入邮箱号");
        isPhone = 0;
        return isPhone;
    }else if(!pattern.test(mailbox)){
        $(".userEmail_small").html("<i class='fa fa-times'></i> 请输入正确的邮箱号");
        isPhone = 0;
        return isPhone;
    }else{
        //正确检测邮箱是否存在
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/LogUser/checkEmail",//要发送的后台地址
            data: {
                userEmail : mailbox
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code == -1){
                    $('.userEmail_small').html("<i class='fa fa-times'></i>" + data.msg);
                    isPhone = 0;
                }else {
                    $('.userEmail_small').html("<i class='fa fa-check'> 该邮箱可以注册");
                    // 邮箱不存在发送验证码
                    isPhone = 1;
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

// 发送验证码
function sendEmail() {
    var email = 1;
    $.ajax({
        type: "POST",//数据发送的方式（post 或者 get）
        url: "/UserManagement/sendRegisterEmail",//要发送的后台地址
        data: {
            userEmail : $('.mailbox').val()
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
    if(checkEmail()){
        $(".userEmail_small").html("<i class='fa fa-check'>");
        sendEmail(); //发送验证码
        resetCode(); //倒计时
    }else{
        // $('.mailbox').focus();
    }

}

//邮箱验证码对与错
var code = 1;
function emailPassword() {
    if($('.userCode').val() != ''){
        $.ajax({
            type: "GET",
            url: "/UserManagement/contrastCode",
            data: {
                userEmail : $('.mailbox').val(),
                userCode : $('.userCode').val()
            },
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
                alert("验证码网络故障");//弹出错误信息
                code = 0;
            }
        });
        return code;
    }else{
        $('.userCode_small').html("<i class='fa fa-times'></i> 请输入您获取的验证码");
        code = 0;
        return code;
    }
    console.log($('.userCode').val());

}



$('.registerButton').on('click',function () {
    $('.hiddenCode').val($('.userCode').val());
    console.log($('.hiddenCode').val());
    var strCount = checkName();
    console.log("用户 " + strCount);
    var strFlag = checkPhone();
    console.log("手机号 " +strFlag);
    var strPhone = checkEmail();
    console.log("邮箱 " +strPhone);
    var strCode = checkEmail();
    console.log("验证码 " +strCode);
    var province = $(".province option:selected").val();
    var city = $(".city option:selected").val();
    var district = $(".district option:selected").val();
    var userAddress = province + city + district;
    console.log("地址 " +userAddress  );
    $(".hiddenInput").val(userAddress);
    if(!strCount){
        alert("请完善用户名信息");
    }else if(!userPassWord()){
        alert("请完善密码信息");
    }else if(!surePword()){
        alert("请完善确认密码信息");
    }else if(!strFlag){
        alert("请完善邮箱信息")
    }else if(!strPhone){
        alert("请完善手机号信息")
    }else if(!strCode){
        alert("请完善验证码信息")
    }else {
        $.ajax({
            type: "POST",
            url: "/LogUser/register",
            data: {
                userName:$('.userName').val(),
                password:$('.userPassWord').val(),
                userPhone:$('.telPhone').val(),
                userEmail : $('.mailbox').val(),
                code : $('.hiddenCode').val(),
                userAddress:$(".hiddenInput").val()
            },
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==0){
                    alert('注册成功');
                    window.location.href = '/LogUser/toLogin'
                }else {
                    alert('Emmmmm.............')
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert($('.hiddenCode').val());
                alert(msg + '注册失败');
            }
        });
    }
});