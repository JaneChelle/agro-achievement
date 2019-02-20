$(document).ready(function() {
    //菜单切换
    $("#register").click(function () {
        $(".ifm").attr("src","register.html");
    });
    $("#result1").click(function () {
        $(".ifm").attr("src","addAchievement.html");
    });
    $("#result2").click(function () {
        $(".ifm").attr("src","userAchieveList.html");
    });
    $("#supply").click(function () {
        $(".ifm").attr("src","addDemand.html");
    });
    $("#supplyg").click(function () {
        $(".ifm").attr("src","userDemandList.html");
    });
    $("#expertInfo").click(function () {
        $(".ifm").attr("src","expert.html");
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
