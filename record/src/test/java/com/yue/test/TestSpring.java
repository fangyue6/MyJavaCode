package com.yue.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yue.common.junit.SpringJunitTest;
import com.yue.common.utils.HttpClientUtil;
import com.yue.core.bean.Achievement;
import com.yue.core.bean.News;
import com.yue.core.bean.Student;
import com.yue.core.dao.AchievementDao;
import com.yue.core.service.AchievementService;
import com.yue.core.service.NewsService;
import com.yue.core.service.StudentService;
import com.yue.core.service.TestService;

public class TestSpring extends SpringJunitTest{
	
	@Autowired
	private TestService testService;
	
	@Autowired 
	private AchievementService achieveService;
	
	@Autowired
	private AchievementDao achieveDao;
	

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private NewsService newsService;;
	
	@Test
	public void testAchievement() {
		List<Achievement> allAchieve = achieveDao.getAllAchievement();
		System.out.println(achieveService.getAll().size());
		achieveService.getAllAchieve();
	}
	
	@Test
	public void testStudent() {
		List<Student> allStudent = studentService.getAll();
		Map<Integer, List<Student>> allStudent2 = studentService
				.getAllStudent();
		Iterator<Entry<Integer, List<Student>>> iterator = allStudent2
				.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, List<Student>> entry = (Map.Entry<Integer, List<Student>>) iterator
					.next();
			System.out.println(entry.getKey());
			List<Student> value = entry.getValue();
			for(int i =0;i<value.size();i++){
				System.out.println(value.get(i).toString());
			}

		}

	}
	
	@Test
	public void test01(){
		Student student=new Student();
		student.setStudentNumber("2015011540");
		Student student2 = studentService.getStudent(student);
		if(null==student2){
			System.out.println("不存在");
		}else{
			System.out.println("存在");
		}
	}
	@Test
	public void test02(){
		Map<String, String> param=new HashMap<String, String>();
		param.put("name", "fangyuye");
		
		System.out.println(HttpClientUtil.doPost("http://127.0.0.1:8088/base/json.do", param));
	}
	
	@Test
	public void test03(){
		Student student=new Student();
		student.setStudentNumber("20150115323");
		student.setPasswd("1234562");
		System.out.println(studentService.getStudentByNumber(student));
	}
	@Test
	public void test04(){
		List<News> get10News = newsService.get10News();


		JSONArray ja = JSONArray.fromObject(get10News);
		System.out.println(ja.toString());

	}

}
