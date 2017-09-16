package com.news.dao;

import org.springframework.stereotype.Repository;

import com.news.entity.Vision;
@Repository
public class VisionDao extends BaseDaoImpl<Vision, Integer> {

	@Override
	public String getNameSpace() {
		return "mappers.VisionMapper";
	}
}
