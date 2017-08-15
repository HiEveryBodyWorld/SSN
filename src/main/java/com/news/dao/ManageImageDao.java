package com.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.news.entity.ManageImages;


@Repository
public class ManageImageDao extends BaseDaoImpl<ManageImages, Integer> {

	@Override
	public String getNameSpace() {
		return "sqlmap.ManageImages";
	}
	
	public List<ManageImages> findUrlByManageId(Integer manageId){
		return selectList(getNameSpace() + ".findUrlByManageId",manageId);
	}

}
