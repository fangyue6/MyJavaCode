package com.yue.spring.createbean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateBeanTest {
	/**
	 * 在HelloWorld中写如下代码
	 * 		public HelloWorld(){
				System.out.println("new helloworld");
			}
			输出为："new helloworld"
		说明
		   *  spring容器默认调用类的默认的构造器来创建对象的
		   *  如果在HelloWorld中，没有默认的构造器，则spring在创建helloWorld对象时，会报错
		      因为找不到默认的构造器
	 */
	@Test
	public void test(){
		ApplicationContext context  =new ClassPathXmlApplicationContext("com/yue/spring/createbean/applicationContext.xml");
		HelloWorld helloworld=(HelloWorld) context.getBean("helloWorld");
		helloworld.say();
		
	}
	
	
}
