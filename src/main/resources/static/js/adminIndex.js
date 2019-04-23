// setInterval("data.innerHTML=new Date().toLocaleString()",1000);
//侧边栏 换色
var list = $('.list');
list.on('click',function (){
	for (let i=0;i<list.length;i++) {
		$(list[i]).removeClass('sliber_active');
	}
	$(this).addClass('sliber_active');			
	
});

//添加弹框
$(document).ready(function(){
	$('.img_add').click(function(){
		$('popup').fadeIn();
		var height=$(".popup_table").height()
		if(height<=326){
			$('.popup').animate({
				top:"115px"
			})
		}
		else{
			$('.popup').animate({
				top:"64px"
			})
		}
		
	});
	$('.popup_bottom>input[type=button]').click(function(){
		$('popup').fadeOut();
		$('.popup').animate({
			top:"-32px"
		})
	})
});






