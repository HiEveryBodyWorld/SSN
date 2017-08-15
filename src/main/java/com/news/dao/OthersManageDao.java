package com.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.news.entity.OthersManage;

@Repository
public class OthersManageDao extends BaseDaoImpl<OthersManage, Integer>{

	@Override
	public String getNameSpace() {
		return "sqlmap.OthersManage";
	}
	
	public List<OthersManage> findByTitle(String title){
		return selectList(getNameSpace() + ".findByTitle",title);
	}

	
}