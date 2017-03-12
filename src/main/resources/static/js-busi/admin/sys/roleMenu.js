$(function() {
	
	//roleMenuManage.initTab();// 初始化TAB点击效果

	//$("li[name='tabBar01']").click();//模拟点击事件
	
	roleMenuManage.initDataList(1, 10);
	roleMenuManage.initDataSelList(1, 10);

});

var roleMenuManage = {
	/*initTab : function() {
		$(".nav-tabs li").each(
				function() {
					$(this).click(
							function() {
								// $(this).hover(function(){
								if (!$(this).hasClass('active')) {
									$(this).addClass('active').siblings(
											'.active').removeClass('active');
								} else {
									$(this).siblings('.active').removeClass(
											'active');
								}
								var target = $(this).attr('name');
								$("." + target).show();
								$("." + target).siblings(
										'.tab-content .tab-pane').hide();

								var tabName = $(this).attr("name");
								if (tabName == "tabBar01") {// 角色列表
									// alert("角色列表");
									roleMenuManage.initDataList(1, 10);
									roleMenuManage.initDataSelList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									roleMenuManage.initDataHisList(1, 10);
								}

							});
				});
	},*/
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		roleMenuManage.initClearAll();// 清除数据

		// 获取选择条件
		var roleId = $("#roleId").val().trim();

		data = {
			status : "1",
			roleId : roleId,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/roleMenu/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataSelList : function(pageNo, pageSize) {
		roleMenuManage.initClearAll();// 清除数据

		// 获取选择条件
		var menuName = "";
		var menuNameObj = $("#menuName_sel");
		if(menuNameObj != null && menuNameObj.val() != null){
			menuName = menuNameObj.val().trim();
		}

		
		var roleId = $("#roleId").val().trim();
		
		data = {
			status : "1",
			roleId : roleId,
			menuName : menuName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/roleMenu/getDataSel",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_sel").html(data);
			}
		});
	},
	addRoleMenu : function(menuId) {

		var roleId = $("#roleId").val().trim();

		data = {
				menuId : menuId,
				roleId : roleId
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/roleMenu/add",
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
	confirmAddStatus : function(menuId) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要添加当前角色么？";
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"roleMenuManage.addRoleMenu('" + menuId + "');");
		$('#myModal').modal('show');
		return rs;
	},
	confirmDelStatus : function(rmId) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要删除当前角色么？";
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");
		
		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"roleMenuManage.updateStatusRole('" + rmId + "','0');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusRole : function(rmId, status) {

		if (rmId == "") {
			tab.alertTitle("角色菜单编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			rmId : rmId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/roleMenu/updateStatus",
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
		self.location= WEB_ROOT+'/role/manager';//重定向
	}
};
