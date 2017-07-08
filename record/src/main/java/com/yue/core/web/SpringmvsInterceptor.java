package com.yue.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yue.common.web.session.SessionProvider;
import com.yue.core.bean.Student;

/**
 * 处理上下文 处理session
 * 
 * @author fangyue
 *
 */
public class SpringmvsInterceptor implements HandlerInterceptor {

	@Autowired
	private SessionProvider sessionProvider;

	// 常量
	private static final String INTERCEPTOR_URL = "/show/";///record

	// 方法前 /record/user/info/
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Student s = (Student) sessionProvider.getAttribute(request,
				Constants.user_session);
		boolean flag = false;
		if (null != s) {
			flag = true;
		}
		request.setAttribute("flag", flag);

		// 是否拦截 http://localhost:8080/record/user/info/x.xx 
		// record/user/info/x.xx
		String requestURI = request.getRequestURI();
		//System.out.println("我拦截的是"+requestURI);
		if (requestURI.startsWith(INTERCEPTOR_URL)) {
			// 必须登录
			if (null == s) {
				response.sendRedirect("/user/login.do");// 登陆页面
				return false;
			}
		}
		return true;
	}

	// 方法后
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	// 页面渲染后
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
