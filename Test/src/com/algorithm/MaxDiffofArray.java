package com.algorithm;

import java.util.Scanner;

public class MaxDiffofArray {  
	   
    /** 
     * @paramargs 
     */  
    public static void main(String[] args) {  
             Scanner in = new Scanner(System.in);
             int n=Integer.parseInt(in.nextLine());
             String s = in.nextLine();
             String[] ss=s.split(" ");
             int[] array = new int[n];
             for(int i=0;i<n;i++){
            	 array[i] = Integer.parseInt(ss[i]);
             }
              //int[] array={100,103,98,105};  
              System.out.println(getMaxDiff(array));  

    }  
    public static int getMaxDiff(int[] array) {  
              int length=array.length;  
              if (length==1) {  
                       return-999;  
              }  
              if (length==2) {  
                       return array[2]-array[1];  
              }  
              int max=array[0];  
              int maxDiff=max-array[1];  
              for (int i = 2; i < length; i++) {  
                       if (array[1]>max) {  
                                max=array[i-1];  
                       }  
                       int currentDif=max-array[i];  
                       if (currentDif>maxDiff) {  
                                maxDiff=currentDif;  
                       }  
              }  
              return maxDiff;  
    }  
}  