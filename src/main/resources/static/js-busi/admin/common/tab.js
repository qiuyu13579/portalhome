/**
 * @author think
 */


$(function() {

});

var tab = {
	closeAll : function(obj) {
		$("#dataDiv").html("");
		$('#dataDiv').hide();// 隐藏展示区域
		$('#submitBut').attr("onclick", "");// 清除事件
		$('#submitBut').hide();// 隐藏保存按钮
		$('#closeBut').attr("onclick", "");// 清除事件
		//$('.color-red pl5').text("");// 清除提示
		$('#titleMsg').text("");// 清除提示
	},
	alertTitle : function(msg) {
		tab.closeAll();// 关闭当前弹出框
		$('#myModalLabel').text('操作失败');
		$('#titleMsg').text(msg);
		$('#titleDiv').show();
		$("#closeBut").attr("onclick", "tab.reloadHtml();"); // 刷新界面
		$('#myModal').modal('show');
	},
	reloadHtml : function(msg) {
		location.reload(true);// 刷新界面
	},
	sendAfter : function() {
		$("#submitBut").attr("disabled", "disabled");// 失效按钮
		$("#submitBut").attr("onclick", "");// 清除事件
	},
	validateText : function(id, msg) {
		var obj = $("#" + id);
		var tx = obj.val().trim();
		if (tx == "") {
			var sp = obj.next().next().text(msg);// 提示信息
			return false;
		} else {
			obj.next().next().text("");// 清除提示
		}
		return true;
	}
};
