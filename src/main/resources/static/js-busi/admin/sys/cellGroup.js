/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;


$(function() {
	
	//cellGroupManage.initSelect();// 初始化下拉框
	cellGroupManage.initTab();//初始化TAB
	$("li[name='tabBar01']").click();//模拟点击事件
	//cellGroupManage.initDataList(1, 10);

});

var cellGroupManage = {
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
									cellGroupManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									cellGroupManage.initDataHisList(1, 10);
								}

							});
				});
	},	
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "cellGroupManage.addCar(this);");
		$('#myModalLabel').text('新增单元格分组');
		$('#dataDiv').show();
		cellGroupManage.initAddForm();// 初始化表单
	},
	showEdit : function(colId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "cellGroupManage.editCar(this);");
		$('#myModalLabel').text('编辑单元格分组');
		$('#dataDiv').show();
		cellGroupManage.initEditForm(colId);// 初始化表单
	},
	showData : function(activeDiv) {
		cellGroupManage.initDataList(1, 10);// 初始化表单
	},
	redictCellInfoUrl : function(id) {
		self.location= WEB_ROOT+'/cellInfo/manager?groupId='+id;//重定向
	},
	initSelect : function() {
		var colId = $("#colId").val();
		if(colId != null &&　colId != ""){
			$("#olId_sel").attr("selected",false);
			$("#olId_sel").find("option[value='"+colId+"']").attr("selected",true);
		}
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
		cellGroupManage.initClearAll();// 清除数据

		// 获取选择条件
		var groupName = "";
		if($("#groupName_sel") && $("#groupName_sel").val()){
			groupName = $("#groupName_sel").val().trim();
		}
		
		data = {
			status : "1",
			groupName : groupName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		cellGroupManage.initClearAll();// 清除数据

		// 获取选择条件
		var groupName = $("#groupName_his").val().trim();
		if($("#groupName_his") && $("#groupName_his").val()){
			groupName = $("#groupName_his").val().trim();
		}

		data = {
			status : "0",
			groupName : groupName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/getDataHis",
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
			"groupId" : id
		};
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/select",
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
			url : WEB_ROOT + "/cellGroup/showAdd",
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

		var groupName = $("#groupName").val().trim();
		if (!tab.validateText("groupName", "单元格分组标题不能为空!")) {
			return;
		}
		var groupDesc = $("#groupDesc").val().trim();
		if (!tab.validateText("groupDesc", "单元格分组描述不能为空!")) {
			return;
		}
		
		data = {
				groupName : groupName,
				groupDesc : groupDesc

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/add",
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
		
		var groupName = $("#groupName").val().trim();
		if (!tab.validateText("groupName", "单元格分组标题不能为空!")) {
			return;
		}
		var groupDesc = $("#groupDesc").val().trim();
		if (!tab.validateText("groupDesc", "单元格分组描述不能为空!")) {
			return;
		}
		
		var groupId = $("#groupId").val();
		
		data = {
				groupName : groupName,
				groupDesc : groupDesc,
				groupId : groupId

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/edit",
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
		var msg = "确认要失效当前单元格分组么？";
		if (status == "1") {
			msg = "确认要生效当前单元格分组么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"cellGroupManage.updateStatus('" + id + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(id, status) {

		if (id == "") {
			tab.alertTitle("单元格分组编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
				groupId : id,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/cellGroup/updateStatus",
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


