package com.news.entity;

import java.util.List;

public class SpaceRecords {
	
	
	private String personName;
	
	private List<BusinessSpace> businessSpaceList;
	
	private Performance performance;
	
	public Performance getPerformance() {
		return performance;
	}
	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<BusinessSpace> getBusinessSpaceList() {
		return businessSpaceList;
	}

	public void setBusinessSpaceList(List<BusinessSpace> businessSpaceList) {
		this.businessSpaceList = businessSpaceList;
	}


}
