package com.yue.proxy.ex;

import org.junit.Test;

public class SalaryTest {
	@Test
	public void test(){
		Logger logger = new Logger();
		Security security = new Security();
		Privilege privilege = new Privilege();
		privilege.setAccess("admin");
		SalaryService target = new SalaryServiceImpl();
		SalaryService proxy = new SalaryServiceProxy(privilege,logger,security,target);
		proxy.showSalary();
	}
}
