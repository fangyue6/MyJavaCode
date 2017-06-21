package com.yue.spring.alias;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AliasTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/alias/applicationContext.xml");
		
		HelloWorld helloWorld = (HelloWorld)context.getBean("王三麻子");
		
		helloWorld.say();
	}
}
