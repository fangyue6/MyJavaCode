package com.yue.core.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;

import com.yue.core.bean.Achievement;
import com.yue.core.bean.News;
import com.yue.core.bean.Student;
import com.yue.core.dao.StudentDao;
import com.yue.core.web.Constants;


/**
 * 学生事务
 * @author fangyue
 *
 */
@Service
@Transactional  //事务
public class StudentServiceImpl implements StudentService{

	@Resource
	private StudentDao studentDao;
	
	List<Student> allStudent;

	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public Student getStudent(Student student) {
		// TODO Auto-generated method stub
		
		Student student2 = studentDao.getStudent(student);
		if(student2!=null){
			String pic=student2.getPic();
			student2.setPic1(Constants.WEBFILE_URL+pic);
			student2.setPic(pic);
		}

		
		return student2;
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		 studentDao.updateStudent(student);
		 Student student2 = studentDao.getStudent(student);
			if(student2!=null){
				String pic=student2.getPic();
				student2.setPic1(Constants.WEBFILE_URL+pic);
				student2.setPic(pic);
			}

		 return student2;
	}

	public List<Student> getAll() {
		allStudent = studentDao.getAllStudent();
		for(int i =0;i<allStudent.size();i++){
			Student student = allStudent.get(i);
			student.setPic1(Constants.WEBFILE_URL+student.getPic());
		}
		return allStudent;
	}

	public Map<Integer, List<Student>> getAllStudent() {
		HashSet<Integer> years = new HashSet<Integer>();
		Map<Integer, List<Student>> treeMap = new TreeMap<Integer, List<Student>>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1==null || o2==null)
				return 0;
				return o2-o1;
			}
		});

		for (int i = 0; i < allStudent.size(); i++) {
			Student s = allStudent.get(i);
			years.add(s.getTime());
		}
		
		Iterator<Integer> iterator = years.iterator();
		
		while (iterator.hasNext()) {
			String year = iterator.next().toString();
			List<Student> studentlist = new ArrayList<Student>();
			for (int i = 0; i < allStudent.size(); i++) {
				Student a = allStudent.get(i);
				if(Integer.parseInt(year)==a.getTime()){
					studentlist.add(a);
				}

			}
			treeMap.put(Integer.parseInt(year), studentlist);
		}

		Iterator<Entry<Integer, List<Student>>> iterator2 = treeMap
				.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<Integer, List<Student>> entry = iterator2.next();
			Object key = entry.getKey();
			List<Student> val = (List<Student>) entry.getValue();
			/*System.out.println("--------------------------------");
			System.out.println(key);
			for (int i = 0; i < val.size(); i++) {
				System.out.println(val.get(i).toString());
			}
			System.out.println("--------------------------------");*/
		}
		return treeMap;
	}

	public Student getStudentByNumber(Student student) {
		Student s = studentDao.getStudentByNumber(student);
		if(s!=null){
			s.setPic1(Constants.WEBFILE_URL+s.getPic());
		}
		
		return s;
	}

	public Pagination getStudentListWithPage(Student student) {
		// 1.起始页 startRow=(pageNo-1)*pageSize
		// 2.每页数
		// 3.总记录数
		Pagination pagination = new Pagination(student.getPageNo(),
				student.getPageSize(), studentDao.getStudentCount(student));
		// News集合
		List<Student> stuList = studentDao.getStudentListWithPage(student);
		for (Student student1 : stuList) {
			student1.setPic1(Constants.WEBFILE_URL + student1.getPic());
		}
		pagination.setList(stuList);

		return pagination;
	}

	/**
	 * 通过id查询学生  并且把图片地址补全
	 */
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentById(id);
		student.setPic1(Constants.WEBFILE_URL+student.getPic());
		return student;
	}

	public void deleteStudentByKey(Integer id) {
		studentDao.deleteStudentByKey(id);
		
	}

	public void deleteStudentByKeys(Integer[] ids) {
		studentDao.deleteStudentByKeys(ids);
		
	}
	
}
