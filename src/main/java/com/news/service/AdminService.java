package com.news.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.AdminDao;
import com.news.dao.AdminRoleDao;
import com.news.entity.Admin;
/**
 * 用户Service接口
 * @author wangxilu
 * @date 2014/12/12
 */
@Service
public class AdminService implements BaseService<Admin , Integer>{
	@Resource
	private AdminDao  adminDao ; 
	@Resource
	private AdminRoleDao  adminRoleDao ;
	@Autowired
	private AdminRoleService adminRoleService;
	
	public void insertLogic(Admin t,Integer roleId){
    	this.adminDao.insert(t);
    	this.adminRoleService.insert(t.getId(), roleId);
	}

	@Override
	public Integer insert(Admin admin) {
		return adminDao.insert(admin);
	}

	@Override
	public Integer update(Admin admin) {
		return adminDao.update(admin);
	}
	@Override
	public Admin findById(Integer id) {
		return adminDao.findById(id);
	}

	@Override
	public List<Admin> findListAll() {
		return adminDao.findListAll();
	}

	@Override
	public Integer delete(Integer id) {
		
		Integer num = adminDao.delete(id);
		
		if(num!=0){
			adminRoleDao.deleteByAdminId(id);
		}
		
		return num;
	}
	public Integer deletes(String ids) {
		String[] userIds=ids.split(",");
		
		for (int i = 0; i < userIds.length; i++){
			
			adminDao.delete(userIds[i]);
			
			adminRoleDao.deleteByAdminId(Integer.parseInt(userIds[i]));
		}
		
		return Integer.parseInt(userIds[0]);
	}

	@Override
	public List<Admin> findListAllWithMap(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Admin findByUsername(String username) {
		return adminDao.findByName(username);
	}

	@Override
	public WebPage<Admin> findPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.findPage(map);
	}
	public Admin findAdminByAccountWithPassword(String account, String password){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("account", account);
		map.put("password", password);
		List<Admin> adminList = this.adminDao.findListAllWithMap(map);
		if(adminList.size() == 1){
			Admin admin =  adminList.get(0);
			map.clear();
			return admin;
		}
		return null;
	}
	

}
