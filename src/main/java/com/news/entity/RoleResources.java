package com.news.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 *
 */
public class RoleResources extends BaseBean {
	private int roleId;
	private int resourcesId;
	private List<String> resourcesIds = new ArrayList<String>();
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(int resourcesId) {
		this.resourcesId = resourcesId;
	}
	public List<String> getResourcesIds() {
		return resourcesIds;
	}
	public void setResourcesIds(List<String> resourcesIds) {
		this.resourcesIds = resourcesIds;
	}
}
