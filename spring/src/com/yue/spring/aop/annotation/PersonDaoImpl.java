package com.yue.spring.aop.annotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value="personDao")
public class PersonDaoImpl implements PersonDao{

	public void deletePerson() {
		// TODO Auto-generated method stub
		System.out.println("delete perosn");
	}

	public List<Person> getPerson(String s) throws Exception{
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();
		Person person1 = new Person();
		person1.setPid(1L);
		person1.setPname("person1");
		
		
		int a = 1/0;
		
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
