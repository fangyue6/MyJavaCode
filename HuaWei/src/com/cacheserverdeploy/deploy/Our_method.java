package com.cacheserverdeploy.deploy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Our_method {
	static GrfAllEdge grf;
	String [] out_put ;
	

	public String[] getOut_put() {
		return out_put;
	}

	public void setOut_put(String[] out_put) {
		this.out_put = out_put;
	}

	public Our_method(String[] graphContent){
		//long time1 = System.currentTimeMillis();
		String line1[] = graphContent[0].split(" ");
        int network_num = Integer.parseInt(line1[0]);
        int link_num = Integer.parseInt(line1[1]);
        //int consume_num = Integer.parseInt(line1[2]);
        //int server_cost = Integer.parseInt(graphContent[2]);
        
        List<int[]> result_lists = new ArrayList<int[]>();
        
        int [][]matrix1 =new int[network_num][network_num];//存储网络节点是否有连接
        
        int [][]matrix3 =new int[network_num][network_num];//存储带宽
        int [][]matrix2 =new int[network_num][network_num];//存储租用费
        
        String [] network_vertex= new String[network_num];
        for(int i=0;i<network_num;i++){
        	network_vertex[i] = i+"";
        }
        
        int [][] consume_matrix = new int[graphContent.length-link_num-5][3];
        
        //init_matrix(matrix1);
        init_matrix(matrix2);
        init_matrix(consume_matrix);
        
        for(int i = 0; i<link_num;i++){
        	String[] temp = graphContent[i+4].split(" ");
        	
        	matrix1[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = 1;//Integer.parseInt(temp[2]);
        	matrix1[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;//Integer.parseInt(temp[2]);
        	matrix3[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[2]);
        	matrix3[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = Integer.parseInt(temp[2]);
        	
        	matrix2[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])] = Integer.parseInt(temp[3]);
        	matrix2[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = Integer.parseInt(temp[3]);
        }
        
        int[] consum_data = new int[graphContent.length-link_num-4];
        for(int i=0;i<graphContent.length-link_num-5;i++){
        	String[] temp = graphContent[i+link_num+5].split(" ");
        	consume_matrix[i][0] = Integer.parseInt(temp[1]);//相连网络节点id
        	consume_matrix[i][1] = Integer.parseInt(temp[2]);//带宽需求
        	consum_data[i] = Integer.parseInt(temp[1]);
        	consume_matrix[i][2] = 0;//剩余的 
        }
        
       
       int network_id1 = 0;
       //get_cheap_id(matrix3,matrix2,1);
       //int network_id2 = get_cheap_id(matrix3,matrix2,2);
       
       int toplink[] = get_mostlink_id(matrix3);//网络节点链路条数排名
       //根据消费节点相连接的网络节点，找出连接数量最多的
       int con_data = get_most_link_by_consume_data(matrix2,consume_matrix);
       //System.out.println(con_data);
       
       List<int[]> result_list1 = new ArrayList<int[]>();//所有路径
       List<Integer> start_list  =new ArrayList<Integer>();
       for(int i=0;i<3;i++){//取前三个链路条数最多的网络节点作为初始节点
    	   network_id1 = toplink[i];
    	   //System.out.println(network_id1);
    	   start_list.add(network_id1);
    	   
    	   
    	   //查找节点network_id1 到节点 con_data之间的所有路径
    	   result_list1 = test01(network_vertex,matrix1,consum_data,network_id1,con_data);
           result_lists = addList(result_lists,result_list1);//更新所有路径
           consum_data = grf.get_consume_data();
       }
       
       
       
       
       result_lists = get_result_list(consum_data,matrix3,result_lists);
       
     
       
       HashSet<Stack> result_Stacks = new HashSet<Stack>();
       List<Integer> result_cost = new ArrayList<Integer>();
       List<Store> store_list = new ArrayList<Store>();
       //筛选路径
       for(int i=0;i<consume_matrix.length;i++){
    	   
    	   for(int j=0;j<result_lists.size();j++){
    		   int[] one_route = result_lists.get(j);
    		   for(int jj=0;jj<one_route.length;jj++){
    			   if(one_route[jj] == consume_matrix[i][0]){
    				   
    				 //如果这条路径包含相连网络节点id
    				   //分为前面一段 和 后面一段
    				   //前一部分
    				   Stack<Integer> st1 = new Stack<Integer>();
    				   //System.out.println("("+consume_matrix[i][0]+")");
    				   int count1 = 0;
    				   int w1 = 99999;
    				   int w11 = 0;
    				   for(int k1=jj-1;k1>=0;k1--){
    					   
    					   if(matrix3[one_route[k1]][one_route[k1+1]]<w1){
                        	   w1 = matrix3[one_route[k1]][one_route[k1+1]];
                           }
    					   st1.add(one_route[k1]);
    					   if(start_list.contains(one_route[k1])){
    						   //如果 one_route包含start_list其中一个，则用这个
    						   w11=w1;
    						  break;
    					   }
    					   
                           
                           
    					   if(count1==0){
    						   w11 = matrix3[one_route[k1]][one_route[k1+1]];
    						   //consume_matrix[i][1] -= w11; 
    					   }
    					   if(matrix3[one_route[k1]][one_route[k1+1]] < w11){
    						   st1.pop();
    						   break;
    					   }
    					   count1++;	  
    				   } 
    				   //System.out.println();
    				   if(st1.size()>0){
    					   st1.add(consume_matrix[i][0]);
    					   if(result_Stacks.contains(st1)){
    						   //consume_matrix[i][1] += w1; 
    						   continue;
    					   }
    					   int cost1 = get_cost(st1,w11,matrix2);
    					   result_Stacks.add(st1);
    					   result_cost.add(cost1);
    					   
    					   
    					   Store s1 =new Store();
    					   s1.setConsume_id(consume_matrix[i][0]);
    					   s1.setConsume_cost(cost1);
    					   s1.setSt(st1);
    					   s1.setW(w11);
    					   store_list.add(s1);
    				   }
    				   
    				   //后一部分
    				   Stack<Integer> st2 = new Stack<Integer>();
    				   int count2 = 0;
    				   int w2 = 9999;
    				   int w22 = 0;
    				   for(int k2=jj+1;k2<one_route.length-1;k2++){
    					   if(matrix3[one_route[k2]][one_route[k2+1]] < w2){
                        	   w2 = matrix3[one_route[k2]][one_route[k2+1]];
                           }
    					   
    					   st2.add(one_route[k2]);
    					   if(start_list.contains(one_route[k2])){
    						 //如果 one_route包含start_list其中一个，则用这个
    						   w22=w2;
    						  break;
    					   }
    					   
    					   
    					   
    					   /*if(consume_matrix[i][1]<=0)
    						   break;*/
    					   if(count2==0){
    						   w22 = matrix3[one_route[k2]][one_route[k2+1]];
    						   //consume_matrix[i][1] -= w22; 
    					   }
    					   if(matrix3[one_route[k2]][one_route[k2+1]] < w22){
    						   st2.pop();
    						   break;
    					   }
    					   count2++;   
    				   }
    				   if(st2.size()>0){
    					   st2.add(consume_matrix[i][0]);
    					   if(result_Stacks.contains(st2)){//去掉重复的
    						   //consume_matrix[i][1] += w2; 
    						   continue;
    					   }
    					   int cost2 = get_cost(st2,w22,matrix2);
    					   result_Stacks.add(st2);
    					   result_cost.add(cost2);
    					   
    					   Store s2 =new Store();
    					   s2.setConsume_id(consume_matrix[i][0]);
    					   s2.setConsume_cost(cost2);
    					   s2.setSt(st2);
    					   s2.setW(w22);
    					   store_list.add(s2);
    				   }
    			   }
    		   }
    	   }
    	   
       }
       
       //System.out.println(result_Stacks.size());
       
       for(int j=0;j<consume_matrix.length;j++){
    	   List<Store> list_temp = new ArrayList<Store>();
    	   
    	   for(int i=0;i<store_list.size();i++){
        	   Store s1 = store_list.get(i);
        	   if(s1.consume_id == consume_matrix[j][0] ){
        		   list_temp.add(s1);
        	   }
           }
    	   Collections.sort(list_temp,new Comparator<Store>() {
			@Override
			public int compare(Store s1, Store s2) {
				return s1.getConsume_cost()-s2.getConsume_cost();
			}  
		});
    	   int sum_w = 0;
    	   int loc_w = -1;
    	  // System.out.println("消费节点："+consume_matrix[j][0]);
    	   HashSet< Integer> temp_hs = new HashSet<Integer>();
    	   for(int ii=0;ii<list_temp.size();ii++){
    		   Stack<Integer> temp_stack = list_temp.get(ii).getSt();
    		   if(temp_stack.size()>=2){
    			   if(temp_hs.contains(temp_stack.get(0))){
    				   continue;
    			   }else{
    				   temp_hs.add(temp_stack.get(0));
    			   }
    		   }else{
    			   continue;
    		   }

    		  list_temp.get(ii).setFlag(1);
    		  sum_w += list_temp.get(ii).getW();
    		  if(sum_w > consume_matrix[j][1]){
    			  loc_w = ii ;
    			  Store temp1 = list_temp.get(loc_w);
    			  sum_w -= temp1.getW();
    			  if(sum_w!=consume_matrix[j][1]){
    				  temp1.setW(consume_matrix[j][1]-sum_w);
    				  temp1.setConsume_cost(get_cost(temp1.getSt(),temp1.getW(),matrix2));
    			  }
    			  break;
    		  }
    		  if(loc_w==-1){
    			  consume_matrix[j][2] = consume_matrix[j][1] - sum_w;
    		  }
    	   }
	   }
      
    	   
       
       // 输出结果   
       List<String[]> result_str_list = new ArrayList<String[]>();
       for(int j=0;j<consume_matrix.length;j++){
    	   List<Store> list_temp = new ArrayList<Store>();
    	   
    	   for(int i=0;i<store_list.size();i++){
        	   Store s1 = store_list.get(i);
        	   if(s1.consume_id == consume_matrix[j][0]  && s1.getFlag()==1){
        		   list_temp.add(s1);
        	   }
           }
    	   Collections.sort(list_temp,new Comparator<Store>() {
			@Override
			public int compare(Store s1, Store s2) {
				return s1.getConsume_cost()-s2.getConsume_cost();
			}  
		});
    	   //System.out.println("消费节点："+consume_matrix[j][0]);
    	   HashSet< Integer> temp_hs = new HashSet<Integer>();
    	   int temp =0;
    	   for(int ii=0;ii<list_temp.size();ii++){
    		   Stack<Integer> temp_stack = list_temp.get(ii).getSt();
    		   if(temp_stack.size()>=2){
    			   if(temp_hs.contains(temp_stack.get(0))){
    				   continue;
    			   }else{
    				   temp_hs.add(temp_stack.get(0));
    			   }
    		   }else{
    			   continue;
    		   }
    		   
    		   String [] str1 = new String[temp_stack.size() + 1];
    		   int stri=0;
    		   for(int outi=temp_stack.size()-2;outi>=0;outi--){
    			   str1[stri] = temp_stack.get(outi)+"";
    			   stri++;
    			   //System.out.print(temp_stack.get(outi)+" ");
    		   }
    		   str1[stri] = search_matrix(consume_matrix,temp_stack.get(temp_stack.size()-1),1)+"";
    		   stri++;
    		   //System.out.print(temp_stack.get(temp_stack.size()-1)+" ");
    		   //temp+=list_temp.get(ii).getW();
    		   str1[stri] = list_temp.get(ii).getW()+"";
    		   result_str_list.add(str1);
    		   /*System.out.print("总消费："+list_temp.get(ii).getConsume_cost()+"  路径带宽：" + 
      	    		   list_temp.get(ii).getW()+" 总带宽分配："+temp+"/"+consume_matrix[j][1]);
    		   System.out.println();*/
    	   }
    	   //System.out.println("------------------------------------");
       }
       int result_line_num = result_str_list.size();
       String [] out_put = new String [result_line_num+2];
       out_put[0] = result_line_num +"";
       out_put[1] = "\r\n";//
       for(int i =0 ;i<result_line_num;i++){
    	   out_put[i+2] = "";
    	   String [] str_temp = result_str_list.get(i);
    	   for(int j=0 ;j<str_temp.length;j++){
    		   out_put[i+2] += str_temp[j] +" ";
    	   }
    	   out_put[i+2] = out_put[i+2].trim();
       }
       
        
       setOut_put(out_put);
       
        //long time2 = System.currentTimeMillis();
        //System.out.println("一共耗费："+(time2-time1)+" ms");
	}
	
//-----------------------------------------------------------------------------------    
    
    public static void init_matrix(int matrix [][]){
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[i].length;j++){
    			matrix[i][j]=0;
    		}
    	}
    }
    public static void print_matrix(int matrix [][]){
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[i].length;j++){
    			System.out.print(matrix[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
    public static int search_matrix(int matrix [][], int network_id, int which){//which=1 返回消费节点ID，which=2返回带宽需求
    	for(int i=0;i<matrix.length;i++){
    		if(matrix[i][0] == network_id){
    			if(which==1)
    				return i;
    			if(which==2)
    				return matrix[i][2];
    		}
    	}
    	return -1;
    }
    
    public  static int get_cheap_id(int[][] matrix1,int[][]matrix2, int which ){
    	//which=1 带宽最大  which=2链路条数最多
    	int sum=-1;
    	int sum1=0;
    	int tempi=-1;
    	for(int i=0;i<matrix1.length;i++){
    		sum1 = 0;
    		for(int j=0;j<matrix1.length;j++){
    			if(matrix1[i][j]!=0){
    				if(which==1)
    					sum1 += matrix1[i][j];//*matrix2[i][j];
    				if(which==2)
    					sum1 += 1;
    				
    				//System.out.println(matrix1[i][j]+" "+matrix2[i][j]);
    			}
    		}
    		//System.out.println(sum1);
    			if(sum<sum1 && sum1!=0){
    				sum = sum1;
    				tempi = i;
    			}
    		
    	}
    	return tempi;
    }
    public  static int[] get_mostlink_id(int[][] matrix1){
    	//链路条数排名
    	int sum1=0;

    	int [] link =new int[matrix1.length];
    	int [] link1 =new int[matrix1.length];
    	for(int i=0;i<matrix1.length;i++){
    		sum1 = 0;
    		for(int j=0;j<matrix1.length;j++){
    			if(matrix1[i][j]!=0){
    					sum1 += 1;
    			}
    		}
    		link[i] = sum1; 
    		link1[i] = i;
    	}
    	for(int i=0;i<link.length-1;i++){
    		for(int j=i;j<link.length-1;j++){
    			if(link[i]<link[j]){
    				int temp =link[j];
    				link[j] = link[i];
    				link[i] = temp;
    				
    				temp =link1[j];
    				link1[j] = link1[i];
    				link1[i] = temp;
    			}
    		}
    	}
    	return link1;
    }
    
   //根据消费节点相连接的网络节点，找出连接数量最多的
    public static int get_most_link_by_consume_data(int [][]network_matrix,int [][] consume_matrix){
    	
    	int tempdata=0;
    	int sum = 0;
    	int sum1 = 0;
    	for(int i=0;i<consume_matrix.length;i++){
    		sum = 0;
    		int consume_temp = consume_matrix[i][0];//消费节点相连接的网络节点id
    		for(int j=0;j<network_matrix.length;j++){
    			if(network_matrix[j][consume_temp]!=0)
    			    sum++;
    		}
    		if(sum > sum1){
    			sum1 = sum;
    			tempdata=consume_temp;
    		}
    	}
    	return tempdata;
    }

    
    public static List<int[]>  addList(List<int[]>a,List<int[]>b){
    	for(int i=0;i<b.size();i++){
    		a.add(b.get(i));
    	}
    	return a;
    }
    
    public static List<int[]> get_result_list(int[]consum_data, int[][]matrix3, List<int[]> result_lists ){
    	HashMap<Integer, List<Integer>> hm =new HashMap<Integer, List<Integer>>();
        for(int i=0;i<consum_data.length-1;i++){
     	   if(consum_data[i] != -1){
     		   List<Integer> lis =new ArrayList<Integer>();
     		   //找跟consum_data[i]相关联的
     		   for(int j=0;j<matrix3[consum_data[i]].length;j++){
     			   if(matrix3[consum_data[i]][j]>0 || matrix3[j][consum_data[i]]>0){
     				   lis.add(j);
     				   //System.out.println(consum_data[i]+" "+matrix3[consum_data[i]][j]);
     			   }
     			   /*if(matrix3[j][consum_data[i]]>0){
     				   lis.add(j);
     				   //System.out.println(j+"-"+consum_data[i]);
     			   }*/
     		   }
     		   hm.put(i, lis);
     	   }
        }
        List<int[]> result_temp = new ArrayList<int[]>();
        Set<Map.Entry<Integer, List<Integer>>> set = hm.entrySet();
        
        for(int i=0;i<result_lists.size();i++){
     	   int [] temp = result_lists.get(i);
     	   for (Iterator<Map.Entry<Integer, List<Integer>>> iter = set.iterator(); iter.hasNext();) {
     		   Map.Entry<Integer, List<Integer>> en = iter.next();  
     		   List<Integer> lIn= (List<Integer>) en.getValue();
     		   
                for(int tj=0;tj<temp.length;tj++){
     			   if(lIn.contains(temp[tj])){
     				   int[]temp1=new int[tj+2];
     				   for(int jj=0;jj<= tj;jj++){
     					   temp1[jj] = temp[jj];
     				   }
     				   if(consum_data[en.getKey()] !=-1){
     					  temp1[tj+1] = consum_data[en.getKey()];
        				   result_temp.add(temp1);
        				   consum_data[en.getKey()] = -1;
     				   }
     				   
     			   }	  
     		   }
            }
        }
        result_lists = addList(result_lists, result_temp);
        return result_lists;
    }
    
    public static int get_cost(Stack<Integer> st,int daikuan ,int [][]matrix2){
    	//daikuan 带宽   matrix2单位租用费。
    	int sum = 0;
    	if(st.size()>0){
    		for(int i=0;i<st.size()-1;i++){
        		sum+= daikuan * matrix2[st.get(i)][st.get(i+1)];
        	}
    	}
    	if(st.size()>2){
    		sum += daikuan * matrix2[st.get(0)][st.get(st.size()-1)];
    	}
    	return sum;
    }
    
    
    public static List<int[]> test01(String[] nodes,int[][] matrix, int[]consume_data,int origin, int goal){
	
    	 grf = new GrfAllEdge(nodes.length, nodes, matrix,consume_data);  
  
        //System.out.println("\n------ 寻找起点到终点的所有路径开始 ------");  
        grf.resetVisited();  
        //int origin = 0;  
        //int goal = 10;  
        Stack<Integer> stack = new Stack<Integer>();  
        stack.push(origin);  
        grf.dfsStack(-1, goal, stack);  
        
        List<int[]> result_list = grf.get_result();
       // System.out.println("个数"+result_list.size());

       /* for(Integer i:grf.get_consume_data()){
        	System.out.print(i+" ");
        }
        System.out.println("\n------ 寻找起点到终点的所有路径结束 ------"); */
        return result_list;
    }
}
