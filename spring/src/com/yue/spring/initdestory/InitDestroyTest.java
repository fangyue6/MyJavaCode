package com.yue.spring.initdestory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitDestroyTest {
	/**
	 * 在spring的配置文件中
	 * 	init-method="init" 
	 *    说明在创建完该对象后，立刻执行init方法，用来进行初始化
	 *  destroy-method="destroy"
	 *    *  当该bean为单例模式，才能调用该方法
	 *        destroy方法在容器销毁的时候被调用
	 *    *  当该bean为多例时，spring容器不负责他的销毁工作
	 *    *  如果该bean为多例时，当不用该bean时，应该手动销毁资源文件
	 */
	@Test
	public void test(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/initdestory/applicationContext.xml");
		
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		
		helloWorld.say();
		
		context.destroy();//销毁spring容器
	}
}
