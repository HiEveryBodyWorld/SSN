package com.news.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wangxilu
 * 菜单和动作资源实体
 *
 */
public class Resources extends BaseBean {
	
	/**
	 * 资源名称
	 */
	private String name;
	/**
	 * 资源地址
	 */
	private String url;
	/**
	 * 上级资源标识
	 */
	private Integer pId;
	/**
	 * 资源类型(0:菜单,1:动作)
	 */
	private Integer type = 0;
	
	/**
	 * 资源排序
	 */
	private Integer sortNum = 1;
	
	/**
	 * 上级资源名称
	 */
	private String pName;
	
	/**
	 * 菜单资源
	 */
	private List<Resources> childList = new ArrayList<Resources>();
	
	/**
	 * 动作资源
	 */
	private List<Resources> actionList = new ArrayList<Resources>();
	
	/**
	 * 授权资源
	 */
	private List<Integer> resourcesIdsPermission = new ArrayList<Integer>();
	
	public List<Integer> getResourcesIdsPermission() {
		return resourcesIdsPermission;
	}

	public void setResourcesIdsPermission(List<Integer> resourcesIdsPermission) {
		this.resourcesIdsPermission = resourcesIdsPermission;
	}
	
	public List<Resources> getActionList() {
		return actionList;
	}
	public void setActionList(List<Resources> actionList) {
		this.actionList = actionList;
	}
	public List<Resources> getChildList() {
		return childList;
	}
	public void setChildList(List<Resources> childList) {
		this.childList = childList;
	}
	/**
	 * @param name
	 * @param url
	 * @param pId
	 * @param type
	 */
	public Resources(String name, String url, Integer pId, Integer type) {
		super();
		this.name = name;
		this.url = url;
		this.pId = pId;
		this.type = type;
	}
	/**
	 * 
	 */
	public Resources() {
		super();
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	@Override
	public String toString() {
		return "Resources [name=" + name + ", url=" + url + ", pId=" + pId
				+ ", pName=" + pName + ", type=" + type + ", sortNum="
				+ sortNum + ", childList=" + childList + ", actionList="
				+ actionList + ", resourcesIdsPermission="
				+ resourcesIdsPermission + "]";
	}
}

