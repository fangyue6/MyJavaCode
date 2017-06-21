package com.yue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.util.UploadUtil;
/**
 * UploadActivity
 * @author fangyue
 *
 */
public class UploadActivity extends HttpServlet {

	/**
	 * 上传与员工 图片
	 */
	private static final long serialVersionUID = 6045352108756500535L;

	public UploadActivity() {
		System.out.println("init -------");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ajaxUpdateResult = "";
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		System.out.println("------dopost------");
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);

			for (FileItem item : items) {

				if (item.isFormField()) {
					System.out.println(item.getString());
					//
					// String filepath = request.getRealPath("/")
					// + UploadUtil.testDate();
					// File file = new File(filepath);
					// file.mkdirs();
					// UploadUtil.creat(filepath + File.separator + "aa.png",
					// item.getInputStream());
				} else {
					String fileName = item.getName();
					InputStream content = item.getInputStream();

					response.setContentType("text/plain");
					response.setCharacterEncoding("UTF-8");
					String filepath = "/media" + File.separator + "picture"
							+ File.separator + "activity";
					String temp = UploadUtil.currentDate()
							+ UploadUtil.getPicFormat(item.getName());
					/*String logPath = request.getRealPath("/") + "log"
							+ File.separator + "log.log";
					UploadUtil.saveLog(logPath, filepath, Level.INFO);*/
					// http://120.27.43.71:8080/store/picture/2015/6/1/baiduapi.png
					File file = new File(filepath);
					file.mkdirs();
					//

					UploadUtil.creat(filepath + File.separator + temp, content);

					String pic_DataBaseUrl = "http://120.27.43.71:8080/store/picture/activity/"
							+ temp;
					/*
					 * ajaxUpdateResult += "File " + fileName +
					 * " is successfully uploaded</br>picture_DataBaseUrl=<a href='"
					 * + pic_DataBaseUrl + "'>" + pic_DataBaseUrl + "</a></br>";
					 */
					ajaxUpdateResult = pic_DataBaseUrl;
				}
			}
		} catch (FileUploadException e) {
			ajaxUpdateResult=null;
			throw new ServletException("Parsing file upload failed.", e);
		}

		response.getWriter().print(ajaxUpdateResult);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
