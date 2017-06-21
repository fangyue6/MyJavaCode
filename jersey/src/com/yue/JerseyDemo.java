package com.yue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * 发送图片到另一台Tomcat服务器
 * @author fangyue
 *
 */
public class JerseyDemo {

	public static void main(String[] args) throws IOException {
		//实例化一个Jersey
		Client client = new Client();
		
		//另一台服务器的请求路径
		String url="http://localhost:8088/web-image/upload/";
		
		//设置请求路径
		WebResource resource = client.resource(url);
		resource=resource.path("/1.jpg");
		
		//本地路径
		String path ="C:\\Users\\fangyue\\Desktop\\实验室网页\\2.jpg";
		
		//读取图片到内存中
		byte[] readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
		
		//发送开始
		resource.put(String.class, readFileToByteArray);
		
		
		
		System.out.println("发送完毕");
	}
}
