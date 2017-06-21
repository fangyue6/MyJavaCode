package com.yue.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import com.yue.utils.WriteFile;

public class FileHandle {
	@Test
	public void test1(){
		String filename="D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID - 副本.log";
		String newfilename="D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log";
		lastchar(filename,newfilename);
	}
	public void lastchar(String fileName,String newfile){
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				tempString=tempString.trim();
				tempString=tempString.subSequence(0, tempString.length()-1)+"";
				System.err.println(tempString);
				WriteFile.writeToTxt(newfile, tempString, 1);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			//mongo.close();
		}
	}
}
