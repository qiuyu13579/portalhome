
var TAB = {
    index : 0,
    id : "platFormTabBar",
    homeTitle : "工作台"
};

// 添加页签
TAB.add = function(opts) {
    TAB.index++;
    var defaultOpts = {
        "title" : "新页签_" + TAB.index,
        "url" : "about:blank",
        "menuId" : "0",
        "refresh" : false,
        "closable" : true
    };

    var options = $.extend(defaultOpts, opts);

    var url = $.trim(options.url);
    var httpReg = /^http/;
    if (httpReg.test(url)) {
        // /以http开头，替换参数
    } else {
        if (url != "about:blank") {
            url = GLOBAL.WEBROOT + "/" + url;
        }
    }

    // 根据title选择tab
    // $("#tabBar").tabs('select','网格经理工作台-主页');

    // 如存在则显示，并刷新；否则新建页签
    if ($("#" + this.id).tabs('exists', options.title)) {
        TAB.select(options.title, options.refresh);
    } else {
        // 判断打开页签个数
        var tabs = $("div.tabs-panels >div");
        if (tabs.length >= 10) {
            alert("您已经打开超过10个页签,请关闭部分页签!\n\n超过10个页签可能会造成运行速度缓慢");
        }

        // 新增页签
        $('#' + this.id).tabs('add', {
            title : options.title,
            content : '<iframe src="' + url + '" name="tabIframe_' + TAB.index + '" id="tabIframe_' + TAB.index
                    + '" style="width:100%;height:100%; " frameborder="0"></iframe>',
            closable : options.closable
        });

        // 新增页签是,记录点击日志
        // var option={"title":title,"url":url,"menuId":menuId};
        // Log.add(option);
    }
};

// 根据title选择页签,refresh{true:"刷新页面",false:"不刷新页面"}
TAB.select = function(title, refresh) {
    $("#" + this.id).tabs('select', title);
    if (refresh) {
        TAB.refresh(title);
    }
};

// 取当前标签iframe对象
TAB.getSelectFrame = function() {
    var obj = $('#' + this.id).tabs('getSelected');
    var tab = obj.panel('options').tab;
    var id = obj.children().attr("id");
    var name = obj.children().attr("name");
    var src = obj.children().attr("src");
    var frameObj = {
        "name" : name,
        "id" : id,
        "src" : src
    };
    return frameObj;
}

// 根据title刷新页签
TAB.refresh = function(title) {
    var tab = $("#" + this.id).tabs('getTab', title);
    if (tab) {
        var oldsrc = tab.children().attr("src");
        if (oldsrc) {
            tab.children().attr({
                        src : oldsrc
                    });
        }
    }
}

// 根据title关闭页签
TAB.close = function(title) {
    var tab = $("#" + this.id).tabs('close', title);
}

// 显示主页,取index=0的页签
TAB.home = function(refresh) {
    $("#" + this.id).tabs('select', TAB.homeTitle);
};