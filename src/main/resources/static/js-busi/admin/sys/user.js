/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;

$(function() {
	
	userManage.initTab();// 初始化TAB点击效果

	$("li[name='tabBar01']").click();//模拟点击事件

});

var userManage = {
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
								if (tabName == "tabBar01") {// 用户列表
									// alert("用户列表");
									userManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									userManage.initDataHisList(1, 10);
								}

							});
				});
	},
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "userManage.addUser(this);");
		$('#myModalLabel').text('新增用户');
		$('#dataDiv').show();
		userManage.initAddForm();// 初始化表单
	},
	showEdit : function(userId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "userManage.editUser(this);");
		$('#myModalLabel').text('编辑用户');
		$('#dataDiv').show();
		userManage.initEditForm(userId);// 初始化表单
	},
	showData : function(activeDiv) {
		userManage.initDataList(1, 10);// 初始化表单
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		$("#data_his_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		userManage.initClearAll();// 清除数据

		// 获取选择条件
		var userName = $("#userName_sel").val().trim();

		data = {
			status : "1",
			userName : userName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/user/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		userManage.initClearAll();// 清除数据

		// 获取选择条件
		var userName = $("#userName_his").val().trim();

		data = {
			status : "0",
			userName : userName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/user/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(userId) {
		data = {
			"userId" : userId
		};
		$.appAjax({
			url : WEB_ROOT + "/user/select",
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
			url : WEB_ROOT + "/user/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	addUser : function(obj) {

		var userName = $("#userName").val().trim();
		if (!tab.validateText("userName", "用户名称不能为空!")) {
			return;
		}
		var userAsname = $("#userAsname").val().trim();
		if (!tab.validateText("userAsname", "用户昵称不能为空!")) {
			return;
		}
		var userPhone = $("#userPhone").val().trim();
		if (!tab.validateText("userPhone", "手机号码不能为空!")) {
			return;
		}
		var userEmail = $("#userEmail").val().trim();
		if (!tab.validateText("userEmail", "邮箱地址不能为空!")) {
			return;
		}
		var userNumber = $("#userNumber").val().trim();
		var userAddress = $("#userAddress").val().trim();
		// alert(ifClick);
		// return;

		data = {
			userName : userName,
			userAsname : userAsname,
			userPhone : userPhone,
			userEmail : userEmail,
			userNumber : userNumber,
			userAddress : userAddress
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/user/add",
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
	editUser : function(obj) {

		var userId = $("#userId").val().trim();
		
		var userName = $("#userName").val().trim();
		if (!tab.validateText("userName", "用户名称不能为空!")) {
			return;
		}
		var userAsname = $("#userAsname").val().trim();
		if (!tab.validateText("userAsname", "用户昵称不能为空!")) {
			return;
		}
		var userPhone = $("#userPhone").val().trim();
		if (!tab.validateText("userPhone", "手机号码不能为空!")) {
			return;
		}
		var userEmail = $("#userEmail").val().trim();
		if (!tab.validateText("userEmail", "邮箱地址不能为空!")) {
			return;
		}
		var userNumber = $("#userNumber").val().trim();
		var userAddress = $("#userAddress").val().trim();
		// alert(ifClick);
		// return;

		data = {
			userId : userId,
			userName : userName,
			userAsname : userAsname,
			userPhone : userPhone,
			userEmail : userEmail,
			userNumber : userNumber,
			userAddress : userAddress
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/user/edit",
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
	confirmUpdateStatus : function(userId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前用户么？";
		if (status == "1") {
			msg = "确认要生效当前用户么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"userManage.updateStatusUser('" + userId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusUser : function(userId, status) {

		if (userId == "") {
			tab.alertTitle("用户编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			userId : userId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/user/updateStatus",
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
	redictRoleUserUrl : function(userId) {
		self.location= WEB_ROOT+'/roleUser/manager?userId='+userId;//重定向
	}
	
};
