package com.yue.core.dao;

import java.util.List;

import com.yue.core.bean.News;


public interface NewsDao {
	//List集合
	public List<News> getNewsListWithPage(News news);
	
	//查询总记录数
	public int getNewsCount(News news);
	
	//添加成果
	public void addNews(News news);
	
	//删除
	public void deleteNewsByKey(Integer id);
	
	//批量删除
	public void deleteNewsByKeys(Integer[] ids);//List<integer> ids
	
	//修改
	public void updateNewsByKey(News news);

	//成果返回一个
	public News getNewsByKey(Integer id);
	
	//返回所有新闻
	public List<News> getAllNews();
	
	//返回前10所有新闻
	public List<News> get10News();

}
