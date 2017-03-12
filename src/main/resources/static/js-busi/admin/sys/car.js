/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;

$(function() {
	
	carManage.initTab();// 初始化TAB点击效果

	$("li[name='tabBar01']").click();//模拟点击事件

});

var carManage = {
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
								if (tabName == "tabBar01") {// 轮播列表
									// alert("轮播列表");
									carManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									carManage.initDataHisList(1, 10);
								}

							});
				});
	},
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "carManage.addCar(this);");
		$('#myModalLabel').text('新增轮播');
		$('#dataDiv').show();
		carManage.initAddForm();// 初始化表单
	},
	showEdit : function(carId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "carManage.editCar(this);");
		$('#myModalLabel').text('编辑轮播');
		$('#dataDiv').show();
		carManage.initEditForm(carId);// 初始化表单
	},
	showData : function(activeDiv) {
		carManage.initDataList(1, 10);// 初始化表单
	},
	redictCarDataUrl : function(carId) {
		self.location= WEB_ROOT+'/carData/manager?carId='+carId;//重定向
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		$("#data_his_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		carManage.initClearAll();// 清除数据

		// 获取选择条件
		var carName = $("#carName_sel").val().trim();

		data = {
			status : "1",
			carName : carName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/car/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		carManage.initClearAll();// 清除数据

		// 获取选择条件
		var carName = $("#carName_his").val().trim();

		data = {
			status : "0",
			carName : carName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/car/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(carId) {
		data = {
			"carId" : carId
		};
		$.appAjax({
			url : WEB_ROOT + "/car/select",
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
			url : WEB_ROOT + "/car/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	addCar : function(obj) {

		var carName = $("#carName").val().trim();
		if (!tab.validateText("carName", "轮播名称不能为空!")) {
			return;
		}
		var carDesc = $("#carDesc").val().trim();
		if (!tab.validateText("carDesc", "轮播描述不能为空!")) {
			return;
		}
		var carHight = $("#carHight").val().trim();
		if (!tab.validateText("carHight", "高度不能为空!")) {
			return;
		}
		var carWidth = $("#carWidth").val().trim();
		if (!tab.validateText("carWidth", "宽度不能为空!")) {
			return;
		}

		data = {
			carName : carName,
			carHight : carHight,
			carWidth : carWidth,
			carDesc : carDesc
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/car/add",
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
	editCar : function(obj) {
		
		var carId = $("#carId").val().trim();

		var carName = $("#carName").val().trim();
		if (!tab.validateText("carName", "轮播名称不能为空!")) {
			return;
		}
		var carDesc = $("#carDesc").val().trim();
		if (!tab.validateText("carDesc", "轮播描述不能为空!")) {
			return;
		}
		var carHight = $("#carHight").val().trim();
		if (!tab.validateText("carHight", "高度不能为空!")) {
			return;
		}
		var carWidth = $("#carWidth").val().trim();
		if (!tab.validateText("carWidth", "宽度不能为空!")) {
			return;
		}

		data = {
			carId : carId,
			carName : carName,
			carHight : carHight,
			carWidth : carWidth,
			carDesc : carDesc
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/car/edit",
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
	confirmUpdateStatus : function(carId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前轮播么？";
		if (status == "1") {
			msg = "确认要生效当前轮播么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"carManage.updateStatusCar('" + carId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatusCar : function(carId, status) {

		if (carId == "") {
			tab.alertTitle("轮播编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
			carId : carId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/car/updateStatus",
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
