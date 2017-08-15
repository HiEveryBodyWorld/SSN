package com.news.entity;


/**
 * @author wangxilu
 *
 */
public class Images extends BaseBean {
	/**
	 * 图片上传描述
	 */
	private String description;
	
	private String url;
	
	private String name;
	
	private Integer spaceId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(Integer spaceId) {
		this.spaceId = spaceId;
	}


}
