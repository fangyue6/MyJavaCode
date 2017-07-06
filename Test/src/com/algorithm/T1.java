package com.algorithm;

import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		double s=0.0;
		for(int i=2;i<=n;i++){
			s  = s + Math.pow(0.5, i);
		}
		String string = String.format("%.1f", n-1+s);
		
		System.out.println(string);

	}

}
