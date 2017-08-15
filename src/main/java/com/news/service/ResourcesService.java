package com.news.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.ResourcesDao;
import com.news.entity.ComboTree;
import com.news.entity.Resources;
@Service
public class ResourcesService implements BaseService<Resources, Integer>{
	
	@Autowired
	ResourcesDao resourcesDao;
	@Override
	public Integer insert(Resources t) {
		return this.resourcesDao.insert(t);
	}

	@Override
	public Integer update(Resources t) {
		return this.resourcesDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		return this.resourcesDao.delete(id);
	}

	@Override
	public WebPage<Resources> findPage(Map<String, Object> map) {
		return this.resourcesDao.findPage(map);
	}

	@Override
	public Resources findById(Integer id) {
		return this.resourcesDao.findById(id);
	}

	@Override
	public List<Resources> findListAll() {
		return this.resourcesDao.findListAll();
	}

	@Override
	public List<Resources> findListAllWithMap(Map<String, Object> paramsMap) {
		return this.resourcesDao.findListAllWithMap(paramsMap);
	}
	
	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		List<Resources> retList = this.resourcesDao.findListAllWithMap(paramsMap);
		if(retList.size() > 0){
			return true;
		}
		return false; 
	}

	public List<Resources> findListType0(){
		return this.resourcesDao.getSqlSessionTemplate().selectList(this.resourcesDao.getStatement("findListType0"));
	}
	
	public List<Resources> findListType1(){
		return this.resourcesDao.getSqlSessionTemplate().selectList(this.resourcesDao.getStatement("findListType1"));
	}
	
	public List<Resources> findListByIds(List<Integer> list){
		return this.resourcesDao.getSqlSessionTemplate().selectList(this.resourcesDao.getNameSpace() + ".findListByIds", list);
	}
	
	public List<Resources> showMenuResource(){
		List<Resources> retList = this.findListType0();
		List<Resources> newList = new ArrayList<Resources>();
		for(Resources res : retList){
			if(res.getpId() == 0){
				for(Resources in : retList){
					if(in.getpId().intValue() == res.getId().intValue()){
						res.getChildList().add(in);
					}
				}
				newList.add(res);
			}
		}
		return newList;
	}
	
	public List<Resources> showActionResource(){
		List<Resources> menuResList = this.showMenuResource();
		List<Resources> actionResList = this.findListType1();
		for(Resources res : menuResList){
			List<Resources> childMenuList = res.getChildList();
			for(Resources childMenu : childMenuList){
				for(Resources actionRes : actionResList){
					if(childMenu.getId().intValue() == actionRes.getpId().intValue()){
						childMenu.getActionList().add(actionRes);
					}
				}
			}
		}
		return menuResList;
	}
	
	public List<ComboTree> getComboTree(){
		List<Resources> resourcesList = this.findListType0();
		List<ComboTree> respList = new ArrayList<ComboTree>();
		ComboTree root = new ComboTree();
		root.setId(0);
		root.setText("系统根菜单");
		for(Resources res : resourcesList){
			if(res.getpId().intValue() == 0){
				ComboTree ct1 = new ComboTree();
				ct1.setId(res.getId());
				ct1.setText(res.getName());
				for(Resources res1 : resourcesList){
					if(res.getId().intValue() == res1.getpId().intValue()){
						ComboTree ct2 = new ComboTree();
						ct2.setId(res1.getId());
						ct2.setText(res1.getName());
						ct1.getChildren().add(ct2);
					}
				}
				root.getChildren().add(ct1);
			}
		}
		respList.add(root);
		return respList;
	}

}
