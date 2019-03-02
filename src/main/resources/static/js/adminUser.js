// 删除
$(".deleteUser").on('click', function () {
    var parent = $(this).parent().parent();
    var userId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除用户ID为 " + userId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type: "DELETE",
            url: "/admin/adminDeleteUser/",
            data: {
                userId:userId,
            },
            dataType: "JSON",
            success: function (data) {
                if (data.code == 0) {
                    $('.cure').addClass('uu');
                    $('.cure').html("删除成功");
                    setTimeout(function () {
                        $('.cure').removeClass("uu")
                        $('.cure').html('');
                    }, 2000);
                    setTimeout(function () {
                        // location.reload(true);
                        window.location.href="/admin/adminUserList";
                    }, 1000);
                } else {

                }
            },
            error: function (msg) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass("uu")
                    $('.cure').html('');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                alert("网络错误");
            }
        })
    }
    else {

    }
});