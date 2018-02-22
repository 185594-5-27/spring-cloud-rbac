package com.produce.sys.dao;



import com.base.entity.QueryTree;
import com.base.entity.Tree;
import com.base.entity.User;
import com.produce.common.base.dao.GenericDao;

import java.util.List;

/**
 *@author linzf
 **/
public interface TreeDao extends GenericDao<Tree, QueryTree> {

    /**
     * 功能描述：加载用户的菜单树的数据
     * @param user
     * @return
     */
	List<Tree> loadUserTree(User user);
}