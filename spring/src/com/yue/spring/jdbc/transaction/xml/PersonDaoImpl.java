package com.yue.spring.jdbc.transaction.xml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	public void savePerson() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().execute("insert into person(pname) values('ttt')");
	}	
}
