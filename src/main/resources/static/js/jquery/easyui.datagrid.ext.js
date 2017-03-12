var datagrid_user_ext_method = {
    /**
     * 整个panel 初始化之后。
     * 
     * @param {}
     *            jq
     */
    onAfterInit : function(jq) {
        // if()
        var options = $(jq).datagrid('options');
        if (options.showexp) {
            var panel_header = $(jq).datagrid('getPanel').panel('header');
            var div_tools = panel_header.find("div.panel-tool");
            // var html = "<a href"
            $("<a href=\"javascript:void(0)\" title=\"下载\"></a>").addClass("icon-down").appendTo(div_tools).bind(
                    "click", function() {
                        expdown(jq);
                    });

            $("<div style=\"display:none\"></div>")
                    .addClass("panel-tools-downform-div")
                    .appendTo(div_tools)
                    .append("<form method='post' class='panel-tools-downform' ><input type='hidden' name='colmodel'/></form>");

            // 下载的方法；
            function expdown(grid) {
                var form = $(grid).datagrid("getDownForm");
                var opts = $(grid).datagrid("options");
                var queryParams = $.extend({}, opts.queryParams, {
                            page : 1,
                            rows : opts.expRows,
                            gridOperateType : "GridExcelDown" // /补上一个操作类型；
                        });
                var url = new Array();
                $.each(queryParams, function(i, n) {
                            url.push(i + "=" + encodeURI(n));
                        });
                if (opts.url.indexOf("?") < 0) {
                    // 设置action，其实就是查询的时候，所需要的URL ;
                    form.attr('action', opts.url + "?" + url.join("&"));
                } else {
                    form.attr('action', opts.url + "&" + url.join("&"));
                }
                // 列选择；//序列化
                if (opts.columns) {
                    var scol = opts.datagrid_user_ext_method.serializeCol(grid);
                    $(":hidden[name='colmodel']", form).val(scol);
                }

                //alert(scol);

                form.submit();
            }
        }
    },

    serializeCol : function(jq) {
        var colModel = $(jq).datagrid("options").columns;
        var defaultcol = {
            "title" : "",
            "field" : "",
            "colspan" : 1,
            "rowspan" : 1,
            "exp" : true, //默认都需要下载；
            "hidden":false //隐藏；默认都不隐藏；  
        };
        var colModelArray = new Array();

        $.each(colModel, function(rowindex, row) {
                    var rowArray = new Array();
                    $.each(row, function(colindex, col) {
                                var tmp = $.extend({},defaultcol, col);
                                if(tmp.hidden){
                                    ///隐藏的列的都不下载；
                                } else {
                                    //非隐藏的列，要求是有下载的才进行下载；默认是都下载的；
                                    if(tmp.exp){
                                        rowArray.push("{'title':'" + tmp.title + "'," + "'field':'" + tmp.field + "',"
                                        + "'colspan':" + tmp.colspan + "," + "'rowspan':" + tmp.rowspan + "}");
                                    }
                                }
                            })
                    if (rowArray.length > 0) {
                        colModelArray.push("[" + rowArray.join(",") + "]");
                    }
                });

        return "[" + colModelArray.join(",") + "]";

    }

};

$.extend($.fn.datagrid.methods, {
            /**
             * 获取文件下载的 form
             * 
             * @param {}
             *            jq
             */
            getDownForm : function(jq) {
                return $.data(jq[0], "datagrid").panel.panel("header").find("div.panel-tools-downform-div form");
            }

        })

/**
 * 扩展了 datagrid的默认属性 增加了 showexp 表示是否出现下载按钮的方法；
 */
$.extend($.fn.datagrid.defaults, {
            showexp : true,
            expRows : -1, // /约定好了，全量下载数据的时候，本页的记录数传入 -1;
            datagrid_user_ext_method : datagrid_user_ext_method
        });
