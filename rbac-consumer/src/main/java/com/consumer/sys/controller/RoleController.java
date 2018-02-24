package com.consumer.sys.controller;

import com.base.entity.QueryUserRole;
import com.base.entity.UserRole;
import com.consumer.common.base.controller.GenericController;
import com.consumer.common.base.service.GenericService;
import com.consumer.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
* 类描述：
* @auther linzf
* @create 2018/2/6 0006 
*/
@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<UserRole, QueryUserRole> {

    @Autowired
    private RoleService roleService;

    @Override
    protected GenericService<UserRole, QueryUserRole> getService() {
        return roleService;
    }

    @RequestMapping(value = "/loadRoleTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadRoleTree(UserRole entity){
        return roleService.loadRoleTree(entity);
    }
}
