package com.news.entity;

import java.util.List;

public class HootCityTransfer {
	
    private String cityName;
    
    List<BusinessSpace> spaceList;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<BusinessSpace> getSpaceList() {
		return spaceList;
	}

	public void setSpaceList(List<BusinessSpace> spaceList) {
		this.spaceList = spaceList;
	}

}