//账号判断
function CheckUserName(){
	var result = 1;
	if($(".userName").val() == ""){
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
           	async: false,
	        success: function (data) {//ajax请求成功后触发的方法
	            if(data.code==-1){
                    $('.userName_small').html("<i class='fa fa-check'>");
                    result = 1;
	            }else {
                    $('.userName_small').html("<i class='fa fa-times'></i> 用户名不存在，请确认");
                    result = 0;
	            }
	        },
	        error: function (msg) {//ajax请求失败后触发的方法
	            alert("网络故障用户名");//弹出错误信息
                result = 0;
	        }
	    });
       return result;
	}
}

//密码
function CheckPassWord(){
	console.log($(".passUserWord").val());
	if($(".passUserWord").val() == ""){
		$('.pWord_small').html("<i class='fa fa-times'></i> 请先输入登录密码");
		return false;
	}else{

		return true;
	}
}

//登录
function userLogin(){
	if(!CheckUserName()){
        $('.userName_small').html("<i class='fa fa-times'></i> 请先完善登录账号，该账号不正确");
        return false;
	}else if(!CheckPassWord()){
        $('.pWord_small').html("<i class='fa fa-times'></i> 请先输入登录密码");
        return false;
	}else {
		return true;
	}
}