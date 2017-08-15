package com.news.entity;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.news.common.JsonDateTimeSerializer;




/**
 * @author wangxilu
 *
 */
public class Projects extends BaseBean{
		// 项目名称
		private String projectName;
		// 活动开始时间
		@JsonSerialize(using = JsonDateTimeSerializer.class)
		private Date activityStartDate;
		// 活动结束时间
		@JsonSerialize(using = JsonDateTimeSerializer.class)
		private Date activityEndDate;
		// 广场ID
	    private Integer spaceId;
	    // 项目负责人
	    private String personName;
	    // 负责人ID
	    private Integer personId;
		// 项目价格
		private Double price;
		private String spaceName;
		private Integer transferPrice;
		
		public Integer getTransferPrice() {
			return transferPrice;
		}
		public void setTransferPrice(Integer transferPrice) {
			this.transferPrice = transferPrice;
		}
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public Date getActivityStartDate() {
			return activityStartDate;
		}
		public void setActivityStartDate(Date activityStartDate) {
			this.activityStartDate = activityStartDate;
		}
		public Date getActivityEndDate() {
			return activityEndDate;
		}
		public void setActivityEndDate(Date activityEndDate) {
			this.activityEndDate = activityEndDate;
		}
		public Integer getSpaceId() {
			return spaceId;
		}
		public void setSpaceId(Integer spaceId) {
			this.spaceId = spaceId;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getSpaceName() {
			return spaceName;
		}
		public void setSpaceName(String spaceName) {
			this.spaceName = spaceName;
		}
		public Integer getPersonId() {
			return personId;
		}
		public void setPersonId(Integer personId) {
			this.personId = personId;
		}
		
}
