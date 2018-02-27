package com.rbac.rbacshow.common.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/*
* 类描述：springMVC的配置
* @auther linzf
* @create 2018/1/24 0024 
*/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 重写方法描述：实现在url中输入相应的地址的时候直接跳转到某个地址
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //  跳转到登陆页
        registry.addViewController("/login").setViewName("login");
        // 登陆成功跳转到首页
        registry.addViewController("/main").setViewName("main");
        // 登陆成功tab首页
        registry.addViewController("/home").setViewName("home");
        // 字典列表页
        registry.addViewController("/dictList").setViewName("/sys/dict/dictList");
        // 用户列表页
        registry.addViewController("/userList").setViewName("/sys/user/userList");
        // 角色列表页
        registry.addViewController("/userRoleList").setViewName("/sys/role/roleList");
        // 组织结构列表页
        registry.addViewController("/groupList").setViewName("/sys/orggroup/groupList");
        // 菜单管理页
        registry.addViewController("/treeList").setViewName("/sys/tree/treeList");

    }

}
