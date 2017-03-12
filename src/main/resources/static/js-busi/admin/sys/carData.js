/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;

$(function() {
	
	//carDataDataManage.initTab();// 初始化TAB点击效果

	//$("li[name='tabBar01']").click();//模拟点击事件
	carDataManage.initDataList(1, 10);

});

var carDataManage = {
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
								if (tabName == "tabBar01") {// 图片列表
									// alert("图片列表");
									carDataManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									// alert("失效列表");
									carDataManage.initDataHisList(1, 10);
								}

							});
				});
	},*/
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "carDataManage.addCar(this);");
		$('#myModalLabel').text('新增图片');
		$('#dataDiv').show();
		carDataManage.initAddForm();// 初始化表单
	},
	showEdit : function(dataId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "carDataManage.editCar(this);");
		$('#myModalLabel').text('编辑图片');
		$('#dataDiv').show();
		carDataManage.initEditForm(dataId);// 初始化表单
	},
	showData : function(activeDiv) {
		carDataManage.initDataList(1, 10);// 初始化表单
	},
	redictCarUrl : function(carId) {
		self.location= WEB_ROOT+'/car/manager?carId='+carId;//重定向
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		//$("#data_his_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		carDataManage.initClearAll();// 清除数据

		// 获取选择条件
		var carTitle = "";
		if($("#carTitle_sel") && $("#carTitle_sel").val()){
			carTitle = $("#carTitle_sel").val().trim();
		}
		
		var carId = $("#carId").val();

		data = {
			carId : carId,
			status : "1",
			carTitle : carTitle,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/carData/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		carDataManage.initClearAll();// 清除数据

		// 获取选择条件
		var carTitle = $("#carTitle_his").val().trim();

		data = {
			status : "0",
			carTitle : carTitle,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/carData/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(dataId) {
		data = {
			"dataId" : dataId
		};
		$.appAjax({
			url : WEB_ROOT + "/carData/select",
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
			url : WEB_ROOT + "/carData/showAdd",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#dataDiv").html(data);
				$('#myModal').modal('show');// 最终展示
			}
		});
	},
	add : function(obj) {

		var carTitle = $("#carTitle").val().trim();
		if (!tab.validateText("carTitle", "图片标题不能为空!")) {
			return;
		}
		var carImage = $("#carImage").val().trim();
		if (!tab.validateText("carImage", "图片源不能为空!")) {
			return;
		}
		var carUrl = $("#carUrl").val().trim();
		if (!tab.validateText("carUrl", "图片链接不能为空!")) {
			return;
		}
		var carOrder = $("#carOrder").val().trim();
		if (!tab.validateText("carOrder", "图片展示顺序不能为空!")) {
			return;
		}
		
		var carId = $("#carId").val();
		
		data = {
				carId : carId,
				carTitle : carTitle,
				carImage : carImage,
				carUrl : carUrl,
				carOrder : carOrder
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/carData/add",
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
	edit : function(obj) {
		
		var carTitle = $("#carTitle").val().trim();
		if (!tab.validateText("carTitle", "图片标题不能为空!")) {
			return;
		}
		var carImage = $("#carImage").val().trim();
		if (!tab.validateText("carImage", "图片源不能为空!")) {
			return;
		}
		var carUrl = $("#carUrl").val().trim();
		if (!tab.validateText("carUrl", "图片链接不能为空!")) {
			return;
		}
		var carOrder = $("#carOrder").val().trim();
		if (!tab.validateText("carOrder", "图片展示顺序不能为空!")) {
			return;
		}
		
		var dataId = $("#dataId").val();
		
		data = {
				dataId : dataId,
				carTitle : carTitle,
				carImage : carImage,
				carUrl : carUrl,
				carOrder : carOrder
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/carData/edit",
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
	confirmUpdateStatus : function(dataId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前图片么？";
		if (status == "1") {
			msg = "确认要生效当前图片么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"carDataManage.updateStatus('" + dataId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(dataId, status) {

		if (dataId == "") {
			tab.alertTitle("图片编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
				dataId : dataId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/carData/updateStatus",
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
