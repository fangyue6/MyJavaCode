package com.record.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.record.mapper.StudentMapper;
import com.record.pojo.Student;
import com.record.pojo.StudentExample;
import com.record.pojo.StudentExample.Criteria;
import com.record.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public Student getStudentById(String studentNumber) {

		StudentExample example =new StudentExample();
		
		Criteria criteria=example.createCriteria();
		criteria.andStudentnumberEqualTo(studentNumber);
		
		List<Student> list=studentMapper.selectByExample(example);
		
		if(list!=null&& list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
