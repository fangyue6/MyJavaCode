package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.filetool.util.FileUtil;


public class Deploy
{
	
	
    /**
     * 你需要完成的入口
     * <功能详细描述>
     * @param graphContent 用例信息文件
     * @return [参数说明] 输出结果信息
     * @see [类、类#方法、类#成员]
     */
    public static String[] deployServer(String[] graphContent)
    {
        /**do your work here**/
    	Our_method me = new Our_method(graphContent);
    	return me.getOut_put();
        //return new String[]{"17","\r\n","0 8 0 20"};
    }
    
    /*public static void main(String [] args){
    	
    	long time1 = System.currentTimeMillis();
    	String graphFilePath = "C:/Users/admin/Desktop/文件/HUAWEI_Code_Craft_2017_Preliminary_Contest_Question_zh/case_example/case0.txt";
    	String[] graphContent = FileUtil.read(graphFilePath, null);
    	Our_method me = new Our_method(graphContent);
    	String[] output =  me.getOut_put();
    	for(int i=0 ;i<output.length;i++){
    		System.out.println(output[i]);
    	}
    	long time2 = System.currentTimeMillis();
        System.out.println("一共耗时："+(time2-time1)+" ms");
    }*/

}
