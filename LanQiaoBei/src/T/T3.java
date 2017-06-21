package T;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class T3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String inString=scanner.nextLine();
		int number=Integer.parseInt(inString);
		
		//System.out.println(Integer.MAX_VALUE);
		int temp=Integer.MAX_VALUE;
		BigInteger bi_s=new BigInteger("0");
		int s=0;
		for(int i =1;i<=number;i++){
			/*if(s<temp/2+i){
				s+=i;
			}else{*/
				//bi_s=new BigInteger(String.valueOf(s));
				bi_s=bi_s.add(new BigInteger(String.valueOf(i)));
				//System.out.println(bi_s.toString()+"----");
			//}
		}
		
		System.out.println(bi_s.toString());
	}

}


