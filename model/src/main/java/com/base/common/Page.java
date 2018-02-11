package com.base.common;

import java.util.List;

/**
 * 分页实体类
 * */
@SuppressWarnings("rawtypes")
public class Page {
	private List rows;
	private long total;
	
	public Page(){}
	
	public Page(List rows, long total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Page [rows=" + rows + ", total=" + total + "]";
	}
}
