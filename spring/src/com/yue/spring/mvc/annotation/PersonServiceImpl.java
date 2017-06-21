package com.yue.spring.mvc.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

	@Resource(name="personDao")
	private PersonDao personDao;

	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
	}

	public void updatePerson() {
		// TODO Auto-generated method stub
		this.personDao.updatePerson();
	}

}
