/*
 *校验导出功能的按钮权限
 * 
 * 
 * */
(function($){
   ///具体的验证内容；
	$.fn.authcheck = function(menuId1){
		//去后台取数据  
		$(".frame-authcheck").each(function(i){ 
 		var menuId =  $(".frame-authcheck").eq(i).attr("functionkey");  
		if(menuId ==  undefined )
		{
			return;
		}
		var param={
				menuId:menuId 
		}
		var url = WEB.WEBROOT + "/menumanage/getMenuShow";
		$.ajax({
			async : false,
			type : "POST",
			url : url,
			data : param,
			success: function (data) {
				if(data =="show")
				{
					//设置这个类属性的按钮为显示  
					 $(this).show(); 
				}
				else
				{
				    $(this).hide(); 
					$(".frame-authcheck").eq(i).attr("style","display: none"); 
				}
			}
		})  
		})
		
		
	}
})(jQuery)
 $(function(){
   // var munekey = $(".frame-authcheck").attr("functionkey"); 
    var munekey = "DO"; 
	$(".frame-authcheck").authcheck(munekey);  
})