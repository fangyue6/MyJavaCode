package com.yue.core.service;

import java.util.List;
import java.util.Map;

import com.yue.core.bean.Achievement;

import cn.itcast.common.page.Pagination;

public interface AchievementService {

	public Pagination getAchieveListWithPage(Achievement achievement);
	
	//添加成果
	public void addAchieve(Achievement achievement);
	
	//删除
	public void deleteAchieveByKey(Integer id);
	
	//批量删除
	public void deleteAchieveByKeys(Integer[] ids);//List<integer> ids
	
	//修改
	public void updateAchieveByKey(Achievement achievement);
	
	//成果返回一个
	public Achievement getAchieveByKey(Integer id);
	
	public Map<Integer, List<Achievement>> getAllAchieve();
	
	public List<Achievement> getAll();
	
	//通过studentNumber查询成果
	public List<Achievement> getAllAchievementByStudentNumber(Achievement achievement);
	
}
