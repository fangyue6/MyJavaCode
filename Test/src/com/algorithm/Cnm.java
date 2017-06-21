package com.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Cnm {
	public static List<List<String>> one=new ArrayList<List<String>>();
	public static List<List<String>> one1=new ArrayList<List<String>>();
	public static List<String> two=new ArrayList<String>();
	public static List<String> three=new ArrayList<String>();

	//打印从n个数种选取m个数的组合数
	public static void main(String[] args) {
		String arr[] = {"1","2","3","4","5","6","7","8","9"}; 
		for(int i=1;i<=9;i++){
			three.add(i+"");
		}
		
		PrintCombination(arr,arr.length,3); 
		System.out.println("one的size="+one.size());
		for(int i=0;i<one.size();i++){
			List<String> result1 = one.get(i);
			/*for(String a:result1){
				System.out.print(a);
			}
			System.out.println();*/
			
			two = leftarr(three,result1);
			/*for(String a:two){
				System.out.print(a);
			}
			System.out.println();*/
			
			String [] arrtwo = new String [two.size()];
			for(int k=0;k<two.size();k++){
				arrtwo[k] = two.get(k);
				String[] arrtwo1 = new String[arrtwo.length];
				for(int ii=0;ii<arrtwo[k].length();ii++){
					arrtwo1[ii] = arrtwo[k].charAt(ii)+"";
				}
				one1.clear();
				PrintCombination1(arrtwo,arrtwo.length,6);
				FullPermutation f=new FullPermutation();  
				for(int j=0;j<one1.size();j++){
					List<String> result2 = one1.get(j);
					
			        f.listAll(result1,""); 
			        List<String> pailie1 = f.getResult();
			        System.out.println(pailie1);
			        
			        f.getResult().clear();
			        f.listAll(result2,"");
			        List<String> pailie2 = f.getResult();
			        
			        System.out.println(pailie2);
				}
			}
			
		}

	}
	//从后往前选取，选定位置i后，再在前i-1个里面选取m-1个。  
	//如 1 2 3 4 5 中选取 3 个  
	//1、选取5后，再在前4个里面选取2个，而前4个里面选取2个又是一个子问题，递归即可。  
	//2、如果不包含5，直接选定4，那么再在前3个里面选取2个，而前三个里面选取2个又是一个子问题，递归即可。  
	//3、如果也不包含4，直接选取3，那么再在前2个里面选取2个，刚好只有两个。  
	//纵向看，1、2、3刚好是一个for循环，初值为5，终值为m  
	//横向看，该问题为一个前i-1个中选m-1的递归。  
	static void Combination(String arr[], int nLen, int m, String out[], int outLen)  
	{  
	    if(m == 0)  
	    {  
	    	List<String> a =new ArrayList<String>();
	        for (int j = 0; j < outLen; j++){
	        	//System.out.print(out[j]+" ");
	        	a.add(out[j]+"");
	        }
	        one.add(a);
	        	
	        //System.out.println();
	  
	        return;  
	    }  
	  
	    for (int i = nLen; i >= m; --i)  //从后往前依次选定一个  
	    {  
	        out[m-1] = arr[i-1]; //选定一个后  
	        Combination(arr,i-1,m-1,out,outLen); // 从前i-1个里面选取m-1个进行递归  
	    }  
	}  
	
	static void Combination1(String arr[], int nLen, int m, String out[], int outLen)  
	{  
	    if(m == 0)  
	    {  
	    	List<String> a =new ArrayList<String>();
	        for (int j = 0; j < outLen; j++){
	        	//System.out.print(out[j]+" ");
	        	a.add(out[j]+"");
	        }
	        one1.add(a);
	        	
	        //System.out.println();
	  
	        return;  
	    }  
	  
	    for (int i = nLen; i >= m; --i)  //从后往前依次选定一个  
	    {  
	        out[m-1] = arr[i-1]; //选定一个后  
	        Combination(arr,i-1,m-1,out,outLen); // 从前i-1个里面选取m-1个进行递归  
	    }  
	}  
	  
	static void PrintCombination(String arr[], int nLen, int m)  
	{  
	    if(m > nLen)  
	        return;  
	  
	    String out[] = new String[m];  
	    Combination(arr,nLen,m,out,m);  
	}  
	static void PrintCombination1(String arr[], int nLen, int m)  
	{  
	    if(m > nLen)  
	        return;  
	  
	    String out[] = new String[m];  
	    Combination1(arr,nLen,m,out,m);  
	}
	
	static List<String> leftarr(List<String>all,List<String>use){
		List<String> left = new ArrayList<String>();
		for(int i=0;i<all.size();i++){
			String ooInteger=all.get(i);
			if(!use.contains(ooInteger)){
				left.add(all.get(i));
			}
		}

		return left;
	}

}
