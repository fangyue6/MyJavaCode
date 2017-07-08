package com.yue.core.bean;

public class Achievement {
	
	private Integer id;
	private String schoolID;
	private String studentNumber;
	private String time;
	private String title;
	private String describe;
	private String code;
	private String essay;
	
	private String code1;//可供下载的code
	private String essay1;//可供下载的essay
	
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;

	}
	
	
	public String getEssay() {
		return essay;
	}
	public void setEssay(String essay) {
		this.essay = essay;
	}
	
	
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getEssay1() {
		return essay1;
	}
	public void setEssay1(String essay1) {
		this.essay1 = essay1;
	}
	@Override
	public String toString() {
		return "Achievement [id=" + id + ", schoolID=" + schoolID
				+ ", studentNumber=" + studentNumber + ", time=" + time
				+ ", title=" + title + ", describe=" + describe + ", code="
				+ code + ", essay=" + essay + ", code1=" + code1 + ", essay1="
				+ essay1 + ", pageNo=" + pageNo + ", startRow=" + startRow
				+ ", pageSize=" + pageSize + "]";
	}

	
	


}
