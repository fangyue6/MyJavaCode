package com.yue.core.dao;

import java.util.List;

import com.yue.core.bean.News;
import com.yue.core.bean.Student;


public interface StudentDao {
	
	//List集合
	public List<Student> getStudentListWithPage(Student student);
	
	//查询总记录数
	public int getStudentCount(Student student);

	public void addStudent(Student student);
	public Student getStudent(Student student);
	public Student getStudentByNumber(Student student);
	public Student getStudentById(Integer id);
	
	
	
	public void updateStudent(Student student);
	public List<Student> getAllStudent();
	
	//删除
	public void deleteStudentByKey(Integer id);
	
	//批量删除
	public void deleteStudentByKeys(Integer[] ids);//List<integer> ids
}
