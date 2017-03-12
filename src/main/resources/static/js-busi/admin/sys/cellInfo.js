/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;


$(function() {
	
	//cellInfoManage.initSelect();// 初始化下拉框
	cellInfoManage.initTab();//初始化TAB
	$("li[name='tabBar01']").click();//模拟点击事件
	//cellInfoManage.initDataList(1, 10);

});

var cellInfoManage = {
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
									cellInfoManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									cellInfoManage.initDataHisList(1, 10);
								}

							});
				});
	},	
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "cellInfoManage.addCar(this);");
		$('#myModalLabel').text('新增单元格分组');
		$('#dataDiv').show();
		cellInfoManage.initAddForm();// 初始化表单
	},
	showEdit : function(celId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "cellInfoManage.editCar(this);");
		$('#myModalLabel').text('编辑单元格分组');
		$('#dataDiv').show();
		cellInfoManage.initEditForm(celId);// 初始化表单
	},
	showData : function(activeDiv) {
		cellInfoManage.initDataList(1, 10);// 初始化表单
	},
	redictCelGroupUrl : function(id) {
		var groupId = $("#groupId").val();
		self.location= WEB_ROOT+'/cellGroup/manager?groupId='+groupId;//重定向
	},
	initSelect : function() {
		//var groupId = $("#groupId").val();
	},
	changeTowhowTr : function(colType) {
		$(".trinput").hide();
		$(".tr"+colType).show();
	},
	initClearAll : function() {
		// 清除数据
		$("#data_list").html("");
		//$("#data_his_list").html("");
	},
	initDataList : function(pageNo, pageSize) {
		cellInfoManage.initClearAll();// 清除数据

		// 获取选择条件
		var celName = "";
		if($("#celName_sel") && $("#celName_sel").val()){
			celName = $("#celName_sel").val().trim();
		}
		var groupId = $("#groupId").val();
		
		data = {
			status : "1",
			groupId : groupId,
			celName : celName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		cellInfoManage.initClearAll();// 清除数据

		// 获取选择条件
		var celName = $("#celName_his").val().trim();
		if($("#celName_his") && $("#celName_his").val()){
			celName = $("#celName_his").val().trim();
		}
		var groupId = $("#groupId").val();
		data = {
			status : "0",
			groupId : groupId,
			celName : celName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(id) {
		data = {
			"celId" : id
		};
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/select",
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
			url : WEB_ROOT + "/cellInfo/showAdd",
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

		var celName = $("#celName").val().trim();
		if (!tab.validateText("celName", "单元格文本不能为空!")) {
			return;
		}
		var celUrl = $("#celUrl").val().trim();
		if (!tab.validateText("celUrl", "单元格文本不能为空!")) {
			return;
		}
		var celImage = $("#celImage").val().trim();
		if (!tab.validateText("celImage", "单元格图片不能为空!")) {
			return;
		}
		var celOrder = $("#celOrder").val().trim();
		if (!tab.validateText("celOrder", "展示顺序不能为空!")) {
			return;
		}
		var groupId = $("#groupId").val().trim();
		
		data = {
				celName : celName,
				celOrder : celOrder,
				celUrl : celUrl,
				celImage : celImage,
				groupId : groupId

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/add",
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
		
		var celName = $("#celName").val().trim();
		if (!tab.validateText("celName", "单元格文本不能为空!")) {
			return;
		}
		var celUrl = $("#celUrl").val().trim();
		if (!tab.validateText("celUrl", "单元格文本不能为空!")) {
			return;
		}
		var celImage = $("#celImage").val().trim();
		if (!tab.validateText("celImage", "单元格图片不能为空!")) {
			return;
		}
		var celOrder = $("#celOrder").val().trim();
		if (!tab.validateText("celOrder", "展示顺序不能为空!")) {
			return;
		}
		var groupId = $("#groupId").val().trim();
		var celId = $("#celId").val().trim();
		
		data = {
				celName : celName,
				celOrder : celOrder,
				celId : celId,
				celUrl : celUrl,
				celImage : celImage,
				groupId : groupId

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/edit",
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
	confirmUpdateStatus : function(id, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前单元格么？";
		if (status == "1") {
			msg = "确认要生效当前单元格么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"cellInfoManage.updateStatus('" + id + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(id, status) {

		if (id == "") {
			tab.alertTitle("单元格编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
				celId : id,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellInfo/updateStatus",
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


