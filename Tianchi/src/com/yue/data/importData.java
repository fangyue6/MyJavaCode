package com.yue.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.yue.utils.ReadFromFile;

public class importData {
	private static String host="localhost";
	private static int port=8081;
	public void readFileByLines() {
		ReadFromFile
				.readFileByLines("D:\\新建文件夹\\天池\\test\\dim_fashion_matchsets.txt");
	}

	@Test
	public void test1() {
		readFileByLines();
	}

	@Test
	// item_coll
	public void test2() throws Exception {
		 //import_dim_fashion_match_sets("D:\\新建文件夹\\天池\\test\\dim_fashion_matchsets.txt");
	}

	@Test
	// terms_item
	public void test3() throws Exception {
		 //import_dim_items1("D:\\新建文件夹\\天池\\test\\dim_items.txt");
	}

	@Test
	// item_cat
	public void test4() throws Exception {
		 //import_dim_items2("D:\\新建文件夹\\天池\\test\\dim_items.txt");
	}

	@Test
	// item_user
	public void test5() throws Exception {
		//import_user_bought_history("D:\\新建文件夹\\天池\\test\\user_bought_history.txt");
	}

	@Test
	// test_items
	public void test6() throws Exception {
		 //import_test_items("D:\\新建文件夹\\天池\\test\\test_items.txt");
	}
	@Test
	// 读取find_ItemID_By_termsID.log文件 然后向mongodb插入 itemId2termsId
	public void test7() throws Exception {
		String fileName="D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log";
		//import_find_ItemID_By_termsID(fileName);
	}

	// 读取dim_fashion_match_sets.txt文件 然后向mongodb插入 item_coll
	public static void import_dim_fashion_match_sets(String fileName)
			throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("item_coll");

		/*
		 * BasicDBObject o = new BasicDBObject(); o.put("name", "zhangsan");
		 * o.put("age", 20);
		 */

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				String[] strtemp = tempString.split(" ");

				// if(line<100){
				String[] s2 = strtemp[1].split("[;,]");
				for (int i = 0; i < s2.length; i++) {
					BasicDBObject o = new BasicDBObject();
					o.put("item_id", s2[i]);
					o.put("coll_id", strtemp[0]);
					collection.insert(o);
				}
				// }
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			mongo.close();
		}
		System.out.println("over");
	}

	// 读取dim_items.txt文件 然后向mongodb插入 terms_item
	public static void import_dim_items1(String fileName) throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("terms_item");

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				String[] strtemp = tempString.split(" ");

				// if(line<100){
				String[] terms_id = strtemp[2].split("[,]");
				for (int i = 0; i < terms_id.length; i++) {
					BasicDBObject o = new BasicDBObject();
					o.put("item_id", strtemp[0]);
					o.put("terms_id", terms_id[i]);
					collection.insert(o);
				}
				// }
				if (line % 1000 == 0) {
					System.out.println(line);
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			mongo.close();
		}
		System.out.println("over");
	}

	// 读取dim_items.txt文件 然后向mongodb插入 item_cat
	public static void import_dim_items2(String fileName) throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("item_cat");

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				String[] strtemp = tempString.split(" ");

				// if(line<100){
				BasicDBObject o = new BasicDBObject();
				o.put("item_id", strtemp[0]);
				o.put("cat_id", strtemp[1]);
				collection.insert(o);
				// }
				if (line % 10000 == 0) {
					System.out.println(line);
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			mongo.close();
		}
		System.out.println("over");
	}

	// 读取user_bought_history.txt文件 然后向mongodb插入 item_user
	public static void import_user_bought_history(String fileName)
			throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("item_user");

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				String[] strtemp = tempString.split(" ");

				// if(line<100){
				// System.out.println(tempString);
				BasicDBObject o = new BasicDBObject();
				o.put("item_id", strtemp[0]);
				o.put("user_id", strtemp[1]);
				collection.insert(o);
				// }
				if (line % 10000 == 0) {
					System.out.println(line);
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			mongo.close();
		}
		System.out.println("over");
	}

	// 读取test_items.txt文件 然后向mongodb插入 testitems
	public static void import_test_items(String fileName) throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("testitems");

		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				// String[] strtemp = tempString.split(" ");

				// if(line<100){
				// System.out.println(tempString);
				BasicDBObject o = new BasicDBObject();
				o.put("item_id", tempString);
				collection.insert(o);
				// }
				if (line % 10000 == 0) {
					System.out.println(line);
				}
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
			mongo.close();
		}
		System.out.println("over");
	}
	
	// 读取find_ItemID_By_termsID.log文件 然后向mongodb插入 itemId2termsId
	//将生成的文本转化为mongodb
	public static void import_find_ItemID_By_termsID(String fileName) throws Exception {
			Mongo mongo = new Mongo(host, port);

			DB db = mongo.getDB("tianchi");

			DBCollection collection = db.getCollection("itemId2termsId");

			File file = new File(fileName);
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				//int line = 1;
				// 一次读入一行，直到读入null为文件结束
				while ((tempString = reader.readLine()) != null) {
					//System.err.println(tempString);
					String [] strs=tempString.split("::");
					
					BasicDBObject o = new BasicDBObject();
					o.put("item_id", strs[0]);
					o.put("terms_ids", strs[1]);
					collection.insert(o);
					
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
				}
				mongo.close();
			}
			System.out.println("over");
		}
}
