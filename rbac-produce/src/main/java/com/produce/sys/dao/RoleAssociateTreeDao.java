package com.produce.sys.dao;


import com.base.entity.QueryRoleAssociateTree;
import com.base.entity.RoleAssociateTree;
import com.base.entity.Tree;
import com.base.entity.UserRole;
import com.produce.common.base.dao.GenericDao;

/**
 *@author linzf
 **/
public interface RoleAssociateTreeDao extends GenericDao<RoleAssociateTree, QueryRoleAssociateTree> {

    /**
     * 功能描述：根据菜单ID来删除关联的菜单数据
     * @param tree
     * @return
     */
    int removeTreeByTreeId(Tree tree);

    /**
     * 功能描述：根据角色ID来删除关联的菜单数据
     * @param userRole
     * @return
     */
    int removeTreeByRoleId(UserRole userRole);
	
}