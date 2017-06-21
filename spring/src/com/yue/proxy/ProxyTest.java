package com.yue.proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test(){
		TargetInterface target = new TargetObject();//目标类的对象
		TargetInterface proxy = new ProxyObject(target);
		proxy.business();
	}
}
