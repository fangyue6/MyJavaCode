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

import com.yue.core.bean.Achievement;
import com.yue.core.dao.AchievementDao;
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
public class AchievementServiceImpl implements AchievementService {

	@Resource
	private AchievementDao achieveDao;
	List<Achievement> allAchieve;

	@Transactional(readOnly = true)
	public Pagination getAchieveListWithPage(Achievement achievement) {
		// 1.起始页 startRow=(pageNo-1)*pageSize
		// 2.每页数
		// 3.总记录数
		Pagination pagination = new Pagination(achievement.getPageNo(),
				achievement.getPageSize(),
				achieveDao.getAchieveCount(achievement));
		// Achievement集合
		List<Achievement> achieveList = achieveDao.getAchieveListWithPage(achievement);
		for(Achievement achi:achieveList){
			achi.setCode1(Constants.WEBFILE_URL+achi.getCode());
			achi.setEssay1(Constants.WEBFILE_URL+achi.getEssay());
		}
		pagination.setList(achieveList);

		return pagination;
	}

	public void addAchieve(Achievement achievement) {

		achieveDao.addAchieve(achievement);

	}

	public void deleteAchieveByKey(Integer id) {
		achieveDao.deleteAchieveByKey(id);

	}

	public void deleteAchieveByKeys(Integer[] ids) {
		achieveDao.deleteAchieveByKeys(ids);

	}

	public void updateAchieveByKey(Achievement achievement) {
		achieveDao.updateAchieveByKey(achievement);

	}

	public Achievement getAchieveByKey(Integer id) {
		Achievement achieve = achieveDao.getAchieveByKey(id);
		achieve.setCode1(Constants.WEBFILE_URL+achieve.getCode());
		achieve.setEssay1(Constants.WEBFILE_URL+achieve.getEssay());
		return achieve;
	}

	public Map<Integer, List<Achievement>> getAllAchieve() {

		 
		HashSet<Integer> years = new HashSet<Integer>();
		Map<Integer, List<Achievement>> treeMap = new TreeMap<Integer, List<Achievement>>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(o1==null || o2==null)
				return 0;
				return o2-o1;
			}
		});

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < allAchieve.size(); i++) {
			Achievement a = allAchieve.get(i);
			a.setEssay1(Constants.WEBFILE_URL+a.getEssay());
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
			List<Achievement> achievelist = new ArrayList<Achievement>();
			for (int i = 0; i < allAchieve.size(); i++) {
				Achievement a = allAchieve.get(i);
				try {
					d = dateFormat.parse(a.getTime());
					calendar.setTime(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (StringUtils.equals(year,
						String.valueOf(calendar.get(Calendar.YEAR)))) {
					achievelist.add(a);
				}

			}
			treeMap.put(Integer.parseInt(year), achievelist);
		}

		Iterator<Entry<Integer, List<Achievement>>> iterator2 = treeMap
				.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<Integer, List<Achievement>> entry = iterator2.next();
			Object key = entry.getKey();
			List<Achievement> val = (List<Achievement>) entry.getValue();
/*			System.out.println("--------------------------------");
			System.out.println(key);
			for (int i = 0; i < val.size(); i++) {
				System.out.println(val.get(i).toString());
			}
			System.out.println("--------------------------------");*/
		}
		return treeMap;
	}

	public List<Achievement> getAll() {
		allAchieve = achieveDao.getAllAchievement();
		return allAchieve;
	}

	public List<Achievement> getAllAchievementByStudentNumber(Achievement achievement) {
		List<Achievement> allAchievement = achieveDao.getAllAchievementByStudentNumber(achievement);
		for(Achievement a:allAchievement){
			a.setCode1(Constants.WEBFILE_URL+a.getCode());
			a.setEssay1(Constants.WEBFILE_URL+a.getEssay());
		}
		return allAchievement;
	}

}
