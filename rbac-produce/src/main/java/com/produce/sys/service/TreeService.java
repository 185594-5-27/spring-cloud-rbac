package com.produce.sys.service;

import com.base.entity.QueryTree;
import com.base.entity.Tree;
import com.base.entity.User;
import com.produce.common.base.dao.GenericDao;
import com.produce.common.base.service.GenericService;
import com.produce.sys.dao.RoleAssociateTreeDao;
import com.produce.sys.dao.TreeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@author linzf
 **/
@Service("treeService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class TreeService extends GenericService<Tree, QueryTree> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private TreeDao treeDao;
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private RoleAssociateTreeDao roleAssociateTreeDao;

	@Override
	protected GenericDao<Tree, QueryTree> getDao() {
		return treeDao;
	}

	/**
	 * 功能描述：删除菜单的数据
	 * @param entity 删除对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean delete(Tree entity) throws Exception {
		roleAssociateTreeDao.removeTreeByTreeId(entity);
		return super.delete(entity);
	}

	/**
	 * 功能描述：加载用户的菜单树的数据
	 * @param user
	 * @return
	 */
	public List<Tree> loadUserTree(User user){
		return treeDao.loadUserTree(user);
	}
}