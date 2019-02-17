//验证用户名
function checkUserName(){
    var preg = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
    if($('.userName').val().length <=0){
        $('.userName_small').text( "<i class='fa fa-times'></i> 请先输入需要注册的用户名");
        return false;
    }else if(!(preg.test($('.userName').val()))){
        $('.userName_small').text( "<i class='fa fa-times'></i> 账号只能输入、英文、数字)");
        return false;
    }else{
    	//检测用户名是否存在
       $.ajax({
	        type: "GET",//数据发送的方式（post 或者 get）
	        url: "/LogUser/checkName",//要发送的后台地址
	        data: {
	        	userName : $('.userName').val()
	        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
	        dataType:"JSON",
	        success: function (data) {//ajax请求成功后触发的方法
	            if(data.code==-1){
	                $('.userName_small').html(data.msg);
	                return false;
	            }else {
	                $('.userName_small').html("<i class='fa fa-check'>");
	                return true;
	            }
	        },
	        error: function (msg) {//ajax请求失败后触发的方法
	            alert("网络故障");//弹出错误信息
	        }
	    });
    }
}
//密码
function userPassWord(){
	var passWord = $(".userPassWord").val();
	if(passWord.length<=0){
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
function checkUserPhone(){
	var phone = $('.telPhone').val();
	console.log(phone.length);
	if(phone.length <= 0) {
		$(".userPhone_small").html("<i class='fa fa-times'></i> 请先输入手机号");
		return false;
	}else if(/^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\d{8}$/g.test(phone)){
        //	3.检测收手机号是否存在
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/LogUser/checkPhone",//要发送的后台地址
            data: {
                userPhone : phone
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==-1){
                    $('.userPhone_small').html(data.msg);
                    return false;
                }else {
                    $('.userPhone_small').html("<i class='fa fa-check'>");
                    return true;
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
            }
        });
	}else{
        $(".userPhone_small").html("<i class='fa fa-times'></i> 手机格式不正确");
        return false;
	}
}
//邮箱的格式是否正确
function checkEmail() {
    var mailbox = $('.mailbox').val();
	var pattern = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
	isPhone = 1;
	if(mailbox == '') {
		$(".userEmail_small").html("<i class='fa fa-times'></i> 请先输入邮箱号");
		isPhone = 0;
		return;
	}else if(!pattern.test(mailbox)){
		$(".userEmail_small").html("<i class='fa fa-times'></i> 请输入正确的邮箱号");
		isPhone = 0;
		return;
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
                    return false;
                }else {
                    $('.userEmail_small').html("<i class='fa fa-check'> 该邮箱可以注册");
                    // 邮箱不存在发送验证码
                    $.ajax({
                        type: "POST",//数据发送的方式（post 或者 get）
                        url: "/UserManagement/sendEmail",//要发送的后台地址
                        data: {
                            userEmail : mailbox
                        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
                        success: function (data) {//ajax请求成功后触发的方法
                            console.log("成功");
                            isPhone = 1;
                            return;
                        },
                        error: function (msg) {//ajax请求失败后触发的方法
                            alert("发送验证码失败!");//弹出错误信息
                            isPhone = 0;
                            return;
                        }
                    });
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("检测邮箱是否存在失败");//弹出错误信息
            }
        });
	}
}
/*获取验证码*/
var isPhone = 1;
function getCode(e){
    checkEmail();
	if(isPhone){
		$(".userEmail_small").html("<i class='fa fa-check'>");
		resetCode(); //倒计时
	}else{
		// $('.mailbox').focus();
	}

}
//邮箱验证码对与错
function emailpassword() {
    if($('.userCode').val() != ''){
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/UserManagement/contrastCode",//要发送的后台地址
            data: {
                userEmail : $('.mailbox').val(),
                userCode : $('.userCode').val(),
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==0){
                    $('.userCode_small').html("<i class='fa fa-check'>" + data.msg);
                    return true;

                }else {
                    $('.userCode_small').html("<i class='fa fa-times'></i>" + data.msg);
                    return false;
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
            }
        });
    }else{
        $('.userCode_small').html("<i class='fa fa-times'></i>" + 请输入您获取的验证码);
        return false;
    }

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
// 注册
function userRegister() {
    // 获取地区
    var province = $(".province option:selected").val();
    var city = $(".city option:selected").val();
    var district = $(".district option:selected").val();
    var userAddress = province + city + district;
    console.log(userAddress);
    if(!checkUserName){
        alert("1");
    }else if(!userPassWord()){
        alert("2");
    }else if(!surePword()){
        alert("3");
    }else if(!checkUserPhone()){
        alert("4");
    }else if(!checkEmail()){
        alert("5");
    }else if(!emailpassword()){
        alert("6");
    }
    else {
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/LogUser/register",//要发送的后台地址
            data: {
                userName : $('.userName').val(),
                password : $('.userPassWord').val(),
                userPhone : $('.telPhone').val(),
                userEmail : $('.mailbox').val(),
                userAddress : userAddress,
                code : $('.userCode').val()
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code==0){
                    return true;
                }else {
                    window.location.href = "/LogUser/toRegister";
                }
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
            }
        });
    }
}