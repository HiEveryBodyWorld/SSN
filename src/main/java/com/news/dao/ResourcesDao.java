package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.Resources;

@Repository
public class ResourcesDao extends BaseDaoImpl<Resources, Integer>{

	@Override
	public String getNameSpace() {
		return "sqlmap.Resources";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

	@Override
	public String getStatement(String sqlId) {
		return super.getStatement(sqlId);
	}

}
