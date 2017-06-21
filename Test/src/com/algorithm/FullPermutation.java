package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FullPermutation {//全排列组合  
    private int n;  
    private List<String> result = new ArrayList<String>();
    public FullPermutation ()  
    {  
        this.n=0;  
    }  
    public  void listAll(List candidate,String prefix)  
    {  
          
        if(candidate.isEmpty())  
        {  
            //System.out.println(prefix);
        	/*if(prefix.charAt(0)!='0'){
        		result.add(prefix);
                this.n++; 
        	}*/
        	result.add(prefix);
            this.n++;
             
        }  
        for(int i=0;i<candidate.size();i++)  
        {  
            List temp=new LinkedList(candidate);//转换成linkList,移除一个对象是在不影响原来队列的基础上的  
            String s1=prefix+temp.remove(i);//用于保存排列组合生成的结果  
            listAll(temp,s1);//注意，这里temp和s1都是全新的集合和字符串，并不是一直对一个集合来进行操作  
              
        }  
          
    }  
    public int getN() {  
        return n;  
    }  
    public void setN(int n) {  
        this.n = n;  
    }  
    public List<String> getResult() {
		return result;
	}
	public void setResult(List<String> result) {
		this.result = result;
	}
	public static void main(String[] args) {  
        String []arr={"0","1","2","3","4","5","6","7","8","9"};  
        FullPermutation f=new FullPermutation();  
        f.listAll(Arrays.asList(arr),"");  
        for(String s:f.getResult()){
        	System.out.println(s);
        }
        System.out.println("所有的排列个数："+f.getN());  
    }  
  
}  