package com.test;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Local.InvokeBat2;
public class DoTest extends HttpServlet {

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
		String bat = request.getParameter("bat");
		System.out.println("bat:"+bat);

		InvokeBat2 test1 = new InvokeBat2(); 
		test1.runit(Integer.parseInt(bat));
	}

}
