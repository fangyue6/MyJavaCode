package com.yue.spring.aop.xml;

import java.util.List;

public interface PersonDao {
	public void savePerson();
	public void updatePerson();
	public List<Person> getPerson() throws Exception;
	public void deletePerson();
}
