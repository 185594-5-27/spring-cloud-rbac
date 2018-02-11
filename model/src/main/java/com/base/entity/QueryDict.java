package com.base.entity;


import com.base.common.QueryBase;

/**
 *@author linzf
 **/
public class QueryDict extends QueryBase {

	public QueryDict(){
		super();
	}

	public QueryDict(String isLoad){
		this.isLoad = isLoad;
	}


	private String code;
	private String text;
	private String type;
	private String value;
	private String isLoad;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsLoad() {
		return isLoad;
	}

	public void setIsLoad(String isLoad) {
		this.isLoad = isLoad;
	}

}
