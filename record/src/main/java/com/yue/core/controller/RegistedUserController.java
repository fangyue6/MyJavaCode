package com.yue.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.cglib.transform.impl.AddDelegateTransformer;

import org.apache.commons.lang3.StringUtils;
//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yue.common.encode.Md5Pwd;
import com.yue.common.web.ResponseUtils;
import com.yue.common.web.session.SessionProvider;
import com.yue.core.bean.School;
import com.yue.core.bean.Student;
import com.yue.core.service.SchoolService;
import com.yue.core.service.StudentService;
import com.yue.core.web.Constants;

/**
 * 已经注册用户或者正准备注册用户的controller
 * 
 * @author fangyue
 *
 */
@Controller
public class RegistedUserController {

	@Autowired
	private SessionProvider sessionProvider;

	@Autowired
	private Md5Pwd md5Pwd;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SchoolService schoolService;

	// 跳转注册页面
	@RequestMapping(value = "/user/regist.do")
	// ,method=RequestMapping
	public String regist() {
		return "regist";
	}

	// 添加学生
	@RequestMapping(value = "/user/add.do", method = RequestMethod.GET)
	public String add(){
		return "regist";
	}
	
	// 添加学生
	@RequestMapping(value = "/user/add.do", method = RequestMethod.POST)
	public String add(Student student, HttpServletRequest request) {
		// 添加学生
		try {
			Student student2 = studentService.getStudentByNumber(student);
			if(null==student2){
				studentService.addStudent(student);
				sessionProvider.setAttribute(request, Constants.user_session,
						student);
				String returnUrl = "../show/index.do";
				return "redirect:" + returnUrl;// 到后台管理页面
				}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("error", "请检查相关信息");

		return "regist";
	}

	// 跳转学生登陆页面
	@RequestMapping(value = "/user/tologin.do")
	public String toLogin(ModelMap model) {
		//List<School> allSchool = schoolService.getAllSchool();
		//model.addAttribute("allSchool", allSchool);
		return "login";
	}

	// 学生登陆 GET
	@RequestMapping(value = "/user/login.do", method = RequestMethod.GET)
	public String login(Student student, HttpServletResponse response) {
		return "login";
	}

	// 学生登陆 POST
	@RequestMapping(value = "/user/login.do", method = RequestMethod.POST)
	public String login(Student student, String returnUrl,
			HttpServletRequest request, ModelMap model) {
		Student student2 = null;
		if (null != student
				&& StringUtils.isNotBlank(student.getStudentNumber())) {
			if (StringUtils.isNotBlank(student.getPasswd())) {
				// 查找学生
				// student.setPasswd(md5Pwd.encode(student.getPasswd()));
				student2 = studentService.getStudent(student);
				if (null != student2) {
					sessionProvider.setAttribute(request,
							Constants.user_session, student2);
					if(null==returnUrl || returnUrl=="")
						returnUrl="../show/index.do";
					return "redirect:" + returnUrl;//到个人中心
				} else {
					model.addAttribute("error", "用户名或密码错误");
				}
			} else {
				model.addAttribute("error", "请输入密码");
			}
		} else {
			model.addAttribute("error", "请输入用户名");
		}
		return "login";
	}
	
	
	//退出
	@RequestMapping(value="/user/logout.do")
	public String logout(String returnUrl,HttpServletRequest request){
		sessionProvider.logout(request);
		return "redirect:" + returnUrl;
	}

}
