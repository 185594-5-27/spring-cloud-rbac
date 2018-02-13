package com.produce.common.base.service;



import com.base.common.Page;
import com.base.common.QueryBase;
import com.produce.common.base.dao.GenericDao;

import java.util.List;

/**
 * 通用Service
 * @author linzf
 * */
public abstract class GenericService<T, Q extends QueryBase> {
	protected abstract GenericDao<T, Q> getDao();

	/**
	 * 功能描述：根据ID来获取数据
	 * @param id
	 * @return
	 */
	public T getById(int id){
		return getDao().getById(id);
	}

	/**
	 * 根据主键值获取对象
	 * @param entity
	 * */
	public T get(T entity){
		return getDao().get(entity);
	}

	/**
	 * 获取全部实体
	 * */
    public List<T> loadAll(){
    	return getDao().loadAll();
    }

	/**
	 * 查找是否存在
	 * @param queryModel 查询条件
	 * */
	public boolean isExist(Q queryModel){
		return getDao().isExist(queryModel)>0;
	}

	/** 
	 * 保存
	 * @param entity 保存对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean save(T entity) throws Exception{
		return getDao().save(entity)>0;
	}

	/** 
	 * 更新 
	 * @param entity 修改对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean update(T entity) throws Exception{
		return getDao().update(entity)>0;
	}

	/**
	 * 删除 
	 * @param entity 删除对象
	 * @return boolean
	 * @throws Exception
	 * */
	public boolean delete(T entity) throws Exception{
		return getDao().delete(entity)>0;
	}

	/**
	 * 分页查询
	 * @param queryModel 查询条件
	 *  */
	public Page findByPage(Q queryModel){
		List<T> list =  getDao().findByPage(queryModel);
		int count = getDao().count(queryModel);
		return new Page(list, count);
	}
	
	/**
	 * 统计
	 * @param queryModel 查询条件
	 * @return int
	 * */
	public int count(Q queryModel){
		return getDao().count(queryModel);
	}

	/**
	 * 查询
	 * @param queryModel 查询条件
	 *  */
	public List<T> query(Q queryModel){
		return getDao().query(queryModel);
	}
	/**
	 * 根据id数组删除记录
	 * @param ids 数组
	 * @return boolean
	 * */
	public boolean deleteByIds(String[] ids) throws Exception{
		return getDao().deleteByIds(ids)>0;
	}

	/**
	 * 功能描述：批量删除数据
	 * @param entityList
	 * @return
	 */
	public boolean removeBath(List<T> entityList) throws Exception{
		for(T t:entityList){
			if(!delete(t)){
				return false;
			}
		}
       return true;
	}
}
