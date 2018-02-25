$(function () {

    $.fn.dictUtil = function(options){
        var opts = $.extend({}, $.fn.dictUtil.defaults, options);
        if(dictValueMap.size()==0){
            $.post(opts.url,function(r){
                if(r.result){
                    $.each(r.data,function(index,info){
                        dictValueMap.put(info.type+"_"+info.code,info.value+"|"+info.text);
                        dictCodeMap.put(info.type+"_"+info.value,info.code+"|"+info.text)
                    })
                }
            });
        }
    }
    $.fn.dictUtil.defaults = {url:"/dict/loadDict"}
})

dictValueMap= parent.dictValueMap;
if(dictValueMap==undefined){
    dictValueMap = new Map();
}
dictCodeMap = parent.dictCodeMap;
if(dictCodeMap==undefined){
    dictCodeMap = new Map();
}

// 根据type和value来获取数据字典的code值
function getCodeDictCode(type,value){
    return dictCodeMap.get(type+"_"+value).split("|")[0];
}

// 根据type和value来获取数据字典的text值
function getCodeDictText(type,value){
    return dictCodeMap.get(type+"_"+value).split("|")[1];
}

//根据type和code来获取数据字典的value值
function getDictValue(type,code){
    var value = dictValueMap.get(type+"_"+code);
    return value.split("|")[0];
}
//根据type和code来获取数据字典的text值
function getDictText(type,code){
    var value = dictValueMap.get(type+"_"+code);
    return value.split("|")[1];
}
// 根据type来获取value的值
function getSelectOption(type,id,select){
    var optionHtml = "";
    for (var i = 0; i < dictValueMap.arr.length; i++) {
        if (dictValueMap.arr[i].key.indexOf(type)!=-1) {
            var value = dictValueMap.arr[i].value.split("|");
            if(select!=undefined){
                if(select==value[0]){
                    optionHtml = optionHtml + "<option value='"+value[0]+"' selected>"+value[1]+"</option>";
                }else{
                    optionHtml = optionHtml + "<option value='"+value[0]+"'>"+value[1]+"</option>";
                }
            }else{
                optionHtml = optionHtml + "<option value='"+value[0]+"'>"+value[1]+"</option>";
            }
        }
    }
    $("#"+id).append(optionHtml)
}

function Map() {
    var struct = function(key, value) {
        this.key = key;
        this.value = value;
    }

    var put = function(key, value){
        for (var i = 0; i < this.arr.length; i++) {
            if ( this.arr[i].key === key ) {
                this.arr[i].value = value;
                return;
            }
        }
        this.arr[this.arr.length] = new struct(key, value);
    }

    var get = function(key) {
        for (var i = 0; i < this.arr.length; i++) {
            if ( this.arr[i].key === key ) {
                return this.arr[i].value;
            }
        }
        return null;
    }

    var remove = function(key) {
        var v;
        for (var i = 0; i < this.arr.length; i++) {
            v = this.arr.pop();
            if ( v.key === key ) {
                continue;
            }
            this.arr.unshift(v);
        }
    }

    var size = function() {
        return this.arr.length;
    }

    var isEmpty = function() {
        return this.arr.length <= 0;
    }
    this.arr = new Array();
    this.get = get;
    this.put = put;
    this.remove = remove;
    this.size = size;
    this.isEmpty = isEmpty;
}