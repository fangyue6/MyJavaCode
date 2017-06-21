package com.yue.spring.initdestory;

public class HelloWorld {
	public void init(){
		System.out.println("init");
	}
	
	public void destroy(){
		System.out.println("destroy");
	}
	
	public void say(){
		System.out.println("say helloWorld");
	}
	public HelloWorld(){
		System.out.println("new helloworld");
	}
}
