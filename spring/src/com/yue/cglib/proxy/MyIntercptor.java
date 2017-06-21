package com.yue.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyIntercptor implements MethodInterceptor{
	
	private Transaction transaction;
	private Object target;
	
	public MyIntercptor(Transaction transaction,Object target){
		this.transaction = transaction;
		this.target = target;
	}
	
	/**
	 * 产生代理对象
	 */
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);//回调函数  拦截器
		enhancer.setSuperclass(this.target.getClass());//设置代理对象的父类
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		if(method.getName().equals("updatePerson")
				||method.getName().equals("savePerson")
				||method.getName().endsWith("deletePerson")){
			this.transaction.beginTransaction();
			method.invoke(this.target, arg2);//目标对象的目标方法
			this.transaction.commit();
			return null;
		}else{
			return method.invoke(this.target, arg2);//目标对象的目标方法
		}
		
		
	}

}
