package com.news.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.RoleResourcesDao;
import com.news.entity.Admin;
import com.news.entity.AdminRole;
import com.news.entity.Resources;
import com.news.entity.ResourcesComparator;
import com.news.entity.RoleResources;

/**
 * @author dell
 *
 */
@Service("permissionService")
public class RoleResourcesService implements BaseService<RoleResources, Integer> {
	@Autowired 
	RoleResourcesDao roleResourcesDao;
	@Autowired
	AdminRoleService adminRoleService;
	@Autowired
	ResourcesService resourcesService;
	
	@Override
	public Integer insert(RoleResources t) {
		return this.roleResourcesDao.insert(t);
	}

	@Override
	public Integer update(RoleResources t) {
		return this.roleResourcesDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		return this.roleResourcesDao.delete(id);
	}

	@Override
	public WebPage<RoleResources> findPage(Map<String, Object> map) {
		return this.roleResourcesDao.findPage(map);
	}

	@Override
	public RoleResources findById(Integer id) {
		return this.roleResourcesDao.findById(id);
	}

	@Override
	public List<RoleResources> findListAll() {
		return this.roleResourcesDao.findListAll();
	}

	@Override
	public List<RoleResources> findListAllWithMap(Map<String, Object> paramsMap) {
		return this.roleResourcesDao.findListAllWithMap(paramsMap);
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		return false;
	}
	
	public Integer deleteByRoleId(Integer roleId) {
		return this.roleResourcesDao.deleteByRoleId(roleId);
	}
	
	/**
	 * @param t
	 */
	public void insertLogic(RoleResources t){
		int roleId = t.getRoleId();
		this.deleteResourcesIdsByRoleId(roleId);
		for(String s : t.getResourcesIds()){
			String[] sArr = s.split("-");
			RoleResources rr = new RoleResources();
			rr.setRoleId(roleId);
			rr.setResourcesId(Integer.valueOf(sArr[0]));
			rr.setCreateTime(new Date());
			this.roleResourcesDao.insert(rr);
		}
	}
	
	/**
	 * @param roleId
	 */
	public void deleteResourcesIdsByRoleId(int roleId){
		this.roleResourcesDao.getSqlSessionTemplate().delete(this.roleResourcesDao.getNameSpace() + ".deleteResourcesIdsByRoleId", roleId);
	}
	
	/**
	 * @param admin
	 * @return
	 */
	public List<Integer> findResourcesIdsByAdmin(Admin admin){
		List<Integer> retList = new ArrayList<Integer>();
		HashMap<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("adminId", admin.getId());
		List<AdminRole> adminRoleList = this.adminRoleService.findListAllWithMap(paramsMap);
		for(AdminRole adminRole : adminRoleList){
			Integer roleId = adminRole.getRoleId();
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("roleId", roleId);
			List<RoleResources> permisstionList = this.findListAllWithMap(paramMap);
			for(RoleResources rr : permisstionList){
				if(!permisstionList.contains(rr.getResourcesId())){
					retList.add(rr.getResourcesId());
				}
			}
		}
		return retList;
	}
	
	public List<Resources> getMenusByAdmin(Admin admin){
			List<Resources> menuResourcesList = new ArrayList<Resources>();
			List<Resources> resourcesList = new ArrayList<Resources>();
			List<Integer> resourcesIdsPermission = this.findResourcesIdsByAdmin(admin);
			if(resourcesIdsPermission.size() == 0){
				return menuResourcesList;
			}
			resourcesList = this.resourcesService.findListByIds(resourcesIdsPermission);
			for(Resources res : resourcesList){
				if(res.getpId().intValue() == 0 && res.getType().intValue() == 0){
					menuResourcesList.add(res);
				}
			}
			for(Resources res : menuResourcesList){
				for(Resources s : resourcesList){
					if(s.getpId().intValue() == res.getId().intValue() && s.getType().intValue() == 0){
						res.getChildList().add(s);
					}
				}
				Collections.sort(res.getChildList(), new ResourcesComparator());
				List<Resources> childList = res.getChildList();
				for(Resources tmp : childList){
					for(Resources s : resourcesList){
						if(s.getpId().intValue() == tmp.getId().intValue() && s.getType().intValue() == 1){
							tmp.getActionList().add(s);
						}
					}
				}
			}
			Collections.sort(menuResourcesList, new ResourcesComparator());
			return menuResourcesList;
	}
	
	public List<String> findActionUrlsByPermission(List<Resources> resList){
		List<String> strList = new ArrayList<String>();
		for(Resources res : resList){
			List<Resources> childList = res.getChildList();
			for(Resources tmp : childList){
				List<Resources> actionList = tmp.getActionList();
				for(Resources in : actionList){
					strList.add(in.getUrl());
				}
			}
		}
		return strList;
	}
	
	public boolean isPermit(Admin admin , String url){
		List<Resources> resList = admin.getPermitResourcesList();
		List<String> urlList = this.findActionUrlsByPermission(resList);
		if(urlList.contains(url)){
			return true;
		}else{
			return false;
		}
	}
	
	public List<Resources> processPermitResources(List<Resources> resourcesPermission){
		List<Resources> retList = new ArrayList<Resources>();
		for(Resources res : resourcesPermission){
			retList.add(res);
			for(Resources child : res.getChildList()){
				retList.add(child);					
					for(Resources action : child.getActionList()){
						retList.add(action);
					}
			}
		}
		return retList;
	}
}
