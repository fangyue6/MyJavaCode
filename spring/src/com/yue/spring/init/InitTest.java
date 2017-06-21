package com.yue.spring.init;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitTest {
	/**
	 * *  在默认情况下，spring容器启动的时候，就把所有的纳入spring容器的bean创建对象
	 *       缺点：
	 *       	如果一个对象中有属性，比如这个属性为集合，在创建这个对象的过程中，集合中有数据
	 *          这样采用默认的启动形式，就会导致数据过早的加载到内存中
	 * *  可以在spring的配置文件中：
	 *       <bean id="helloWorld" class=".." lazy-init="true">
	 *       延迟bean的创建时间，在context.getBean时才要创建bean的对象
	   *  如果spring的配置文件书写错误，如果所有的spring的bean都采用lazy-init="true"这种形式
	      则在启动web服务器的时候，发现不了spring容器的错误，这样是不利于排错的
	 */
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/init/applicationContext.xml");
		
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		
		helloWorld.say();
	}
	
}
