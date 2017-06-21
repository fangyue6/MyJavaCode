package com.yue.spring.scan;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/**
 * @Component=<bean id="student" class="..Student">
 * @author Administrator
 *
 */
@Component
public class Student {
	@Resource//(name="person")
	private Person person;
	
	public void say(){
		System.out.println("student say");
		//person.say();
	}
}
