package com.news.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.news.common.JsonDateTimeSerializer;

/**
 * 
 * @author wangxilu
 *
 */
public class BaseBean {
	/**
	 * 实体唯一标识
	 */
	private Integer id;
	/**
	 * 创建者标识
	 */
	private Integer creatorId;
	/**
	 * 创建者
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	private Date createTime;
	/**
	 * 更新者标识
	 */
	private Integer operatorId;
	/**
	 * 更新者
	 */
	private String operator;
	/**
	 * 更新时间
	 */
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	private Date operateTime;
	
	/**
	 * 是否删除
	 */
	private Integer isDel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public Integer getIsDel() {
		return isDel;
	}
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}


}
