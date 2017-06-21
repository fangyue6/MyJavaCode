package com.yue.spring.scope;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	public List<String> s = new ArrayList<String>();
	public void say(){
		System.out.println("scope hello world");
	}
	public HelloWorld(){
		System.out.println("new scope helloworld");
	}
}
