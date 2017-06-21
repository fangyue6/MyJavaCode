package com.algorithm;

import java.util.Arrays;  

public class MinDifference {  
  
    /** 
     * 题目：求数组中两两元素之差绝对值最小值 
solution 1.sort the data array.Find the min difference between two adjacent element. 
solution 2. 
设这个整数数组是a1,a2,...,an 
构造数组B=(b1,b2,...,bn-1)  
b1 = a1-a2,  
b2 = a2-a3,  
b3 = a3-a4,  
...  
bn-1 = an-1 - an  
 
那么原数组中，任意两整数之差ai-aj（1 <=i,j <=n）可以表示成  
B中第i个到第j-1个元素的连续求和  
 
例如b2+b3+b4 = (a2-a3) + (a3-a4) + (a4-a5) = a2-a5  
 
O(n)构造出B序列后  
 
用类似“最大子段和”算法求“最小绝对值子段和” 
 
但是，如何求得“最小绝对值子段和”？我没有想出来。。。 
     */  
    public static void main(String[] args) {  
  
        int[] data={100,98,103,105};  
        int min=minDifference(data);  
        System.out.println(min);  
    }  
  
    public static int minDifference(int[] data){  
        if(data==null||data.length==0){  
            return Integer.MIN_VALUE;  
        }  
        sort(data,0,data.length-1);  
        int len=data.length;  
        int[] diff=new int[len-1];  
        for(int i=0;i<len-1;i++){  
            diff[i]=data[i+1]-data[i];  
        }  
        //System.out.println(Arrays.toString(diff));  
        return min(diff);  
    }  
    public static int min(int[] diff){  
        if(diff==null||diff.length==0){  
            return Integer.MIN_VALUE;  
        }  
        int min=diff[0];  
        for(int i=0,len=diff.length;i<len;i++){  
            //not necessary,since 'int[] data' is sorted,so 'int[] diff' is progressively increased.  
            //int tmp=diff[i]>0?diff[i]:(-diff[i]);  
            if(min>diff[i]){  
                min=diff[i];  
            }  
        }  
        return min;  
    }  
      
    //QuickSort.Of course we can use Arrays.sort(),but I write it for practice.  
    public static void sort(int[] x,int s,int e){  
        if(s>=e){  
            return;  
        }  
        int i=s;  
        int j=e;  
        boolean flag=false;  
        while(i!=j){  
            if(x[i]>x[j]){  
                swap(x,i,j);  
                flag=!flag;  
            }  
            if(flag){  
                i++;  
            }else{  
                j--;  
            }  
        }  
        sort(x,s,i-1);  
        sort(x,j+1,e);  
    }  
      
    public static void swap(int[] x,int i,int j){  
        int tmp=x[i];  
        x[i]=x[j];  
        x[j]=tmp;  
    }  
}  