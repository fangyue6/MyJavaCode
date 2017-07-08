package com.yue.core.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
//import org.json.JSONObject;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yue.common.utils.UploadUtil;
import com.yue.common.web.ResponseUtils;
import com.yue.core.web.Constants;

@Controller
public class UploadController_1 {
	/**
	 * 获取项目路径
	 * @param request
	 * @return
	 */
	public String path(HttpServletRequest request) {

		String strDirPath = request.getSession().getServletContext()
				.getRealPath("/");

		int end = strDirPath.substring(0, strDirPath.length() - 1).lastIndexOf(
				File.separator);

		return strDirPath.substring(0, end + 1);
	}

	/**
	 * 
	 * @param request
	 * @param file
	 *            上传文件的控件
	 * @param path
	 *            数据库存储路径目录，不包含文件名
	 * @return
	 */
	private JSONObject saveFile(HttpServletRequest request, MultipartFile file,
			String path) {
		int result = 0;
		String url = Constants.WEBFILE_URL;
		// 原始文件名
		String filename = file.getOriginalFilename().trim();
		// 文件扩展名
		String extension = FilenameUtils.getExtension(filename).trim();
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 文件保存路径 存储文件的服务器目录
				String pathStr = path(request) + Constants.WEBFILE_storeName;
				File file_path = new File(pathStr + path);
				if (!file_path.exists()) {
					file_path.mkdirs();
				}
				if (!StringUtils.isBlank(extension)) {
					filename = filename.hashCode() + "." + extension;
				}
				File file_ = new File(file_path, filename);
				if (!file_.exists()) {
					file_.createNewFile();
				}
				// 转存文件
				file.transferTo(file_);
				url += (path + "/" + filename);
				result = 1;
			} catch (Exception e) {
				e.printStackTrace();
				result = 0;
			}
		} else {// 文件为空
			result = 0;
		}

		// 返回两个路径 一个状态
		JSONObject jo = new JSONObject();
		jo.put("result", result);
		jo.put("url", url);
		jo.put("path", path + "/" + filename);
		return jo;
	}
	
	/**
	 * 共有上传的代码
	 * @param up_pic
	 * @param path      存储目录
	 * @param response
	 * @param request
	 */
	private void common_upload(MultipartFile up_pic[],String path,HttpServletResponse response,HttpServletRequest request){
		JSONObject jos = new JSONObject();
		// 判断file数组不能为空并且长度大于0
		if (up_pic != null && up_pic.length > 0) {
			// 循环获取file数组中得文件
			for (int i = 0; i < up_pic.length; i++) {
				MultipartFile file = up_pic[i];
				// 保存文件
				JSONObject jo = saveFile(request, file, path);
				jos.put("result", jo);
			}
		}
		
		//String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
		
	/*	try {
			 PrintWriter out = response.getWriter(); 
			 System.out.println(jsonpCallback+"("+jos.toString()+")");
			 out.println(jsonpCallback+"("+jos.toString()+")");//返回jsonp格式数据
			 out.flush();  
			 out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ResponseUtils.renderJson(response, jos.toString());
	}

	// 上传图片
	@RequestMapping(value = "/upload/uploadPic1.do",method = RequestMethod.POST)//
	public void uploadPic(
			@RequestParam(required = false) MultipartFile up_pic[],
			String time, String studentNumber, HttpServletResponse response,
			HttpServletRequest request) {
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		// 数据库保存的路径
		String pathString = "upload/pic/" + time.trim() + "/" + studentNumber.trim();
		
		common_upload(up_pic,pathString,response,request);
	}


	// 上传代码
	@RequestMapping(value = "/upload/uploadCode1.do",method = RequestMethod.POST)
	public void uploadCode(
			@RequestParam(required = false) MultipartFile upload_code[],
			String uploadtime, String studentNumber,
			HttpServletResponse response,HttpServletRequest request) {
		
		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		// 数据库保存的路径
		String pathString = "upload/code/" + uploadtime.trim() + "/" + studentNumber.trim();
		common_upload(upload_code,pathString,response,request);
	}

	// 上传文章
	@RequestMapping(value = "/upload/uploadEssay1.do",method = RequestMethod.POST)
	public void uploadEssay(
			@RequestParam(required = false) MultipartFile upload_essay[],
			String uploadtime, String studentNumber,
			HttpServletResponse response, HttpServletRequest request) {

		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		// 数据库保存的路径
		String pathString = "upload/essay/" + uploadtime.trim() + "/" + studentNumber.trim();
		common_upload(upload_essay, pathString, response, request);
	}

	// 上传新闻图片
	@RequestMapping(value = "/upload/uploadNews1.do",method = RequestMethod.POST)
	public void uploadNews(
			@RequestParam(required = false) MultipartFile upload_news[],
			HttpServletResponse response,HttpServletRequest request) {

		response.setHeader("Access-Control-Allow-Origin", "*");// 跨域
		
		// 数据库保存的路径
		String pathString = "upload/news/" + UploadUtil.testDate().trim();
		common_upload(upload_news,pathString,response,request);
	}


	@RequestMapping(value = "/index.do")
	public String index() {
		return "index";
	}

	@Test
	public void test1() throws IOException {
		File file_path = new File(
				"D:/develop/apache-tomcat-7.0.69/webapps/web-file/fic/123/234");

		if (!file_path.exists()) {
			file_path.mkdirs();
		}

		File file = new File(file_path, "111.jpg");

		if (!file.exists()) {
			try {
				System.out.println(file.createNewFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	@RequestMapping("/base/jsonp.do")   //jsonp
	public void exchangeJson(HttpServletRequest request,HttpServletResponse response) { 
	   try {  
	    /*response.setContentType("text/plain");  
	    response.setHeader("Pragma", "No-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);*/  

	    PrintWriter out = response.getWriter();       
	    JSONObject resultJSON = new JSONObject(); //根据需要拼装json 
	    resultJSON.put("result", 1);
	    String jsonpCallback = request.getParameter("jsonpCallback");//客户端请求参数  
	    
	    out.println(jsonpCallback+"("+resultJSON.toString()+")");//返回jsonp格式数据  
	    System.out.println(jsonpCallback+"("+resultJSON.toString()+")");
	    out.flush();  
	    out.close();  
	  } catch (IOException e) {  
	   e.printStackTrace();  
	  }  
	}  
	@RequestMapping("/base/json.do")   //json
	public void json(String name,HttpServletRequest request,HttpServletResponse response) { 
		System.out.println("我得到了name参数为"+name);
		try {  
			/*response.setContentType("text/plain");  
	    response.setHeader("Pragma", "No-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);*/  
			
			PrintWriter out = response.getWriter();       
			JSONObject resultJSON = new JSONObject(); //根据需要拼装json 
			resultJSON.put("result", 1);
			
			out.println(resultJSON.toString());//返回json格式数据  
			System.out.println(resultJSON.toString());
			out.flush();  
			out.close();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}  
}
// clean tomcat7:redeploy -DskipTests

