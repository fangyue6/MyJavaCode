package com.yue.spring.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
	/**
	 * 由spring容器产生的bean默认是单例模式
	 *    在spring的配置文件中：
	 *   	 scope:
	 *          singleton  默认的形式
	 *    如果写默认的形式，一个集合或者一个数据出现在了类的属性中，这个数据将成为全局的数据(共享数据)，应该
	 *    注意并发问题
	 *  当spring容器中的bean是多例，则不管配置文件中的lazy-init为default、false还是true，在
	 *     context.getBean时才要为bean创建对象
	 */
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/scope/applicationContext.xml");
		
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
/*		HelloWorld helloWorld2 = (HelloWorld)context.getBean("helloWorld");
		System.out.println(helloWorld);
		System.out.println(helloWorld2);*/
		
		helloWorld.s.add("aaa");
		helloWorld.s.add("bb");
		
		HelloWorld helloWorld1 = (HelloWorld)context.getBean("helloWorld");
		helloWorld1.s.add("cc");
		System.out.println(helloWorld.s.size());
	}
}
