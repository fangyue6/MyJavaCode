package com.yue.core.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yue.common.web.session.SessionProvider;
import com.yue.core.bean.Achievement;
import com.yue.core.bean.Student;
import com.yue.core.service.AchievementService;
import com.yue.core.web.Constants;

import cn.itcast.common.page.Pagination;
/**
 * 成果管理
 * @author fangyue
 *
 */
@Controller
public class AchieveManageController {
	@Autowired
	private AchievementService achieveService;
	
	@Autowired
	private SessionProvider sessionProvider;

	// 成果列表页面
	@RequestMapping(value = "/show/ach/list.do")
	public String list(Integer pageNo,HttpServletRequest request,ModelMap model) {
		Student student = (Student) sessionProvider.getAttribute(request, Constants.user_session);
		//参数
		StringBuilder params=new StringBuilder();
		
		Achievement achieve = new Achievement();
		// 判断传递来的名称是否为NUll并且还要判断是否为空串
		if (student!=null && StringUtils.isNotBlank(student.getStudentNumber())) {
			achieve.setStudentNumber(student.getStudentNumber());
		}

		
		
		//页号   //如果页号为空，  或者小于1  置为1
		achieve.setPageNo(Pagination.cpn(pageNo));
		
		//每一页数
		achieve.setPageSize(5);
		
		//分页对象
		Pagination pagination = achieveService.getAchieveListWithPage(achieve);
		
		//分页展示   /brand/list.do?name=哈他&isDisplay=1&pageNo=2
		pagination.pageView("list.do", params.toString());
		
		model.addAttribute("pagination", pagination);//request  ,response
		model.addAttribute("student", student);//request  ,response

		return "achieve/list";
	}
	
	//跳转品牌添加页面
	@RequestMapping(value="/show/ach/toAdd.do")
	public String toAdd(HttpServletRequest request,ModelMap model){
		Student student = (Student) sessionProvider.getAttribute(request, Constants.user_session);
		model.addAttribute("student", student);
		return "achieve/add";
	}
	
	//添加品牌
	@RequestMapping(value="/show/ach/add.do")
	public String add(String schoolID,String studentNumber,Achievement achieve,HttpServletRequest request){
		//添加开始
		//Student student = (Student) sessionProvider.getAttribute(request, Constants.user_session);
		achieve.setSchoolID(schoolID);
		achieve.setStudentNumber(studentNumber);
		achieveService.addAchieve(achieve);
		return "redirect:list.do";
	}
	
	//删除一个品牌
	@RequestMapping(value="/show/ach/delete.do")
	public String delete(Integer id,ModelMap model){
		//删除
		achieveService.deleteAchieveByKey(id);
		
		
		return "redirect:list.do";
	}
	//删除多个品牌
	@RequestMapping(value="/show/ach/deletes.do")
	public String deletes(Integer[] ids,ModelMap model){
		//删除
		achieveService.deleteAchieveByKeys(ids);
		
		return "redirect:list.do";
	}
	
	//跳转修改页面
	@RequestMapping(value="/show/ach/toEdit.do")
	public String toEdit(Integer id,HttpServletRequest request,ModelMap model){
		Achievement achieve = achieveService.getAchieveByKey(id);
		Student student = (Student) sessionProvider.getAttribute(request, Constants.user_session);
		model.addAttribute("achieve", achieve);
		model.addAttribute("student", student);
		return "achieve/edit";
	}
	
	//跳转列表页面
	@RequestMapping(value="/show/ach/edit.do")
	public String edit(Achievement achieve,ModelMap model){
		achieveService.updateAchieveByKey(achieve);

		return "redirect:list.do";
	}
	
	// 跳转right_myachieve页面
	@RequestMapping(value = "/show/ach/right_myachieve.do")
	public String right_myachieve(HttpServletRequest request,ModelMap model) {
		Serializable student = sessionProvider.getAttribute(request, Constants.user_session);
		model.addAttribute("student", student);
		return "achieve/list";
	}
}
