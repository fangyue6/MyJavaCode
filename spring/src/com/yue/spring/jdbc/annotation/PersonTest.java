package com.yue.spring.jdbc.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void testSavePerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/jdbc/annotation/applicationContext.xml");
		
		PersonService personService = (PersonService)context.getBean("personService");
		
		personService.savePerson();
	}
}
