package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.RoleResources;
@Repository
public class RoleResourcesDao extends BaseDaoImpl<RoleResources, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.RoleResources";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

	@Override
	public String getStatement(String sqlId) {
		return super.getStatement(sqlId);
	}

	public int deleteByRoleId(Integer roleId) {
		return getSqlSessionTemplate().delete("deleteByRoleId", roleId);
	}
}
