package com.cacheserverdeploy.deploy;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("num:");
		int num=sc.nextInt();
		System.out.println("n:");
		int n=sc.nextInt();
		int[] a=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(i+": "+a[i]);;
//		}
		T(a,num);
	}
	public static void T(int[] a,int num){
		int sum=0;
		int location=-1;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
			if(sum>num){
				location=i;
				break;
			}			
		}
		if(location==-1){
			System.out.println("不能改变");
			return;
		}
		System.out.println(a[location]+"---");
		sum-=a[location];
		if(sum!=num)
			a[location]=num-sum;
		for (int i = 0; i < a.length; i++) {
			System.out.println(i+": "+a[i]);
		}
	}
}