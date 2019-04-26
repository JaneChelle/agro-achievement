var E = window.wangEditor;
var editor = new E('#editor');
// 或者 var editor = new E( document.getElementById('editor') )
editor.create();
// 赋值
var content = $('.organizationContent').val();
editor.txt.text(content);

function adminContent() {
    var getContent = editor.txt.text();
    console.log(getContent);
    $('.organizationContent').val(getContent);
    return;
}
// 修改

// 状态码回显
var options = $('.selectStatusCode option');
var statusCode = $('.organizationStatusCode').val();
for (var i = 0; i < options.length; i++) {
    if ($(options[i]).val() == statusCode) {
        $(options[i]).attr("selected", true);
    } else {
        $(options[i]).attr("selected", false);
    }
}

//radio回显
$(".Name").each(function () {
    var typeName=$('#typeName').val();
    var val = $(this).val();
    if(val ==typeName){
        $(this).attr("checked",true);
    }
});

// 修改机构
function modifyOrganization() {
    // 获取机构类型ID
    var data_Id =  $("input[name='typeName']:checked").attr('id');
    $('#typeName').val(data_Id);
    var inform = "您确定添加一条机构信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminEditOrganization" ,//url
            data: $('#form2').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/adminAdminDemand";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminAdminDemand";
                };
            },
            error : function() {
                alert(data);
                alert("异常！");
            }
        });
    }
}