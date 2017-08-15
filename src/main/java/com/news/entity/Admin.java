package com.news.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.news.common.JsonDateTimeSerializer;

/**
 * @author wangxilu
 *
 */
public class Admin extends BaseBean {
	/**
	 * 帐号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 最后登录时间
	 */
	@JsonSerialize(using = JsonDateTimeSerializer.class)
	private Date lastLoginTime;
	
	/**
	 * 最后登陆IP
	 */
	private String lastLoginIP;
	
	/**
	 * 角色集合
	 */
	@JsonDeserialize
	private List<Integer> roleIds = new ArrayList<Integer>();
	
	/**
	 * 分层次授权资源
	 */
	private List<Resources> permitResourcesList = new ArrayList<Resources>();
	
	/**
	 * 无层次授权资源
	 */
	private List<Resources> permitResourcesListNoLevel = new ArrayList<Resources>();
	
	
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public List<Integer> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}
	public List<Resources> getPermitResourcesList() {
		return permitResourcesList;
	}
	public void setPermitResourcesList(List<Resources> permitResourcesList) {
		this.permitResourcesList = permitResourcesList;
	}
	public List<Resources> getPermitResourcesListNoLevel() {
		return permitResourcesListNoLevel;
	}
	public void setPermitResourcesListNoLevel(
			List<Resources> permitResourcesListNoLevel) {
		this.permitResourcesListNoLevel = permitResourcesListNoLevel;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

}
