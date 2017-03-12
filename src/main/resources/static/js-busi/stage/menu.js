$(function() {

	menuHome.getMenuHTML();// 加载菜单
	// customHome.init();//初始化界面数据

});

var menuHome = {
	getMenuHTML : function() {// 获取菜单
		var modelId = $("#modelId").val();
		// 保存数据
		var dataReq = {
			modelId : modelId
		};
		$.appAjax({
			url : WEB_ROOT + "/homeMenu/queryMenuList",
			data : dataReq,
			async : true,
			dataType : "html",
			success : function(data) {
				$("#menuDIV").html(data);
				menuHome.initMenuHTML();
			}
		});
	},
	initMenuHTML : function() {// 获取菜单

		$(".h-nav a:first-child").addClass("first");
		$(".list-news li:last-child").css("border-bottom", "none");

		var qcloud = {};
		$('[h_nav]').hover(
				function() {
					var _nav = $(this).attr('h_nav');
					clearTimeout(qcloud[_nav + '_timer']);
					qcloud[_nav + '_timer'] = setTimeout(function() {
						$('[h_nav]')
								.each(
										function() {
											$(this)[_nav == $(this).attr(
													'h_nav') ? 'addClass'
													: 'removeClass']
													('nav-up-hover');
										});
						$('#' + _nav).stop(true, true).slideDown(200);
					}, 150);
				}, function() {
					var _nav = $(this).attr('h_nav');
					clearTimeout(qcloud[_nav + '_timer']);
					qcloud[_nav + '_timer'] = setTimeout(function() {
						$('[h_nav]').removeClass('nav-up-hover');
						$('#' + _nav).stop(true, true).slideUp(200);
					}, 150);
				});
	}

}