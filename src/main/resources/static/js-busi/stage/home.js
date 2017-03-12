
var data_base;
var data_new;

$(function() {
	
	customHome.init();//初始化界面数据
	
});
	
	
var customHome = {
			
	/**
	* 加载所有模块数据
	**/
	init : function(){
		
		var options = {
			//cellHeight: 2,
			//cellWidth: 2,
			//draggable : false,
			float : true
		};
		$('.grid-stack').gridstack(options);
		
		
		/*var options = {
		        cellHeight: 20,
		        verticalMargin: 1
		    };
		    $('.grid-stack').gridstack(options);*/
		
		
		//模拟从数据读取的数据，拼装不同模块的数据
		customHome.queryDataToShow();
	},
	/**
	**重置模块
	**/
	reset_widget : function(){
		
		
		//alert("开始预览");
		data_base = data_new;
		
		customHome.queryDataToShow();//初始化界面数据
	},
	changeLoTowhow : function(){
		var olId = $("#olId").val();
		self.location= WEB_ROOT+'/custom/editModelLo?olId='+olId;//重定向
	},
	/**
	** 从数据库获取配置数据
	**/
	queryDataToShow : function(){
		
		var data = [
				    {x : 0,y : 0,width : 3,height : 20,modeId:1,modelName:'轮播新闻',modelType:'01'},
				    {x : 3,y : 0,width : 3,height : 20,modeId:2,modelName:'图片',modelType:'02'},
				    
				    {x : 0,y : 20,width : 2,height : 30,modeId:3,modelName:'文章列表',modelType:'03'},
				    {x : 2,y : 20,width : 4,height : 30,modeId:4,modelName:'广告',modelType:'04'},
				    
				   /*  
				    {x : 0,y : 0,width : 3,height : 5,modeId:1},
				    {x : 3,y : 0,width : 3,height : 5,modeId:2},
				    
				    {x : 0,y : 5,width : 2,height : 10,modeId:3},
				    {x : 2,y : 5,width : 4,height : 10,modeId:4},
				   
				   
				    {x : 3,y : 5,width : 6,height : 5,modeId:5},
				    {x : 3,y : 10,width : 3,height : 5,modeId:6},
				    {x : 6,y : 10,width : 3,height : 5,modeId:7} 
				   */
				            ];
		
		
		var olId = $("#olId").val();
		//保存数据
		var dataReq = {olId : olId};
		//tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/custom/ajaxLoColumns",
			data : dataReq,
			success : function(obj) {
				if (obj.success && obj.data.listMain != null && obj.data.listMain.length >= 1) {
					//tab.alertTitle("操作成功！");// 错误提示
					
					var dataColumn = new Array();　
					
					jQuery.each(obj.data.listMain, function(i, n){
						
						//拼装数组信息
						var column = new Object();
						column.x = n.colX;
						column.y = n.colY;
						column.width = n.colWidth;
						column.height = n.colHeigh;
						column.modeId = n.modeId;
						column.modeName = n.modeName;
						column.colOrder = n.colOrder;
						column.colTitle = n.colTitle;
						column.colType = n.colType;
						column.colId = n.colId;
						
						dataColumn.push(column);
						
					});
					
					customHome.loadLo(dataColumn);//加载自定义布局
					
				} else {
					//tab.alertTitle("加载模块数据失败！");// 错误提示
					alert("加载模块数据失败！");
				}
			}
		}); 
		
	},
	loadLo : function(data){//加载布局
		
		$("#showDIV").html("");//清除内容
		var grid = $('.grid-stack').data('gridstack');
		
		for (var i=0;i<data.length;i++)
		{
			var node = data[i];
			
			var div_html = '';
			
			div_html += '<div colId="'+node.colId+'" ><div class="grid-stack-item-content-show" >';
			//div_html += '<div colId="'+node.colId+'" >';
			div_html += '<dl class="module_list"  modeId="'+node.colId+'" >';
			div_html += '<dt >模块名称：'+node.colTitle+' 模块类型：'+node.colType+'</dt>';
			//div_html += '<dt >模块名称：'+node.colTitle+' 模块类型：'+node.colType+'</dt>';
			//div_html += '<dd><img  src="../upfiles/1.jpg"></dd>';
			div_html += '</dl>';
			div_html += '<div/>';
			
			grid.add_widget($(div_html),node.x, node.y, node.width, node.height);
			
			//移除拉动条
			$(".ui-resizable-handle").remove();
			
			
			
		}
		
		//布局完以后，动态填充栏目内容
		customHome.getColHTML();
	},
	getColHTML : function() {
		
		$(".grid-stack-item").each(function(){
			var obj = $(this);

			var colId = obj.attr("colId");
			//保存数据
			var dataReq = {colId : colId};
			$.appAjax({
				url : WEB_ROOT + "/custom/getColHTML",
				data : dataReq,
				async : true,
				dataType : "html",
				success : function(data) {
					
					//alert(data);
					//var myDiv = obj.children('.grid-stack-item-content');
					var myDiv = obj.children('.grid-stack-item-content-show');
					myDiv.html(data);
					
					//obj.html(data);
				}
			});
			
			
		});
		
	},
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "menuManage.addMenu(this);");
		$('#myModalLabel').text('新增菜单');
		$('#dataDiv').show();
		menuManage.initAddForm();// 初始化表单
	},
	showEdit : function(menuId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "menuManage.editMenu(this);");
		$('#myModalLabel').text('编辑菜单');
		$('#dataDiv').show();
		menuManage.initEditForm(menuId);// 初始化表单
	},
	showData : function(activeDiv) {
		menuManage.initDataList(1, 10);// 初始化表单
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		$("#data_his_list").html("");
	}
	
	
	
	
	
	
}