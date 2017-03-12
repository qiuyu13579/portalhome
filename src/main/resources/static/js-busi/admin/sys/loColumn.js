/**
 * @author think
 */

/**
 * 当前页
 */
var pageNow = 1;


var LB = "01";
var TP = "02";
var WZ = "03";
var WZLB = "04";
var DYGLB = "05";
var WBLB = "06";
var ZDJM = "20";

$(function() {
	
	loColumnManage.initSelect();// 初始化下拉框
	loColumnManage.initTab();//初始化TAB
	$("li[name='tabBar01']").click();//模拟点击事件
	//loColumnManage.initDataList(1, 10);

});

var loColumnManage = {
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
									loColumnManage.initDataList(1, 10);
								} else if (tabName == "tabBar02") {// 失效列表
									loColumnManage.initDataHisList(1, 10);
								}

							});
				});
	},	
	showAdd : function(obj) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "loColumnManage.addCar(this);");
		$('#myModalLabel').text('新增栏目');
		$('#dataDiv').show();
		loColumnManage.initAddForm();// 初始化表单
	},
	showEdit : function(colId) {
		tab.closeAll();// 关闭当前弹出框
		$('#submitBut').show();// 按钮
		$("#submitBut").attr("onclick", "loColumnManage.editCar(this);");
		$('#myModalLabel').text('编辑栏目');
		$('#dataDiv').show();
		loColumnManage.initEditForm(colId);// 初始化表单
	},
	showData : function(activeDiv) {
		loColumnManage.initDataList(1, 10);// 初始化表单
	},
	redictCarUrl : function(carId) {
		self.location= WEB_ROOT+'/car/manager?carId='+carId;//重定向
	},
	redictCoustLo : function(olId) {
		var olId = $("#olId_sel").val();
		self.location= WEB_ROOT+'/custom/editModelLo?olId='+olId;//重定向
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
		loColumnManage.initClearAll();// 清除数据

		// 获取选择条件
		var colTitle = "";
		if($("#colTitle_sel") && $("#colTitle_sel").val()){
			colTitle = $("#colTitle_sel").val().trim();
		}
		
		var olId = $("#olId_sel").val();

		data = {
			olId : olId,
			status : "1",
			colTitle : colTitle,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/loColumn/getData",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_list").html(data);
			}
		});
	},
	initDataHisList : function(pageNo, pageSize) {
		loColumnManage.initClearAll();// 清除数据

		// 获取选择条件
		var colTitle = $("#colTitle_his").val().trim();
		if($("#colTitle_his") && $("#colTitle_his").val()){
			colTitle = $("#colTitle_his").val().trim();
		}
		var olId = $("#olId_his").val();

		data = {
			status : "0",
			olId : olId,
			colTitle : colTitle,
			pageNo : pageNo,
			pageSize : pageSize
		};
		$.appAjax({
			url : WEB_ROOT + "/loColumn/getDataHis",
			data : data,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#data_his_list").html(data);
			}
		});
	},
	initEditForm : function(colId) {
		data = {
			"colId" : colId
		};
		$.appAjax({
			url : WEB_ROOT + "/loColumn/select",
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
			url : WEB_ROOT + "/loColumn/showAdd",
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

		var colTitle = $("#colTitle").val().trim();
		if (!tab.validateText("colTitle", "栏目标题不能为空!")) {
			return;
		}
		var colDesc = $("#colDesc").val().trim();
		if (!tab.validateText("colDesc", "栏目描述不能为空!")) {
			return;
		}
		var colType = $("#colType").val();
		if (!tab.validateText("colType", "栏目类型不能为空!")) {
			return;
		}
		
		var olId = $("#olId_sel").val();
		data = {
				colTitle : colTitle,
				colDesc : colDesc,
				colType : colType,
				olId : olId
		};
		
		/*var LB = "01";
		var TP = "02";
		var WZ = "03";
		var WZLB = "04";
		var DYGLB = "05";
		var WBLB = "06";
		var ZDJM = "20";*/
		
		//以下为动态字段
		if(colType == LB){//轮播
			var carId = $("#carId").val().trim();
			if (!tab.validateText("carId", "轮播不能为空!")) {
				return;
			}
			data.carId = carId;
		}else if(colType == TP){//图片
			var imageUrl = $("#imageUrl").val();
			if (!tab.validateText("imageUrl", "图片源不能为空!")) {
				return;
			}
			data.imageUrl = imageUrl;
			//alert(imageUrl);
			var dataUrl = $("#dataUrl").val().trim();
			if (!tab.validateText("dataUrl", "链接地址不能为空!")) {
				return;
			}
			data.dataUrl = dataUrl;
			
			
		}else if(colType == WZ){//文章
			var artId = $("#artId").val().trim();
			if (!tab.validateText("artId", "文章源不能为空!")) {
				return;
			}
			data.artId = artId;
			
			var dataUrl = $("#dataUrl").val().trim();
			if (!tab.validateText("dataUrl", "链接地址不能为空!")) {
				return;
			}
			data.dataUrl = dataUrl;
			
		}else if(colType == WZLB){//文章列表
			var agId = $("#agId").val().trim();
			if (!tab.validateText("agId", "文章列表不能为空!")) {
				return;
			}
			data.agId = agId;
			
		}else if(colType == DYGLB){//单元格列表
			var unId = $("#unId").val().trim();
			if (!tab.validateText("unId", "单元格列表不能为空!")) {
				return;
			}
			data.unId = unId;
			
		}else if(colType == WBLB){//文本列表
			var tgId = $("#tgId").val().trim();
			if (!tab.validateText("tgId", "文本列表不能为空!")) {
				return;
			}
			data.tgId = tgId;
			
		}else if(colType == ZDJM){//指定界面
			var urlAdress = $("#urlAdress").val().trim();
			if (!tab.validateText("urlAdress", "指定界面不能为空!")) {
				return;
			}
			data.urlAdress = urlAdress;
			
		}else{
			return;
		}
		
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/loColumn/add",
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
		if (!tab.validateText("carTitle", "栏目标题不能为空!")) {
			return;
		}
		var carImage = $("#carImage").val().trim();
		if (!tab.validateText("carImage", "栏目源不能为空!")) {
			return;
		}
		var carUrl = $("#carUrl").val().trim();
		if (!tab.validateText("carUrl", "栏目链接不能为空!")) {
			return;
		}
		var carOrder = $("#carOrder").val().trim();
		if (!tab.validateText("carOrder", "栏目展示顺序不能为空!")) {
			return;
		}
		
		var colId = $("#colId").val();
		
		data = {
				colId : colId,
				carTitle : carTitle,
				carImage : carImage,
				carUrl : carUrl,
				carOrder : carOrder
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/loColumn/edit",
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
	confirmUpdateStatus : function(colId, status) {
		var rs = false;
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('确认框');
		var msg = "确认要失效当前栏目么？";
		if (status == "1") {
			msg = "确认要生效当前栏目么？";
		}
		$('#titleMsg').text(msg);
		$('#submitBut').show();
		$('#submitBut').text("继续");

		$('#titleDiv').show();
		$("#submitBut").attr(
				"onclick",
				"loColumnManage.updateStatus('" + colId + "','" + status
						+ "');");
		$('#myModal').modal('show');
		return rs;
	},
	updateStatus : function(colId, status) {

		if (colId == "") {
			tab.alertTitle("栏目编号不能为空!");
			return;
		}
		if (status == "") {
			tab.alertTitle("状态不能为空!");
			return;
		}
		data = {
				colId : colId,
			status : status
		};
		tab.sendAfter();// 关闭当前弹出框
		$.appAjax({
			url : WEB_ROOT + "/loColumn/updateStatus",
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


