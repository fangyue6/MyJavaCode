package com.yue.core.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import net.sf.json.JSONArray;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.common.page.Pagination;

import com.yue.common.web.ResponseUtils;
import com.yue.core.bean.Achievement;
import com.yue.core.bean.News;
import com.yue.core.bean.Student;
import com.yue.core.dao.NewsDao;
import com.yue.core.service.AchievementService;
import com.yue.core.service.NewsService;
import com.yue.core.service.StudentService;

/**
 * 主页
 * 
 * @author fangyue
 *
 */
@Controller
public class IndexController {
	@Autowired
	private AchievementService achieveService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private NewsService newsService;

	// 刚打开主页
	@RequestMapping(value = "/")
	public String openindex() {
		
		return "index.shtml";
	}
	// 主页
	@RequestMapping(value = "/index.shtml")
	public String index(ModelMap model) {

		//System.out.println("我来了");
		List<News> get10News = newsService.get10News();

		model.addAttribute("news10", get10News);

		return "tech/index";
	}
	// 主页异步请求
	@RequestMapping(value = "/upload/index.do")//,method = RequestMethod.POST
	public void uploadCode(HttpServletResponse response,HttpServletRequest request) {
		
		//System.out.println("请求了\n");
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		List<News> get10News = newsService.get10News();
		
		
		JSONArray jsonArray = JSONArray.fromObject(get10News);
		//System.out.println(jsonArray.toString());
		
		/*try {
			
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ResponseUtils.renderJson(response, jsonArray.toString());
	}

	// 新闻页
	@RequestMapping(value = "/news.shtml")
	public String news(Integer pageNo, HttpServletRequest request,
			ModelMap model) {
		// 参数
		StringBuilder params = new StringBuilder();

		News news = new News();

		// 页号 //如果页号为空， 或者小于1 置为1
		news.setPageNo(Pagination.cpn(pageNo));

		// 每一页数
		news.setPageSize(5);

		// 分页对象
		Pagination pagination = newsService.getNewsListWithPage(news);

		// 分页展示 /brand/list.do?name=哈他&isDisplay=1&pageNo=2
		pagination.pageView("news.shtml", params.toString());

		model.addAttribute("pagination", pagination);// request ,response
		model.addAttribute("news", news);// request ,response
		
		
		//最新新闻  10条
		List<News> get10News = newsService.get10News();

		model.addAttribute("news10", get10News);

		return "tech/news";
	}

	// 成员页
	@RequestMapping(value = "/members.shtml")
	public String members(ModelMap model) {
		List<Student> allStudent = studentService.getAll();
		Map<Integer, List<Student>> studentMap = studentService.getAllStudent();
		model.addAttribute("sum", allStudent.size());
		model.addAttribute("studentMap", studentMap);
		return "tech/members";
	}

	// 论文发表页
	@RequestMapping(value = "/publication.shtml")
	public String publication(ModelMap model) {
		Integer sum = achieveService.getAll().size();
		Map<Integer, List<Achievement>> allAchieve = achieveService
				.getAllAchieve();
		model.addAttribute("sum", sum);
		model.addAttribute("achieveMap", allAchieve);
		return "tech/publication";
	}
	
	// 科研项目页
	@RequestMapping(value = "/projects.shtml")
	public String projects(ModelMap model) {
		
		return "tech/projects";
	}

	// 合作页
	@RequestMapping(value = "/collaboration.shtml")
	public String collaboration() {
		return "tech/collaboration";
	}

	// 加入我们页
	@RequestMapping(value = "/join_us.shtml")
	public String join_us() {
		return "tech/join_us";
	}

	// 关于我们页
	@RequestMapping(value = "/about_us.shtml")
	public String about_us() {
		return "tech/about_us";
	}

	// 个人页面
	@RequestMapping(value = "/person.shtml")
	public String person(String sn, ModelMap model) {
		Student s = new Student();
		s.setStudentNumber(sn);
		Student student = studentService.getStudentByNumber(s);
		Achievement achievement = new Achievement();

		achievement.setStudentNumber(sn);
		List<Achievement> achievelist = achieveService
				.getAllAchievementByStudentNumber(achievement);

		model.addAttribute("student", student);
		model.addAttribute("achievelist", achievelist);
		return "tech/person";
	}
	
	

}
