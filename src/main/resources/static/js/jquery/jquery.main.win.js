/*
 * 首页脚本 by depend util.js,jquery-1.2+.js version:0.3
 */


// 全局窗口
var WIN = {
    id : "",
    param : false,
    
    /**
     * 打开窗口
     * @param {} opts
     */
    open : function(opts) {

        var defaultOptions = {
            id : "",
            title : "操作",
            url : "",
            width : 750,
            height : 400,
            iconCls : "icon-edit",
            shadow : false,
            modal : true,
            closable : true,
            left : false,
            top : false,
            onClose : false
        };
        var options = $.extend(defaultOptions, opts);
        
        // 如果设置left,top参数,则覆盖默认居中
        options.left = opts.left || (window.screen.width - options.width) / 2;
        options.top = opts.top || (window.screen.height - options.height) / 2 - 100;

        /*
         * var objId = option.id || this.id var title = option.title ||
         * this.title; var width = option.width || this.width; var height =
         * option.height || this.height; var shadow = typeof(option.shadow) ==
         * "boolean" ? option.shadow : this.shadow; var modal =
         * typeof(option.modal) == "boolean" ? option.modal : this.modal; var
         * closable = typeof(option.closable) == "boolean" ? option.closable :
         * this.closable; var closed = option.closed || false; var url =
         * option.url || "about:blank"; var iconCls = option.iconCls ||
         * "icon-edit";
         */

        var url = options.url;
        if (url == "") {
            alert("url参数不能为空;");
            return;
        }
        if (url != "about:blank" && url.indexOf("http") < 0) {
        	
            url = GLOBAL.WEBROOT + "/" + url;
        }

        if (options.id == "") {
            alert("id参数不能为空;");
            return;
        }
        this.id = options.id;

        /**
         * 改造后的流程，如下： 1.根据Id，查找 id 一样的元素是否存在，如果存在，那么删除； 2.构造一个 div ; 3.对div调用
         * dialog； 4.对div调用 dialog('open'); 5.div 下面有个：iframe src 指向目标的 url;
         */
        var divId = 'globalModalWindow-' + options.id;
        var iframeId = "globalModalIframe-" + options.id
        if ($("#" + divId).length > 0) {
            $("#" + divId).remove();
        }

        var winopts = {
            title : options.title,
            width : options.width,
            height : options.height,
            top : options.top,
            left : options.left,
            closable : options.closable,
            modal : options.modal,
            shadow : options.shadow,
            iconCls : options.iconCls,
            closed : true,
            //fit:true,
            onClose : function() {

                var ifrm = $("iframe", this);
                var el = ifrm.get(0);
                el.contentWindow.document.write('');
                el.contentWindow.close();
                ifrm.attr('src', "about:blank");

                $(this).dialog('destroy');
                $(this).remove();

                if (options.onClose) {
                    options.onClose(WIN.param);
                    this.param = false;
                }
            }
        };

        var $div = $(document.createElement('div'));
        $div.attr('title', options.title);
        $div.attr("id",divId);
        $div.empty();
        var $iframe = $('<iframe id="' + iframeId + '" name="' + iframeId + '" src="' + url
                + '" frameborder="0" />').css({
                    width : '100%',
                    //height : $div.height-5,
                    //height : '100%',
                    height : winopts.height-40,
                    border : 0,
                    overflow: 'auto'
                }).appendTo($div);
                
        $div.dialog(winopts);
        $div.dialog('open');
        $div = null;
        $iframe = null;
    },
    
    /**
     * 关闭弹出页面
     * @param {} id
     * @param {} param
     */
    close : function(id, param) {
        if (id == undefined) {
            id = this.id;
        }
        WIN.param = param;
        $('#globalModalWindow-' + id).dialog('close');
    }
};
