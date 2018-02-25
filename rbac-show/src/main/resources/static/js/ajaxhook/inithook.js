$(function () {
    hookAjax({
        onreadystatechange:function(xhr){
           // console.log("onreadystatechange called: %O",xhr)
            //return true
        },
        onload:function(xhr){
            //console.log("onload called: %O",xhr)
            //xhr.responseText="hook"+xhr.responseText;
            //return true;
        },
        open:function(arg,xhr){
            console.log("open called: method:%s,url:%s,async:%s",arg[0],arg[1],arg[2],xhr);
            if(arg[1].indexOf("\?")!=-1){
                arg[1]+="&token="+token;
            }else{
                arg[1]+="?token="+token;
            }

            //统一添加请求头
        },
        send:function(arg,xhr){
           // console.log("send called: %O",arg[0])
            //xhr.setRequestHeader("_custom_header_","ajaxhook")
        },
        setRequestHeader:function(arg,xhr){
           // console.log("setRequestHeader called!",arg)
        }
    })

})
