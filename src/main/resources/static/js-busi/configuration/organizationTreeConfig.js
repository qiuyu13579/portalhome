/**Web根路径*/
var basePath = WEB_ROOT;
var pageNow = 1;

$(function(){
    $(".st_tree").SimpleTree({
        click:function(a){
            if(!$(a).attr("hasChild"))
                alert($(a).attr("ref"));
        }
    });
    
    init();
});

/*$(document).ready(function(){
   
});*/

function init(){
	 $(".st_tree>ul>li>a").dblclick(function(){
	        //$(this).find(".wordInput").val($(this).find(".wordTit").html());
	        $(this).find(".wordTit").hide();
	        $(this).find(".wordInput").show();
	        $(this).find(".wordInput").focus().val($(this).find(".wordTit").html());
	    });
	    $(".wordInput").mouseout(function(){
	        $(this).parent().find(".wordTit").html($(this).val());
	        $(".wordTit").show();
	        $(".wordInput").hide();
	    });
}

function addTree(){
	$("#dxbox li input[type=checkbox]").each(function(){
	    //var chk = $(this).find("[checked]");
	    if(this.checked){
	    alert($(this).val());
	    }
	});
	$(".right_content .st_tree>ul").append("<li class='folder open'><input type='checkbox' class='workFlowCheck'><a href='#' ref=''><span class='wordTit'>新目录,双击修改名称</span><input type='text' class='wordInput'></a></li>");
	
//	$(".right_content .st_tree>ul").append("<li ><input type='checkbox' class='workFlowCheck'><a href='#' ref=''><span class='wordTit'>测试添加</span><input type='text' class='wordInput'></a></li><ul show='true'><li><input type='checkbox' class='workFlowCheck'><a href='#' ref='zhwt'>总部领导</a></li></ul>");
	
	
	init();
}