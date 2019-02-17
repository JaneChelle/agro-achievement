//账号判断
function CheckUserName(){
	console.log($(".userName").val());
	if($(".userName").val().length<=0){
		$('.userName_small').html("<i class='fa fa-times'></i> 请先输入登录账号");
		return false;
	}else{
		//检测用户名是否存在
       $.ajax({
	        type: "GET",//数据发送的方式（post 或者 get）
	        url: "/LogUser/checkName",//要发送的后台地址
	        data: {
	        	userName : $(".userName").val()
	        },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
	        dataType:"JSON",
	        success: function (data) {//ajax请求成功后触发的方法
	            if(data.code==-1){
                    $('.userName_small').html("<i class='fa fa-check'>");
                    return true;
	            }else {
                    $('.userName_small').html("<i class='fa fa-times'></i> 用户名不存在，请确认");
                    return false;
	            }
	        },
	        error: function (msg) {//ajax请求失败后触发的方法
	            alert("网络故障");//弹出错误信息
	        }
	    });
	}
}

//密码
function CheckPassWord(){
	console.log($(".passWord").val());
	if($(".passWord").val().length<=0){
		$('.userName_small').html("<i class='fa fa-times'></i> 请先输入登录密码");
		return false;
	}else{
		$('.pWord_small').html("<i class='fa fa-check'>");
		return true;
	}
}

//登录
function login(){
    CheckUserName();
    CheckPassWord();
    if(CheckUserName() && CheckPassWord()){
        $.ajax({
            type: "GET",//数据发送的方式（post 或者 get）
            url: "/LogUser/login",//要发送的后台地址
            data: {
                userName : $(".userName").val(),
                password : $(".passWord").val()
            },//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
            dataType:"JSON",
            success: function (data) {//ajax请求成功后触发的方法
                if(data.code == 2 || data.code == 0){
                    return true;
                }else if(data.code == 1){
                    window.location.href = "/HomeController/home";
                    return true;
                }else {
                	alert("账号或密码错误，需重新登录")
                    location.reload();
                	return false;
				}
            },
            error: function (msg) {//ajax请求失败后触发的方法
                alert("网络故障");//弹出错误信息
            }
		})
    }
    else{
        return false;
    }
}