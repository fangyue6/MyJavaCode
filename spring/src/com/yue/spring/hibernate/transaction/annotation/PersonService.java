package com.yue.spring.hibernate.transaction.annotation;

import java.util.List;

public interface PersonService {
	public void savePerson(Person person);
	
	public List<Person> getPersons();
}
