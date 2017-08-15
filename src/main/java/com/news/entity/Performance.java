package com.news.entity;

public class Performance {
	
	private String personName;
	private Integer projectsNum;//项目总数
	private Double projectsTal;//项目总价
	private Double projectsAvg;//项目平均
	
	
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Integer getProjectsNum() {
		return projectsNum;
	}
	public void setProjectsNum(Integer projectsNum) {
		this.projectsNum = projectsNum;
	}
	public Double getProjectsTal() {
		return projectsTal;
	}
	public void setProjectsTal(Double projectsTal) {
		this.projectsTal = projectsTal;
	}
	public Double getProjectsAvg() {
		return projectsAvg;
	}
	public void setProjectsAvg(Double projectsAvg) {
		this.projectsAvg = projectsAvg;
	}

}
