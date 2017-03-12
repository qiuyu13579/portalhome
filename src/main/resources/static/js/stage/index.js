(function ($) {
    $.learuntab = {
    		
    };
    $.learunindex = {
        load: function () {
            $(window).load(function () {
                window.setTimeout(function () {
                    $('#ajax-loader').fadeOut();
                }, 300);
            });
        }
    };
    $(function () {
        $.learunindex.load();
        //$.learuntab.init();
    });
})(jQuery);