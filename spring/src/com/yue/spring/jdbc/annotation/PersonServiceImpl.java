package com.yue.spring.jdbc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="personService")
public class PersonServiceImpl implements PersonService{
	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Transactional(readOnly=false)
	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
		int a = 1/0;
		this.personDao.savePerson();
	}
}
