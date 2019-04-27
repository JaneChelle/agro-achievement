// 删除
$(".deleteAchievement").on('click', function () {
    var parent = $(this).parent().parent();
    var achievementId = parent.children("td:nth-child(2)").text();
    var inform = "您确定要删除成果ID为 " + achievementId + " 的所有信息吗？";
    if(confirm(inform) == true){
        $.ajax({
            url: "/admin/adminDeleteAchievement",
            data: {
                achievementId:achievementId
            },
            success: function (data) {
                alert("删除成功");
                location.reload(true);
            },
            error: function (msg) {
                alert("网络错误");
            }
        })
    }
    else {

    }
});

function formReset()
{
    document.getElementById("myForm").reset();
}

$(document).ready(function(){
    //为外面的盒子绑定一个点击事件
    $("#uploadImgBtn").click(function(){
        /*
        1、先获取input标签
        2、给input标签绑定change事件
        3、把图片回显
         */
        //            1、先回去input标签
        var $input = $("#file");
        //            2、给input标签绑定change事件
        $input.on("change" , function(){
            //补充说明：因为我们给input标签设置multiple属性，因此一次可以上传多个文件
            //获取选择图片的个数
            var files = this.files;
            var length = files.length;
            console.log("选择了"+length+"张图片");
            //3、回显
            $.each(files,function(key,value){
                //每次都只会遍历一个图片数据
                var div = document.createElement("div"),
                    img = document.createElement("img");
                div.className = "pic";

                var fr = new FileReader();
                fr.onload = function(){
                    img.src=this.result;
                    div.appendChild(img);
                    document.getElementById("thimg").appendChild(div);
                };
                fr.readAsDataURL(value);
            })

        });
        //4、我们把当前input标签的id属性remove
        $input.removeAttr("id");
        //我们做个标记，再class中再添加一个类名就叫test
        var newInput = '<input class="uploadImg test" type="file" name="file" multiple id="file">';
        $(this).append($(newInput));
    })

});


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
    var inform = "你确定要添加一条成功吗？";
    if(confirm(inform) == true){
        data.append("CustomField", "This is some extra data, testing");
        $("#btnSubmit").prop("disabled", true);
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/admin/adminAddAchievement",
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
                    window.location.href = "/admin/adminAchievementList";
                }else{
                    alert(data.msg);
                    window.location.href = "/admin/adminAchievementList";
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


