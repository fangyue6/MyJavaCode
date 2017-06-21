package com.yue.spring.ex;
/**
 * 面向接口编程
 * @author Administrator
 *
 */
public class ReadDocument {
	private Document document;
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public void say(){
		this.document.read();
	}
}
