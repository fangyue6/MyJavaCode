package com.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class TestSort {

	public static void main(String[] args) {
		List<Integer> l  = new ArrayList<Integer>();
		l.add(1);
		l.add(3);
		l.add(2);
		l.add(5);
		
		List<Store> lstore  = new ArrayList<Store>();
		for(int i=0;i<10;i++){
			Store store = new Store();
			store.setA(i*(int)(Math.random()*100));
			store.setName(i+"");
			lstore.add(store);
		}
		
		Collections.sort(l, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		
		Collections.sort(lstore, new Comparator<Store>() {

			@Override
			public int compare(Store o1, Store o2) {
				// TODO Auto-generated method stub
				return o1.getA()-o2.getA();
			}
		});
		
		for(Integer i:l){
			System.out.println(i);
		}
		for(Store i:lstore){
			System.out.println(i.toString());
		}

	}

}
class Store{
	private int a;
	private String name;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Store [a=" + a + ", name=" + name + "]";
	}
	
	
}
