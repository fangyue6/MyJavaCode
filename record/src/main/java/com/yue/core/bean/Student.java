package com.yue.core.bean;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4098300065187088544L;
	private int id;
	private String schoolID;
	private String studentNumber;
	private int time;
	private String name;
	private int year;
	private String sex;
	private String phone;
	private String qq;
	private String wechat;
	private String email;
	private String pic;
	private String passwd;
	
	private String place;
	private String describe;
	
	private String homepage;
	private Integer graduated;
	private Integer isshow;
	private String other;
	
	
	private String pic1;
	
	//页号
	private Integer pageNo=1;
	//开始行
	private Integer startRow;
	//每页数
	private Integer pageSize=10;
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		//计算一次开始行
		this.startRow=(pageNo-1)*pageSize;
		this.pageNo = pageNo;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		//计算一次开始行
		this.startRow=(pageNo-1)*pageSize;
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	

	
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public Integer getGraduated() {
		return graduated;
	}
	public void setGraduated(Integer graduated) {
		this.graduated = graduated;
	}
	public Integer getIsshow() {
		return isshow;
	}
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", schoolID=" + schoolID
				+ ", studentNumber=" + studentNumber + ", time=" + time
				+ ", name=" + name + ", year=" + year + ", sex=" + sex
				+ ", phone=" + phone + ", qq=" + qq + ", wechat=" + wechat
				+ ", email=" + email + ", pic=" + pic + ", passwd=" + passwd
				+ ", place=" + place + ", describe=" + describe + ", pic1="
				+ pic1 + ", pageNo=" + pageNo + ", startRow=" + startRow
				+ ", pageSize=" + pageSize + "]";
	}


}
