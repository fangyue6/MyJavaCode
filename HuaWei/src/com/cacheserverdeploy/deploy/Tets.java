package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tets {

	public static void main(String[] args) {
		Stack<Integer> stack =new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.push(4);
		for(Integer i:stack){
			System.out.print(i+" ");
		}
		System.out.println();
		
		stack.pop();
		for(int j=0;j<stack.size();j++){
			System.out.print(stack.get(j)+" ");
		}
		System.out.println();
		int a[]={1,2,3,4,5};
		int [] newa = Arrays.copyOfRange(a, 0, 2);
		for(Integer i:newa){
			System.out.print(i+" ");
		}

		
		A a1 = new A();
		
		
		A a2 = new A();
		List<A> as =new ArrayList<A>();
		as.add(a1);
		as.add(a2);
		
		a1.setA(10);
		a2.setA(11);
		
		for(int i=0;i<as.size();i++){
			System.out.println(as.get(i).toString());
		}
		
		
	}

	
}
class A{
	int a=0;
	int b =1;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "A [a=" + a + ", b=" + b + "]";
	}
	
}
