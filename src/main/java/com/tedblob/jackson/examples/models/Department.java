package com.tedblob.jackson.examples.models;

public class Department {
	
	private String deptName;
	private long deptId;
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}
}
