package com.yue.core.bean;

public class School {
	private String schoolID;
	private String schoolName;
	private String schoolCollege;
	private String schoolMajor;
	public String getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolCollege() {
		return schoolCollege;
	}
	public void setSchoolCollege(String schoolCollege) {
		this.schoolCollege = schoolCollege;
	}
	public String getSchoolMajor() {
		return schoolMajor;
	}
	public void setSchoolMajor(String schoolMajor) {
		this.schoolMajor = schoolMajor;
	}
	@Override
	public String toString() {
		return "School [schoolID=" + schoolID + ", schoolName=" + schoolName
				+ ", schoolCollege=" + schoolCollege + ", schoolMajor="
				+ schoolMajor + "]";
	}
	
	

}
