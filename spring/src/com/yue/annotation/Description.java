package com.yue.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 注解类 
 * @author Administrator
 *   *  提供标注在类的哪些部位
 *   *  这个注解的作用范围是哪些
 *   *  在document里(帮助文档里)是否体现注解类
 */
/**
 * @Target能标注在注解类型上
 *    ElementType
 *       TYPE 
 *          类和接口
 *       FIELD
 *          属性
 *       METHOD
 *          方法
 *       PARAMETER
 *          方法中的参数
 *       CONSTRUCTOR
 *          构造器
 *       ANNOTATION_TYPE
 *          注解类型
 *       PACKAGE
 *          包
 *   指明了所在的注解类能标注在类的哪些部位
 *   @Target({ElementType.TYPE,ElementType.METHOD})
 *      既可以标注在类上也可以标注在方法上
 */
@Target(ElementType.TYPE)
/**
 * 是否让@Description这个注解出现在帮助文档中
 */
@Documented
/**
 * @Retention
 *    说明@Description注解的作用域
 *      RetentionPolicy.SOURCE
 *        @Description这个注解在源文件中起作用
 *      RetentionPolicy.CLASS
 *         @Description这个注解即在源文件中起作用又在class文件中起作用
 		RetentionPolicy.RUNTIME
 		   @Description在源文件、class文件、运行的过程中都起作用
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
	String value();//属性
}
