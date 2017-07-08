package com.yue.core.dao;

import java.util.List;

import com.yue.core.bean.School;


public interface SchoolDao {

	public void addSchool(School school);
	
	public List<School> getAllSchool();
}
