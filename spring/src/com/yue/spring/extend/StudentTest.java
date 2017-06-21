package com.yue.spring.extend;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/extend/applicationContext.xml");
		
		Student student = (Student)context.getBean("student");
		
		student.say();
	}
}
