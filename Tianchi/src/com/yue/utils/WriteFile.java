package com.yue.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

public class WriteFile {
	public static void write(String filename, String data) {
		try {
			// String data = " This content will append to the end of the file";

			File file = new File(filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// true = append file
			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.flush();
			bufferWritter.close();
			fileWritter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public static void writeToTxt(String filename,String data,int newline) {
		//String filename = "D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log";
		/*Set set = new HashSet<String>();
		set.add("中国");
		set.add("美国");
		set.add("英国");
		set.add("俄罗斯");
		Iterator iterator = set.iterator();*/
		File file = new File(filename);
		FileWriter fw = null;
		BufferedWriter writer = null;
		try {
			fw = new FileWriter(file,true);
			writer = new BufferedWriter(fw);
			writer.write(data);
			if(newline>0){
				writer.newLine();// 换行
			}
			
			
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void test01() throws Exception {
		write("D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log", "ddd");
		// saveLog("D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log","dddddd",Level.INFO);
	}

	/**
	 * LogFilepath是保存日志的路径 String logPath = request.getRealPath("/") + "log" +
	 * File.separator + "log.log";
	 */
	public static void saveLog(String LogFilepath, String LogMessage,
			Level level) throws SecurityException, IOException {

		Logger loger = Logger.getLogger("test.Test");
		FileHandler fh = new FileHandler(LogFilepath, true);// 方法返回日志文件存放的路径
		loger.addHandler(fh);
		loger.setLevel(Level.ALL);
		SimpleFormatter sf = new SimpleFormatter();
		fh.setFormatter(sf);
		loger.log(level, LogMessage);
	}
}