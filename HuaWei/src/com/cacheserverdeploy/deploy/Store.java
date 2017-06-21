package com.cacheserverdeploy.deploy;

import java.util.Stack;

public class Store{
	int consume_id;
	int consume_cost;
	int w;
	int flag=0;
	Stack<Integer> st;
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getConsume_id() {
		return consume_id;
	}
	public void setConsume_id(int consume_id) {
		this.consume_id = consume_id;
	}
	public int getConsume_cost() {
		return consume_cost;
	}
	public void setConsume_cost(int consume_cost) {
		this.consume_cost = consume_cost;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public Stack<Integer> getSt() {
		return st;
	}
	public void setSt(Stack<Integer> st) {
		this.st = st;
	}
	
}