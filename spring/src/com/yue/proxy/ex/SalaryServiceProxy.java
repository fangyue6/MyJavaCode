package com.yue.proxy.ex;

public class SalaryServiceProxy implements SalaryService{

	private Privilege privilege;
	private Logger logger;
	private Security security;
	
	private SalaryService target;
	
	public SalaryServiceProxy(Privilege privilege,Logger logger,Security security,SalaryService target){
		this.privilege = privilege;
		this.logger = logger;
		this.security = security;
		this.target = target;
	}
	
	
	public void showSalary() {
		// TODO Auto-generated method stub
		this.logger.logging();
		this.security.security();
		if(this.privilege.getAccess().equals("admin")){
			this.target.showSalary();//目标对象的目标方法
		}else{
			System.out.println("您没有该权限");
		}
	}

}
