package com.produce.sys.controller;

import com.base.entity.QueryUserRole;
import com.base.entity.UserRole;
import com.produce.common.base.controller.GenericController;
import com.produce.common.base.service.GenericService;
import com.produce.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 类描述：
* @auther linzf
* @create 2018/2/6 0006 
*/
@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<UserRole, QueryUserRole> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected GenericService<UserRole, QueryUserRole> getService() {
        return userRoleService;
    }


}
