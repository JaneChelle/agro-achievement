
function adminContent() {
    var getContent = editor.txt.text();
    console.log(getContent);
    $('.exampleContent').val(getContent);
    return;
}

// 删除
$(".deleteExample").on('click', function () {
    var parent = $(this).parent().parent();
    var exampleId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除需公告ID为 " + exampleId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/adminDeleteExample",
            data: {
                exampleId:exampleId
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