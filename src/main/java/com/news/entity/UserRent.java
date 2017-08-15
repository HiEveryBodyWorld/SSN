package com.news.entity;

import java.util.Date;

/**
 * @author wangxilu
 *
 */
public class UserRent{
		
		private Integer id;
		private Integer userId;
		private String name;
		private String phone;
		private String province;
		private String city;
		private Integer activityNumber;
		private Date startDate;
		private Date endDate;
		private String type;
		private String others;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Integer getActivityNumber() {
			return activityNumber;
		}
		public void setActivityNumber(Integer activityNumber) {
			this.activityNumber = activityNumber;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getOthers() {
			return others;
		}
		public void setOthers(String others) {
			this.others = others;
		}
		
}
