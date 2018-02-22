package com.produce.sys.dao;


import com.base.entity.QueryUserAssociateRole;
import com.base.entity.User;
import com.base.entity.UserAssociateRole;
import com.produce.common.base.dao.GenericDao;

/**
 *@author linzf
 **/
public interface UserAssociateRoleDao extends GenericDao<UserAssociateRole, QueryUserAssociateRole> {

    /**
     * 功能描述：根据用户的ID来删除用户的权限数据
     * @param user
     * @return
     */
    int removeUserRole(User user);
}