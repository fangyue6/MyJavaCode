package com.yue.annotation;

@Description(value="这是一个学生类")
public class Student {
	@Name(aa="这是一个方法")
	public void say(){
		System.out.println("aaa");
	}
	@Name(aa="说明这个学生来源")
	public void des(){
		System.out.println("来自传智播客，good student");
	}
}
