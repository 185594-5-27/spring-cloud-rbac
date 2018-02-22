package com.produce.sys.controller;

import com.base.entity.QueryUserRole;
import com.base.entity.Tree;
import com.base.entity.UserRole;
import com.produce.common.base.constant.SystemStaticConst;
import com.produce.common.base.controller.GenericController;
import com.produce.common.base.service.GenericService;
import com.produce.sys.service.TreeService;
import com.produce.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    private UserRoleService userRoleService;

    @Autowired
    private TreeService treeService;


    @Override
    protected GenericService<UserRole, QueryUserRole> getService() {
        return userRoleService;
    }

    @RequestMapping(value = "/loadRoleTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadRoleTree(@RequestBody UserRole entity){
        entity = userRoleService.getUserRoleAssociate(entity);
        List<Tree> treeList = treeService.query(null);
        if(entity!=null){
            for(Tree tree:entity.getTreeList()){
                treeList.stream().forEach(t->{
                    if(t.getId()==tree.getId()){
                        t.setChecked(true);
                    }
                });
            }
        }
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put("data",treeList);
        return result;
    }


}
