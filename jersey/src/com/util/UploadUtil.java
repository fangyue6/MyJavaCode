package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;


public class UploadUtil {
	
	public static void saveLog(String LogFilepath, String LogMessage,
			Level level) throws SecurityException, IOException {
		/**
		 * String logPath = request.getRealPath("/") + "log" + File.separator
				+ "log.log";
		 */
		Logger loger = Logger.getLogger("test.Test");
		FileHandler fh = new FileHandler(LogFilepath, true);// 方法返回日志文件存放的路径
		loger.addHandler(fh);
		loger.setLevel(Level.ALL);
		SimpleFormatter sf = new SimpleFormatter();
		fh.setFormatter(sf);
		loger.log(level, LogMessage);
	}
	public static void creat(String newFilePath, InputStream in) {
		System.out.println(newFilePath);
		try {
			FileOutputStream out = new FileOutputStream(newFilePath);
			byte buf[] = new byte[1024];
			int len = -1;
			while ((len = in.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("出现错误");
		}
	}
	/**
	 * 得到当前年月日  2015/6/9
	 * @return
	 */
	public static String testDate() {
		int year = 0;
		int month = 0;
		int day = 0;

		TimeZone shanghaiTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
		Calendar calendar = Calendar.getInstance(shanghaiTimeZone);

		year = calendar.get(calendar.YEAR);

		month = calendar.get(calendar.MONTH) + 1;
		day = calendar.get(calendar.DAY_OF_MONTH);
		System.out.println(year + " " + month + " " + day);

		return year + File.separator + month + File.separator + day;
	}
	
	/**
	 * 
	 * @return 返回当前long型日期
	 */
	public static String currentDate() {
		TimeZone shanghaiTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
		Calendar calendar = Calendar.getInstance(shanghaiTimeZone);
		
		long current=calendar.getTimeInMillis();
		
		return current+"";
	}
	/**
	 * 
	 * @param filename 图片文件名
	 * @return  返回图片格式
	 */
	public static  String getPicFormat(String filename){
		
		return filename.substring(filename.lastIndexOf("."));
	}
	@Test 
	public void test_getPicFormat(){
		System.out.println(getPicFormat("g.h.g.j.png"));
	}
}
