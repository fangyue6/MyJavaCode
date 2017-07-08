package com.yue.core.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yue.common.web.session.SessionProvider;
import com.yue.core.bean.Student;
import com.yue.core.service.StudentService;
import com.yue.core.web.Constants;

import cn.itcast.common.page.Pagination;

/**
 * 学生管理
 * 
 * @author fangyue
 *
 */
@Controller
@RequestMapping(value = "/show")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private SessionProvider sessionProvider;

	// student列表页面
	@RequestMapping(value = "/stu/list.do")
	public String list(Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		// 参数
		StringBuilder params = new StringBuilder();

		Student stu = new Student();

		// 页号 //如果页号为空， 或者小于1 置为1
		stu.setPageNo(Pagination.cpn(pageNo));

		// 每一页数
		stu.setPageSize(5);

		// 分页对象
		Pagination pagination = studentService.getStudentListWithPage(stu);

		// 分页展示 /brand/list.do?name=哈他&isDisplay=1&pageNo=2
		pagination.pageView("list.do", params.toString());

		model.addAttribute("pagination", pagination);// request ,response
		model.addAttribute("stu", stu);// request ,response

		return "stu/list";
	}

	// 跳转学生添加页面
	@RequestMapping(value = "/stu/toAdd.do")
	public String toAdd(HttpServletRequest request, ModelMap model) {
		return "/stu/add";
	}

/*	// 添加学生
	@RequestMapping(value = "/stu/stuadd.do", method = RequestMethod.GET)
	public String add() {
		return "stu/add";
	}*/

	// 添加学生  , method = RequestMethod.POST
	@RequestMapping(value = "/stu/add.do")
	public String add(Student stu,ModelMap model) {
		Student s1 =new Student();
		s1.setStudentNumber(stu.getStudentNumber());
		// 添加学生
		try {
			Student student2 = studentService.getStudent(s1);
			if (null == student2) {
				studentService.addStudent(stu);
				/*
				 * sessionProvider.setAttribute(request, Constants.user_session,
				 * stu);
				 */
				String returnUrl = "list.do";
				return "redirect:" + returnUrl;// 到学生列表页面
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		model.addAttribute("error", "请检查相关信息");
		model.addAttribute("student", stu);

		return "stu/add";
	}

	// 删除一个学生
	@RequestMapping(value = "/stu/delete.do")
	public String delete(Integer id, ModelMap model) {
		// 删除

		studentService.deleteStudentByKey(id);

		return "redirect:list.do";
	}

	// 删除多个学生
	@RequestMapping(value = "/stu/deletes.do")
	public String deletes(Integer[] ids, ModelMap model) {
		// 删除

		studentService.deleteStudentByKeys(ids);
		return "redirect:list.do";
	}

	// 跳转修改页面
	@RequestMapping(value = "/stu/toEdit.do")
	public String toEdit(Integer id, HttpServletRequest request, ModelMap model) {

		Student stu = studentService.getStudentById(id);

		model.addAttribute("student", stu);
		return "stu/edit";
	}

	// 修改学生 跳转列表页面
	@RequestMapping(value = "/stu/edit.do")
	public String edit(Student student, ModelMap model) {
		// achieveService.updateAchieveByKey(achieve);

		// studentService.updateStudentByKey(news);
		return "redirect:list.do";
	}
	
	// 跳转right_myinfo页面
		@RequestMapping(value = "/stu/right_myinfo.do")
		public String right_myinfo(HttpServletRequest request,ModelMap model) {
			Serializable student = sessionProvider.getAttribute(request, Constants.user_session);
			model.addAttribute("student", student);
			//return "right_myinfo";//
			return "stu/edit";
		}
		
		// 修改我的个人信息
		@RequestMapping(value = "/stu/modify_myinfo.do")
		public String modify_myinfo(Student student,HttpServletRequest request,ModelMap model) {
			Student updateStudent = studentService.updateStudent(student);
			sessionProvider.setAttribute(request, Constants.user_session, updateStudent);
			/*if(null != sessionProvider.getAttribute(request, Constants.admin_session)){
				
			}*/
			model.addAttribute("student", updateStudent);
			return "redirect:right_myinfo.do";
		}
}
