$(function() {
	
	//groupArticleManage.initTab();// 初始化TAB点击效果

	//$("li[name='tabBar01']").click();//模拟点击事件
	
	groupArticleManage.initDataList(1, 10);
	groupArticleManage.initDataSelList(1, 10);

});

var groupArticleManage = {
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		//groupArticleManage.initClearAll();// 清除数据

		// 获取选择条件
		var groupId = $("#groupId").val().trim();

		data = {
			status : "1",
			groupId : groupId,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/groupArticle/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataSelList : function(pageNo, pageSize) {
		//groupArticleManage.initClearAll();// 清除数据
		

		// 获取选择条件
		var artName = "";
		var artNameObj = $("#artName_sel");
		if(artNameObj != null && artNameObj.val() != null){
			artName = artNameObj.val().trim();
		}

		
		var groupId = $("#groupId").val().trim();
		
		data = {
			status : "1",
			groupId : groupId,
			artName : artName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/groupArticle/getDataSel",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_sel").html(data);
			}
		});
	},
	add : function(artId) {

		var groupId = $("#groupId").val().trim();

		data = {
				artId : artId,
				groupId : groupId
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/groupArticle/add",
			data : data,
			success : function(obj) {
				if (obj.success) {
					tab.alertTitle("操作成功！");// 错误提示
				} else {
					tab.alertTitle(obj.msg);// 错误提示
				}
			}
		});
	},
	confirmAdd : function(artId) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要添加当前文章么？";
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"groupArticleManage.add('" + artId + "');");
		$('#myModal').modal('show');
		return rs;
	},
	confirmDelStatus : function(gcId) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要删除当前文章么？";
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");
		
		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"groupArticleManage.updateStatus('" + gcId + "','0');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(gcId, status) {

		if (gcId == "") {
			tab.alertTitle("主键不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			gcId : gcId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/groupArticle/updateStatus",
			data : data,
			success : function(obj) {
				//alert(obj.success);
				if (obj.success) {
					tab.alertTitle("操作成功！");// 错误提示
				} else {
					tab.alertTitle(obj.msg);// 错误提示
				}
			}
		});
	},
	redictBackUrl : function() {
		self.location= WEB_ROOT+'/articleGroup/manager';//重定向
	}
};
