package com.yue.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 本地session
 * @author fangyue
 *
 */
public class HttpSessionProvider implements SessionProvider {

	public void setAttribute(HttpServletRequest request, String name,
			Serializable value) {
		HttpSession session = request.getSession();//true  如果有就取，没有就创建
		session.setAttribute(name, value);
		
	}

	public Serializable getAttribute(HttpServletRequest request, String name) {
		HttpSession session = request.getSession(false);
		if(session !=null){
			return (Serializable) session.getAttribute(name);
		}
		return null;
	}

	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session !=null){
			 session.invalidate();
		}
		//Cookie JSESSIONID
	}

	public String getSessionId(HttpServletRequest request) {
		
		//request.getRequestedSessionId();//Http://localhost:8080/html/ss.shtml?JSESSIONID=jhjhjsduew23
		return request.getSession().getId();
	}



}
