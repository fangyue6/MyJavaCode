import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		String inString=scanner.nextLine();
		int number=Integer.parseInt(inString);
		if(number<=2){
			System.out.println(1);
		}else{
			int[] f=new int[number+1];
			f[1]=f[2]=1;
			for(int i =3;i<=number;i++){
				f[i]=f[i-1]+f[i-2];
				if(f[i]>=10007){
					f[i]%=10007;
				}
			}
			System.out.println(f[number]);
		}
		
	}
}
