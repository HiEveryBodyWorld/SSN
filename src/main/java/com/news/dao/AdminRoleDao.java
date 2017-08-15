/**
 * 
 */
package com.news.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.AdminRole;

/**
 * @author dell
 *
 */
@Repository
public class AdminRoleDao extends BaseDaoImpl<AdminRole, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.AdminRole";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

	@Override
	public String getStatement(String sqlId) {
		return super.getStatement(sqlId);
	}
	
	public Integer deleteByAdminId(Integer id) {
		return getSqlSessionTemplate().delete("deleteByAdminId", id);
	} 

}
