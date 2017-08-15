package com.news.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.news.entity.Location;

@Repository
public class LocationDao extends BaseDaoImpl<Location, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.Location";
	}
	
	public SqlSessionTemplate getSqlSessionTemplate(){
		return super.getSqlSessionTemplate();
	}

	public List<Location> findLocationById(Integer spaceId){
		return selectList("findLocationById",spaceId);
	}
}
