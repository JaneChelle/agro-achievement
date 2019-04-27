//添加需求
function addDemand() {
    var demandName=$('.demandName').val();
    var expectedPrice=$('.expectedPrice').val();
    var demanders=$('.demanders').val();
    var linkman=$('.linkman').val();
    var phone=$('.phone').val();
    var email=$('.email').val();
    // var demandIntroduce=$('.demandIntroduce').text();
    if(demandName ==''){
        $('.cure').addClass('uu');
        $('.cure').html('需求名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
     }
    //     else if(demandIntroduce==''){
    //     $('.cure').addClass('uu');
    //     $('.cure').html('需求介绍不能为空');
    //     setTimeout(function () {
    //         $('.cure').removeClass('uu');
    //         $('.cure').html(' ');
    //     },2000);
    // }
        else if(expectedPrice==''){
        $('.cure').addClass('uu');
        $('.cure').html('需求价格不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(demanders==''){
        $('.cure').addClass('uu');
        $('.cure').html('需求者不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(linkman==''){
        $('.cure').addClass('uu');
        $('.cure').html('联系人不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(phone==''){
        $('.cure').addClass('uu');
        $('.cure').html('电话不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(email==''){
        $('.cure').addClass('uu');
        $('.cure').html('邮件不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    } else{
        var demandIntroduce = $('.w-e-text').text();
        var form = $('#myform')[0];
        var formData = new FormData(form);
        formData.append('demandIntroduce',demandIntroduce);
        console.log(formData);

        $.ajax({
            type: "post",
            url: "/demand/addDemand",
            data: formData,
            contentType: false,
            mimeType: 'multipart/form-data',
            dataType: "json",
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
                    window.location.href = '/demand/selectDemand?statusCode=0';
                    alert('成功')
                }else{
                    window.location.href = '/demand/selectDemand';
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
// 修改需求
function demendModify() {
    var form = $('#myform')[0];
    var formData = new FormData(form);
    $.ajax({
        type: "post",
        url: "/demand/modifyDemand",
        processData: false,
        data:  formData,
        contentType: false,
        mimeType: 'multipart/form-data',
        dataType: "json",
        success: function (data) {
            if(data.code == 0){
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').removeClass('uu');
                },2000);
                setTimeout(function () {
                    location.reload(true);
                },1000);
                alert('修改成功！');
                window.location.href = '/demand/selectDemand';
            }else{
                alert('修改失败！')
                window.location.href = '/demand/selectDemand';
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
    return;
}