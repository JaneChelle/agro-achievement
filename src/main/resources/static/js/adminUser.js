function addressUser() {
    // 获取地区
    var province = $(".province option:selected").val();
    var city = $(".city option:selected").val();
    var district = $(".district option:selected").val();
    var userAddress = province +"-" + city +"-" + district;
    $(".hiddenInput").val(userAddress);
    console.log(userAddress);
    return;
}

// 添加用户
function addAdmin() {
    var inform = "您确定添加一条用户信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminAddUser" ,//url
            data: $('#form1').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminUserList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminUserList";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }
}
// 修改用户
function modifyAdmin() {
    var inform = "您确定修改此用户信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminModifyUser" ,//url
            data: $('#form2').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminUserList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminUserList";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }

}
// 删除
$(".deleteUser").on('click', function () {
    var parent = $(this).parent().parent();
    var userId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除用户ID为 " + userId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type: 'DELETE',
            url: "/admin/adminDeleteUser/",
            data: {
                userId:userId
            },
            dataType: "JSON",
            success: function (data) {
                alert("删除成功");
                window.location.reload();
            },
            error: function (msg) {
                window.location.reload();
            }
        })
    }
    else {

    }
});

// 用户等级回显
$('.modifyUser').val($('.userLevel').val());

var hiddenInput = $('.hiddenInput').val();
console.log(hiddenInput);
var result=hiddenInput.split("-");
for(var i=0;i<result.length;i++) {
    console.log(result[i]);
}

$('.result_1').data("province",result[0]);
$('.result_2').data("city",result[1]);
$('.result_3').data("district",result[2]);


