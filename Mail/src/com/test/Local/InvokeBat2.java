package com.test.Local;

import java.io.IOException;  
import java.io.InputStream;  
  
public class InvokeBat2 {  
    public void runbat(String batName) {  
        try {  
            Process ps = Runtime.getRuntime().exec(batName);  
            InputStream in = ps.getInputStream();  
            int c;  
            while ((c = in.read()) != -1) {  
                System.out.print(c);// 如果你不需要看输出，这行可以注销掉  
            }  
            in.close();  
            ps.waitFor();  
  
        } catch (IOException ioe) {  
            ioe.printStackTrace();  
        } catch (InterruptedException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        System.out.println("child thread done");  
    }  
    
    public void runit(int flag){
    	String start = "C:\\Users\\admin\\Desktop\\ipclient.bat";  
    	String stop = "C:\\Users\\admin\\Desktop\\closeIpclient.bat"; 
    	if(flag==1){
    		runbat(start); 
    	}else{
    		runbat(stop); 
    	}
    }
  
    public static void main(String[] args) {  
        InvokeBat2 test1 = new InvokeBat2();  
        //String batName = "C:\\Users\\admin\\Desktop\\closeIpclient.bat";  
        String batName = "C:\\Users\\admin\\Desktop\\ipclient.bat";  
        test1.runbat(batName);  
        System.out.println("main thread");  
    }  
}  