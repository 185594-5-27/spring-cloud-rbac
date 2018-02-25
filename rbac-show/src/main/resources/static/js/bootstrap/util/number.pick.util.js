// 实现输入框为数字的时候的数字的增减功能
function plusText(type,id){
    var value_info = $("#"+id).val();
    if(value_info!=""&&!isNaN(value_info)){
        if(type=='1'){
            $("#"+id).val(parseInt(value_info)-1);
        }else{
            $("#"+id).val(parseInt(value_info)+1);
        }
    }
}
