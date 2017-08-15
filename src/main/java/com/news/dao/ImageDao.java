package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.Images;

@Repository
public class ImageDao extends BaseDaoImpl<Images, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.Images";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

}
