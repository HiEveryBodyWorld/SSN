package com.news.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.ImagesDetail;

@Repository
public class ImageDetailDao extends BaseDaoImpl<ImagesDetail, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.ImagesDetail";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}
	
	public List<ImagesDetail> findListById(Integer id) {
		return getSqlSessionTemplate().selectList("findListById", id);
	} 

}
