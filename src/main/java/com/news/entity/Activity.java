package com.news.entity;

import java.util.List;




/**
 * @author wangxilu
 *
 */
public class Activity {
		// 活动ID
		private Integer id;
		// 活动描述
		private String description;
		// ids
	    private String ids;
	    // 场地ID
	    private Integer spaceId;
	    
	    private List<String> imagesurl;
		public List<String> getImagesurl() {
			return imagesurl;
		}
		public void setImagesurl(List<String> imagesurl) {
			this.imagesurl = imagesurl;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIds() {
			return ids;
		}
		public void setIds(String ids) {
			this.ids = ids;
		}
		public Integer getSpaceId() {
			return spaceId;
		}
		public void setSpaceId(Integer spaceId) {
			this.spaceId = spaceId;
		}
		 		
}
