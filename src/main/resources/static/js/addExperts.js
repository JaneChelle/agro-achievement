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
function addExperts() {
    var expertsName=$('.expertsName').val();
    var time=$('.time').val();
    var expertsCountry=$('.expertsCountry').val();
    var expertsEducation=$('.expertsEducation').val();
    var degree=$('.degree').val();
    var school=$('.school').val();
    var major=$('.major').text();
    var unit=$('.unit').text();
    var position=$('.position').text();
    var expertsPhone=$('.expertsPhone').text();
    var expertsEmail=$('.expertsEmail').text();
    var typeName=$('.typeName').text();
    var researchField=$('.researchField').text();
    var researchAchievements=$('.researchAchievements').text();
    var personalPrize=$('.personalPrize').text();
    var resultsPrize=$('.resultsPrize').text();
    if(expertsName ==''){
        $('.cure').addClass('uu');
        $('.cure').html('专家名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(time==''){
        $('.cure').addClass('uu');
        $('.cure').html('出生日期不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(expertsCountry==''){
        $('.cure').addClass('uu');
        $('.cure').html('国籍不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(expertsEducation==''){
        $('.cure').addClass('uu');
        $('.cure').html('学历不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(degree==''){
        $('.cure').addClass('uu');
        $('.cure').html('学位不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(school==''){
        $('.cure').addClass('uu');
        $('.cure').html('毕业学校不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(major==''){
        $('.cure').addClass('uu');
        $('.cure').html('所学专业不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(expertsPhone==''){
        $('.cure').addClass('uu');
        $('.cure').html('联系方式不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(unit==''){
        $('.cure').addClass('uu');
        $('.cure').html('所在单位不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(position==''){
        $('.cure').addClass('uu');
        $('.cure').html('行政职位不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(expertsEmail==''){
        $('.cure').addClass('uu');
        $('.cure').html('邮件不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(typeName==''){
        $('.cure').addClass('uu');
        $('.cure').html('类型不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(researchField==''){
        $('.cure').addClass('uu');
        $('.cure').html('研究领域不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(researchAchievements==''){
        $('.cure').addClass('uu');
        $('.cure').html('研究成果不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(personalPrize==''){
        $('.cure').addClass('uu');
        $('.cure').html('个人获奖不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }
    else if(resultsPrize==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果获奖不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }
else{
        var form = $('#myform')[0];
        var formData = new FormData(form);
        $.ajax({
            type: "post",
            url: "/experts/addExperts",
            processData: false,
            data: formData,
            contentType: false,
            mimeType: 'multipart/form-data',
            dataType: "json",
            success: function (data) {

                if (data.code == 0){
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass('uu');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000);
                    alert('添加成功')
                    window.location.href = '/experts/expertsUserDetails';
                }else{
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass('uu');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000);
                    alert('添加失败');
                    window.location.href = '/experts/expertsUserDetails';
                }

            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass('uu');
                },1000);

                alert('异常')
            }
        });
        return true;
    }
    // return;
};