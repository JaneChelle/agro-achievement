//删除成果
$(document).on("click", "#deletesAchievement",function() {
    var achievementName = $(this).parent().parent().children('.achievementName').text();
    var achievementId = $(this).parent().parent().children('.achievementId').text();
    var inform = "您确定要删除 " + achievementName + " 发布的成果吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            url: "/achievement/deleteAchievement",
            data: {
                'achievementId': achievementId
            },
            async: false,
            success: function (data) {

                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                //alert(data.msg)
            },
            error: function (data) {
                // $('.cure').addClass('uu');
                // $('.cure').html(data.msg);
                // setTimeout(function () {
                //     $('.cure').css('display', 'none');
                // }, 2000);
                // setTimeout(function () {
                //     location.reload(true);
                // }, 1000);
                //
                // alert(data.msg)
            }
        });
    } else {
        return false;
    }
});
//
//删除需求
$(document).on("click", "#deletesDemand",function() {
    var demandName = $(this).parent().parent().children('.demandName').text();
    var demandId = $(this).parent().parent().children('.demandId').val();
    var inform = "您确定要删除 " + demandName + " 发布的需求吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            url: "/demand/deleteDemand",
            data: {
                'demandId': demandId
            },
            async: false,
            success: function (data) {

                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                //alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);

                alert(data.msg)
            }
        });
    } else {
        return false;
    }
});
//删除机构
$(document).on("click", "#deletesOrganization",function() {
    var organizationName = $(this).parent().parent().children('.organizationName').text();
    var organizationId = $(this).parent().parent().children('.organizationId').val();
    var inform = "您确定要删除 " + organizationName + " 发布的需求吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            url: "/organization/deleteOrganization",
            data: {
                'organizationId': organizationId
            },
            async: false,
            success: function (data) {

                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                //alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);

                alert(data.msg)
            }
        });
    } else {
        return false;
    }
});
//删除案列
$(document).on("click", "#deletesExample",function() {
    var exampleTitle = $(this).parent().parent().children('.exampleTitle').text();
    var exampleId = $(this).parent().parent().children('.exampleId').val();
    var inform = "您确定要删除 " + exampleTitle + " 这个案列吗？";
    var r = confirm(inform);
    if (r == true) {
        $.ajax({
            url: "/example/deleteExample",
            data: {
                'exampleId': exampleId
            },
            async: false,
            success: function (data) {

                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);
                //alert(data.msg)
            },
            error: function (data) {
                $('.cure').addClass('uu');
                $('.cure').html(data.msg);
                setTimeout(function () {
                    $('.cure').css('display', 'none');
                }, 2000);
                setTimeout(function () {
                    location.reload(true);
                }, 1000);

                alert(data.msg)
            }
        });
    } else {
        return false;
    }
});