//删除
$(document).on("click", ".adiv1",function() {
    var achievementName = $(this).parent().parent().children('.achievementName').text();
    var achievementId = $(this).parent().parent().children('.achievementId').text();
    var inform = "您确定要删除 " + achievementName + " 发布的成果吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            url: "/achievement/deleteAchievement",
            data: {
                'achievementId': achievementId
            },
            async: false,
            success: function (data) {

                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                //alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);

                alert(data.msg)
            }
        });
    } else {
        return false;
    }
});
//修改
