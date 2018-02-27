package com.rbac.rbacshow.sys.controller;

import com.base.entity.OrgGroup;
import com.base.entity.User;
import com.rbac.rbacshow.common.base.GenericController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 类描述：
* @auther linzf
* @create 2018/2/6 0006 
*/
@Controller
@RequestMapping("/group")
public class OrgGroupController extends GenericController<OrgGroup> {

    /**
     * 跳转到添加用户的页面
     * @throws Exception
     * */
    @RequestMapping(value="/addUserPage")
    public String addUserPage() throws Exception{
        return getPageBaseRoot()+"/addUser";
    }

    /**
     * 功能描述：跳转到更新用户的页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateUserPage")
    public String updateUserPage(User entity, Model model) throws Exception {
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+"/updateUser";
    }

    /**
     * 功能描述：跳转到更新组织架构页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateGroupPage")
    public String updateGroupPage(OrgGroup entity, Model model) throws Exception {
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+UPDATEPAGE;
    }

    /**
     * 功能描述：跳转到增加组织架构页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addGroupPage")
    public String addPage(OrgGroup entity, Model model) throws Exception {
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+ADDPAGE;
    }

}
