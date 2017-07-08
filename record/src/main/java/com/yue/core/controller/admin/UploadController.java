package com.yue.core.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
//import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.yue.common.web.ResponseUtils;
import com.yue.core.web.Constants;

/**
 * 上传图片 上传代码
 * 
 * @author fangyue
 *
 */
@Controller
public class UploadController {
	

	// 上传图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(HttpServletResponse response) {
		/*@RequestParam(required = false) MultipartFile up_pic,
		String time, String studentNumber, */
		JSONObject j = new JSONObject();
		j.put("url", Constants.address_URL+"/upload/uploadPic1.do");
		ResponseUtils.renderJson(response, j.toString());
		
		

	/*	String extension = FilenameUtils.getExtension(up_pic
				.getOriginalFilename());

		
		 * //图片名称生成策略 DateFormat df = new
		 * SimpleDateFormat("yyyyMMddHHmmssSSS");//毫秒 //图片名称一部分 String format =
		 * df.format(new Date());
		 
		String format = studentNumber.trim() + "_";
		// 随机三位数
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			format += r.nextInt(10);
		}
		format += "." + extension;
		// 实例化一个Jersey
		Client client = new Client();
		// 保存数据库的
		String path = "upload/pic/" + time.trim() + "_" + format;

		// 另一台服务器的请求路径
		String url = Constants.IMAGE_URL + path;

		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始
		try {
			resource.put(String.class, up_pic.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.renderJson(response, jo.toString());*/
	}

	// 上传代码
	@RequestMapping(value = "/upload/uploadCode.do")
	public void uploadCode(HttpServletResponse response) {
		/*@RequestParam(required = false) MultipartFile upload_code,
		String uploadtime, String studentNumber,*/
		JSONObject j = new JSONObject();
		j.put("url", Constants.address_URL+"/upload/uploadCode1.do");
		ResponseUtils.renderJson(response, j.toString());


		/*String originalFilename = upload_code.getOriginalFilename();
		String extension = FilenameUtils.getExtension(originalFilename);

		// 实例化一个Jersey
		Client client = new Client();
		// 保存数据库的
		String path = "upload/code/" + uploadtime.trim() + "_"
				+ studentNumber.trim() + "_" + originalFilename.hashCode()+"."+extension;

		// 另一台服务器的请求路径
		String url = Constants.IMAGE_URL + path;

		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始
		try {
			resource.put(String.class, upload_code.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.renderJson(response, jo.toString());*/
	}

	// 上传文章
	@RequestMapping(value = "/upload/uploadEssay.do")
	public void uploadEssay(HttpServletResponse response) {
		/*@RequestParam(required = false) MultipartFile upload_essay,
		String uploadtime, String studentNumber,*/
		JSONObject j = new JSONObject();
		j.put("url", Constants.address_URL+"/upload/uploadEssay1.do");
		ResponseUtils.renderJson(response, j.toString());
		
		/*String originalFilename = upload_essay.getOriginalFilename();
		String extension = FilenameUtils.getExtension(originalFilename);

		// 实例化一个Jersey
		Client client = new Client();
		// 保存数据库的
		String path = "upload/essay/" + uploadtime.trim() + "_"
				+ studentNumber.trim() + "_" + originalFilename.hashCode()+"."+extension;

		// 另一台服务器的请求路径
		String url = Constants.IMAGE_URL + path;

		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始
		try {
			resource.put(String.class, upload_essay.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.renderJson(response, jo.toString());*/
	}

	// 上传新闻图片
	@RequestMapping(value = "/upload/uploadNews.do")
	public void uploadNews(HttpServletResponse response) {
		/*@RequestParam(required = false) MultipartFile upload_news,*/
		JSONObject j = new JSONObject();
		j.put("url", Constants.address_URL+"/upload/uploadNews1.do");
		ResponseUtils.renderJson(response, j.toString());
	
		/*String originalFilename = upload_news.getOriginalFilename();
		String extension = FilenameUtils.getExtension(originalFilename);

		// 实例化一个Jersey
		Client client = new Client();

		// 保存数据库的
		String path = "upload/news/" + originalFilename.hashCode()+"."+extension;

		// 另一台服务器的请求路径
		String url = Constants.IMAGE_URL + path;

		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始
		try {
			resource.put(String.class, upload_news.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);

		ResponseUtils.renderJson(response, jo.toString());*/
	}

	// 上传多个图片
	@RequestMapping(value = "/upload/uploadMany.do")
	public void uploadMany(
			@RequestParam(required = false) MultipartFile fileselect,
			HttpServletResponse response) {

		MultipartFile upload_essay = fileselect;
		String originalFilename = upload_essay.getOriginalFilename();
		//String extension = FilenameUtils.getExtension(originalFilename);

		// 实例化一个Jersey
		Client client = new Client();
		// 保存数据库的
		String path = "upload/essay/" + originalFilename;

		// 另一台服务器的请求路径
		String url = Constants.WEBFILE_URL + path;

		// 设置请求路径
		WebResource resource = client.resource(url);

		// 发送开始
		try {
			resource.put(String.class, upload_essay.getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 返回两个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path", path);
		System.out.println(url);

		// ResponseUtils.renderJson(response, jo.toString());
	}
	@RequestMapping(value="/test.do")
	public void test1(HttpServletResponse response,HttpServletRequest request){
		System.out.println("come on ");
		System.out.println(request.getContextPath());
		String strDirPath = request.getSession().getServletContext().getRealPath("/"); 
		System.out.println(strDirPath);
	}
}
