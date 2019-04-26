// 状态码
var options = $('.modifyDemand option');
var statusCode = $('.statusCodeDemand').val();
for (var i = 0; i < options.length; i++) {
    if ($(options[i]).val() == statusCode) {
        $(options[i]).attr("selected", true);
    } else {
        $(options[i]).attr("selected", false);
    }
}
// 添加
function addDemand() {
    var inform = "你确定要添加一条需求吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminAddDemand" ,//url
            data: $('#form1').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminAdminDemand";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminAdminDemand";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }
}
// 修改
function modifyDemand() {
    var inform = "你确定要修改此需求吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminEditDemand" ,//url
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
$(".deleteDemand").on('click', function () {
    var parent = $(this).parent().parent();
    var demandId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除需求ID为 " + demandId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/adminDeleteDemand",
            data: {
                demandId:demandId
            },
            success: function (data) {
                alert("删除成功");
                window.location.reload();
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {

    }
});