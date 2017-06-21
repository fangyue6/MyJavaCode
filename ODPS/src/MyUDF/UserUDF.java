package MyUDF;
import com.aliyun.odps.udf.UDF;


public class UserUDF extends UDF {

	/**
     * project: example_project 
     * table: wc_in1 
     * columns: col1,col2
     * 
     */
    public String evaluate(String a, String b) {
      return "ss2s:" + a + "," + b;
    }

}
