package com.yue.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.yue.utils.WriteFile;

public class FindData {
	private static String host = "localhost";
	private static int port = 8081;

	@Test
	public void test1() throws Exception {
		// find_Item_id_By_Coll_id("D:\\新建文件夹\\天池\\test\\test_items.txt");
	}

	public void find_Item_id_By_Coll_id(String fileName) throws Exception {
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection = db.getCollection("item_coll");
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// System.out.println(tempString);
				BasicDBObject bd = new BasicDBObject();
				bd.put("item_id", tempString);
				// System.out.println(collectio);
				/*
				 * DBCursor find = collection.find(bd); while (find.hasNext()) {
				 * System.out.println(find.next()); }
				 */
				System.out.println(collection
						.find(new BasicDBObject("item_id", tempString))
						.toArray().size());
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

	@Test
	public void test2() throws Exception {
		// find_ItemID_By_termsID();
	}

	public void find_ItemID_By_termsID() throws Exception {
		String filename = "D:\\新建文件夹\\天池\\log\\find_ItemID_By_termsID.log";
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection1 = db.getCollection("terms_item");
		DBCollection collection2 = db.getCollection("testitems");

		DBCursor cursor2 = collection2.find();

		while (cursor2.hasNext()) {

			System.out.println("------------------------------");
			// WriteFile.writeToTxt(filename,
			// "------------------------------",1);

			String item_id = cursor2.next().get("item_id").toString();
			if (null == item_id || "" == item_id) {
				continue;
			}
			DBCursor cursor1 = collection1.find(new BasicDBObject("item_id",
					item_id));

			System.out.print(item_id + "::");
			WriteFile.writeToTxt(filename, item_id + "::", 0);
			while (cursor1.hasNext()) {
				String terms_id = cursor1.next().get("terms_id").toString();

				System.err.print(terms_id + ",");
				WriteFile.writeToTxt(filename, terms_id + ",", 0);
			}

			cursor1.close();
			WriteFile.writeToTxt(filename, "", 1);
			// WriteFile.writeToTxt(filename,
			// "------------------------------",1);
			System.out.println();
			System.out.println("------------------------------\n");
		}
		cursor2.close();

		mongo.close();
		System.out.println("over");
		// WriteFile.writeToTxt(filename, "over",1);
	}

	@Test
	public void test3() throws Exception {
		create_dim_items_finalData();
	}

	/**
	 * 查询所有itemId2termsId（大循环），分割terms_id,记录item_id（记作A），
	 * 再在terms_item表中取item_id(记作B)， A B1,B2...Bn为最终结果
	 * 
	 * @throws Exception
	 */
	public void create_dim_items_finalData() throws Exception {
		String filename = "D:\\新建文件夹\\天池\\log\\result_find_ItemID_By_termsID.log";
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection1 = db.getCollection("terms_item");
		DBCollection collection2 = db.getCollection("itemId2termsId");

		// DBCollection collection_result = db.getCollection("itemId2termsId");

		DBCursor cursor2 = collection2.find();
		int count = cursor2.count();
		int j = 0;

		while (cursor2.hasNext()) {
			j++;
			// System.out.println("------------------------------");
			// WriteFile.writeToTxt(filename,
			// "------------------------------",1);

			DBObject o = cursor2.next();
			String termsid = o.get("terms_ids").toString();
			String item_id = o.get("item_id").toString();

			String[] termsids = termsid.split(",");// terms_id数组

			StringBuffer item_id_each = new StringBuffer();
			Set item_id_set = new HashSet<String>();
			// 分割terms_id
			for (int i = 0; i < termsids.length; i++) {
				DBCursor cursor1 = collection1.find(new BasicDBObject(
						"terms_id", termsids[i]));
				// System.out.println("条目="+cursor1.count());
				// System.out.println("条目="+cursor1.count());
				while (cursor1.hasNext()) {
					DBObject dbo = cursor1.next();
					// System.out.println(dbo.toString());
					String ii = dbo.get("item_id").toString();
					item_id_set.add(ii);

				}
				cursor1.close();
				for (Iterator<String> iterator = item_id_set.iterator(); iterator
						.hasNext();) {
					item_id_each.append(iterator.next());
				}
				WriteFile.writeToTxt(filename,
						item_id + "::" + item_id_each.toString(), 1);
			}

			System.out.println("(" + j + "/" + count + "):");
			// WriteFile.writeToTxt(filename, item_id+"::"+item_id_each, 1);
		}
		cursor2.close();

		mongo.close();
		System.out.println("over");
		// WriteFile.writeToTxt(filename, "over",1);
	}

	@Test
	public void test_find_item_coll() throws Exception {
		String filename="D:\\新建文件夹\\天池\\log\\result_find_item_coll.log";
		Mongo mongo = new Mongo(host, port);

		DB db = mongo.getDB("tianchi");

		DBCollection collection1 = db.getCollection("terms_item");
		DBCollection collection11 = db.getCollection("terms_item");
		
		DBCollection collection2 = db.getCollection("testitems");
		
		//DBCollection collection_result = db.getCollection("itemId2termsId");

		DBCursor cursor2 = collection2.find();
		int count=cursor2.count();
		int j=0;

		//1.遍历testitems的item_id
		while (cursor2.hasNext()) {
			j++;
			DBObject  o=cursor2.next();
			String item_id = o.get("item_id").toString();
		DBCursor cursor1 = collection1.find(new BasicDBObject("item_id",item_id));
		if(cursor1.count()!=0){
			System.err.print("("+j+"/"+count+"):");
			System.out.println("item_id="+item_id+"-->"+cursor1.count()+"个");
		continue;
		}
		StringBuffer sb = new StringBuffer();
		Set item_id_set = new HashSet<String>();
			
		//2.在item_coll中通过item_id找到coll_id
				while(cursor1.hasNext()){
					DBObject dbo=cursor1.next();
					
					String coll_id=dbo.get("terms_id").toString();
					
					DBCursor cursor11 =collection11.find(new BasicDBObject("terms_id",coll_id));
					
					System.err.println("   terms_id="+coll_id+"-->"+cursor11.count()+"个");
					//3.在item_coll中通过coll_id找到item_id，输出结果
					while(cursor11.hasNext()){
						DBObject dbo11=cursor11.next();
						String item_result=dbo11.get("item_id").toString();
						item_id_set.add(item_result+",");
					}
					cursor11.close();
					for (Iterator<String> iterator = item_id_set.iterator(); iterator
							.hasNext();) {
						sb.append(iterator.next());
					}
					//WriteFile.writeToTxt(filename, item_id+" "+sb.toString(), 1);
				}
				cursor1.close();
				 //System.err.println(item_id+" "+sb.toString());
				
				if(j%500==0){
					System.out.println("("+j+"/"+count+"):");
				}
			
			//WriteFile.writeToTxt(filename, item_id+"::"+item_id_each, 1);
		}
		cursor2.close();

		mongo.close();
		System.out.println("over");
		//WriteFile.writeToTxt(filename, "over",1);
	}
}
