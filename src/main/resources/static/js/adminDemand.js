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