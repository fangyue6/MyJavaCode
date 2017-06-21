package com.yue.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements PersonDao{

	public void insertPerson() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().execute("insert into person values(1,'ee')");
	}
	
	public void updatePerson(){
		this.getJdbcTemplate().execute("update person set pname='rr' where pid=1");
	}
	
	public void deletePerson(){
		this.getJdbcTemplate().execute("delete from person where pid=1");
	}
	/**
	 * queryForList得到的是一个map
	 */
	public List<Person> getAllPerson() {
		
		List list = this.getJdbcTemplate().queryForList("select * from person");
		
		//List list1 = this.getJdbcTemplate().queryForList("select * from person", Person.class);
		System.out.println(list);
		return null;
	}

	public List<Person> getAllPersonByRowMapper() {
		// TODO Auto-generated method stub
	  List<Person> personList =	this.getJdbcTemplate().query("select * from person", new PersonRowMapper());
	  System.out.println(personList.size());
	  return null;
	}
	
	public List<Person> getPersons(){
		List<Person> personList = this.getJdbcTemplate().query("select * from person where pid=?", new Object[]{2}, new PersonRowMapper());
		System.out.println(personList);
		return null;
	}

}
