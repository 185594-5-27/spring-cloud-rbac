$(function () {

    $.fn.ajaxUtil = function(options){
        var opts = $.extend({}, $.fn.ajaxUtil.defaults, options);
        $.post(opts.url,opts.data,opts.fun);
    }

    $.fn.ajaxUtil.defaults = {}
})