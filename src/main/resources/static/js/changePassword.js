$('.modifyPassWord').on('click',function () {
    var userName = $('.userName').val();
    var userId = $('.userId').val();
    var surePassWord = $('.surePassWord').val();
    var password = $('.password').val();
    var rePassword = $('.rePassword').val();
    console.log(surePassWord);
    var inform = "您确定要修改用户名为 " + userName + " 的密码吗？";
    if(confirm(inform) == true){
        if((password == '') && (rePassword == '')){
            alert('请填写修改密码');
        }else if(surePassWord != password){
            alert('您输入的账户原密码不正确，请重新输入');
        }else if(surePassWord == rePassword){
            alert('新密码与原密码相同，请重新输入');
        }else{
            $.ajax({
                type:'POST',
                url: "/UserManagement/changePassword",
                data: {
                    userId:userId,
                    password:password,
                    rePassword:rePassword
                },
                dataType: "JSON",
                success: function (data) {
                    alert('修改成功');
                    window.location.reload();
                },
                error: function (msg) {
                    alert('修改成功');
                    window.location.reload();
                }
            })
        }

    }
});