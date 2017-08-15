package com.news.entity;

import java.util.List;

/**
 * 后台向前台返回JSON，用于easyui的datagrid
 * 
 * @author 
 * 
 */
@SuppressWarnings("rawtypes")
public class EasyuiDataGridJson implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -920929596070375581L;
	private int total;// 总记录数
	
	private List rows;// 每行记录
	private List footer;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}

}
