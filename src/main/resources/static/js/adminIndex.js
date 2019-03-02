setInterval("data.innerHTML=new Date().toLocaleString()",1000);
//侧边栏 换色
var list = $('.list');
list.on('click',function (){
	for (let i=0;i<list.length;i++) {
		$(list[i]).removeClass('sliber_active');
	}
	$(this).addClass('sliber_active');			
	
})

//添加弹框
$(document).ready(function(){
	$('.img_add').click(function(){
		$('popup').fadeIn();
		var height=$(".popup_table").height()
		if(height<=326){
			$('.popup').animate({
				top:"115px",
			})
		}
		else{
			$('.popup').animate({
				top:"64px",
			})
		}
		
	})
	$('.popup_bottom>input[type=button]').click(function(){
		$('popup').fadeOut();
		$('.popup').animate({
			top:"-32px",
		})
	})
})

//修改弹框
$(document).ready(function(){
	$('.modify').click(function(){
		$('popupModify').fadeIn();
		var height=$(".popup_table").height()
		if(height<=326){
			$('.popupModify').animate({
				top:"115px",
			})
		}
		else{
			$('.popupModify').animate({
				top:"64px",
			})
		}
		
	})
	$('.popup_bottom>input[type=button]').click(function(){
		$('popupModify').fadeOut();
		$('.popupModify').animate({
			top:"-32px",
		})
	})
})

// 修改 显示信息
$(".modify").on('click', function () { 
	var td = $('.section>table>tbody>tr>td');
	var inputValue = $('.popupModify>.popup_table>form>table>thead>tr>td>input');
    var list = [];
    for (let i=3; i<=td.length+1; i++) {
    	var parent = $(this).parent().parent();
    	var tdText = parent.children(`td:nth-child(${i})`).text();
    	list.push(tdText);
    } 
    for(let i=0; i<=inputValue.length+1; i++){
    	$(inputValue[i]).val(list[i]);
    }
});

//批量删除
//获取选中选项的值
$(".electionDelete").click(function(){ 
	var listarr = [];
    listarr.splice(0,listarr.length);
    var list=$('.selectall');
	$(".section_table :checkbox").each(function(){ 
		if($(this).prop("checked")==true){ 
            listarr.push($(this).val());
            $('.browider').val(listarr);
		} 
	})
	console.log( $('.browider').val());
});


