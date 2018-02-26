$(function () {

    $.fn.bootstrapNav = function(options){
        var opts = $.extend({}, $.fn.bootstrapNav.defaults, options);
        var navbar_header_content = "<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-ex1-collapse'>";
        navbar_header_content += "<span class='sr-only'>Toggle navigation</span>";
        navbar_header_content += "<span class='icon-bar'></span>";
        navbar_header_content += "<span class='icon-bar'></span>";
        navbar_header_content += "<span class='icon-bar'></span>";
        navbar_header_content += "</button>";
        navbar_header_content += "<a class='navbar-brand' href='"+opts.index+"'>"+opts.navTitle+"</a>";
        $("#navbar_header").html(navbar_header_content);
    }

    /*
    * param index:单击后台业务管理系统的时候响应的事件。
    * param navTitle:后台系统的nav的标题。
    */
    $.fn.bootstrapNav.defaults = {index:'main',navTitle:'后台业务管理系统'};
});