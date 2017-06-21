package T;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String inString=scanner.nextLine();
		int number=Integer.parseInt(inString);
		double are=Math.PI*number*number;
		DecimalFormat df=new DecimalFormat("0.0000000");
		Double double1=new Double(are);
		System.out.println(df.format(double1));
	}

}
