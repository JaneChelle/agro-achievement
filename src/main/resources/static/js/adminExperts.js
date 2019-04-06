setInterval("data.innerHTML=new Date().toLocaleString()",1000);
// 删除
$(".deleteExperts").on('click', function () {
    var parent = $(this).parent().parent();
    var expertsId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除用户ID为 " + expertsId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/adminDeleteExperts/",
            data: {
                expertsId:expertsId
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

