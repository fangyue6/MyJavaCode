package com.yue.spring.mvc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonActionTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/mvc/applicationContext.xml");
		
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.updatePerson();
	}
}
