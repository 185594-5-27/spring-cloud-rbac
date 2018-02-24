package com.consumer.sys.controller;

import com.base.entity.OrgGroup;
import com.base.entity.QueryOrgGroup;
import com.base.entity.QueryUser;
import com.consumer.common.base.controller.GenericController;
import com.consumer.common.base.service.GenericService;
import com.consumer.sys.service.OrgGroupService;
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
@RequestMapping("/group")
public class OrgGroupController extends GenericController<OrgGroup, QueryOrgGroup> {

    @Autowired
    private OrgGroupService orgGroupService;

    @Override
    protected GenericService<OrgGroup, QueryOrgGroup> getService() {
        return orgGroupService;
    }

    /**
     * 功能描述：获取组织架构底下的相应的用户
     * @return
     */
    @RequestMapping(value = "/userList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> userList(QueryUser user){
        return orgGroupService.userList(user);
    }

    /**
     * 功能描述：获取组织架构的整颗菜单树
     * @return
     */
    @RequestMapping(value = "/loadGroupTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadGroupTree(){
        return orgGroupService.loadGroupTree();
    }

}
