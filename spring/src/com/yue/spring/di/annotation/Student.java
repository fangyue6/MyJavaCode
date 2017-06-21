package com.yue.spring.di.annotation;


public class Student {
	private String name;
	private int age;
	public Student(){
		this.name="xxx";
		this.age=11;
	}
	public void say(){
		System.out.println("student say");
		System.out.println(name+","+age);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
