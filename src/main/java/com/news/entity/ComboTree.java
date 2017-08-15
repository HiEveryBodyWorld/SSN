package com.news.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合树状下拉框
 * <input id="cc" class="easyui-combotree"  style="width:100px;" data-options="data:[{'id':0,'text':'0','children':[{'id':1,'text':'1','children':[{'id':11,'text':'11'}]}]}]">
 * @author dell
 *
 */
public class ComboTree {
	private int id;
	private String text;
	private List<ComboTree> children = new ArrayList<ComboTree>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<ComboTree> getChildren() {
		return children;
	}
	public void setChildren(List<ComboTree> children) {
		this.children = children;
	}
	
}
