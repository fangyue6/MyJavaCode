package com.yue.common.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 异步返回各种格式 json xml text
 * 
 * @author fangyue
 *
 */
public class ResponseUtils {

	// 发送内容 "application/json;charset=UTF-8"
	public static void render(HttpServletResponse response, String contentType,
			String text) {

		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//发送的是JSON
	public static void renderJson(HttpServletResponse response,String text){
		render(response, "application/json;charset=UTF-8", text);
	}
	//发送的是XML
	public static void renderXml(HttpServletResponse response,String text){
		render(response, "text/xml;charset=UTF-8", text);
	}
	//发送的是text
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain;charset=UTF-8", text);
	}

}
