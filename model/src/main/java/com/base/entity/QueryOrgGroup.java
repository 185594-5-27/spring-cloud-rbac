package com.base.entity;


import com.base.common.QueryBase;

/**
 *@author linzf
 **/
public class QueryOrgGroup extends QueryBase {
	private Long existingNum;
	private String groupCode;
	private String name;
	private String node;
	private Long num;
	private String parentNode;

	public Long getExistingNum() {
		return existingNum;
	}

	public void setExistingNum(Long existingNum) {
		this.existingNum = existingNum;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

}
