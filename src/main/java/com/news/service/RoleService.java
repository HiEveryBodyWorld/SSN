/**
 * 
 */
package com.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.RoleDao;
import com.news.entity.Role;

/**
 * @author dell
 *
 */
@Service
public class RoleService implements BaseService<Role, Integer> {
	
	@Autowired
	private RoleDao beanDao;

	@Override
	public Integer insert(Role t) {
		return this.beanDao.insert(t);
	}

	@Override
	public Integer update(Role t) {
		return this.beanDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		return this.beanDao.delete(id);
	}

	@Override
	public WebPage<Role> findPage(Map<String, Object> map) {
		return this.beanDao.findPage(map);
	}

	@Override
	public Role findById(Integer id) {
		return this.beanDao.findById(id);
	}

	@Override
	public List<Role> findListAll() {
		return this.beanDao.findListAll();
	}

	@Override
	public List<Role> findListAllWithMap(Map<String, Object> paramsMap) {
		return this.beanDao.findListAllWithMap(paramsMap);
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		return false;
	}

}
