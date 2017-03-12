/* 
后台管理
by tangyk 西兰花 on 2017/2/27
*/


//选项卡hover状态
$("document").ready(function(){
    $(".nav-tabs li").each(function(){
        $(this).hover(function(){
            if(!$(this).hasClass('active')){
                $(this).addClass('active').siblings('.active').removeClass('active');
            }else{
                $(this).siblings('.active').removeClass('active');
            }
            var target = $(this).attr('name');
            $("."+target).show();
            $("."+target).siblings('.tab-content .tab-pane').hide();
        });
    });
});

//自定义布局:滚动条往下时工具栏悬浮
$("document").ready(function(){
	$(window).scroll( function (){   
	var  h_num=$(window).scrollTop();   
	     if (h_num>300){   
	        $( '.module_head' ).addClass("module_head_fix");       
	    } else {   
	        $( '.module_head' ).removeClass("module_head_fix");            
	    }              
	});  
});