setInterval("data.innerHTML=new Date().toLocaleString()",1000);
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
                alert("网络错误");
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

