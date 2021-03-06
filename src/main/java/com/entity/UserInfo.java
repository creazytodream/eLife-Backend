package com.entity;

/**
 * UserInfo实体类
 */

public class UserInfo {
	private String openid;
	private String name;
	private String department;
	private String office;
	private int floor;
	private String deptAdmin;
	private String companyAdmin;
	private String section;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getDeptAdmin() {
		return deptAdmin;
	}
	public void setDeptAdmin(String deptAdmin) {
		this.deptAdmin = deptAdmin;
	}
	public String getCompanyAdmin() {
		return companyAdmin;
	}
	public void setCompanyAdmin(String companyAdmin) {
		this.companyAdmin = companyAdmin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
}