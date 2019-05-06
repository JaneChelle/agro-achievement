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
    var radios = document.getElementsByName("expertsSex");
    for ( var i = 0; i < radios.length; i++) {
        var expertsName = $('.expertsName').val();
        var time = $('.time').val();
        var expertsCountry = $('.expertsCountry').val();
        var expertsEducation = $('.expertsEducation').val();
        var degree = $('.degree').val();
        var school = $('.school').val();
        var major = $('.major').val();
        var unit = $('.unit').val();
        var position = $('.position').val();
        var expertsPhone = $('.expertsPhone').val();
        var expertsEmail = $('.expertsEmail').val();
        var typeName = $('.typeName').val();
        var researchField = $('.researchField').val();
        var researchAchievements = $('.researchAchievements').val();
        var personalPrize = $('.personalPrize').val();
        var resultsPrize = $('.resultsPrize').val();
        if (expertsName == '') {
            alert('专家名称不能为空')
        } else if (time == '') {
            alert('出生日期不能为空')
        } else if (expertsCountry == '') {
            alert('国籍不能为空')
        } else if (expertsEducation == '') {
            alert('学历不能为空')
        } else if (degree == '') {
            alert('学位不能为空')
        } else if (school == '') {
            alert('毕业学校不能为空');
        } else if (major == '') {
            alert('所学专业不能为空');
        } else if (expertsPhone == '') {
            alert('联系方式不能为空')
        } else if (unit == '') {
            alert('所在单位不能为空')
        } else if (position == '') {
            alert('行政职位不能为空')
        } else if (expertsEmail == '') {
            alert('邮件不能为空')
        } else if (typeName == '') {
            alert('类型不能为空')
        } else if (researchField == '') {
            alert('研究领域不能为空')
        } else if (researchAchievements == '') {
            alert('研究成果不能为空')
        } else if (personalPrize == '') {
            alert('个人获奖不能为空')
        } else if (resultsPrize == '') {
            alert('成果获奖不能为空');
        }  else   if (radios[i].checked!=true) {
            i++;
            alert('请填写性别');

        }
        else {
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

                    if (data.code == 0) {
                        alert('添加成功');
                        window.location.href = '/experts/expertsUserDetails';
                    } else {
                        alert('添加失败');
                        window.location.href = '/experts/expertsUserDetails';
                    }

                },
                error: function (data) {
                    alert('异常')
                }
            });
            return true;
        }
        // return;
    }
};