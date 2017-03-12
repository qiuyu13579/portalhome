/**
 * 基于 jquery 写的，用于行政区域/业务区域的三级联动效果；
 */
(function($){
	
	/**
	 * 解析页面上元素的参数；
	 */
	var parseOptions = function(el,opts){
		var htmlOpts = {
		   children : $(el).attr("area-children"),
		   type : $(el).attr("area-type"),
		   level : $(el).attr("area-level"),
		   defaultValue : $(el).attr("area-defaultvalue")
		};
		if(opts){
			return $.extend({},$.fn.area.defaultOpts,htmlOpts,opts);
		} else {
			return $.extend({},$.fn.area.defaultOpts,htmlOpts);
		}
	};
	
	$.areaPlugin = {
			
			/**
			 * 省分编码信息，固定的，基本上不会有调整，所以直接列出来；不需要在ajax处理；
			 */
			provinceAreaInfos:{
				"admin":{"11":"北京","51":"广东","10":"内蒙古","13":"天津","17":"山东","18":"河北","19":"山西",
					"30":"安徽","31":"上海","91":"辽宁","34":"江苏","36":"浙江","38":"福建","50":"海南",
					"59":"广西","70":"青海","71":"湖北","74":"湖南","75":"江西","76":"河南","79":"西藏",
					"81":"四川","83":"重庆","84":"陕西","85":"贵州","86":"云南","87":"甘肃","88":"宁夏",
					"89":"新疆","90":"吉林","97":"黑龙江"},
					
				"busi":{"11":"北京","51":"广东","10":"内蒙古","13":"天津","17":"山东","18":"河北","19":"山西",
						"30":"安徽","31":"上海","91":"辽宁","34":"江苏","36":"浙江","38":"福建","50":"海南",
						"59":"广西","70":"青海","71":"湖北","74":"湖南","75":"江西","76":"河南","79":"西藏",
						"81":"四川","83":"重庆","84":"陕西","85":"贵州","86":"云南","87":"甘肃","88":"宁夏",
						"89":"新疆","90":"吉林","97":"黑龙江"}
			},
			/**
			 * 各自返回的数据为：
			 * [areaCode:,areaName:,childrenList:   ---省级
			 *   [
			 *     {areaCode:,areaName:,childrenList:  --地市级
			 *       [
			 *         {areaCode:,areaName:}  --区县级
			 *       ]
			 *     }
			 *   ]
			 *  ]
			 */
			areaInfos : {"admin":{},"busi":{}},
			/**
			 * 加载数据；
			 */
			loadAreas : function(opts){
				var options = $.extend({
					  type:"busi"},
					opts);

				var url = WEB.WEBROOT + "/area/queryAreas";
				
				$.appAjax({
					url:url,
					data: [{name:"type",value:options.type}],
					type : "post",
				    dataType:"json",
				    success:function(data){
				    	$.areaPlugin.areaInfos[options.type] = data;
				    }
				});
			},
			
			/**
			 * 获取省分列表数据
			 * @param opts
			 */
			loadAreaCitys: function(opts){
				var options = $.extend({
					  type:"busi",province:"00",defaultvalue:"",callback:false,select:false},
					opts);

				var url = WEB.WEBROOT + "/area/queryCitys";
				
				$.appAjax({
					url:url,
					data: [{name:"type",value:options.type},{name:"provinceCode",value:options.province} ],
					type : "post",
				    dataType:"json",
				    success:function(data){
				    	var key = "city_"+options.province;
				    	$.areaPlugin.areaInfos[options.type][key] = data;
				    	if($.isFunction(options.callback)){
							options.callback(data,options.defaultvalue,options.select);
						}
				    }
				});
			},
			
			/**
			 * 根据省分编码获取地市列表信息；从目前的data中获取，如果获取不到，就取ajax，回调处理；
			 * 
			 * 入参：type --- 数据类型；privince ---省分编码；callback --数据回调处理；select --下拉列表:
			 */
			queryCitys : function(opts){
				var options = $.extend({
					  type:"busi",	  province:"00",  "defaultvalue":"",  callback:false,  select:false},
					opts);
				var key = "city_"+options.province;
				var data = $.areaPlugin.areaInfos[options.type][key];
				if(data && $.isArray(data)){
					if($.isFunction(options.callback)){
						options.callback(data,options.defaultvalue,options.select);
					}
				} else {
					if($.isFunction(options.callback)){
						$.areaPlugin.loadAreaCitys(options);
					}
				}
			},
			
			/**
			 * 加载地市列表信息
			 */
			loadCityList : function(opts){
				var options = $.extend({
					  type:"admin",  province:"00",  citySelect:false},
					opts);
				if(!options.citySelect){
					return ;
				}

				$select = $("#"+options.citySelect);
				$select.attr("area-province",options.province);
				///获取地市列表的展示控制，是否展示空值 和 默认值 ；
				var options = $.extend(options,{
					  showblank:$select.attr("area-showblank"),
					  defaultvalue : $select.attr("area-defaultvalue")
				});
				
				$select.empty();
				if(options.showblank && options.showblank=="true"){
				    $select.append("<option value=''>请选择</>");
				}
				$.areaPlugin.queryCitys({"type":options.type,"province":options.province,"select":$select,"defaultvalue":options.defaultvalue,"callback":$.areaPlugin.displayArea});
			},
			
			/**
			 * 用于在下拉框中展示数据；
			 * @param data
			 * @param $select
			 */
			displayArea : function(data,defaultvalue,$select){
				if(data && $.isArray(data)){
		    		$.each(data,function(i,n){
		    			if(n.areaCode == defaultvalue){
		    				$select.append("<option value='"+n.areaCode+"' selected = 'selected'>"+n.areaName+"</>");
		    			} else {
		    				$select.append("<option value='"+n.areaCode+"'>"+n.areaName+"</>");
		    			}
		    		});
		    	};
		    	//触发 citySelect 的change事件；
		    	$select.change();
			},
			
			/**
			 * 加载区县列表信息
			 */
			loadCountyList : function(opts){
				var options = $.extend({
					type:"admin",
					province:"00",
					city:"00",
					countySelect:false},opts);
				
				if(!options.countySelect){
					return ;
				}
				
				$select = $("#"+options.countySelect);
				$select.attr({"area-city" : options.city,
					"area-province" : options.province});
				///获取地市列表的展示控制，是否展示空值 和 默认值 ；
				var options = $.extend(options,{
					  showblank:$select.attr("area-showblank"),
					  defaultvalue : $select.attr("area-defaultvalue")
				});
				
				$select.empty();
				if(options.showblank && options.showblank=="true"){
				    $select.append("<option value=''>请选择</>");
				}
				$.areaPlugin.queryCitys({"type":options.type,"province":options.province,"defaultvalue":options.defaultvalue,"select":$select,
					"callback":function(pdata,defaultvalue,tmpSelect){
						if(pdata && $.isArray(pdata)){
				    		$.each(pdata,function(i,n){
				    			if(n.areaCode == options.city){
				    				$.areaPlugin.displayArea(n.childrenList,defaultvalue,tmpSelect);
				    				return;
				    			}
				    		});
				    	};
					}
				});
				/*var data = $.areaPlugin.queryCountys({"type":options.type,"province":options.province,"city":options.city});
				if(data && $.isArray(data)){
				    $.each(data,function(i,n){
				        if(n.areaCode == options.defaultvalue){
				    	    $select.append("<option value='"+n.areaCode+"' selected = 'selected'>"+n.areaName+"</>");
				    	} else {
				    		$select.append("<option value='"+n.areaCode+"'>"+n.areaName+"</>");
				    	}
				    });
				};*/
			},
			
			/**
			 * 加载乡镇列表信息
			 */
			loadTownList : function(opts){
				var options = $.extend({
					type:"admin",
					province:"00",
					city:"00",
					county:"00",
					townSelect:false},opts);
				
				if(!options.townSelect){
					return ;
				}
				
				$select = $("#"+options.townSelect);
				$select.attr({"area-county" : options.county,"area-city" : options.city,
					"area-province" : options.province});
				///获取地市列表的展示控制，是否展示空值 和 默认值 ；
				var options = $.extend(options,{
					  showblank:$select.attr("area-showblank"),
					  defaultvalue : $select.attr("area-defaultvalue")
				});
				
				$select.empty();
				if(options.showblank && options.showblank=="true"){
				    $select.append("<option value=''>请选择</>");
				}
				$.areaPlugin.queryCitys({"type":options.type,"province":options.province,"defaultvalue":options.defaultvalue,"select":$select,
					"callback":function(pdata,defaultvalue,tmpSelect){
						if(pdata && $.isArray(pdata)){
				    		$.each(pdata,function(i,n){
				    			if(n.areaCode == options.city){
				    				$.each(n.childrenList,function(j,m){
					    				if (m.areaCode == options.county) {
						    				$.areaPlugin.displayArea(m.childrenList,defaultvalue,tmpSelect);
						    				return;
					    				}
				    				});
				    			}
				    		});
				    	};
					}
				});
			},
			
			/**
			 * 加载省分数据
			 * @param opts
			 */
			loadProvinceList : function(opts){
				var options = $.extend({
					type:"admin",
					provinceSelect:false,
					show9a:false},opts);
				
				if(!options.provinceSelect){
					return ;
				}
				var url = WEB.WEBROOT + "/area/queryProvinces";
				
				$select = $("#"+options.provinceSelect);
				///获取地市列表的展示控制，是否展示空值 和 默认值 ；
				var options = $.extend(options,{
					  showblank:$select.attr("area-showblank"),
					  defaultvalue : $select.attr("area-defaultvalue"),
					  showall : $select.attr("area-showall"),
					  show9a:$select.attr("area-show9a")
				});
				
				$select.empty();
		    	if(options.showblank && options.showblank=="true"){
		    		$select.append("<option value=''>请选择</>");
		    	}
		    	if(options.showall && options.showall == "true"){
		    		$select.append("<option value='00'>全国</>");
		    	}
		    	
		    	///
		    	if(options.type == "busi" && options.showall && options.showall == "true"){
		    		$select.append("<option value='9A'>沃易购基地</>");
		    	}
		    	
		    	//省分数据处理；
		    	$.each($.areaPlugin.provinceAreaInfos[options.type],function(i,n){
		    		if(i == options.defaultvalue){
		    			$select.append("<option value='"+i+"' selected = 'selected'>"+n+"</>");
		    		} else {
		    			$select.append("<option value='"+i+"'>"+n+"</>");
		    		}
		    	});
		    	///触发一次变更；
		    	$select.change();
		    	
				
				/**$.appAjax({
					url:url,
					data: [{name:"type",value:options.type}],
					type : "post",
				    dataType:"json",
				    success:function(data){
				    	$select.empty();
				    	if(options.showblank && options.showblank=="true"){
				    		$select.append("<option value=''>请选择</>");
				    	}
				    	if(options.showall && options.showall == "true"){
				    		$select.append("<option value='00'>全国</>");
				    	}
				    	
				    	$.extend($.areaPlugin.areaInfos[options.type],{"provinces":data});

				    	//$.areaPlugin.areaInfos[options.type].provinces = data;
				    	
				    	if(data){
				    		$.each(data,function(i,n){
				    			if(i == options.defaultvalue){
				    				$select.append("<option value='"+i+"' selected = 'selected'>"+n+"</>");
				    			} else {
				    				$select.append("<option value='"+i+"'>"+n+"</>");
				    			}
				    		});
				    	};
				    	///触发一次变更；
				    	$select.change();
				    }
				});**/
			}
	};
	
	
	
	$.fn.area = function(opts){
		return this.each(function(){
			var options = parseOptions(this,opts);
			
			/**
			 * 考虑数据的初始化操作
			 */
			if(options.level=="province"){
				
				//先绑定 onChange 事件；
				$(this).change(function(){
					$.areaPlugin.loadCityList({
						type:options.type,
						province : $(this).val(),
						citySelect : options.children
					});
				});
				
				///如果是省级；初始化下拉框数据；
				$.areaPlugin.loadProvinceList({
					type:options.type,
					provinceSelect : $(this).attr("id")
				});
				
				
			} else if(options.level=="city"){
				//先绑定change事件；
				$(this).change(function(){
					$.areaPlugin.loadCountyList({
						type:options.type,
						province : $(this).attr("area-province"),
						city : $(this).val(),
						countySelect : options.children
					});
				});
				
				///如果是地市级，而且，该select 不作为其它 select 的子节点，那么需要考虑该数据初始化；
				if($(".jquery-area[area-children='"+$(this).attr("id")+"']").size() ==0){
					$.areaPlugin.loadCityList({
						type:options.type,
						province : $(this).attr("area-province"),
						citySelect : $(this).attr("id")
					});
				}
				
				
				$(this).change();
				
			} else if(options.level == "county"){
				//先绑定change事件；
				$(this).change(function(){
					if (undefined != $(this).attr("area-children") && '' != $(this).attr("area-children")) {
						$.areaPlugin.loadTownList({
							type:options.type,
							province : $(this).attr("area-province"),
							city : $(this).attr("area-city"),
							county : $(this).val(),
							townSelect : options.children
						});
					}
				});
				
				///区县级，仅考虑数据初始化，而不处理数据联动的哦；
				if($(".jquery-area[area-children='"+$(this).attr("id")+"']").size() ==0){
					///如果当前是区县级；需要初始化；
					$.areaPlugin.loadCountyList({
						type:options.type,
						province : $(this).attr("area-province"),
						city : $(this).attr("area-city"),
						county : $(this).val(),
						countySelect : $(this).attr("id")
					});
			    }
				$(this).change();
			} else if(options.level == "town"){
				///区县级，仅考虑数据初始化，而不处理数据联动的哦；
				if($(".jquery-area[area-children='"+$(this).attr("id")+"']").size() ==0){
					///如果当前是乡镇级；需要初始化；
					$.areaPlugin.loadTownList({
						type:options.type,
						province : $(this).attr("area-province"),
						city : $(this).attr("area-city"),
						county : $(this).attr("area-county"),
						townSelect : $(this).attr("id")
					});
			    }
			}
			
			
			return $(this);
		});
	};
	
	/**
	 * 默认参数
	 */
	$.fn.area.defaultOpts = {
			children : "",
			level:"province",
			type:"admin"
	};
	
})(jQuery)

/**
 * 页面初始化处理
 */	
$(function(){
	
	//初始化加载 业务区县数据；
	/*$.areaPlugin.loadAreas({
		type:"busi"
	});*/
	//初始化加载 地市区县数据；
	/*$.areaPlugin.loadAreas({
		type:"admin"
	});*/
	
	//按照省、地市、区县三级的顺序进行初始化和 change 事件调用；
	$(".jquery-area[area-level='province']").area();
	$(".jquery-area[area-level='city']").area();
	$(".jquery-area[area-level='county']").area();
	$(".jquery-area[area-level='town']").area();
})