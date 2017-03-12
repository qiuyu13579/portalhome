
var initmenu = {
		initMenu : function(data) {
			var _html = "";
		    $.each(data, function (i) {
		        var row = data[i];
		        if (row.F_ParentId == "0") {
		            if (i == 0) {
		                _html += '<li class="treeview active">';
		            } else {
		                _html += '<li class="treeview">';
		            }
		            _html += '<a href="#">'
		            _html += '<i class="' + row.F_Icon + '"></i><span>' + row.F_FullName + '</span><i class="fa fa-angle-left pull-right"></i>'
		            _html += '</a>'
		            var childNodes = $.learunindex.jsonWhere(data, function (v) { return v.F_ParentId == row.F_ModuleId });
		            if (childNodes.length > 0) {
		                _html += '<ul class="treeview-menu">';
		                $.each(childNodes, function (i) {
		                    var subrow = childNodes[i];
		                    var subchildNodes = $.learunindex.jsonWhere(data, function (v) { return v.F_ParentId == subrow.F_ModuleId });
		                    _html += '<li>';
		                    if (subchildNodes.length > 0) {
		                        _html += '<a href="#"><i class="' + subrow.F_Icon + '"></i>' + subrow.F_FullName + '';
		                        _html += '<i class="fa fa-angle-left pull-right"></i></a>';
		                        _html += '<ul class="treeview-menu">';
		                        $.each(subchildNodes, function (i) {
		                            var subchildNodesrow = subchildNodes[i];
		                            _html += '<li><a class="menuItem" data-id="' + subrow.F_ModuleId + '" href="' + subrow.F_UrlAddress + '"><i class="' + subchildNodesrow.F_Icon + '"></i>' + subchildNodesrow.F_FullName + '</a></li>';
		                        });
		                        _html += '</ul>';

		                    } else {
		                        _html += '<a class="menuItem" data-id="' + subrow.F_ModuleId + '" href="' + subrow.F_UrlAddress + '"><i class="' + subrow.F_Icon + '"></i>' + subrow.F_FullName + '</a>';
		                    }
		                    _html += '</li>';
		                });
		                _html += '</ul>';
		            }
		            _html += '</li>'
		        }
		    });
		    $("#sidebar-menu").append(_html);
		    $("#sidebar-menu li a").click(function () {
		        var d = $(this), e = d.next();
		        if (e.is(".treeview-menu") && e.is(":visible")) {
		            e.slideUp(500, function () {
		                e.removeClass("menu-open")
		            }),
		            e.parent("li").removeClass("active")
		        } else if (e.is(".treeview-menu") && !e.is(":visible")) {
		            var f = d.parents("ul").first(),
		            g = f.find("ul:visible").slideUp(500);
		            g.removeClass("menu-open");
		            var h = d.parent("li");
		            e.slideDown(500, function () {
		                e.addClass("menu-open"),
		                f.find("li.active").removeClass("active"),
		                h.addClass("active");

		                var _height1 = $(window).height() - $("#sidebar-menu >li.active").position().top - 41;
		                var _height2 = $("#sidebar-menu li > ul.menu-open").height() + 10
		                if (_height2 > _height1) {
		                    $("#sidebar-menu >li > ul.menu-open").css({
		                        overflow: "auto",
		                        height: _height1
		                    })
		                }
		            })
		        }
		        e.is(".treeview-menu");
		    });
			
		},
		loadMenu : function() {
			var data = {};
			$.appAjax({
				url : WEB_ROOT + "/sys/menu/queryMenuList",
				data : data,
				success : function(obj) {
					if (obj.success) {
						
						var dataMenu = new Array();　
						
						jQuery.each(obj.data, function(i, n){
							
							
							//alert(i+":"+n.menuName);
							
							//拼装数组信息
							var menu = new Object();
							menu.F_ModuleId = n.menuId;
							menu.F_ParentId = n.menuSup;
							menu.F_FullName = n.menuName;
							if(n.menuIcon == null || n.menuIcon == ""){
								menu.F_Icon = "fa fa-coffee";
							}else{
								menu.F_Icon = n.menuIcon;
							}
							menu.F_UrlAddress = WEB_ROOT+n.menuUrl;
							if(n.ifClick　==　"1"){//是否可点击
								menu.F_Target = "iframe";
								menu.F_AllowExpand = "1";
								menu.F_IsMenu = "1";
								menu.F_IsPublic = 0;
							}else{//展示类
								menu.F_Target = "expand";
								menu.F_AllowExpand = "1";
								menu.F_IsMenu = "0";
								menu.F_IsPublic = 0;
								menu.F_UrlAddress = null;
							}
							menu.F_SortCode = n.menuOrder;
							
							//alert(menu.F_Icon );
							
							dataMenu.push(menu);
							
							//alert(n.brandId);
							//$("#s_brand").append('<option value=' + n.brandId + ' ' + '>' + n.brandName + '</option>');
						});
						
						initmenu.initMenu(dataMenu);
						//tab.alertTitle("操作成功！");// 错误提示
					} else {
						alert("加载菜单失败！");
						//tab.alertTitle(obj.msg);// 错误提示
					}
				}
			});
			
			
		    var data = [
				{ "F_ModuleId": "001", "F_ParentId": "0", "F_EnCode": "SysManage", 
				"F_FullName": "单位组织", "F_Icon": "fa fa-coffee", "F_UrlAddress": null, "F_Target": "expand", 
				"F_IsMenu": 0, "F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
				"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": null, 
				"F_CreateDate": null, "F_CreateUserId": null, "F_CreateUserName": null, 
				"F_ModifyDate": "2015-11-17 11:22:46", "F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" 
				},       
					{ "F_ModuleId": "001001", "F_ParentId": "001", 
					"F_EnCode": "AreaManage", "F_FullName": "部门管理", "F_Icon": "fa fa-th-list", 
					"F_UrlAddress": "/bumen", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "部门管理", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" }, 
					
					{ "F_ModuleId": "001002", "F_ParentId": "001", 
					"F_EnCode": "AreaManage", "F_FullName": "岗位管理", "F_Icon": "fa fa-graduation-cap", 
					"F_UrlAddress": "/gangwei", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 2, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "岗位管理", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" },  
					
					{ "F_ModuleId": "001002", "F_ParentId": "001", 
					"F_EnCode": "AreaManage", "F_FullName": "用户管理", "F_Icon": "fa fa-user", 
					"F_UrlAddress": "/yonghu", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 3, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "用户管理", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" },
					
				{ "F_ModuleId": "004", "F_ParentId": "0", "F_EnCode": "SysManage", 
					"F_FullName": "系统管理", "F_Icon": "fa fa-coffee", "F_UrlAddress": null, "F_Target": "expand", 
					"F_IsMenu": 0, "F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": null, 
					"F_CreateDate": null, "F_CreateUserId": null, "F_CreateUserName": null, 
					"F_ModifyDate": "2015-11-17 11:22:46", "F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" 
				},       
					{ "F_ModuleId": "001001", "F_ParentId": "004", 
					"F_EnCode": "AreaManage", "F_FullName": "菜单管理", "F_Icon": "fa fa-th-list", 
					"F_UrlAddress": "/portalhome/sys/menu/manager", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "部门管理", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" }, 
					
				
				{ "F_ModuleId": "002", "F_ParentId": "0", "F_EnCode": "SysManage", 
					"F_FullName": "文章管理", "F_Icon": "fa fa-coffee", "F_UrlAddress": null, "F_Target": "expand", 
					"F_IsMenu": 0, "F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 2, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": null, 
					"F_CreateDate": null, "F_CreateUserId": null, "F_CreateUserName": null, 
					"F_ModifyDate": "2015-11-17 11:22:46", "F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" 
					},       
					{ "F_ModuleId": "002001", "F_ParentId": "002", 
					"F_EnCode": "AreaManage", "F_FullName": "新增文章", "F_Icon": "fa fa-th-list", 
					"F_UrlAddress": "/portalhome/article/add", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "新增文章", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" }, 
					
					{ "F_ModuleId": "002002", "F_ParentId": "002", 
					"F_EnCode": "AreaManage", "F_FullName": "文章维护", "F_Icon": "fa fa-graduation-cap", 
					"F_UrlAddress": "/portalhome/article/manager", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 2, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "文章维护", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" },
				
				{ "F_ModuleId": "003", "F_ParentId": "0", "F_EnCode": "SysManage", 
					"F_FullName": "栏目管理", "F_Icon": "fa fa-coffee", "F_UrlAddress": null, "F_Target": "expand", 
					"F_IsMenu": 0, "F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 2, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": null, 
					"F_CreateDate": null, "F_CreateUserId": null, "F_CreateUserName": null, 
					"F_ModifyDate": "2015-11-17 11:22:46", "F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" 
					},       
					{ "F_ModuleId": "003001", "F_ParentId": "003", 
					"F_EnCode": "AreaManage", "F_FullName": "新增栏目", "F_Icon": "fa fa-th-list", 
					"F_UrlAddress": "/portalhome/custom/add", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 1, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "新增栏目", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" }, 
					
					{ "F_ModuleId": "003002", "F_ParentId": "003", 
					"F_EnCode": "AreaManage", "F_FullName": "栏目维护", "F_Icon": "fa fa-graduation-cap", 
					"F_UrlAddress": "/portalhome/custom/manager", "F_Target": "iframe", "F_IsMenu": 1, 
					"F_AllowExpand": 1, "F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, 
					"F_SortCode": 2, "F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": "栏目维护", 
					"F_CreateDate": "2015-11-12 14:38:20", "F_CreateUserId": "System", 
					"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-04-29 14:05:33", 
					"F_ModifyUserId": "System", "F_ModifyUserName": "超级管理员" },
					
						{ "F_ModuleId": "003002001", "F_ParentId": "003002", 
						"F_EnCode": "DatabaseManage", "F_FullName": "栏目装修", "F_Icon": "fa fa-database", 
						"F_UrlAddress": "/portalhome/custom/manager", "F_Target": "iframe", "F_IsMenu": 1, "F_AllowExpand": 1, 
						"F_IsPublic": 0, "F_AllowEdit": null, "F_AllowDelete": null, "F_SortCode": 1, 
						"F_DeleteMark": 0, "F_EnabledMark": 1, "F_Description": null, 
						"F_CreateDate": "2015-11-12 15:03:09", "F_CreateUserId": "System", 
						"F_CreateUserName": "超级管理员", "F_ModifyDate": "2016-03-11 12:10:01", 
						"F_ModifyUserId": "0f36148c-719f-41e0-8c8c-16ffbc40d0e0", "F_ModifyUserName": "佘赐雄" }
					
		    ];
		    
		    
		    
		}
}


