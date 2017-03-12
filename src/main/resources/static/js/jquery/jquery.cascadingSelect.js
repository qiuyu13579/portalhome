/***
 * 联动下拉框
 * 后台返回的json串需类似：[{"value":"A01","text":"鼓楼营销部",...},{"value":"A21","text":"仓山营销部",...}]
 */
(function ($) {
 $.fn.cascadingSelect = function (option) {     
     var optionTag = '<option></option>';
     var config = $.extend({}, $.fn.cascadingSelect.defaults, option);
     var source = option.source;
     var url = option.url;
     if (typeof source === 'undefined' || source == null || source == '') {alert("父选择框ID未指定");throw "父选择框ID未指定"; }
     if (typeof url == 'undefined' || url == '') {alert("url未指定");throw "url未指定"; }
     return this.each(function () {
	     var $this = $(this);
	     (function () {
	         var methods = {
	             clearItems: function () {
	                 $this.empty();
	                 /*if (!$this.attr("disabled")) {
	                     $this.attr("disabled", "disabled");
	                 }*/
	             },
	             reset: function () {
	                 methods.clearItems();
	                 $this.append($(optionTag).attr("value", "").text(config.promptText));
	                 $this.trigger('change');                 
	             },
	             initialize: function () {
	                 if ($this.children().size() == 0) {
	                     methods.reset();
	                 }
	             },
	             showLoading: function () {
	                 methods.clearItems();
	                 $this.append($(optionTag).attr("value", "").text(config.loadingText));
	             },
	             loaded: function () {
	                 $this.removeAttr("disabled");
	                 $this.trigger('change');
	             },
	             showError: function () {
	                 methods.clearItems();
	                 $this.append($(optionTag).attr("value", "").text(config.errorText));
	             },
	             post: function () {
	                 methods.showLoading();
	                 $.isFunction(config.onLoading) && config.onLoading.call($this);
	                 $.ajax({
	                     url: url,
	                     type: config.type,
	                     dataType: 'json',
	                     async: config.async,
	                     data: config.data || $("#"+source).serialize(),
	                     success: function (data) {
	                         methods.reset();
	                         if(data!=null){
	                        	 $.each(data, function (i, k) {
	                                 $this.append($(optionTag).attr("value", eval("k." + config.valuefield)).text(eval("k." + config.textfield))); 
	                             });
	                         }
	                         if(config.defaultValue!=null && config.defaultValue!=''){
	                        	 $this.val(config.defaultValue);
	                         }
	                         methods.loaded();
	                         $.isFunction(config.onLoaded) && config.onLoaded.call($this);
	                     },
	                     error: function () {
	                         methods.showError();
	                     }
	                 });
	             }
	         };
	         var parentSelect = $("#"+source);
	         if (parentSelect.val() != '') {
                 methods.post();
             }
	         $("#"+source).change(function () {	             
	             if (parentSelect.val() != '') {
	                 methods.post();
	             }else {
	                 methods.reset();
	             }
	         });
	         methods.initialize();
	     })();
     });
 }
 
$.fn.cascadingSelect.defaults = {
     promptText : '--请选择--', //下拉框第一个选项 
     loadingText : '加载中...', //当加载时
     errorText : '加载失败',	//出错时
     source : null, //父选择框ID
     url : '',	//action url
     type : 'POST',
     data : null,	//url参数
     async : true,  //异步请求
     onLoading : null,	 //加载前事件	
     onLoaded : null,	 //加载完事件	
     textfield : 'text', //对应pojo的值字段（下拉框在页面上的展示文本）	
     valuefield : 'value', //对应pojo的编码字段	
     defaultValue : null
 }
 })(jQuery);