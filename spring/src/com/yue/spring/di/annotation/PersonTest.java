package com.yue.spring.di.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/di/annotation/applicationContext.xml");
		
		Person person = (Person)context.getBean("person");
		person.say();
		
		context.close();
	}
	
}
