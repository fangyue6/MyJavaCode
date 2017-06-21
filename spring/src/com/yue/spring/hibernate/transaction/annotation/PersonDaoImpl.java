package com.yue.spring.hibernate.transaction.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import org.springframework.stereotype.Repository;

@Repository(value="personDao")
public class PersonDaoImpl  implements PersonDao{

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(person);
	}

	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Person");
	}

}
