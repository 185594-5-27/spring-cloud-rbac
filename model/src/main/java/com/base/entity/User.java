package com.base.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *@author linzf
 **/
public class User implements Serializable {

	private static final long serialVersionUID = -880218717499238863L;

	public User(){
		super();
	}

	public User(int id){
		this.id = id;
	}

	private int id;
	private String login;
	private String password;
	private String userName;
	private String address;
	private String job;
	private long groupId;
	private Date birthDate;
	private String city;
	private String district;
	private String province;
	private String streetAddress;
	private String state;
	private String type;
	private Date lastLoginDate;
	// 用户角色信息
	private List<UserRole> roles;
	// 权限集合数据
	private String roleArray;
	// 所在分组的集合
	private OrgGroup orgGroup;

	public OrgGroup getOrgGroup() {
		return orgGroup;
	}

	public void setOrgGroup(OrgGroup orgGroup) {
		this.orgGroup = orgGroup;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getRoleArray() {
		return roleArray;
	}

	public void setRoleArray(String roleArray) {
		this.roleArray = roleArray;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}


	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * 功能描述：组装角色数据集合
	 * @param roleArray
	 */
	public void packagingRoles(String roleArray){
		List<UserRole> roles = new ArrayList<UserRole>();
		if(roleArray!=null){
			UserRole userRole = null;
			for(String roleId:roleArray.split(",")){
				if(!roleId.isEmpty()){
					userRole = new UserRole();
					userRole.setId(Long.parseLong(roleId));
					roles.add(userRole);
				}
			}
		}
		this.setRoles(roles);
	}

}
