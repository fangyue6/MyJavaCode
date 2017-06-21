package com.yue.spring.mvc.annotation;

import org.springframework.stereotype.Repository;
/**
 * <bean id="personDaoImpl" class="PersonDaoImpl">
 * @author Administrator
 *
 */
@Repository("personDao")
public class PersonDaoImpl implements PersonDao{

	public void savePerson() {
		// TODO Auto-generated method stub
		System.out.println("save person");
	}

	public void updatePerson() {
		// TODO Auto-generated method stub
		System.out.println("update person");
	}

}
