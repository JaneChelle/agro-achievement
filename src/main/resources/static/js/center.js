$(document).ready(function() {
    //菜单切换
    $("#register").click(function () {
        $(".ifm").attr("src","/UserManagement/toModifyUser");
    });
    $("#result1").click(function () {
        $(".ifm").attr("src","/achievement/toAddAchievement");
    });
    $("#modifyPassword").click(function () {
        $(".ifm").attr("src","/UserManagement/toChangePassword");
    });
    $("#findPassword").click(function () {
        $(".ifm").attr("src","/UserManagement/toFindPassword");
    });
    $("#result2").click(function () {
        $(".ifm").attr("src","/achievement/selectAchievement?statusCode=0");
    });
    $("#supply").click(function () {
        $(".ifm").attr("src","/demand/toAddDemand");
    });
    $("#supplyg").click(function () {
        $(".ifm").attr("src","/demand/selectDemand");
    });
    $("#expertInfo").click(function () {
        $(".ifm").attr("src","/experts/toAddExperts");
    });
    $("#expertsUserDetails").click(function () {
        $(".ifm").attr("src","/experts/expertsUserDetails");
    });
    $("#addOrganization").click(function () {
        $(".ifm").attr("src","/organization/toAddOrganization");
    });
    $("#userOrganizationList").click(function () {
        $(".ifm").attr("src","/organization/selectOrganizationByUser?statusCode=0");
    });
    $("#addExample").click(function () {
        $(".ifm").attr("src","/example/toAddExample");
    });
    $("#userExampleList").click(function () {
        $(".ifm").attr("src","/example/selectExampleByUser");
    });
//设置高亮
    $(".addColor").on('click',function () {
        $(".addColor").css("backgroundColor","#282B33");
        $(this).css("backgroundColor","#009688");
    })
    //设置滑动
    $(".list_one").click(function(){
        $(this).siblings(".list_two").slideToggle("1s");
        $(this).parent().siblings().children(".list_two").slideUp("1s");

    });

});
