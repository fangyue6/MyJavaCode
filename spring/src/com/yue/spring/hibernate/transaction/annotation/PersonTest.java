package com.yue.spring.hibernate.transaction.annotation;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void testSavePerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring0401/hibernate/transaction/annotation/applicationContext.xml");
		
		PersonService personService = (PersonService)context.getBean("personService");
	
		Person person = new Person();
		
		person.setPname("person");
		
		personService.savePerson(person);
	}
	
	@Test
	public void testDataSource(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring0401/hibernate/transaction/annotation/applicationContext.xml");
		
		DataSource dataSource = (DataSource)context.getBean("dataSource");
	
		System.out.println(dataSource);
	}
	
	@Test
	public void testGetPerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring0401/hibernate/transaction/annotation/applicationContext.xml");
		
		PersonService personService = (PersonService)context.getBean("personService");
	
		System.out.println(personService.getPersons().size());
	}
}
