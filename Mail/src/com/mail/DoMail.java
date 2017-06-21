package com.mail;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoMail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8209252250820781583L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		System.out.println("接收者:"+email);
		System.out.println("标题:"+subject);

		// 1. 得到session

		Session session = MailUtils.createSession("smtp.163.com",
				"yue_fang_ser", "Yue854289665Fang");

		// 2. 创建邮件对象

		// String from, String to, String subject, String content
		Mail mail = new Mail("yue_fang_ser@163.com", email,subject, content);

		// 创建两个附件对象
/*
		AttachBean ab1 = new AttachBean(new File(
				"D:/数据/MobileFile/IMG_20150501_212727.jpg"), "小美女.jpg");
		AttachBean ab2 = new AttachBean(new File(
				"D:/数据/MobileFile/IMG_20150502_140551.jpg"), "我的羽绒服.jpg");

		// 添加到mail中
		mail.addAttach(ab1);
		mail.addAttach(ab2);*/

		// 3. 发送

		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
