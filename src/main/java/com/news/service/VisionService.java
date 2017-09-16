package com.news.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.common.WebPage;
import com.news.dao.VisionDao;
import com.news.entity.Vision;

@Service
public class VisionService implements BaseService<Vision, Integer>{
	@Resource
	public VisionDao visionDao;

	@Override
	public Integer insert(Vision t) {
		// TODO Auto-generated method stub
		return visionDao.insert(t);
	}

	@Override
	public Integer update(Vision t) {
		// TODO Auto-generated method stub
		return visionDao.update(t);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vision findById(Integer id) {
		// TODO Auto-generated method stub
		return visionDao.findById(id);
	}

	@Override
	public List<Vision> findListAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebPage<Vision> findPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return visionDao.findPage(map);
	}

	@Override
	public List<Vision> findListAllWithMap(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsEntity(Map<String, Object> paramsMap) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
