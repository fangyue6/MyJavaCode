package com.yue.core.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yue.core.bean.Achievement;
import com.yue.core.bean.TestTb;
import com.yue.core.dao.AchievementDao;
import com.yue.core.dao.TestTbDao;


/**
 * 
 * @author lx
 *
 */
@Service
//开启事务
@Transactional
public class TestServiceImpl implements TestService{

	@Resource
	private TestTbDao testTbDao;
	
	@Resource
	private AchievementDao achievementDao;
	
	//@Transactional(readOnly = true)//只读的，关闭事务
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		
		//抛异常   
		throw new RuntimeException();
	}

	public List<Achievement> getAllAchieve() {
		List<Achievement> allAchievement = achievementDao.getAllAchievement();
		return allAchievement;
		
	}

}
