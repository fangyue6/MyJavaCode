package com.yue.core.service;

import java.util.List;

import com.yue.core.bean.School;


public interface SchoolService {

	public void addSchool(School school);
	
	public List<School> getAllSchool();
	
}
