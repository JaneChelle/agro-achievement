function fomrReset()
{
    document.getElementById("myform").reset();
}
//手机号的验证
function phone()
{
    var phone = document.getElementsByClassName('phone').value;
    if(!(/^1[34578]\d{9}$/.test(phone))){
        alert("手机号码有误，请重填");
        return false;
    }
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
                }
                fr.readAsDataURL(value);
            })

        })
        //4、我们把当前input标签的id属性remove
        $input.removeAttr("id");
        //我们做个标记，再class中再添加一个类名就叫test
        var newInput = '<input class="uploadImg test" type="file" name="file" multiple id="file">';
        $(this).append($(newInput));
    })

})
function fomrReset()
{
    document.getElementById("myform").reset();
}
//添加成果
function submitAchievement() {
    var achievementName=$('.achievementName').val();
    var achievementIntroduce=$('.achievementIntroduce').val();
    var typeName=$('.typeName').val();
    var achievementKey=$('.achievementKey').val();
    var start_time=$('.start_time').val();
    var end_time=$('.end_time').val();
    var propertyAddress=$('.propertyAddress').val();
    var awards=$('.awards').val();
    var expectedPrice=$('.expectedPrice').val();
    var linkman=$('.linkman').val();
    var phone=$('.phone').val();
    var propertyIntroduce=$('.propertyIntroduce').val();
    var email=$('.email').val();
    var contactAddress=$('.contactAddress').val();
    var propertyNumber=$('.propertyNumber').val();
    var cellNumber=$('.cellNumber').val();
    var file=$('.pic img').src;
    if(achievementName ==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(achievementIntroduce==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果介绍不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(typeName==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果类型不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(achievementKey==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果关键字不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(start_time==''){
        $('.cure').addClass('uu');
        $('.cure').html('开始时间不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(end_time==''){
        $('.cure').addClass('uu');
        $('.cure').html('结束时间不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(propertyAddress==''){
        $('.cure').addClass('uu');
        $('.cure').html('产权归属地不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(awards==''){
        $('.cure').addClass('uu');
        $('.cure').html('获奖情况不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(expectedPrice==''){
        $('.cure').addClass('uu');
        $('.cure').html('预期交易价格不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(linkman==''){
        $('.cure').addClass('uu');
        $('.cure').html('联系人不能为空');
        setTimeout(function () {
            $('.cure').html(' ');
            $('.cure').removeClass('uu');
        },2000);
    }else if(phone==''){
        $('.cure').addClass('uu');
        $('.cure').html('联系电话不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(propertyIntroduce == ''){
        $('.cure').addClass('uu');
        $('.cure').html('知识产权说明不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(email == ''){
        $('.cure').addClass('uu');
        $('.cure').html('邮箱不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(contactAddress == ''){
        $('.cure').addClass('uu');
        $('.cure').html('联系地址不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(propertyNumber == ''){
        $('.cure').addClass('uu');
        $('.cure').html('知识产权编号不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(cellNumber == ''){
        $('.cure').addClass('uu');
        $('.cure').html('手机号不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(file == ''){
        $('.cure').addClass('uu');
        $('.cure').html('图片不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }
    else{
        $.ajax({
            type: "post",
            url: "/achievement/addAchievement",
            data: $('#myform').serialize(),
            async: false,
            success: function (data) {
                // $('.cure').addClass('uu');
                // $('.cure').html(data.msg);
                // setTimeout(function () {
                //     $('.cure').removeClass('uu');
                // },2000);
                // setTimeout(function () {
                //     location.reload(true);
                // },1000);
                if (data.code = 0){
                    window.location.href = '/achievement/selectAchievement?statusCode=0';
                    alert('成功')
                }else{
                    window.location.href = '/achievement/toAddAchievement';
                    alert('发布失败')
                }

            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass('uu');
                },1000);
                // setTimeout(function () {
                //     location.reload(true);
                // },500);

                alert('异常')
            }
        });
        return true;
    }

};