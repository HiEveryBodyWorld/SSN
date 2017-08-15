package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.UploadImages;

@Repository
public class UploadImageDao extends BaseDaoImpl<UploadImages, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.UploadImages";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

}
