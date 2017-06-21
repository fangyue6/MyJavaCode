package 算法提高;

import org.junit.Test;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=0;
		for(int i =3;i<1000;i++){
			if(i%3==0 || i%5==0){
				s+=i;
			}
		}
		System.out.println(s);
	}
	@Test
	public void t1(){
		
	}
}
