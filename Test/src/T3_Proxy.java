import java.net.URL;

import org.apache.commons.io.IOUtils;


public class T3_Proxy {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.baidu.com");
			
			String s = IOUtils.toString(url);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
