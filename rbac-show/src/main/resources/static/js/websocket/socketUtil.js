$(function () {

    var stompClient = null;

    // 设置websocket的连接
    $.fn.socketConnect = function(options){
        var opts = $.extend({}, $.fn.socketConnect.defaults, options);
        var socket = new SockJS(opts.sockurl);
        stompClient = Stomp.over(socket);
        stompClient.connect({login:opts.login}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe(opts.stompClienturl, opts.success);
        });
    }

    // 设置连接websocket的参数
    $.fn.socketConnect.defaults = {sockurl:'',stompClienturl:'',login:'',success:function(greeting){
        console.log('greeting obj is: ' + greeting);
    }};

    // 断开websocket的连接
    $.fn.socketDConnectis = function(){
        if (stompClient != null) {
            stompClient.disconnect();
        }
        console.log("Disconnected");
    }

})