package com.base.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *@author linzf
 **/
public class Tree implements Comparable<Tree> {

	public Tree(){
		super();
	}

	public Tree(Long id){
		this.id = id;
	}

	private long id;
	private String code;
	private String icon;
	private String name;
	private long pId;
	private long treeOrder;
	private String url;
	private String state;
	// 菜单节点是否选中的状态
	private boolean checked;
	// 父菜单信息
	private Tree tree;
	// 子菜单节点信息
	private List<Tree> child = new ArrayList<Tree>();

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public List<Tree> getChild() {
		return child;
	}

	public void setChild(List<Tree> child) {
		this.child = child;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPId() {
		return pId;
	}

	public void setPId(long pId) {
		this.pId = pId;
	}

	public long getTreeOrder() {
		return treeOrder;
	}

	public void setTreeOrder(long treeOrder) {
		this.treeOrder = treeOrder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 功能描述：实现集合根据treeOrder字段进行排序的功能
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Tree o) {
		long i = this.getTreeOrder() - o.getTreeOrder();
		return Integer.parseInt(i+"");
	}
}
