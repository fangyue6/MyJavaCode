package com.yue.cglib.proxy;

import java.util.List;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test(){
		PersonDaoImpl target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		MyIntercptor intercptor = new MyIntercptor(transaction,target);
		
		PersonDaoImpl personDaoImpl = (PersonDaoImpl)intercptor.createProxy();
		personDaoImpl.deletePerson();
		List<Person> persons=personDaoImpl.getPerson();
		for(Person p:persons){
			System.out.println(p.getPname());
		}
	}
}
