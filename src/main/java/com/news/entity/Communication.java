package com.news.entity;

import java.util.Date;

public class Communication extends BusinessSpace{
    private Integer id;

    private Integer businessId;

    private Date createDate;
    
    private Date communicateDate;
    
    private String areaType;

    private Double price;

    private String chargeName;
    
    private String communicateName;

    private Date updateDate;

    private String name;

    private String detail;
    

    public Date getCommunicateDate() {
		return communicateDate;
	}

	public void setCommunicateDate(Date communicateDate) {
		this.communicateDate = communicateDate;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCommunicateName() {
        return communicateName;
    }

    public void setCommunicateName(String communicateName) {
        this.communicateName = communicateName == null ? null : communicateName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }


	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
}