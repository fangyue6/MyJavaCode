package MyUDF;
import com.aliyun.odps.udf.UDF;

public class ThmlUDF extends UDF {

	public String evaluate(String str) {
		//str += "<div><p>不是吧</p><p>d2</p><p>d3</p><p>呃呃佛挡杀佛</p><p>d5</p>a</div>";
		StringBuffer sb =new StringBuffer(str);
		/*try{
			while (sb.indexOf("<") > -1 && sb.indexOf(">") > -1) {
				int d = sb.indexOf("<");
				int dd = sb.indexOf(">");
				String s1="";
				
				if (d == 0) {
					s1 = sb.substring(dd + 1);
				} else {
					s1 = sb.substring(0, d) + sb.substring(dd + 1);
				}
				sb =new StringBuffer(s1);
			}
		}catch(Exception e){
			return "";
		}*/
		System.out.println(sb.toString());
		return sb.toString();
	}

}
