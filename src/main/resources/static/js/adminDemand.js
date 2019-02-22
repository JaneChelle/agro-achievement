//案例 详情 弹框
$('.exampleTd').on('click',function(){
	$(this).children('.examplePopup').show();
	$('.exampleDetails').animate({
		top:"1px",
	})
})
$('.exampleCancel').on('click',function(){
	$('.examplePopup').fadeOut();
	$('.exampleDetails').animate({
		top:"-135px",
	})
})

//修改
$('.modify').on('click',function(){
	var tdExample = $(this).parent().parent().children("td.exampleTd").children(".examplePopup").children(".exampleDetails").children("p").text();
	console.log(tdExample);
	console.log($('.popup>.popup_table .exampleTextarea'))
	$('.popup>.popup_table .exampleTextarea').val("tdExample");
})