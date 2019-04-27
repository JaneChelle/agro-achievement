// 添加

$(document).ready(function () {

    $("#btnSubmit").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });
});

function fire_ajax_submit() {
    // Get form
    var form = $('#form2')[0];
    var data = new FormData(form);
    var inform = "你确定要添加一名专家吗？";
    if(confirm(inform) == true){
        data.append("CustomField", "This is some extra data, testing");
        $("#btnSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/admin/adminAddExperts",
            data: data,
            processData: false, //prevent jQuery from automatically transforming the data into a query string
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log(data);
                console.log("SUCCESS : ", data);
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminExampleList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminExampleList";
                }
                $("#btnSubmit").prop("disabled", false);
            },
            error: function (e) {
                console.log("ERROR : ", e);
                alert("异常");
                $("#btnSubmit").prop("disabled", false);

            }
        });
    }
}


// 修改
function modifyAdmin() {
    var inform = "您确定修改此专家信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminEditExperts" ,//url
            data: $('#form3').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminExpertsList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminExpertsList";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }

}

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
                alert("删除成功");
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

