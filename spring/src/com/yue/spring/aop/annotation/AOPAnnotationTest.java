package com.yue.spring.aop.annotation;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author Administrator
 *
 */
public class AOPAnnotationTest {
	@Test
	public void test() throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/aop/annotation/applicationContext.xml");
		
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		
		personDao.deletePerson();
		
		/*List<Person> personList = personDao.getPerson("sss");
		
		System.out.println(personList.size());*/
	}
}
