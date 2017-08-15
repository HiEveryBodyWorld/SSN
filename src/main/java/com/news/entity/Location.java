package com.news.entity;

import java.util.List;




/**
 * @author wangxilu
 *
 */
public class Location extends BaseBean {
		// 类型
		private String type;
		// 场地名称
		private String locationName;
		// 面积
		private double locationArea;
		// 长
		private String length;
		// 宽
		private String width;
		// 底价
		private double floorPrice ;
		// 报价
		private double price ;
		// 频次
		private Integer frequency ;
		// 点间距
		private String pointSpacing ;
		// 朝向
		private String toward;
		//室内室外
		private String door;
		//分辨率
		private String resolutionlength;
		//分辨率
	    private String resolutionwidth;
		//屏幕所属
		private String  belong;
		//联系人
		private String contact;
		//联系电话
		private String mobile;
		//备注
		private String note;
		//限高
		private double heightLimit;
		//场地ID
		private Integer spaceId;
		//图片Ids
	    private String ids;
	    
	    private List<String> imagesurl;
	    
		public String getResolutionlength() {
			return resolutionlength;
		}
		public void setResolutionlength(String resolutionlength) {
			this.resolutionlength = resolutionlength;
		}
		public String getResolutionwidth() {
			return resolutionwidth;
		}
		public void setResolutionwidth(String resolutionwidth) {
			this.resolutionwidth = resolutionwidth;
		}
		public List<String> getImagesurl() {
			return imagesurl;
		}
		public void setImagesurl(List<String> imagesurl) {
			this.imagesurl = imagesurl;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getLocationName() {
			return locationName;
		}
		public void setLocationName(String locationName) {
			this.locationName = locationName;
		}
		public double getLocationArea() {
			return locationArea;
		}
		public void setLocationArea(double locationArea) {
			this.locationArea = locationArea;
		}
	
		public String getIds() {
			return ids;
		}
		public void setIds(String ids) {
			this.ids = ids;
		}
		public double getFloorPrice() {
			return floorPrice;
		}
		public void setFloorPrice(double floorPrice) {
			this.floorPrice = floorPrice;
		}
		
		public String getLength() {
			return length;
		}
		public void setLength(String length) {
			this.length = length;
		}
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public Integer getFrequency() {
			return frequency;
		}
		public void setFrequency(Integer frequency) {
			this.frequency = frequency;
		}
		public String getPointSpacing() {
			return pointSpacing;
		}
		public void setPointSpacing(String pointSpacing) {
			this.pointSpacing = pointSpacing;
		}
		public String getToward() {
			return toward;
		}
		public void setToward(String toward) {
			this.toward = toward;
		}
		
		public String getDoor() {
			return door;
		}
		public void setDoor(String door) {
			this.door = door;
		}
		public String getBelong() {
			return belong;
		}
		public void setBelong(String belong) {
			this.belong = belong;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public double getHeightLimit() {
			return heightLimit;
		}
		public void setHeightLimit(double heightLimit) {
			this.heightLimit = heightLimit;
		}
		public Integer getSpaceId() {
			return spaceId;
		}
		public void setSpaceId(Integer spaceId) {
			this.spaceId = spaceId;
		}
		
}
