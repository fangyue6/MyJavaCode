package com.yue.core.service;

import java.util.List;
import java.util.Map;

import cn.itcast.common.page.Pagination;

import com.yue.core.bean.Student;

public interface StudentService {

	public Pagination getStudentListWithPage(Student student);

	public void addStudent(Student student);

	public Student getStudent(Student student);

	public Student updateStudent(Student student);

	public Student getStudentByNumber(Student student);

	public Student getStudentById(Integer id);

	public List<Student> getAll();

	public Map<Integer, List<Student>> getAllStudent();

	// 删除
	public void deleteStudentByKey(Integer id);

	// 批量删除
	public void deleteStudentByKeys(Integer[] ids);// List<integer> ids

}
