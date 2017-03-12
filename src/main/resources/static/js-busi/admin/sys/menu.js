/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;

$(function() {
	
	menuManage.initTab();// 初始化TAB点击效果

	$("li[name='tabBar01']").click();//模拟点击事件

});

var menuManage = {
	initTab : function() {
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
								if (tabName == "tabBar01") {// 菜单列表
									// alert("菜单列表");
									menuManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									menuManage.initDataHisList(1, 10);
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
	},
	initDataList : function(pageNo, pageSize) {
		menuManage.initClearAll();// 清除数据

		// 获取选择条件
		var menuName = $("#menuName_sel").val().trim();

		data = {
			status : "1",
			menuName : menuName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/menu/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		menuManage.initClearAll();// 清除数据

		// 获取选择条件
		var menuName = $("#menuName_his").val().trim();

		data = {
			status : "0",
			menuName : menuName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/menu/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(menuId) {
		data = {
			"menuId" : menuId
		};
		$.appAjax({
			url : WEB_ROOT + "/menu/select",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	initAddForm : function() {
		data = {};
		$.appAjax({
			url : WEB_ROOT + "/menu/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	addMenu : function(obj) {

		var menuName = $("#menuName").val().trim();
		if (!tab.validateText("menuName", "菜单名称不能为空!")) {
			return;
		}
		var menuDesc = $("#menuDesc").val().trim();
		if (!tab.validateText("menuDesc", "菜单描述不能为空!")) {
			return;
		}
		var menuUrl = $("#menuUrl").val().trim();
		if (!tab.validateText("menuUrl", "菜单链接不能为空!")) {
			return;
		}
		var menuOrder = $("#menuOrder").val().trim();
		if (!tab.validateText("menuOrder", "展示顺序不能为空!")) {
			return;
		}
		var menuIcon = $("#menuIcon").val().trim();
		//if (!tab.validateText("menuIcon", "展示顺序不能为空!")) {
		//	return;
		//}
		var menuSup = $("#menuSup").val().trim();
		if (!tab.validateText("menuSup", "上级菜单不能为空!")) {
			return;
		}
		var ifClick = $("#ifClick").val();
		// alert(ifClick);
		// return;

		data = {
			menuName : menuName,
			menuDesc : menuDesc,
			menuUrl : menuUrl,
			menuOrder : menuOrder,
			menuIcon : menuIcon,
			menuSup : menuSup,
			ifClick : ifClick
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/menu/add",
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
	editMenu : function(obj) {

		var menuId = $("#menuId").val().trim();
		// alert(menuId);
		if (!tab.validateText("menuId", "菜单编码不能为空!")) {
			return;
		}

		var menuName = $("#menuName").val().trim();
		if (!tab.validateText("menuName", "菜单名称不能为空!")) {
			return;
		}
		var menuDesc = $("#menuDesc").val().trim();
		if (!tab.validateText("menuDesc", "菜单描述不能为空!")) {
			return;
		}
		var menuUrl = $("#menuUrl").val().trim();
		if (!tab.validateText("menuUrl", "菜单链接不能为空!")) {
			return;
		}
		var menuOrder = $("#menuOrder").val().trim();
		if (!tab.validateText("menuOrder", "展示顺序不能为空!")) {
			return;
		}
		var menuIcon = $("#menuIcon").val().trim();
		//if (!tab.validateText("menuIcon", "展示顺序不能为空!")) {
		//	return;
		//}
		var menuSup = $("#menuSup").val().trim();
		if (!tab.validateText("menuSup", "上级菜单不能为空!")) {
			return;
		}
		var ifClick = $("#ifClick").val();
		// alert(ifClick);
		// return;

		data = {
			menuId : menuId,
			menuName : menuName,
			menuDesc : menuDesc,
			menuUrl : menuUrl,
			menuIcon : menuIcon,
			menuOrder : menuOrder,
			menuSup : menuSup,
			ifClick : ifClick
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/menu/edit",
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
	confirmUpdateStatus : function(menuId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前菜单么？";
		if (status == "1") {
			msg = "确认要生效当前菜单么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"menuManage.updateStatusMenu('" + menuId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusMenu : function(menuId, status) {

		if (menuId == "") {
			tab.alertTitle("菜单编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			menuId : menuId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/menu/updateStatus",
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
};
