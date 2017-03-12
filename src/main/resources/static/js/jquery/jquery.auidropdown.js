/*
*	民族通用选择插件(也可作为tip通用显示控件,传要显示的url即可) md by linmc
* 	调用示例：
* 	<span class="aui-dropdown nationality_select_cls" value="">-请选择-</span>
* 
*	$('.nationality_select_cls').auiDropdown({
*		title:'请点击选择名族',
*		url:'${ctx}/demo/nationality',//要加载的url
*		width:410,自定义显示宽度 高度适配
*		noDataText:'== 未设置== '//无内容时默认显示内容
*	}).bind('change',function(event,a,b){
*		//to do something
*		var mz = $(this).attr("value");
*	});
*/

$.fn.auidropdown = function(cfg) {
	var athis = $(this);
	var nationalityArray = new Array();
	nationalityArray[0] = {'name':'汉族','code':'HA'};
	nationalityArray[1] = {'name':'壮族','code':'ZH'};
	nationalityArray[2] = {'name':'满族','code':'MA'};
	nationalityArray[3] = {'name':'回族','code':'HU'};
	nationalityArray[4] = {'name':'苗族','code':'MH'};
	nationalityArray[5] = {'name':'维吾尔族','code':'UG'};
	nationalityArray[6] = {'name':'土家族','code':'TJ'};
	nationalityArray[7] = {'name':'彝族','code':'YI'};
	nationalityArray[8] = {'name':'蒙古族','code':'MG'};
	nationalityArray[9] = {'name':'藏族','code':'ZA'};
	nationalityArray[10] = {'name':'布依族','code':'BY'};
	nationalityArray[11] = {'name':'侗族','code':'DO'};
	nationalityArray[12] = {'name':'瑶族','code':'YA'};
	nationalityArray[13] = {'name':'朝鲜族','code':'CS'};
	nationalityArray[14] = {'name':'白族','code':'BA'};
	nationalityArray[15] = {'name':'哈尼族','code':'HN'};
	nationalityArray[16] = {'name':'哈萨克族','code':'KZ'};
	nationalityArray[17] = {'name':'黎族','code':'LI'};
	nationalityArray[18] = {'name':'傣族','code':'DA'};
	nationalityArray[19] = {'name':'畲族','code':'SH'};
	nationalityArray[20] = {'name':'傈僳族','code':'LS'};
	nationalityArray[21] = {'name':'仡佬族','code':'GL'};
	nationalityArray[22] = {'name':'东乡族','code':'DX'};
	nationalityArray[23] = {'name':'高山族','code':'GS'};
	nationalityArray[24] = {'name':'拉祜族','code':'LH'};
	nationalityArray[25] = {'name':'水族','code':'SU'};
	nationalityArray[26] = {'name':'佤族','code':'VA'};
	nationalityArray[27] = {'name':'纳西族','code':'NX'};
	nationalityArray[28] = {'name':'羌族','code':'QI'};
	nationalityArray[29] = {'name':'土族','code':'TU'};
	nationalityArray[30] = {'name':'仫佬族','code':'ML'};
	nationalityArray[31] = {'name':'锡伯族','code':'XB'};
	nationalityArray[32] = {'name':'柯尔克孜族','code':'KG'};
	nationalityArray[33] = {'name':'景颇族','code':'JP'};
	nationalityArray[34] = {'name':'毛南族','code':'MN'};
	nationalityArray[35] = {'name':'撒拉族','code':'SL'};
	nationalityArray[36] = {'name':'布朗族','code':'BL'};
	nationalityArray[37] = {'name':'塔吉克族','code':'TA'};
	nationalityArray[38] = {'name':'阿昌族','code':'AC'};
	nationalityArray[39] = {'name':'普米族','code':'PM'};
	nationalityArray[40] = {'name':'鄂温克族','code':'EW'};
	nationalityArray[41] = {'name':'达斡尔族','code':'DU'};
	nationalityArray[42] = {'name':'怒族','code':'NU'};
	nationalityArray[43] = {'name':'京族','code':'GI'};
	nationalityArray[44] = {'name':'基诺族','code':'JN'};
	nationalityArray[45] = {'name':'德昂族','code':'DE'};
	nationalityArray[46] = {'name':'保安族','code':'BO'};
	nationalityArray[47] = {'name':'俄罗斯族','code':'RS'};
	nationalityArray[48] = {'name':'裕固族','code':'YG'};
	nationalityArray[50] = {'name':'门巴族','code':'MB'};
	nationalityArray[51] = {'name':'鄂伦春族','code':'OR'};
	nationalityArray[52] = {'name':'独龙族','code':'DR'};
	nationalityArray[53] = {'name':'塔塔尔族','code':'TT'};
	nationalityArray[54] = {'name':'赫哲族','code':'HZ'};
	nationalityArray[49] = {'name':'珞巴族','code':'LB'};
	nationalityArray[55] = {'name':'乌兹别克族','code':'UZ'};
	
	var extParam = arguments.length>1?arguments[1]:"";
	if (athis.attr('aui-init')) {
		if (cfg == 'clear') {          //clear
			if (athis.attr('aui-init')) {
				var el = $('#' + athis.attr('elid'));
				$('.micro-btn-clear', el).trigger("click",[extParam]);
				return $(this);
			}
		} else if (cfg == 'destory') {          //destory
			if (athis.attr('aui-init')) {
				$('#' + athis.attr('elid')).remove();
				return;
			}
		} else if (cfg == 'datachange') {       //clear
			if (athis.attr('aui-init')) {
				var el = $('#' + athis.attr('elid'));
				$('.micro-btn-clear', el).click().attr('error', true);
				el.empty().remove();
				return $(this);
			}

		}
	}
	var clickbody;
	var opts = $.extend({
		width:410,
		emptyText:'-- 请选择 -- ',
		noDataText:'[空]',
		hideButtons:false,
		multi:false, //是否多选
		xtype:'text',
		positionOffset:0,
		items:[
			{isChecked:false,value:'1',key:'abc'}
		], 
		className:'aui-dropdown-content', 
		appendClass:'',//自定义特殊样式
		title:'点击相应选择项',
		nationalityArray:nationalityArray,//直接渲染数组内容 数组属性要求 name code
		itemClass:'item',//判断是否含有元素及元素点击事件用
		optionClassName:'aui-dropdown-container'}, cfg);
		
	if (opts.xtype == 'text') {
		athis.html(opts.emptyText);
	}
	
	if (opts.xtype == 'text') {
		athis.hover(function() {
			athis.addClass('aui-dropdown-over');
		}, function() {
			athis.removeClass('aui-dropdown-over');
		});
	}
		
	athis.click(function(e) {
		
		//渲染位置定义
		var offset = athis.offset();
		var bro=$.browser;
	    if(bro.msie) {
	    	var top = offset.top - $(document).scrollTop()+( opts.positionOffset || athis.outerHeight());
	    } else {
	    	var top = offset.top+( opts.positionOffset || athis.outerHeight());
	    }
		
		//控件唯一性判断
		if (!athis.attr('elid')) {
			athis.attr('elid', 'aui-gen' + Math.ceil(Math.random() * 100000000));
		}
		var el = $('#' + athis.attr('elid'));
		if (el.size() > 0 && !el.attr('error')) {
			if (el.is(":visible")) {
				if (e.type != 'click') {
					return;
				}
				el.hide();
			} else {
				el.css({top:top,left:offset.left}).show();
			}
		} else {
			$('#' + athis.attr('elid')).remove();
			el = $('<div class="' + opts.className + '" id="' + athis.attr('elid') + '"></div>')
					.css({ top: top, left: offset.left }).css("position", "absolute")
					.appendTo(document.body);
		    //alert($(".ccfx_html_body").size());
		    //alert($("body").size());
			el.css('z-index',9999999999);//jQuery.maxZIndex()+1
			if (opts.appendClass) {
				var classes = opts.appendClass.split(" ");
				for (var n = 0; n < classes.length; n++) {
					el.addClass(classes[n]);
				}
			}
			
			el.width(Math.max(100, opts.width || athis.outerWidth()));
			var recalcValue = function(a) {
				var val = [];
				el.find('.item-sel').each(function() {
					val[val.length] = $(this).attr('aid') || $(this).text();
				});
				athis.attr('value', val.join(',')).trigger('change',[a]);
				if (!val.length) {
					athis.html(opts.emptyText);
				}
			};
			el.bind('select-change', function(event,a) {
				if (opts.xtype != 'text') {
					recalcValue();
					return;
				}
				athis.empty();
				var itemsel = el.find(".item-sel");
				
				itemsel.each(function() {
					var itemSp = $("<span class='nationality-sel sel'></span>").appendTo(athis);
					itemSp.html($(this).html()).data('el', $(this));
					if ($(this).attr("aid")) {
						itemSp.attr('aid', $(this).attr("aid"));
					}
					itemSp.append($('<img src="'+WEB.WEBROOT+'/resource/images/icon/winClose.gif" title="删除" border=0>').click(function() {
						itemSp.data('el').removeClass('item-sel');
						itemSp.remove();
						recalcValue();
					}))
				});
				recalcValue(a);
			});
			var bindElEvent = function() {
				el.find('.'+opts.itemClass).hover(function() {
					$(this).addClass('item-over');//.css('color','red');
				}, function() {
					$(this).removeClass('item-over');//.css('color','#000');
				}).click(function(e) {
					if (opts.select) {
						opts.select(e, $(this), el);
						return;
					}
					
					//通过循环样式单选多选处理
					if(!opts.multi) {		
						var itemsel = el.find(".item-sel");
						itemsel.each(function() {
							$(this).removeClass('item-sel');
						});
					}
					
					if ($(this).hasClass('item-sel')) {
							$(this).removeClass('item-sel');
					} else {
						$(this).addClass('item-sel');
					}
					
					el.trigger('select-change');
					if (!opts.multi) {
						el.hide();
					}
				}).dblclick(function() {
					el.trigger('select-change');
					el.hide();
				});
			};
			
			
			if (opts.url || athis.attr('aui-url')) {
				el.html('<img src="'+WEB.WEBROOT+'/resource/images/message/waiting16.gif" border=0/>')
						.load(opts.url || athis.attr('aui-url'), null, function(a, status, c) {
					if (status == 'success') {
						if (!$('.'+opts.itemClass, el).size()) {
							el.html(opts.noDataText || '&#160;').attr('error', true);
							return;
						}
						bindElEvent();
						var tb = $("<div class='toolbar'/>").prependTo(el);
						if (opts.title) {
							tb.append(opts.title);
						}
						if (opts.multi) {
							tb.append(
									$('<a href=# class="micro-btn micro-btn-all">全选</a>')
											.click(function() {
										$(el).find('.item:not(.item-sel)').addClass('item-sel');
										el.trigger('select-change');
									}))
									
							tb.append($('<a href=# class="micro-btn micro-btn-clear">清空</a>').click(function(event,a) {
								$(el).find('.item-sel').removeClass('item-sel');
								el.trigger('select-change',[a]);
							}));
							
						}
						
						
						
						if (opts.hideButtons) {
							tb.hide();
						}
					} else {
						el.html('服务器返回出错:' + status).attr('error', true);
					}

				});
			} else if(opts.nationalityArray.length>0) {
				var dataArray = opts.nationalityArray;
				var itemContent = "";
				for (var n=0;n<dataArray.length;n++) {
					if(dataArray[n] && dataArray[n]!=undefined) {
						itemContent += "<div class='item' aid='"+dataArray[n].code+"'>"+dataArray[n].name+"</div>";
					}
									}
				el.append(itemContent);
				bindElEvent();
				var tb = $("<div class='toolbar'/>").prependTo(el);
				if (opts.title) {
					tb.append(opts.title);
				}
				if (opts.multi) {
					tb.append(
							$('<a href=# class="micro-btn micro-btn-all">全选</a>')
									.click(function() {
								$(el).find('.item:not(.item-sel)').addClass('item-sel');
								el.trigger('select-change');
								el.hide();
							}))
							
					tb.append($('<a href=# class="micro-btn micro-btn-clear">清空</a>').click(function(event,a) {
						$(el).find('.item-sel').removeClass('item-sel');
						el.trigger('select-change');
						el.hide();
					}));
				}
				
				
				
				if (opts.hideButtons) {
					tb.hide();
				}
			} else {
				bindElEvent();
			}
			el.show();
			
			//渲染框的事件处理
			clickbody = function(e) {
				if ($(e.target).is('#' + athis.attr("elid")) || $(e.target).is('.'+opts.itemClass)
						|| $(e.target).is('.micro-btn')
						) {
							return;
				}
				if ($(e.target).is('tr.aui-grid-row-sel')) {//gird时
					return;
				}
				el.hide();
			};
			$(document.body).click(clickbody);
		}
		//事件不再分派到其他节点
		e.stopPropagation();
	});

	return athis;
};