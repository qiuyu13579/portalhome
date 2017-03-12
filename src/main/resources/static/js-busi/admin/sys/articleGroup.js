/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;


$(function() {
	
	//articleGroupManage.initSelect();// 初始化下拉框
	articleGroupManage.initTab();//初始化TAB
	$("li[name='tabBar01']").click();//模拟点击事件
	//articleGroupManage.initDataList(1, 10);

});

var articleGroupManage = {
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
									articleGroupManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									articleGroupManage.initDataHisList(1, 10);
								}

							});
				});
	},	
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "articleGroupManage.addCar(this);");
		$('#myModalLabel').text('新增文章分组');
		$('#dataDiv').show();
		articleGroupManage.initAddForm();// 初始化表单
	},
	showEdit : function(colId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "articleGroupManage.editCar(this);");
		$('#myModalLabel').text('编辑文章分组');
		$('#dataDiv').show();
		articleGroupManage.initEditForm(colId);// 初始化表单
	},
	showData : function(activeDiv) {
		articleGroupManage.initDataList(1, 10);// 初始化表单
	},
	redictArticelGroupUrl : function(id) {
		self.location= WEB_ROOT+'/groupArticle/manager?groupId='+id;//重定向
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
		articleGroupManage.initClearAll();// 清除数据

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
			url : WEB_ROOT + "/articleGroup/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		articleGroupManage.initClearAll();// 清除数据

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
			url : WEB_ROOT + "/articleGroup/getDataHis",
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
			url : WEB_ROOT + "/articleGroup/select",
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
			url : WEB_ROOT + "/articleGroup/showAdd",
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
		if (!tab.validateText("groupName", "文章分组标题不能为空!")) {
			return;
		}
		var groupDesc = $("#groupDesc").val().trim();
		if (!tab.validateText("groupDesc", "文章分组描述不能为空!")) {
			return;
		}
		
		data = {
				groupName : groupName,
				groupDesc : groupDesc

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/articleGroup/add",
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
		if (!tab.validateText("groupName", "文章分组标题不能为空!")) {
			return;
		}
		var groupDesc = $("#groupDesc").val().trim();
		if (!tab.validateText("groupDesc", "文章分组描述不能为空!")) {
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
			url : WEB_ROOT + "/articleGroup/edit",
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
		var msg = "确认要失效当前文章分组么？";
		if (status == "1") {
			msg = "确认要生效当前文章分组么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"articleGroupManage.updateStatus('" + id + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(id, status) {

		if (id == "") {
			tab.alertTitle("文章分组编号不能为空!");
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
			url : WEB_ROOT + "/articleGroup/updateStatus",
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


