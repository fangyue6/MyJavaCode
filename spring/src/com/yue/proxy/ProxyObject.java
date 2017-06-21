package com.yue.proxy;

public class ProxyObject implements TargetInterface{

	private TargetInterface target;
	
	public ProxyObject(TargetInterface target){
		this.target = target;
	}
	/**
	 * 在目标类的目标方法的上下文加一些内容
	 */
	@Override
	public void business() {
		// TODO Auto-generated method stub
		System.out.println("aaaaa");
		this.target.business();//目标类的目标方法
		System.out.println("bbbbb");
	}

}
