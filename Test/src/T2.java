
public class T2 {

	public static void main(String[] args) {
		
		String md5 = "fd96eeb0c09c75a79e2bb517dc780f2d";
		for(int i =0;i<md5.length();i++){
			System.out.println(Integer.toBinaryString((int)md5.charAt(i)));
		}

	}

}
