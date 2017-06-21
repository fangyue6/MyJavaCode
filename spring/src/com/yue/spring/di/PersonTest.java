package com.yue.spring.di;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/di/applicationContext.xml");
		
		Person person = (Person)context.getBean("person");		
	
		System.out.println(person.getPid());
		
		System.out.println(person.getPname());
		
		person.getStudent().say();
		
		List list = person.getLists();
		
		System.out.println("size:"+list.size());
	}
}
