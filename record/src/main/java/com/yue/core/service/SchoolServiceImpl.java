package com.yue.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yue.core.bean.School;
import com.yue.core.dao.SchoolDao;
/**
 * 学校事务
 * 
 * @author fangyue
 *
 */
@Service
@Transactional  //事务
public class SchoolServiceImpl implements SchoolService {
	
	@Resource
	private SchoolDao schoolDao;

	public void addSchool(School school) {
		// TODO Auto-generated method stub

	}

	public List<School> getAllSchool() {
		List<School> allSchool = schoolDao.getAllSchool();
		return allSchool;
	}

}
