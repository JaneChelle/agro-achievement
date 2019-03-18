// 删除
$(".deleteType").on('click', function () {
    var parent = $(this).parent().parent();
    var typeId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除类型ID为 " + typeId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type:'DELETE',
            url: "/admin/deleteType",
            data: {
                typeId:typeId
            },
            success: function (data) {
                window.location.reload();
            },
            error: function (msg) {
                console.log("网络错误");
                window.location.reload();
            }
        })
    }
    else {

    }
});
// 删除
$(".deleteOrganizationType").on('click', function () {
    var parent = $(this).parent().parent();
    var organizationTypeId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除机构类型ID为 " + organizationTypeId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type:'DELETE',
            url: "/admin/deleteOrganizationType",
            data: {
                organizationTypeId:organizationTypeId
            },
            success: function (data) {
                window.location.reload();
            },
            error: function (msg) {
                console.log("网络错误");
                window.location.reload();
            }
        })
    }
    else {

    }
});