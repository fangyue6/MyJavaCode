package com.algorithm;

import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;  
import java.util.List;  
import java.util.Scanner;
import java.util.Set;
  
public class mAn {  
	static int ns=0;
    private int all;  
    static Set<String> set = new HashSet<String>();
    public mAn()  
    {  
        this.all=0;  
    }  
    public int getAll() {  
        return all;  
    }  
    public void setAll(int all) {  
        this.all = all;  
    }  
    public static void main(String[] args) {  
    	Scanner in = new Scanner(System.in);
    	String sin = in.nextLine();
    	String []ss = sin.split(" ");
    	ns=Integer.parseInt(ss[0]);
    	int k =Integer.parseInt(ss[1]);
    	
        String[] n =new String[ns];
        for(int i=0;i<ns;i++){
        	n[i] = new String(i+"");
        }
        
        mAn m=new mAn();  
        List lst = Arrays.asList(n);  
        m.take("",k,lst);  

        int number=0;
        for(String s:set){
        	int si = Integer.parseInt(s);
        	if(si%ns==0){
        		number++;
        		number= number%1000000007;
        	}
        }
        System.out.println(number);
    }  
  
    public  void take(String s, int total, List lst) {  
        for (int i = 0; i < lst.size(); i++) {  
            //System.out.println("i="+i);  
            List templst=new LinkedList(lst);  
            String n =  (String) templst.remove(i);// 取出来的数字  
            String str = s + n;  
            if (total == 1) {  
            	str = paixu(str);
            	set.add(str);
            		/*int ss = Integer.parseInt(str);
                	System.out.println(str+"--"+ss+"--"+ns);
                	int temp = ss%ns;
                	System.out.println(temp);
                	all++; */
            	
                //System.out.println(str+"--");//以最极端 n个里面只取一个，直接把取出来的结果输出即可  
                //total=all;  
                 
              
            } else {  
                int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上  
                take(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合  
            }  
        }  
          
    }  
  public static String paixu(String s){
	  int [] a = new int[s.length()];
	  for(int i=0;i<s.length();i++){
		  a[i] = Integer.parseInt(s.charAt(i)+"");
	  }
	  for(int i=0;i<s.length()-1;i++){
		  for(int j=i+1;j<s.length();j++){
			  int temp=0;
			  if(a[j]<a[i]){
				  temp = a[i];
				  a[i] = a[j];
				  a[j] = temp;
			  }
		  }
	  }
	  String ss="";
	  for(int i=0;i<s.length();i++){
		  ss +=a[i];
	  }
	  return ss;
  }
}  