package com.yue.spring.hibernate.transaction.xml;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}

}
