package 算法提高;

import java.util.Scanner;

public class 栅格打印问题 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		int n  = Integer.parseInt(line.split(" ")[0]);
		int m  = Integer.parseInt(line.split(" ")[1]);
		if(n<=0 || m<=0)
			return;
		System.out.print("+");
		for(int i=0;i<m;i++){
			System.out.print("-+");
		}
		System.out.println();
		
		for(int j=0;j<n;j++){
			
			System.out.print("|");
			for(int i=0;i<m;i++){
				System.out.print(" |");
			}
			System.out.println();
			
			System.out.print("+");
			for(int i=0;i<m;i++){
				System.out.print("-+");
			}
			System.out.println();
		}
		

	}

}
