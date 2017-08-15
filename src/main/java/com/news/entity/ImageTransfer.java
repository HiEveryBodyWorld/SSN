package com.news.entity;


/**
 * @author wangxilu
 *
 */
public class ImageTransfer extends BaseBean{
	/**
	 * 图片上传描述
	 */
	private String description;
	
	private String ids;
	
	private Integer spaceId;

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
