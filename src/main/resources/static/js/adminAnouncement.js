
function adminContent() {
    var getContent = editor.txt.text();
    console.log(getContent);
    $('.announcementContent').val(getContent);
    return;
}

// 删除
$(".deleteAnnouncement").on('click', function () {
    var parent = $(this).parent().parent();
    var announcementId = parent.children("td.announcementID").text();
    var inform = "您确定要删除需公告ID为 " + announcementId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/deleteAnnouncement",
            data: {
                announcementId:announcementId
            },
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