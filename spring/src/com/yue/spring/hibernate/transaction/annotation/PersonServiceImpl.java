package com.yue.spring.hibernate.transaction.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="personService")
public class PersonServiceImpl implements PersonService{

	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Transactional(readOnly=false)
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.personDao.savePerson(person);
	}

	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return this.personDao.getPersons();
	}
}
