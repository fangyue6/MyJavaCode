package com.yue.spring.scan;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/scan/applicationContext.xml");
		
		Person person = (Person)context.getBean("person");
		
		person.say();
		
		
	}
}
