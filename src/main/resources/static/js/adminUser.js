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

// 删除
$(".deleteUser").on('click', function () {
    var parent = $(this).parent().parent();
    var userId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除用户ID为 " + userId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/adminDeleteUser/",
            data: {
                userId:userId,
            },
            dataType: "JSON",
            success: function (data) {
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

