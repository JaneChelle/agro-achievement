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

// 添加

$(document).ready(function () {

    $("#btnSubmit").click(function (event) {
        adminContent();
        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });
});

function fire_ajax_submit() {
    // 获取机构类型ID
    var dataId =  $(".typeName input[name='typeName']:checked").attr('id');
    console.log(dataId);
    $('.TypeId').val(dataId);
    // Get form
    var form = $('#form2')[0];
    var data = new FormData(form);
    var inform = "你确定要添加一条机构信息吗？";
    if(confirm(inform) == true){
        console.log(dataId);
        data.append("CustomField", "This is some extra data, testing");
        $("#btnSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/admin/adminAddOrganization",
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
                    window.location.href = "/admin/adminOrganizationList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminOrganizationList";
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