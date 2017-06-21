package cn.itcast.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.core.bean.TestTb;
import cn.itcast.core.dao.TestTbDao;

/**
 * 
 * @author lx
 *
 */
@Service
//开启事务
@Transactional
public class TestTbServiceImpl implements TestTbService{

	@Resource
	private TestTbDao testTbDao;
	
	//@Transactional(readOnly = true)//只读的，关闭事务
	public void addTestTb(TestTb testTb) {
		testTbDao.addTestTb(testTb);
		
		//抛异常   
		throw new RuntimeException();
	}

}
