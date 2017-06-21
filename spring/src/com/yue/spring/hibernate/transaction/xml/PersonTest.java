package com.yue.spring.hibernate.transaction.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void testSavePerson(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/hibernate/transaction/xml/applicationContext.xml");
		
		PersonService personService = (PersonService)context.getBean("personService");
	
		Person person = new Person();
		
		person.setPname("xx");
		
		personService.savePerson(person);
	}
}
