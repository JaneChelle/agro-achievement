// 前台显示 1 显示 0 不显示
var length = $('.isListShow').length;
for (var i=0; i<length; i++){
    if($($('.isListShow')[i]).text() == "1"){
        $($('.isListShow')[i]).text("显示");
    }else if($($('.isListShow')[i]).text() == "0"){
        $($('.isListShow')[i]).text("不显示");
    }
}

// 导航 显示与不显示
if(typeof localStorage=='undefined')
{
    window.alert("浏览器不支持localStorage");
}else{
    var show=new Array("全部","显示","不显示");
    var div1=$('.div1');
    function all_show(){
        div1.style.backgroundColor=show[0];
        window.localStorage.setItem('innerHTML',show[0]);
    }
    function is_show()
    {
        div1.style.backgroundColor=show[1];
        window.localStorage.setItem('innerHTML',show[1]);

    }
    function no_show()
    {
        div1.style.backgroundColor=show[2];
        window.localStorage.setItem('innerHTML',show[2]);
    }
    window.onload=function colorLoad()
    {
        document.getElementById("div1").innerHTML=window.localStorage.getItem('innerHTML');
    }
}

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
// 添加
function adminAdd() {
    var inform = "您确定添加一条公告信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/admin/addAnnouncement" ,//url
            data: $('#form2').serialize(),
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                if (data.code == 0) {
                    alert(data.msg);
                    window.location.href = "/admin/selectAnnouncement";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/selectAnnouncement";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }
}