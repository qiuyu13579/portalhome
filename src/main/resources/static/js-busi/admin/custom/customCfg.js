//自定义布局:滚动条往下时工具栏悬浮
$("document").ready(function(){
	
	
	$(window).scroll( function (){   
	var  h_num=$(window).scrollTop();   
	     if (h_num>50){   
	        $( '.module_head' ).addClass("module_head_fix");       
	    } else {   
	        $( '.module_head' ).removeClass("module_head_fix");            
	    }              
	});  
	
	
});