/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;


$(function() {
	
	//articleManage.initSelect();// 初始化下拉框
	articleManage.initTab();//初始化TAB
	$("li[name='tabBar01']").click();//模拟点击事件
	//articleManage.initDataList(1, 10);

});

var articleManage = {
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
									articleManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									articleManage.initDataHisList(1, 10);
								}

							});
				});
	},	
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "articleManage.addCar(this);");
		$('#myModalLabel').text('新增文章分组');
		$('#dataDiv').show();
		articleManage.initAddForm();// 初始化表单
	},
	showEdit : function(colId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "articleManage.editCar(this);");
		$('#myModalLabel').text('编辑文章分组');
		$('#dataDiv').show();
		articleManage.initEditForm(colId);// 初始化表单
	},
	showData : function(activeDiv) {
		articleManage.initDataList(1, 10);// 初始化表单
	},
	redictCarUrl : function(carId) {
		self.location= WEB_ROOT+'/car/manager?carId='+carId;//重定向
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
		articleManage.initClearAll();// 清除数据

		// 获取选择条件
		var artName = "";
		if($("#artName_sel") && $("#artName_sel").val()){
			artName = $("#artName_sel").val().trim();
		}
		
		data = {
			status : "1",
			artName : artName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/article/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		articleManage.initClearAll();// 清除数据

		// 获取选择条件
		var artName = "";
		if($("#artName_his") && $("#artName_his").val()){
			artName = $("#artName_his").val().trim();
		}

		data = {
			status : "0",
			artName : artName,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/article/getDataHis",
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
			"artId" : id
		};
		$.appAjax({
			url : WEB_ROOT + "/article/select",
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
			url : WEB_ROOT + "/article/showAdd",
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

		var artName = $("#artName").val().trim();
		if (!tab.validateText("artName", "文章分组标题不能为空!")) {
			return;
		}
		var artDesc = $("#artDesc").val().trim();
		if (!tab.validateText("artDesc", "文章分组描述不能为空!")) {
			return;
		}
		var artClass = $("#artClass").val().trim();
		if (!tab.validateText("artClass", "文章分类描述不能为空!")) {
			return;
		}
		var artSource = $("#artSource").val().trim();
		if (!tab.validateText("artSource", "文章源不能为空!")) {
			return;
		}
		var artLabel = $("#artLabel").val().trim();
		if (!tab.validateText("artLabel", "文章标签不能为空!")) {
			return;
		}
		var artUrl = $("#artUrl").val().trim();
		if (!tab.validateText("artUrl", "文章内容不能为空!")) {
			return;
		}
		
		data = {
				artName : artName,
				artClass : artClass,
				artSource : artSource,
				artLabel : artLabel,
				artUrl : artUrl,
				artDesc : artDesc

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/article/add",
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
		
		var artName = $("#artName").val().trim();
		if (!tab.validateText("artName", "文章分组标题不能为空!")) {
			return;
		}
		var artDesc = $("#artDesc").val().trim();
		if (!tab.validateText("artDesc", "文章分组描述不能为空!")) {
			return;
		}
		var artClass = $("#artClass").val().trim();
		if (!tab.validateText("artClass", "文章分类描述不能为空!")) {
			return;
		}
		var artSource = $("#artSource").val().trim();
		if (!tab.validateText("artSource", "文章源不能为空!")) {
			return;
		}
		var artLabel = $("#artLabel").val().trim();
		if (!tab.validateText("artLabel", "文章标签不能为空!")) {
			return;
		}
		var artUrl = $("#artUrl").val().trim();
		if (!tab.validateText("artUrl", "文章内容不能为空!")) {
			return;
		}
		
		var artId = $("#artId").val();
		
		data = {
				artId : artId,
				artName : artName,
				artClass : artClass,
				artSource : artSource,
				artLabel : artLabel,
				artUrl : artUrl,
				artDesc : artDesc

		};
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/article/edit",
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
				"articleManage.updateStatus('" + id + "','" + status
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
				artId : id,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/article/updateStatus",
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


