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
import com.yue.core.bean.News;
import com.yue.core.bean.Student;
import com.yue.core.service.NewsService;
import com.yue.core.web.Constants;

import cn.itcast.common.page.Pagination;
/**
 * 成果管理
 * @author fangyue
 *
 */
@Controller
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private SessionProvider sessionProvider;

	// 新闻列表页面
	@RequestMapping(value = "/show/news/list.do")
	public String list(Integer pageNo,HttpServletRequest request,ModelMap model) {
		//参数
		StringBuilder params=new StringBuilder();
		
		News news = new News();

		
		
		//页号   //如果页号为空，  或者小于1  置为1
		news.setPageNo(Pagination.cpn(pageNo));
		
		//每一页数
		news.setPageSize(5);
		
		//分页对象
		Pagination pagination = newsService.getNewsListWithPage(news);
		
		//分页展示   /brand/list.do?name=哈他&isDisplay=1&pageNo=2
		pagination.pageView("list.do", params.toString());
		
		model.addAttribute("pagination", pagination);//request  ,response
		model.addAttribute("news", news);//request  ,response

		return "news/list";
	}
	
	//跳转新闻添加页面
	@RequestMapping(value="/show/news/toAdd.do")
	public String toAdd(HttpServletRequest request,ModelMap model){
		return "news/add";
	}
	
	//添加品牌
	@RequestMapping(value="/show/news/add.do")
	public String add(News news,HttpServletRequest request){
		//添加开始
		newsService.addNews(news);
		return "redirect:list.do";
	}
	
	//删除一个新闻
	@RequestMapping(value="/show/news/delete.do")
	public String delete(Integer id,ModelMap model){
		//删除

		newsService.deleteNewsByKey(id);
		
		return "redirect:list.do";
	}
	//删除多个新闻
	@RequestMapping(value="/show/news/deletes.do")
	public String deletes(Integer[] ids,ModelMap model){
		//删除
		//achieveService.deleteAchieveByKeys(ids);
		newsService.deleteNewsByKeys(ids);
		return "redirect:list.do";
	}
	
	//跳转修改页面
	@RequestMapping(value="/show/news/toEdit.do")
	public String toEdit(Integer id,HttpServletRequest request,ModelMap model){
		/*News achieve = achieveService.getAchieveByKey(id);
		Student student = (Student) sessionProvider.getAttribute(request, Constants.user_session);
		model.addAttribute("achieve", achieve);
		model.addAttribute("student", student);*/
		News news  =newsService.getNewsByKey(id);
		model.addAttribute("news", news);
		return "news/edit";
	}
	
	//修改新闻  跳转列表页面
	@RequestMapping(value="/show/news/edit.do")
	public String edit(News news,ModelMap model){
		//achieveService.updateAchieveByKey(achieve);

		newsService.updateNewsByKey(news);
		return "redirect:list.do";
	}
}
