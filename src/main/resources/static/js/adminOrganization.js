// 添加
function adminContent() {
    var getContent = editor.txt.text();
    console.log(getContent);
    $('.organizationIntroduce').val(getContent);
    return;
}

// 删除
$(".deleteOrganization").on('click', function () {
    var parent = $(this).parent().parent();
    var exampleId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除机构ID为 " + exampleId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            type: 'DELETE',
            url: "/admin/adminDeleteOrganization",
            data: {
                organizationId:exampleId
            },
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

function photoup() {
    $('#fileds').click();
    $('#fileds').change(function() {
        //获取input file的files文件数组;
        //$('#filed')获取的是jQuery对象，.get(0)转为原生对象;
        //这边默认只能选一个，但是存放形式仍然是数组，所以取第一个元素使用[0];
        var file = $('#fileds').get(0).files[0];
        //创建用来读取此文件的对象
        var reader = new FileReader();
        //使用该对象读取file文件
        reader.readAsDataURL(file);
        //读取文件成功后执行的方法函数
        reader.onload = function(e) {
            //读取成功后返回的一个参数e，整个的一个进度事件
            //选择所要显示图片的img，要赋值给img的src就是e中target下result里面
            //的base64编码格式的地址
            $('#imgshow').get(0).src = e.target.result;
        }
    })
}
// 添加机构
function addOrganization() {
    // 获取机构类型ID
    var dataId =  $("input[name='typeName']:checked").attr('id');
    $('.TypeId').val(dataId);
    var form = $('#form1')[0];
    var data = new FormData(form);
    var inform = "您确定添加一条机构信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/adminAddOrganization" ,//url
            data: $('#form1').serialize(),
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
                alert("异常！");
            }
        });
    }
}