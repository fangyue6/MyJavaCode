package com.yue.core.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yue.common.web.session.SessionProvider;
import com.yue.core.bean.Student;
import com.yue.core.service.StudentService;
import com.yue.core.web.Constants;

/**
 * 前台页面及后台个人信息编辑
 * 
 * @author fangyue
 *
 */
@Controller
@RequestMapping(value = "/show")
public class ShowController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SessionProvider sessionProvider;

	// 跳转头页面
	@RequestMapping(value = "/top.do")
	public String top(HttpServletRequest request,ModelMap model) {
		Serializable student = sessionProvider.getAttribute(request, Constants.user_session);
		model.addAttribute("student", student);
		return "top";
	}

	// 跳转main页面
	@RequestMapping(value = "/main.do")
	public String main() {
		return "main";
	}

	// 跳转left页面
	@RequestMapping(value = "/left.do")
	public String left(HttpServletRequest request,ModelMap model) {
		//增加超级管理权限
		Student student=(Student) sessionProvider.getAttribute(request, Constants.user_session);
		if(Constants.superuser.equals(student.getName()) && Constants.superpass.equals(student.getStudentNumber())){
			sessionProvider.setAttribute(request, Constants.admin_session, student);
			model.addAttribute("superadmin", Constants.superuser);
		}
		return "left";
	}

	// 跳转right欢迎页面
	@RequestMapping(value = "/right.do")
	public String right() {
		return "right";
	}


	
	
	
	//后台主页
	@RequestMapping(value="/index.do")
	public String index(){
		return "index";
	}
	
}
