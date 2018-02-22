package com.produce.sys.service;


import com.base.entity.QueryUserRole;
import com.base.entity.UserRole;
import com.produce.common.base.dao.GenericDao;
import com.produce.common.base.service.GenericService;
import com.produce.sys.dao.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author linzf
 **/
@Service("userRoleService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class UserRoleService extends GenericService<UserRole, QueryUserRole> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private UserRoleDao userRoleDao;

	@Override
	protected GenericDao<UserRole, QueryUserRole> getDao() {
		return userRoleDao;
	}

	/**
	 * 功能描述：获取权限菜单数据
	 * @param entity
	 * @return
	 */
	public UserRole getUserRoleAssociate(UserRole entity){
		return userRoleDao.getUserRoleAssociate(entity);
	}

}