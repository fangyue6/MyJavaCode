package com.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coupingfang {
	static long[] shu = new long[20];
	static Set<String> jjSet = new HashSet<String>();
	static String ai="0123456789"; 
	
	public static void main(String[] args) {
		FullPermutation p = new FullPermutation();
		String []arr={"0","1","2","3","4","5","6","7","8","9"};  
        p.listAll(Arrays.asList(arr),""); 
        List<String> list = p.getResult();
        for(String str:list){
        	ai = str;
        	dfs(0, 0);
        }
        System.out.println(jjSet.size());
        for(String s:jjSet){
        	System.out.println(s);
        }

	}
	public static void dfs(int cur , int num){
		if(cur == 10){
			 long[] shu2 = new long[20];
			 for(int i =0;i<num;i++){
				 shu2[i] = shu[i];//将存储的数字赋值
			 }
			 Arrays.sort(shu2, 0, num);//排序
			 String xu = "";
			 for(int i=0;i<num;i++){
				/* while(shu2[i] != 0){
					 int a = (int) (shu2[i] % 10);
					 shu2[i]  = shu2[i] / 10;
					 String b = a + "";
					 xu = xu + b;
				 }
				 xu = xu + "-"; */
				 xu = xu + "-" + shu2[i];
			 }
			 /*for(int i=0;i<num;i++){
				 System.out.print(shu[i]+" ");
			 }
			 System.out.println();*/
			 
			 jjSet.add(xu);
			 
			 return;
		}
		
		if(ai.charAt(cur) == '0'){//如果第一个表示0 那么直接进行下一个数字
			shu[num] = 0;
			dfs(cur+1,num+1);
		}else{
			long sum = 0;
			for(int i=cur;i<10;i++){
				sum = sum*10+Integer.parseInt(ai.charAt(i)+"");
				double son = Math.sqrt(sum);
				if(son == (int)son){
					shu[num]  = sum;
					dfs(i+1, num+1);
				}
			}
		}
	}

}
