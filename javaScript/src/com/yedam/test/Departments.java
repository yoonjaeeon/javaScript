package com.yedam.test;

public class Departments {
	int DepartmentId;
	String DepartmentName;
	int ManagerId;
	int LocationId;
	public int getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public int getLocationId() {
		return LocationId;
	}
	public void setLocationId(int locationId) {
		LocationId = locationId;
	}
	@Override
	public String toString() {
		return "Departments [DepartmentId=" + DepartmentId + ", DepartmentName=" + DepartmentName + ", ManagerId="
				+ ManagerId + ", LocationId=" + LocationId + "]";
	}
	
}
