package com.base.entity;

/**
 *@author linzf
 **/
public class UserAssociateRole {
	private int userId;
	private long roleId;

	public UserAssociateRole(){
		super();
	}

	public UserAssociateRole(int userId, long roleId){
		this.userId = userId;
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

}
