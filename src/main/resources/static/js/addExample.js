//添加案例
function addExample() {
    var exampleTitle=$('.exampleTitle').val();
    var exampleContent = $('.w-e-text').text();
    if(exampleTitle ==''){
        $('.cure').addClass('uu');
        $('.cure').html('案例标题不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(exampleContent == ''){
        $('.cure').addClass('uu');
        $('.cure').html('案例内容不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }
    else{
        var form = $('#myform')[0];
        var formData = new FormData(form);
        formData.append("exampleContent",exampleContent)
        $.ajax({
            type: "post",
            url: "/example/addExample",
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
                    window.location.href = '/example/selectExampleByUser';
                }else{
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass('uu');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000);
                    window.location.href = '/example/selectExampleByUser';
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
//修改
function modifyExample() {
    var exampleTitle=$('.exampleTitle').val();
    var exampleContent = $('.w-e-text').text();
    if(exampleTitle ==''){
        $('.cure').addClass('uu');
        $('.cure').html('案例标题不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }else if(exampleContent == ''){
        $('.cure').addClass('uu');
        $('.cure').html('案例内容不能为空');
        setTimeout(function () {
            $('.cure').removeClass('uu');
            $('.cure').html(' ');
        },2000);
    }
    else{
        var form = $('#myform')[0];
        var formData = new FormData(form);
        formData.append("exampleContent",exampleContent)
        $.ajax({
            type: "post",
            url: "/example/modifyExample",
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
                    alert('修改成功')
                    window.location.href = '/example/selectExampleByUser';
                }else{
                    $('.cure').addClass('uu');
                    $('.cure').html(data.msg);
                    setTimeout(function () {
                        $('.cure').removeClass('uu');
                    },2000);
                    setTimeout(function () {
                        location.reload(true);
                    },1000);
                    alert('修改失败')
                    window.location.href = '/example/selectExampleByUser';
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