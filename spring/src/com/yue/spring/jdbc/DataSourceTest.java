package com.yue.spring.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {
	@Test
	public void testDataSource() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("com/yue/spring/jdbc/applicationContext.xml");
		DataSource dataSource = (DataSource)context.getBean("dataSource1");
		System.out.println(dataSource);
		
		Connection connection = dataSource.getConnection();
		Statement stmt = connection.createStatement();
	}
}
