package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.Role;

@Repository
public class RoleDao extends BaseDaoImpl<Role, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.Role";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

	@Override
	public String getStatement(String sqlId) {
		return super.getStatement(sqlId);
	}

}
