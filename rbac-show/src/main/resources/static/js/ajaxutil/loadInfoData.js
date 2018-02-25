$(function () {

    $.fn.loadInfoData = function(options){
        var opts = $.extend({}, $.fn.loadInfoData.defaults, options);
        $.post(opts.url,opts.data,function(r){
            var obj = r.entity;
            $.fn.loadForm(obj);
        })
    }

    $.fn.loadForm = function(obj){
        var key,value,tagName,type,arr;
        for(x in obj){
            key = x;
            value = obj[x];
            $("[name='"+key+"'],[name='"+key+"[]']").each(function(){
                tagName = $(this)[0].tagName;
                type = $(this).attr('type');
                if(tagName=='INPUT'){
                    if(type=='radio'){
                        $(this).attr('checked',$(this).val()==value);
                    }else if(type=='checkbox'){
                        arr = value.split(',');
                        for(var i =0;i<arr.length;i++){
                            if($(this).val()==arr[i]){
                                $(this).attr('checked',true);
                                break;
                            }
                        }
                    }else{
                        $(this).val(value);
                    }
                }else if(tagName=='SELECT' || tagName=='TEXTAREA'){
                    $(this).val(value);
                }

            });
        }
    }

    $.fn.loadInfoData.defaults = {};

})