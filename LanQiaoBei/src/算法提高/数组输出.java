package 算法提高;

import java.util.Scanner;

public class 数组输出 {
	public static void chazhao(int[][] arr,int result){
		boolean flag =false;
		for(int i=0;i<arr.length;i++){
    		for(int j=0;j<arr[i].length;j++){
    			if(arr[i][j]==result&&!flag){
    				System.out.print(result+" "+(i+1)+ " "+(j+1));
    				flag=true;	
    				break;
    			}
    			
    		}
    		
		}
	}
	
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int[][] arr = new int[3][4];
    	int[] temp = new int[12];
    	int length=0;
    	int tempMax = 0;
    	for(int i=0;i<arr.length;i++){
    		for(int j=0;j<arr[i].length;j++){
    			 arr[i][j] = sc.nextInt();
    			 if(arr[i][j]<0){
    				 arr[i][j]=arr[i][j]*(-1);
    			 }
    		     temp[length++]=arr[i][j];
    		     if(arr[i][j]>tempMax){
    		    	 tempMax = arr[i][j];
    		     }
    		}
        }
    	chazhao(arr,tempMax);
    }
}
