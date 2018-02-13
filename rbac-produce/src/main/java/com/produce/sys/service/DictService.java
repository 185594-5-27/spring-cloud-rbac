package com.produce.sys.service;


import com.base.entity.Dict;
import com.base.entity.QueryDict;
import com.produce.common.base.dao.GenericDao;
import com.produce.common.base.service.GenericService;
import com.produce.sys.dao.DictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *@author linzf
 **/
@Service("dictService")
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictService extends GenericService<Dict, QueryDict> {
	@Autowired
	@SuppressWarnings("SpringJavaAutowiringInspection")
	private DictDao dictDao;
	@Override
	protected GenericDao<Dict, QueryDict> getDao() {
		return dictDao;
	}
}