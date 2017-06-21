package com.yue.test;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

public class MapReduceTest {
	public void MapReduce() throws Exception{  
        Mongo mongo = new Mongo("localhost",27017);  
        DB db = mongo.getDB("qimiguangdb");  
        DBCollection coll = db.getCollection("collection1");  
         
        String map = "function() { emit(this.name, {count:1});}";  
                                                                                                                
     
        String reduce = "function(key, values) {";    
        reduce=reduce+"var total = 0;";    
        reduce=reduce+"for(var i=0;i<values.length;i++){total += values[i].count;}";    
        reduce=reduce+"return {count:total};}";    
            
        String result = "resultCollection";    
            
        MapReduceOutput mapReduceOutput = coll.mapReduce(map,    
                reduce.toString(), result, null);    
        DBCollection resultColl = mapReduceOutput.getOutputCollection();    
        DBCursor cursor= resultColl.find();    
        while (cursor.hasNext()) {    
            System.out.println(cursor.next());    
        }    
    }    
}
