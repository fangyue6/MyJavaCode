package com.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestP {
	static List<String> result = new ArrayList<String>(); 
	static String now="";
	static long nu[] = new long[10];
	static Set<String> resultset = new HashSet<String>();
	static String curString ="";
	public static void main(String[] args){
		String[] arr = {"0","1","2","3","4","5","6","7","8","9"};
		getAll(Arrays.asList(arr), "");
		for(String s:result){
			curString =s;
			cou(0,0);
		}
		for(String s:resultset){
			System.out.println(s);
		}
	}
	
	public static void cou(int cur,int num){
		if(cur==10){
			long sortnu[] = new long[10];
			for(int i=0;i<num;i++){
				sortnu[i] = nu[i];
			}
			Arrays.sort(sortnu,0,num);
			String temp=""; 
			for(int i=0;i<num;i++){
				temp += sortnu[i]+" ";
			}
			resultset.add(temp);
		}else{
			if(curString.charAt(cur)=='0'){
				nu[num] = 0;
				cou(cur+1,num+1);
			}else{
				long sum = 0;
				for(int i=cur;i<10;i++){
					sum = sum*10 + Integer.parseInt(curString.charAt(i)+"");
					long sum1 = (long)Math.sqrt(sum);
					if(sum1*sum1 == sum){
						nu[num] = sum;
						cou(i+1, num+1);
					}
				}
			}
			
			
		}
	}
	
	public static void getAll(List candicate,String perfix){
		if(candicate.isEmpty()){
				result.add(perfix);
		}else{
			for(int i=0;i<candicate.size();i++){
				List temp = new LinkedList(candicate);
				String s = perfix + temp.remove(i);
				getAll(temp, s);
			}
		}
		
	}

}
