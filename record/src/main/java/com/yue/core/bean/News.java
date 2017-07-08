package com.yue.core.bean;

public class News {
	private int id;
	private String title;
	private String abstracts;
	private String reporter;
	private String reporttitle;
	private String organizer;
	private String contentintroduction;
	private String reporterintroduction;
	private String reporterindex;
	private String time;
	private String pic;
	private String pic1;//展示使用的
	
	//页号
	private Integer pageNo=1;
	//开始行
	private Integer startRow;
	//每页数
	private Integer pageSize=10;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getReporttitle() {
		return reporttitle;
	}
	public void setReporttitle(String reporttitle) {
		this.reporttitle = reporttitle;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getContentintroduction() {
		return contentintroduction;
	}
	public void setContentintroduction(String contentintroduction) {
		this.contentintroduction = contentintroduction;
	}
	public String getReporterintroduction() {
		return reporterintroduction;
	}
	public void setReporterintroduction(String reporterintroduction) {
		this.reporterintroduction = reporterintroduction;
	}
	public String getReporterindex() {
		return reporterindex;
	}
	public void setReporterindex(String reporterindex) {
		this.reporterindex = reporterindex;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
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
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", abstracts="
				+ abstracts + ", reporter=" + reporter + ", reporttitle="
				+ reporttitle + ", organizer=" + organizer
				+ ", contentintroduction=" + contentintroduction
				+ ", reporterintroduction=" + reporterintroduction
				+ ", reporterindex=" + reporterindex + ", time=" + time
				+ ", pic=" + pic + ", pic1=" + pic1 + ", pageNo=" + pageNo
				+ ", startRow=" + startRow + ", pageSize=" + pageSize + "]";
	}
	
	

}
