package com.news.entity;

import java.util.Date;

public class Vision {
    private Integer id;

    private String visionCode;

    private String url;

    private String describtion;

    private Date visionTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVisionCode() {
		return visionCode;
	}

	public void setVisionCode(String visionCode) {
		this.visionCode = visionCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public Date getVisionTime() {
		return visionTime;
	}

	public void setVisionTime(Date visionTime) {
		this.visionTime = visionTime;
	}

	
}