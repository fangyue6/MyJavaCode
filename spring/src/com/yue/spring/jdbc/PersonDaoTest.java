package com.yue.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDaoTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/jdbc/applicationContext.xml");
		
		PersonDao personDao = (PersonDao)context.getBean("personDao");
	 
		//personDao.insertPerson();
		
		personDao.updatePerson();
		
		personDao.getAllPerson();
		
		personDao.getAllPersonByRowMapper();
	}
}
