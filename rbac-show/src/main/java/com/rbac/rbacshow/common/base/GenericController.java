package com.rbac.rbacshow.common.base;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 类描述：
* @auther linzf
* @create 2018/2/5 0005 
*/
public abstract class GenericController<T> {

    /**修改页面路径*/
    public final static String UPDATEPAGE = "/update";

    /**新增页面路径*/
    public final static String ADDPAGE = "/add";

    /**
     * Controller基路径
     * */
    protected String basePath;

    /**抽象方法，获取页面基路径
     * @throws Exception */
    protected String getPageBaseRoot() throws Exception{
        if(basePath==null){
            basePath = this.getClass().getName();
            Pattern p=Pattern.compile(".[a-z|A-z]+.controller.[a-z|A-z]+Controller");
            Matcher m=p.matcher(basePath);
            if(m.find()){
                basePath = m.group();
                basePath = basePath.substring(1, basePath.length()-10);
                basePath = basePath.replace(".", "/");
                basePath = basePath.replace("/controller/", "/");
                basePath = toFirstCharLowerCase(basePath);
                basePath = basePath.substring(0,basePath.lastIndexOf("/")+1)+toFirstCharLowerCase(basePath.substring(basePath.lastIndexOf("/")+1));
            }
            else{
                throw new Exception("获取页面基路径失败");
            }
        }
        return basePath;
    }

    /**
     * 功能描述：直接跳转到添加数据的页面
     * @return
     */
    @RequestMapping(value = "/addPage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String addPage() throws Exception{
        return getPageBaseRoot()+ADDPAGE;
    }

    /**
     * 功能描述：直接跳转到更新数据的页面
     * @param entity
     * @return
     */
    @RequestMapping(value = "/updatePage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updatePage(T entity,Model model) throws Exception{
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+UPDATEPAGE;
    }

    /**
     * 将首字母变小写
     * @param str
     * @return
     */
    private String toFirstCharLowerCase(String str){
        char[]  columnCharArr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < columnCharArr.length; i++) {
            char cur = columnCharArr[i];
            if(i==0){
                sb.append(Character.toLowerCase(cur));
            }else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }

}
