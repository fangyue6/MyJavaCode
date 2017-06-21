package com.yue.spring.ex;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DocumentTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/ex/applicationContext.xml");
		
		ReadDocument readDocument = (ReadDocument)context.getBean("readDocument");
		readDocument.say();
	}
}
