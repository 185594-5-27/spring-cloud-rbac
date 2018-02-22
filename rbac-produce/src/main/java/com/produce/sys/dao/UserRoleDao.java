package com.produce.sys.dao;


import com.base.entity.QueryUserRole;
import com.base.entity.UserRole;
import com.produce.common.base.dao.GenericDao;

/**
 *@author linzf
 **/
public interface UserRoleDao extends GenericDao<UserRole, QueryUserRole> {

    /**
     * 功能描述：获取权限菜单数据
     * @param entity
     * @return
     */
    UserRole getUserRoleAssociate(UserRole entity);
	
}