function fomrReset()
{
    document.getElementById("myform").reset();
}
//手机号的验证
function phone()
{
    var phone = document.getElementById('phone').value;
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
