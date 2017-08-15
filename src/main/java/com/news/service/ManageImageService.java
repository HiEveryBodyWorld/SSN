package com.news.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.ManageImageDao;
import com.news.entity.ManageImages;


@Service
public class ManageImageService implements BaseService<ManageImages,Integer> {

	
	@Autowired
	private ManageImageDao manageImageDao;
	
	@Override
	public Integer insert(ManageImages t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(ManageImages t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageImages findById(Integer id) {
		return null;
	}
	
	public List<ManageImages> findUrlByManageId(Integer id) {
		return manageImageDao.findUrlByManageId(id);
	}

	@Override
	public List<ManageImages> findListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebPage<ManageImages> findPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ManageImages> findListAllWithMap(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return false;
	}

}
