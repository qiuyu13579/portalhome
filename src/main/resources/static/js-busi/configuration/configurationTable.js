/**Web根路径*/
var basePath = WEB_ROOT;
var pageNow = 1;

$(document).ready(function(){
	//初始化查询条件 //
	$("#tab1").click();
	});



function getOrganizationTree(){
	var startTime = $('#startTime').val();
	var endTime =$('#endTime').val();
	var keyWords = $("#keyWords").val();
	
	var pageSize=5;//每页显示5个数据
	var params = {				
			startTime : startTime,
			endTime : endTime,		
			keyWords : keyWords,
			pageSize : pageSize
			
	};
	//$.gridLoading({message:"正在查询，请稍后..."});
	$.ajax({
		url : basePath+"/organization/getOrganizationTree",
		data : params,
		async : true,
		dataType : "html",
		success: function (obj) { 
			
			$("#configurationTableContent").empty();
			$("#configurationTableContent").html(obj);
			//$.gridUnLoading({message:"正在查询，请稍后..."});
	    }
	});
} 

function getPermission(){
	var startTime = $('#startTime').val();
	var endTime =$('#endTime').val();
	var keyWords = $("#keyWords").val();
	
	var pageSize=5;//每页显示5个数据
	var params = {				
			startTime : startTime,
			endTime : endTime,		
			keyWords : keyWords,
			pageSize : pageSize
			
	};
	//$.gridLoading({message:"正在查询，请稍后..."});
	$.ajax({
		url : basePath+"/permission/getPermission",
		data : params,
		async : true,
		dataType : "html",
		success: function (obj) { 
			
			$("#configurationTableContent").empty();
			$("#configurationTableContent").html(obj);
			//$.gridUnLoading({message:"正在查询，请稍后..."});
	    }
	});
} 

