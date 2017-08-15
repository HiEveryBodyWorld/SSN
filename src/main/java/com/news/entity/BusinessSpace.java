package com.news.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.news.common.JsonDateTimeSerializer;



/**
 * @author wangxilu
 *
 */
public class BusinessSpace extends BaseBean {
		// 场地名称
		private String spaceName;
		// 地区编码
		private Integer areacode;
		// 精确地址
		private String address;
		// 经度
		private double longitude;
		// 纬度
		private double dimensions;
		// 省
		private String province ;
		// 市
		private String city ;
		// 县
		private String area ;
		// 联系电话
		private String phone ;
		private String introduce;
		//
		private double businessArea;
		private String type;
		//所属商圈
		private String  businessCircle;
		//客流量
		private Integer traffic;
		private String storeLocation;
		private String features;
		//小编意见
		private String review;
		private String contact;
		//上架下架
		private Integer upDown;
		@JsonSerialize(using = JsonDateTimeSerializer.class)
		private Date   openDate;
		
		
		private List<Projects> projectsList;
		private String imageIds;
		
		private List<String> spaceImageUrl;
		private String contact2;
		private String phone2;
		private String totalMobile;
		private String mobile1;
		private String mobile;
        private Integer ishoot;
        private String spaceType;

        private List<Location> locations;
        
		public List<Location> getLocations() {
			return locations;
		}

		public void setLocations(List<Location> locations) {
			this.locations = locations;
		}

		public String getTotalMobile() {
			return totalMobile;
		}

		public void setTotalMobile(String totalMobile) {
			this.totalMobile = totalMobile;
		}

		public String getMobile1() {
			return mobile1;
		}

		public void setMobile1(String mobile1) {
			this.mobile1 = mobile1;
		}

		public List<String> getSpaceImageUrl() {
			return spaceImageUrl;
		}

		public void setSpaceImageUrl(List<String> spaceImageUrl) {
			this.spaceImageUrl = spaceImageUrl;
		}

		public String getImageIds() {
			return imageIds;
		}

		public void setImageIds(String imageIds) {
			this.imageIds = imageIds;
		}

		public Integer getIshoot() {
			return ishoot;
		}

		public String getSpaceType() {
			return spaceType;
		}

		public void setSpaceType(String spaceType) {
			this.spaceType = spaceType;
		}

		public void setIshoot(Integer ishoot) {
			this.ishoot = ishoot;
		}

		public List<Projects> getProjectsList() {
			return projectsList;
		}

		public void setProjectsList(List<Projects> projectsList) {
			this.projectsList = projectsList;
		}
		
		public Integer getAreacode() {
			return areacode;
		}
		public void setAreacode(Integer areacode) {
			this.areacode = areacode;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getLongitude() {
			return longitude;
		}
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public double getDimensions() {
			return dimensions;
		}
		public void setDimensions(double dimensions) {
			this.dimensions = dimensions;
		}
		public String getProvince() {
			return province;
		}
		public Integer getUpDown() {
			return upDown;
		}
		public void setUpDown(Integer upDown) {
			this.upDown = upDown;
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
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getSpaceName() {
			return spaceName;
		}
		public void setSpaceName(String spaceName) {
			this.spaceName = spaceName;
		}
		public String getIntroduce() {
			return introduce;
		}
		public void setIntroduce(String introduce) {
			this.introduce = introduce;
		}
		public double getBusinessArea() {
			return businessArea;
		}
		public void setBusinessArea(double businessArea) {
			this.businessArea = businessArea;
		}
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBusinessCircle() {
			return businessCircle;
		}
		public void setBusinessCircle(String businessCircle) {
			this.businessCircle = businessCircle;
		}
		public Integer getTraffic() {
			return traffic;
		}
		public void setTraffic(Integer traffic) {
			this.traffic = traffic;
		}
		public String getStoreLocation() {
			return storeLocation;
		}
		public void setStoreLocation(String storeLocation) {
			this.storeLocation = storeLocation;
		}
		public String getFeatures() {
			return features;
		}
		public void setFeatures(String features) {
			this.features = features;
		}
		public String getReview() {
			return review;
		}
		public void setReview(String review) {
			this.review = review;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public Date getOpenDate() {
			return openDate;
		}
		public void setOpenDate(Date openDate) {
			this.openDate = openDate;
		}

		public String getContact2() {
			return contact2;
		}

		public void setContact2(String contact2) {
			this.contact2 = contact2;
		}

		public String getPhone2() {
			return phone2;
		}

		public void setPhone2(String phone2) {
			this.phone2 = phone2;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

}
