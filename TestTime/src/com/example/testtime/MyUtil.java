package com.example.testtime;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyUtil {
	public MyUtil() {

	}

	/**
	 * 
	 * @param time
	 *            时间戳 毫秒机级
	 * 
	 * 
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss
	 * @return yyyy-MM-dd HH:mm:ss 格式的时间
	 */
	public static String getTime(long time, String format) {
		// time*=1000;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(time);
		// System.out.println(date);
		return date;
	}

	/**
	 * 
	 * @param user_time
	 *            时间
	 * 
	 * @param format
	 *            yyyy-MM-dd HH:mm:ss
	 * @return 转换为时间戳 毫秒级
	 */
	public static Long getLong(String user_time, String format) {
		String re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date d;
		try {
			d = sdf.parse(user_time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = str.substring(0, 10);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Long.parseLong(re_time) * 1000;
	}

	public static String getNetTime(String timeurl) {
		URL url;
		String str = null;
		try {
			//timeurl = "http://www.bjtime.cn";
			//timeurl = "http://www.baidu.com";
			url = new URL(timeurl);
			// 取得资源对象
			URLConnection uc = url.openConnection();// 生成连接对象
			uc.connect(); // 发出连接
			long ld = uc.getDate(); // 取得网站日期时间
			Date date = new Date(ld); // 转换为标准时间对象
			// 分别取得时间中的小时，分钟和秒，并输出
			/*
			 * System.out.print(date.getHours() + "时" + date.getMinutes() + "分"
			 * + date.getSeconds() + "秒\n");
			 */
			Calendar ca = Calendar.getInstance();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			str = df.format(date);// 签到时间
			// System.out.println(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public static void main(String[] args) {// 1426108203 1426089600
											// 1427817600000
		Long l = getLong("2015-04-01 13:00:00", "yyyy-MM-dd HH:mm:ss");
		System.out
				.println(getLong("2015-04-01 12:00:00", "yyyy-MM-dd HH:mm:ss"));
		System.out.println(getTime(l, "yyyy-MM-dd HH:mm:ss"));
	}
}
