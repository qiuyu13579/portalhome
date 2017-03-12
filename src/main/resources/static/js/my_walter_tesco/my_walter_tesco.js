// 我的沃易购--预留联系方式信息隐藏显示
var bloo=false;
function reserved_information(ts,targets){
	//var bloo=false;
	if(bloo==false){
		$(ts).attr({"src":"../../images/my_walter_tesco/fold.gif"});
		bloo=true;	
		$(targets).hide();
	}else{
		$(ts).attr({"src":"../../images/my_walter_tesco/unfold.gif"});
		$(targets).show();
		bloo=false;
	}
}

//编辑地址
function new_address_hide(){
	$(".new_address").hide();	
	$(".set_address").show();
}
function new_address_show(){
	$(".new_address").show();
	$(".set_address").hide();
}

//投诉
function complaints(){
	$(".nav-tabs li").eq(3).children("a").click();	
}



/*==================================我的沃易购侧栏点击切换效果脚本*/
/*$(function(){
	hide_s();
	color_000()
	$(".main-con dl dd").eq(0).show();
	$(".nav_menu li").eq(0).children("a").css({"color":"orange"});
})
$(document).ready(function(e) {
    $(".nav_menu li").each(function(index, element) {
        $(this).click(function(){
			var i=$(".nav_menu li").index(this);	
			color_000();
			$(".nav_menu li").eq(i).children("a").css({"color":"orange"});
			hide_s();
			$(".main-con dl dd").eq(i).show();
		})
    });
});
		
	

function color_000(){
	$(".nav_menu li").each(function(index, element) {
        $(this).children("a").css({"color":"#000"});
    });	
}

function hide_s(){
	$(".main-con dl dd").each(function(index, element) {
        $(this).hide();
    });	
}*/ 


function Role_management_select(ts){
	if($(ts).prop("checked")==true){
		$(ts).parent("i").attr({"class":"select_off"});
	}
	else{
		$(ts).parent("i").attr({"class":"select_on"});
	}	
}

function Role_management_select2(ts,target){
	if($(ts).prop("checked")==true){
		$(target+" i").each(function(index, element) {
            $(this).attr({"class":"select_off"});
        });
		$(target+" input").each(function(index, element) {
            $(this).attr({"checked":true});
        });
	}
	else{
		$(target+" i").each(function(index, element) {
            $(this).attr({"class":"select_on"});
        });
		$(target+" input").each(function(index, element) {
            $(this).attr({"checked":false});
        });
	}	
}

function attr_src(src){
	$("#ifa").attr({"src":src});	
}



/*角色管理 新增*/
$(function(){
	$(".citySelet_list").hide();
	$(".citySelet_list").eq(0).show();
	$(".list_city dl dd").eq(0).attr({"class":"bgCengs"});
	$(".list_city dl dd").click(function(){
		var i=$(".list_city dl dd").index(this);
		$(".list_city dl dd").removeClass("bgCengs");
		$(".list_city dl dd").eq(i).attr({"class":"bgCengs"});
		$(".citySelet_list").hide();	
		$(".citySelet_list").eq(i).show();
	})	
})

/*角色管理 修改*/
$(function(){
	$(".citySelet_list2").hide();
	$(".citySelet_list2").eq(0).show();
	$(".list_city2 dl dd").eq(0).attr({"class":"bgCengs"});
	$(".list_city2 dl dd").click(function(){
		var i=$(".list_city2 dl dd").index(this);
		$(".list_city2 dl dd").removeClass("bgCengs");
		$(".list_city2 dl dd").eq(i).attr({"class":"bgCengs"});
		$(".citySelet_list2").hide();	
		$(".citySelet_list2").eq(i).show();
	})	
})