package com.yue.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

/**
 * session供应类
 * @author fangyue
 *
 */
public interface SessionProvider {

	//往session设置值
	//name Constants buyer_session
	//value 用户对象
	public void setAttribute(HttpServletRequest request,String name,Serializable value);
	
	//从session中取值
	public Serializable getAttribute(HttpServletRequest request,String name);
	
	//退出登陆
	public void logout(HttpServletRequest request);
	
	//获取SessionID
	public String getSessionId(HttpServletRequest request);
}
