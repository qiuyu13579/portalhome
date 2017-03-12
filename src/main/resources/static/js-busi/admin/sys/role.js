/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;

$(function() {
	
	roleManage.initTab();// 初始化TAB点击效果

	$("li[name='tabBar01']").click();//模拟点击事件

});

var roleManage = {
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
								if (tabName == "tabBar01") {// 角色列表
									// alert("角色列表");
									roleManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									roleManage.initDataHisList(1, 10);
								}

							});
				});
	},
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "roleManage.addRole(this);");
		$('#myModalLabel').text('新增角色');
		$('#dataDiv').show();
		roleManage.initAddForm();// 初始化表单
	},
	showEdit : function(roleId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "roleManage.editRole(this);");
		$('#myModalLabel').text('编辑角色');
		$('#dataDiv').show();
		roleManage.initEditForm(roleId);// 初始化表单
	},
	showData : function(activeDiv) {
		roleManage.initDataList(1, 10);// 初始化表单
	},
	redictRoleMenuUrl : function(roleId) {
		self.location= WEB_ROOT+'/roleMenu/manager?roleId='+roleId;//重定向
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		$("#data_his_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		roleManage.initClearAll();// 清除数据

		// 获取选择条件
		var roleName = $("#roleName_sel").val().trim();

		data = {
			status : "1",
			roleName : roleName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/role/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		roleManage.initClearAll();// 清除数据

		// 获取选择条件
		var roleName = $("#roleName_his").val().trim();

		data = {
			status : "0",
			roleName : roleName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/role/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(roleId) {
		data = {
			"roleId" : roleId
		};
		$.appAjax({
			url : WEB_ROOT + "/role/select",
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
			url : WEB_ROOT + "/role/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	addRole : function(obj) {

		var roleName = $("#roleName").val().trim();
		if (!tab.validateText("roleName", "角色名称不能为空!")) {
			return;
		}
		var roleDesc = $("#roleDesc").val().trim();
		if (!tab.validateText("roleDesc", "角色描述不能为空!")) {
			return;
		}
		var roleOrder = $("#roleOrder").val().trim();
		if (!tab.validateText("roleOrder", "展示不能为空!")) {
			return;
		}

		data = {
			roleName : roleName,
			roleDesc : roleDesc,
			roleOrder : roleOrder
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/role/add",
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
	editRole : function(obj) {
		
		var roleId = $("#roleId").val().trim();

		var roleName = $("#roleName").val().trim();
		if (!tab.validateText("roleName", "角色名称不能为空!")) {
			return;
		}
		var roleDesc = $("#roleDesc").val().trim();
		if (!tab.validateText("roleDesc", "角色描述不能为空!")) {
			return;
		}
		var roleOrder = $("#roleOrder").val().trim();
		if (!tab.validateText("roleOrder", "展示不能为空!")) {
			return;
		}

		data = {
			roleId : roleId,
			roleName : roleName,
			roleDesc : roleDesc,
			roleOrder : roleOrder
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/role/edit",
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
	confirmUpdateStatus : function(roleId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前角色么？";
		if (status == "1") {
			msg = "确认要生效当前角色么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"roleManage.updateStatusRole('" + roleId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusRole : function(roleId, status) {

		if (roleId == "") {
			tab.alertTitle("角色编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			roleId : roleId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/role/updateStatus",
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
