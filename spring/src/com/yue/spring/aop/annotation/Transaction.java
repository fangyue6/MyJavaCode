package com.yue.spring.aop.annotation;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
/**
 * @Component=bean id="transaction" class="..Transaction"
 * @author Administrator
 * @Aspect=  切面类 
 *      <aop:config>
 *      	@Pointcut("execution(* cn.itcast.spring0401.aop.annotation.PersonDaoImpl.*(..))")
	          private void aa(){}//切入点签名
	          <aop:pointcut expression="execution(* cn.itcast.spring0401.aop.annotation.PersonDaoImpl.*(..))" id="aa()"/>
 *      </aop:config>
 * @Pointcut 标注一个切入点
 */
@Aspect
@Component(value="transaction")
public class Transaction {
	@Pointcut("execution(* com.yue.spring.aop.annotation.PersonDaoImpl.*(..))")
	private void aa(){}//切入点签名
	
//	@Before("aa()")
//	public void beforeMethod(){
//		System.out.println("before method");
//	}
	
//	@AfterReturning(value="aa()",returning="val")
//	public void afterMethod(JoinPoint joinPoint,Object val){
//		List<Person> personList = (ArrayList<Person>)val;
//		for(Person person:personList){
//			System.out.println(person.getPname());
//		}
//		System.out.println("after method");
//	}
	
	@After("aa()")
	public void finalMethod(JoinPoint joinPoint){
		joinPoint.getArgs();
		System.out.println("final method");
	}
	
	@Around("aa()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint){
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("around method");
		return obj;
	}
	
	@AfterThrowing(value="aa()",throwing="ex")
	public void throwingMethod(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
