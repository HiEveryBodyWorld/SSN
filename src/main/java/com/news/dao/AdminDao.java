package com.news.dao;

import org.springframework.stereotype.Repository;

import com.news.entity.Admin;

/**
 * 用户DAO接口实现类
 * @author wangxilu
 * @date 2014/12/12
 */
@Repository
public class AdminDao extends BaseDaoImpl<Admin, Integer>{
	@Override
	public String getNameSpace() {
		return "sqlmap.Admin";
	}

	public Admin findByName(String username) {
        return selectOne(getNameSpace() + ".findByUsername", username); 
    }

}
