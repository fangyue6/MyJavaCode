package com.yue.spring.aop.xml;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl{

	public void deletePerson() {
		// TODO Auto-generated method stub
		System.out.println("delete perosn");
	}

	public List<Person> getPerson() throws Exception{
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person();
		person1.setPid(1L);
		person1.setPname("person1");
		
		
		
		
		System.out.println("get person");
		
		personList.add(person1);
		
		Person person2 = new Person();
		person2.setPid(2L);
		person2.setPname("person2");
		
		personList.add(person2);
		
		return personList;
	}

	public void savePerson() {
		// TODO Auto-generated method stub
		System.out.println("delete perosn");
	}

	public void updatePerson() {
		// TODO Auto-generated method stub
		System.out.println("delete perosn");
	}

}
