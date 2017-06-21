package com.yue.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 注解解析器
 * @author Administrator
 *
 */
public class StudentParse {
	@Test
	public void parse() throws Exception{
		Class classStudent = Class.forName("com.yue.annotation.Student");
		if(classStudent.isAnnotationPresent(Description.class)){//如果该注解存在
			Description description = (Description)classStudent.getAnnotation(Description.class);
			System.out.println(description.value());
		}
		Method[] methods = classStudent.getMethods();
		
		System.out.println(methods.length);
		for(Method method:methods){
			System.out.println(method.getName());
			if(method.isAnnotationPresent(Name.class)){//如果该注解存在
				Name name = (Name)method.getAnnotation(Name.class);
				System.out.println(name.aa());
			}
		}
	}
}
