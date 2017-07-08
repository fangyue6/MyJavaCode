package com.yue.core.web;
/**
 * 业务常量
 * @author fangyue
 *
 */
public interface Constants {
	/**
	 * 图片服务器
	 */
	//public static final String IMAGE_URL="http://114.215.88.247:8088/web-file/";//http://114.215.88.247/
	//202.193.10.244 zhanglab.ci.gxnu.edu.cn   172.16.25.252
	public static final String WEBFILE_URL="http://172.16.25.252/web-file/";//http://114.215.88.247/
	//public static final String WEBFILE_URL="http://localhost:8080/web-file/";//http://114.215.88.247/
	
	/**
	 * 文件接收服务器   跨域地址
	 */
	//public static final String address_URL="http://114.215.88.247:8088";//http://114.215.88.247/
	public static final String address_URL="http://172.16.25.252";//http://114.215.88.247/
	//public static final String address_URL="http://localhost:8080";//http://114.215.88.247/
	
	/**
	 * 图片服务器项目名
	 */
	public static final String WEBFILE_storeName="web-file/";//http://114.215.88.247/
	
	/**
	 * 用户Session user_session  user_session
	 * 超级管理员Session admin_session superadmin
	 */
	public static final String user_session="user_session";
	public static final String admin_session="superadmin";
	
	/**
	 * 超级管理员用户名和密码    superadmin  superadmin
	 * com.yue.core.controller.ShowController.left
	 */
	public static final String superuser="superadmin";
	public static final String superpass="superadmin";
	

}
