package com.produce.sys.controller;


import com.base.entity.QueryTree;
import com.base.entity.Tree;
import com.base.entity.User;
import com.base.util.redis.RedisCache;
import com.produce.common.base.constant.SystemStaticConst;
import com.produce.common.base.controller.GenericController;
import com.produce.common.base.service.GenericService;
import com.produce.common.util.user.UserInfo;
import com.produce.sys.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 类描述：菜单操作controller
* @auther linzf
* @create 2017/10/10 0010 
*/
@RestController
@RequestMapping("/tree")
public class TreeController extends GenericController<Tree,QueryTree> {

    @Autowired
    private TreeService treeService;

    @Autowired
    private RedisCache redisCache;

    @Override
    protected GenericService<Tree, QueryTree> getService() {
        return treeService;
    }

    /**
     * 功能描述：加载首页菜单节点的数据
     * @return
     */
    @RequestMapping(value="/mainTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> mainTree(String token){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Tree> trees = UserInfo.loadUserTree(treeService,(User)redisCache.getObject(token,User.class));
        result.put("data",trees);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        return result;
    }


    /**
     * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
     * @return
     */
    @RequestMapping(value = "/loadUserTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadUserTree(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Tree> treeList = treeService.query(null);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG,"加载菜单数据成功！");
        result.put("data",treeList);
        return result;
    }


}
