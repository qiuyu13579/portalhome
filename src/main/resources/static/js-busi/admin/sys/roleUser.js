$(function() {
	
	roleUserManage.initDataList(1, 10);
	roleUserManage.initDataSelList(1, 10);
	
});

var roleUserManage = {
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		roleUserManage.initClearAll();// 清除数据

		// 获取选择条件
		var userId = $("#userId").val().trim();
		// 获取选择条件
		var roleName = "";
		var roleNameObj = $("#roleName_seled");
		if(roleNameObj != null && roleNameObj.val() != null){
			roleName = roleNameObj.val().trim();
		}
		data = {
			status : "1",
			userId : userId,
			roleName : roleName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/roleUser/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataSelList : function(pageNo, pageSize) {
		roleUserManage.initClearAll();// 清除数据

		// 获取选择条件
		var userName = "";
		var userNameObj = $("#userName_sel");
		if(userNameObj != null && userNameObj.val() != null){
			userName = userNameObj.val().trim();
		}

		
		var userId = $("#userId").val().trim();
		
		data = {
			status : "1",
			userId : userId,
			userName : userName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/roleUser/getDataSel",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_sel").html(data);
			}
		});
	},
	initAddForm : function() {
		data = {};
		$.appAjax({
			url : WEB_ROOT + "/roleUser/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	addRoleUser : function(roleId) {

		var userId = $("#userId").val().trim();

		data = {
				roleId : roleId,
				userId : userId
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/roleUser/add",
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
	confirmAddStatus : function(roleId) {
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
				"roleUserManage.addRoleUser('" + roleId + "');");
		$('#myModal').modal('show');
		return rs;
	},
	confirmDelStatus : function(ruId) {
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
				"roleUserManage.updateStatusRole('" + ruId + "','0');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusRole : function(ruId, status) {

		if (ruId == "") {
			tab.alertTitle("角色菜单编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			ruId : ruId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/roleUser/updateStatus",
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
		self.location= WEB_ROOT+'/user/manager';//重定向
	}
};
