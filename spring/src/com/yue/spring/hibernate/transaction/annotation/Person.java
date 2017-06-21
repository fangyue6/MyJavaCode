package com.yue.spring.hibernate.transaction.annotation;

/**
 * Person entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Person implements java.io.Serializable {

	// Fields

	private Long pid;
	private String pname;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(String pname) {
		this.pname = pname;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}