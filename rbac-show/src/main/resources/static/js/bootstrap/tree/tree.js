$(function () {

    function initTree(data,opts){
        // 遍历循环菜单元素并添加菜单到相应的节点
        for (var i = 0; i < data.length; i++) {
            // 添加一级节点
            var menu_li = document.createElement("li");
            $(menu_li).append("<a href='javascript:void(0);' class='collapsed' expanded='false' data-toggle='collapse' data-target='#"+data[i].id+"'><i class='"+data[i].icon+"'></i> "+data[i].name+" <i class='fa fa-fw fa-caret-down'></i></a>")
            if(data[i].child.length>0){
                // 添加二级节点并设置二级节点的html的属性
                var child = data[i].child;
                var child_menu_ul = document.createElement("ul");
                child_menu_ul.setAttribute("id", data[i].id);
                child_menu_ul.setAttribute("aria-expanded", "false");
                child_menu_ul.setAttribute("class", "collapse");
                for(var j=0;j<child.length;j++){
                    var child_menu_ul_li = document.createElement("li");
                    if(child[j].icon!=''&&child[j].icon!=undefined){
                        $(child_menu_ul_li).append("<a href='javascript:void(0)' ><i class='"+child[j].icon+"'></i> "+child[j].name+"</a>")
                        // jquery绑定监听事件的时候同时传递相应的参数【将菜单节点添加到tab标签页上】
                        $(child_menu_ul_li).find("a").bind("click",{id:child[j].id,name:child[j].name,url:child[j].url},function(e){
                            $("#"+opts.tabId).data("tabs").addTab({id: e.data.id, text: e.data.name, closeable: true, url: e.data.url});
                        })
                    }else{
                        $(child_menu_ul_li).append("<a href='javascript:void(0)' ><i class='fa fa-fw'></i> "+child[j].name+"</a>")
                        // jquery绑定监听事件的时候同时传递相应的参数【将菜单节点添加到tab标签页上】
                        $(child_menu_ul_li).find("a").bind("click",{id:child[j].id,name:child[j].name,url:child[j].url},function(e){
                            $("#"+opts.tabId).data("tabs").addTab({id: e.data.id, text: e.data.name, closeable: true, url: e.data.url});
                        })
                    }
                    $(child_menu_ul).append(child_menu_ul_li)
                }
                $(menu_li).append(child_menu_ul);
            }
            $("#"+opts.treeId).append(menu_li);
        }
    }

    $.fn.bootstrapTree = function(options){
        var opts = $.extend({}, $.fn.bootstrapTree.defaults, options);
        var data = options.data;
        if(opts.url!=undefined&&opts.url!=""){
            $.post(opts.url,function (r) {
                data = r.data;
                initTree(data,opts);
            })
        }else{
            initTree(data,opts);
        }
    }
    $.fn.bootstrapTree.defaults = {};
});
