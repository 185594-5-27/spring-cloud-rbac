/**
 * 实现从后台加载checkbox集合
 */
$(function () {
    $.fn.checkbox = function(options){
        var opts = $.extend({}, $.fn.checkbox.defaults, options);
        $.post(opts.url,opts.data,function(data){
            if(data.result){
                  $.each(data.list,function(index,info){
                      var isCheck = false;
                      if(opts.checkData!=undefined&&opts.checkData!=""){
                          $.each(eval("("+opts.checkData+")"),function(idc,ic){
                              if(ic[opts.val]==info[opts.val]){
                                  isCheck = true;
                                  return false;
                              }
                          })
                      }
                      if(isCheck){
                          $("#"+opts.id).append("<label  class='checkbox-inline'><input type='checkbox' name='"+opts.name+"' value='"+info[opts.val]+"' checked='checked' /> "+info[opts.showVal]+"</label>");
                      }else{
                          $("#"+opts.id).append("<label  class='checkbox-inline'><input type='checkbox' name='"+opts.name+"' value='"+info[opts.val]+"' /> "+info[opts.showVal]+"</label>");
                      }

                  })
            }
        })
    }
    $.fn.checkbox.defaults = {}
})