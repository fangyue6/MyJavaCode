package com.yue.spring.createbean;

public class HelloWorldFactory {
	/**
	 * 工厂方法
	 * @return
	 */
	public static HelloWorld createBean(){
		return new HelloWorld();
	}
}
