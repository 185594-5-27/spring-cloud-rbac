package com.rbac.rbacshow.sys.controller;

import com.base.entity.Tree;
import com.rbac.rbacshow.common.base.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 类描述：
* @auther linzf
* @create 2018/2/7 0007 
*/
@Controller
@RequestMapping("/tree")
public class TreeController extends GenericController<Tree> {

    /**
     * 功能描述：跳转到增加菜单节点的页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addTreePage")
    public String addPage(Tree entity, Model model) throws Exception{
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+ADDPAGE;
    }

    /**
     * 功能描述：跳转到修改菜单节点的页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateTreePage")
    public String updateTreePage(Tree entity, Model model) throws Exception{
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+UPDATEPAGE;
    }


}
