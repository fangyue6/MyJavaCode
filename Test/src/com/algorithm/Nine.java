package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nine {
	static String nu = "123456789";
	static Set<String> result = new HashSet<String>();

	public static void main(String[] args) {
		String [] a = {"1","2","3","4","5","6","7","8","9"};
		FullPermutation p = new FullPermutation();
		p.listAll(Arrays.asList(a), "");
		List<String> list = p.getResult();
		for(String s:list){
			nu = s;
			dfs();
		}
		System.out.println(result.size());
		for(String s:result){
			System.out.println(s);
		}

	}
	public static void dfs(){
			for(int oneend=1;oneend<8;oneend++){
				for(int twoend =oneend+1;twoend<8;twoend++){
					long one=0,two=0,three=0;
					for(int i=0;i<oneend;i++){
						one = one*10+Integer.parseInt(nu.charAt(i)+"");
					}
					for(int i=oneend;i<twoend;i++){
						two = two*10+Integer.parseInt(nu.charAt(i)+"");
					}
					for(int i=twoend;i<9;i++){
						three = three*10+Integer.parseInt(nu.charAt(i)+"");
					}
					if(one*two==three){
						if(one>two){
							long temp = two;
							two = one;
							one = temp;
						}
						result.add(one+"*"+two+"="+three);
						return;
					}
				}
				
			}

	}

}
