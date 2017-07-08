package com.yue.core.service;

import java.util.List;

import com.yue.core.bean.Achievement;
import com.yue.core.bean.TestTb;


public interface TestService {

	public void addTestTb(TestTb testTb);
	
	public List<Achievement> getAllAchieve();
}
