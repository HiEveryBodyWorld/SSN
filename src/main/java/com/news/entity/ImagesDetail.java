package com.news.entity;


/**
 * @author wangxilu
 *
 */
public class ImagesDetail {
	/**
	 * 图片访问路径
	 */
	private String url;
	
	private Integer id;
		
	private String name;
	
	private Integer isDel;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}
