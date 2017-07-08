package com.yue.core.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yue.core.bean.News;
import com.yue.core.dao.NewsDao;
import com.yue.core.web.Constants;

import cn.itcast.common.page.Pagination;

/**
 * 品牌事务
 * 
 * @author fangyue
 *
 */
@Service
@Transactional
// 事务
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsDao newsDao;
	List<News> allNews;

	@Transactional(readOnly = true)
	public Pagination getNewsListWithPage(News news) {
		// 1.起始页 startRow=(pageNo-1)*pageSize
		// 2.每页数
		// 3.总记录数
		Pagination pagination = new Pagination(news.getPageNo(),
				news.getPageSize(), newsDao.getNewsCount(news));
		// News集合
		List<News> NewsList = newsDao.getNewsListWithPage(news);
		for (News news1 : NewsList) {
			System.out.println("-"+news1.getPic()+"-");
			//if(news1.getPic().trim()!="" && news1.getPic().trim()!=null)
			news1.setPic1(Constants.WEBFILE_URL + news1.getPic());
		}
		pagination.setList(NewsList);

		return pagination;
	}

	public void addNews(News news) {

		newsDao.addNews(news);

	}

	public void deleteNewsByKey(Integer id) {
		newsDao.deleteNewsByKey(id);

	}

	public void deleteNewsByKeys(Integer[] ids) {
		newsDao.deleteNewsByKeys(ids);

	}

	public void updateNewsByKey(News news) {
		newsDao.updateNewsByKey(news);

	}

	public News getNewsByKey(Integer id) {
		News news = newsDao.getNewsByKey(id);
		news.setPic1(Constants.WEBFILE_URL + news.getPic());

		return news;
	}

	public Map<Integer, List<News>> getAllNews_() {

		HashSet<Integer> years = new HashSet<Integer>();
		Map<Integer, List<News>> treeMap = new TreeMap<Integer, List<News>>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						if (o1 == null || o2 == null)
							return 0;
						return o2 - o1;
					}
				});

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < allNews.size(); i++) {
			News a = allNews.get(i);
			a.setPic1(Constants.WEBFILE_URL + a.getPic());
			try {
				d = dateFormat.parse(a.getTime());
				calendar.setTime(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			years.add(calendar.get(Calendar.YEAR));
		}
		Iterator<Integer> iterator = years.iterator();
		while (iterator.hasNext()) {
			String year = iterator.next().toString();
			List<News> Newslist = new ArrayList<News>();
			for (int i = 0; i < allNews.size(); i++) {
				News a = allNews.get(i);
				try {
					d = dateFormat.parse(a.getTime());
					calendar.setTime(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (StringUtils.equals(year,
						String.valueOf(calendar.get(Calendar.YEAR)))) {
					Newslist.add(a);
				}

			}
			treeMap.put(Integer.parseInt(year), Newslist);
		}

		Iterator<Entry<Integer, List<News>>> iterator2 = treeMap.entrySet()
				.iterator();
		while (iterator2.hasNext()) {
			Entry<Integer, List<News>> entry = iterator2.next();
			Object key = entry.getKey();
			List<News> val = (List<News>) entry.getValue();
			/*
			 * System.out.println("--------------------------------");
			 * System.out.println(key); for (int i = 0; i < val.size(); i++) {
			 * System.out.println(val.get(i).toString()); }
			 * System.out.println("--------------------------------");
			 */
		}
		return treeMap;
	}

	public List<News> getAllNews() {
		allNews = newsDao.getAllNews();
		for (int i = 0; i < allNews.size(); i++) {
			News a = allNews.get(i);
			a.setPic1(Constants.WEBFILE_URL + a.getPic());
		}
		return allNews;
	}

	public List<News> get10News() {
		List<News> get10News = newsDao.get10News();
		for (int i = 0; i < get10News.size(); i++) {
			News a = get10News.get(i);
			//if(a.getPic().trim()!=null && a.getPic().trim()!="")
			a.setPic1(Constants.WEBFILE_URL + a.getPic());
		}
		return get10News;
	}

}
