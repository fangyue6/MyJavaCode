package com.record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.record.pojo.Student;
import com.record.service.StudentService;

/**
 * 这是学生controller
 * 
 * @author fangyue
 *
 */
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/student/{studentNumber}")
	@ResponseBody
	public Student getStudentByStudentNumber(@PathVariable String studentNumber) {
		Student s = studentService.getStudentById(studentNumber);
		return s;
	}
}
