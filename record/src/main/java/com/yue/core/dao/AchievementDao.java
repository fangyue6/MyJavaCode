package com.yue.core.dao;

import java.util.List;

import com.yue.core.bean.Achievement;


public interface AchievementDao {
	//List集合
	public List<Achievement> getAchieveListWithPage(Achievement achievement);
	
	//查询总记录数
	public int getAchieveCount(Achievement achievement);
	
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
	
	//返回所有成果
	public List<Achievement> getAllAchievement();
	
	//通过studentNumber查询成果
	public List<Achievement> getAllAchievementByStudentNumber(Achievement achievement);
}
