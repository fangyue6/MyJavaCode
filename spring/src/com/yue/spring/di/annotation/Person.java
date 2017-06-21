package com.yue.spring.di.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
@Scope(value="prototype")
public class Person {
	//@Resource(name="s")
	@Autowired
    @Qualifier("s")
	private Student student;
	
	public void say(){
		this.student.say();
	}
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}
}
