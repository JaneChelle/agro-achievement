function addOrganization() {
    var organizationName=$('.organizationName').val();
    var organizationCountry=$('.organizationCountry').val();
    var organizationRegion=$('.organizationRegion').val();
    var legalCategory=$('.legalCategory').val();
    var organizationIntroduce=$('.organizationIntroduce').val();
    var contactAddress=$('.contactAddress').val();
    var linkman=$('.linkman').val();
    var phone=$('.phone').val();
    var email=$('.email').val();
    var organizationUrl=$('.organizationUrl').val();
    var typeName=$('#typeName').val();
    if(organizationName ==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果名称不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(organizationCountry==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果介绍不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(organizationRegion==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果类型不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(legalCategory==''){
        $('.cure').addClass('uu');
        $('.cure').html('成果关键字不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(organizationIntroduce==''){
        $('.cure').addClass('uu');
        $('.cure').html('开始时间不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
        },2000);
    }else if(contactAddress==''){
        $('.cure').addClass('uu');
        $('.cure').html('结束时间不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');$('.cure').html(' ');
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
    }else if(email == ''){
        $('.cure').addClass('uu');
        $('.cure').html('知识产权说明不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(organizationUrl == ''){
        $('.cure').addClass('uu');
        $('.cure').html('邮箱不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(typeName == ''){
        $('.cure').addClass('uu');
        $('.cure').html('联系地址不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }
    else{
        var form = $('#myform')[0];
        var formData = new FormData(form);

        $.ajax({
            type: "post",
            url: "/organization/addOrganization",
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
                    window.location.href = '/organization/selectOrganizationByUser?statusCode=0';
                }else{
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass('uu');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000);
                  alert('添加失败')
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
    return;
};