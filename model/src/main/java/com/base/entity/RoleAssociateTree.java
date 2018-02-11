package com.base.entity;

/**
 *@author linzf
 **/
public class RoleAssociateTree {

	public RoleAssociateTree(){
		super();
	}

	public RoleAssociateTree(long roleId,long treeId){
		this.roleId = roleId;
		this.treeId = treeId;
	}

	private long roleId;
	private long treeId;

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getTreeId() {
		return treeId;
	}

	public void setTreeId(long treeId) {
		this.treeId = treeId;
	}

}
