package com.yue.spring.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 控制反转
 * @author fangyue
 *
 */
public class IOCTest {
	@Test
	public void testSpringHelloWorld(){
		/**
		 * 启动spring容器
		 * 		创建spring容器对象就相当于启动spring容器
		 * spring容器做的工作：
		 *   * 创建对象
		 */
		ApplicationContext context  =new ClassPathXmlApplicationContext("com/yue/spring/ioc/applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		helloWorld.say();
	
	}
}
