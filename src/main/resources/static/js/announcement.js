// 删除需求
$(".deleteUser").on('click', function () {
    var parent = $(this).parent().parent();
    var announcementId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除用户ID为 " + announcementId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type: "DELETE",
            url: "/admin/deleteAnnouncement/",
            data: {
                announcementId:announcementId,
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
                        window.location.href="/admin/selectAnnouncement";
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