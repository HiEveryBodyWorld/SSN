package com.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.AdminRoleDao;
import com.news.entity.AdminRole;

@Service
public class AdminRoleService implements BaseService<AdminRole, Integer> {
	
	@Autowired
	private AdminRoleDao beanDao;

	@Override
	public Integer insert(AdminRole t) {
		return this.beanDao.insert(t);
	}

	@Override
	public Integer update(AdminRole t) {
		return this.beanDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		return this.beanDao.delete(id);
	}

	@Override
	public WebPage<AdminRole> findPage(Map<String, Object> map) {
		return this.beanDao.findPage(map);
	}

	@Override
	public AdminRole findById(Integer id) {
		return this.beanDao.findById(id);
	}

	@Override
	public List<AdminRole> findListAll() {
		return this.beanDao.findListAll();
	}

	@Override
	public List<AdminRole> findListAllWithMap(Map<String, Object> paramsMap) {
		return this.beanDao.findListAllWithMap(paramsMap);
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		return false;
	}
	
	public void insert(Integer adminId, Integer roleId){
		this.deleteByAdminId(adminId);
		
		AdminRole ar = new AdminRole();
		ar.setAdminId(adminId);
		ar.setRoleId(roleId);
		this.insert(ar);
	}
	
	public int deleteByAdminId(Integer adminId){
		return this.beanDao.getSqlSessionTemplate().delete(this.beanDao.getNameSpace() + ".deleteByAdminId", adminId);
	}

}
