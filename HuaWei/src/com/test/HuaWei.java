package com.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import javax.management.Query;

public class HuaWei {
	static int vertex_nums = 20;
	//最短路径：Dijkstra,dist[j]=min{dist[j],dist[i]+graphy[i][j]}  
	//graphy:G=(V,E),V：顶点集,E:边集  
	//e∈ E&e>0表示顶点邻接，权值为e,e=-1表示两顶点不邻接  
	static int dijkstra(int [][]graph, int start_vertex, int end_vertex, int[]  path, int[]ban_visit)  
	{  
	    int shortpath[] = new int[vertex_nums];//存储起点到各终点的最短路径//初始化，-1代表max_value 
	    for(int i =0;i<vertex_nums;i++){
	    	shortpath[i] = -1;
	    }
	    int visited[] = new int[vertex_nums];//已访问过的顶点  
	    for(int i=0;i<vertex_nums;i++){
	    	visited[i] = 0;
	    }
	    int min;  
	    //初始化起点到自身的最短距离为0  
	    shortpath[start_vertex] = 0;  

	    int num = vertex_nums - 1;  
	    while (num>0)  
	    {  
	        //贪心策略：从访问过的顶点中，找出最短路径，从已知的最短路径开始延伸  
	            //寻找新的中间点k，依据就是数组中权值最小的那个点的位置（且没被访问过）  
	            min = -1;  
	        int k = -1;  
	        for (int i = 0; i<vertex_nums; i++)  
	        {  
	            if (ban_visit[i] != 1 && visited[i] != 1 && shortpath[i] != -1 &&  
	                (min != -1 && shortpath[i]<min || min == -1))  
	            {  
	                min = shortpath[i];  
	                k = i;  
	            }  
	        }  
	        //终点最短路径已找到或所有顶点最短路径都已找到  
	        if (end_vertex == k || min == -1)  
	            break;  
	        //标记访问过的顶点  
	        visited[k] = 1;  
	        num--;  
	        //dist[j]=min{d[j],dist[i]+graphy[i][j]}  
	        //更新未访问过邻接顶点的最短路径  
	        for (int i = 0; i<vertex_nums; i++)  
	        {  
	            if (ban_visit[i] != 1 && visited[i] != 1 && graph[k][i] != -1 &&  
	                (shortpath[i] != -1 && shortpath[i]> min + graph[k][i] ||  
	                shortpath[i] == -1))  
	            {  
	                shortpath[i] = min + graph[k][i];  
	                path[i] = k;//更新记录前驱顶点，供最后回溯最短路径  
	            }  
	        }  
	    }  
	    min = shortpath[end_vertex];  
	    return min;  
	} 
	//广度优先检查图是否连接了所有必经点（包括起点和终点）情况  
	//时间复杂度O(v^2)（且有适当剪枝）,v为顶点个数  
	//连接表的速度是O(v+e)，确实，对于稀疏图而言，邻接表更有优势！  
	static boolean isConnected(int[][]graph, int []specified_node, int  mustsize)  
	{  
	    int start_vertex = specified_node[0];  
	    //set<int>setting(specified_node, specified_node + mustsize);  
	    Stack<Integer> setting = new Stack<Integer>();
	    for(int i=0;i<mustsize;i++){
	    	setting.add(specified_node[i]);
	    }
	    int dfs_visited[] = new int[vertex_nums];//通过dfs_visited数组来标记这个顶点是否被访问过，0表示未被访问，1表示被访问    
	    for(int i=0;i<vertex_nums;i++){
	    	dfs_visited[i] = 0;
	    }
	    Queue<Integer> que = new LinkedList<Integer>();
	        
	        
	    int cnt = mustsize - 1;  
	    //cout<<"顶点"<<start_vertex<<"已经被检查"<<endl;  
	    dfs_visited[start_vertex] = 1;//标记顶点start_vertex被访问  
	    que.add(start_vertex);  
	    boolean linkflag = false;//用于剪枝，判断是否可以停止判断  
	    while (!que.isEmpty() && !linkflag)  
	    {  
	    	
	        int k = que.poll();
	        //cout<<que.size();  
	        for (int j = 0; j<vertex_nums&&!linkflag; j++)  
	        {  
	            if (graph[k][j]>0 && dfs_visited[j] == 0)  
	            {  
	                //cout<<"顶点"<<j<<"已经被检查"<<endl; 
	            	//setting.find(j) != setting.end()
	            	if(setting.indexOf(j)!=-1){
	            		cnt--;  
	            	}
	                /*if (setting.get(j) != setting.lastElement())  
	                    cnt--;*/  
	                if (cnt == 0)//剪枝  
	                    linkflag = true;  
	                dfs_visited[j] = 1;//标记为已经被访问过  
	                que.remove(j);//弹出  
	            }  
	        }  
	    }  
	    return cnt == 0;  
	} 
	
	//时间复杂度O(k*v)（且有适当剪枝）,k为必经点的个数，v为顶点个数  
	static boolean isValidNode(int[][]graph, int[]mustpass, int mustsize)//是否每一节点都是有效的（指的是出入度的合法性）  
	{  
	    boolean flagrow = true, flagcol = true;  
	    int cnt = mustsize - 2;  
	    for (int nsize = 1; nsize<mustsize - 1; nsize++)  
	    {  
	        flagrow = true;
	        flagcol = true;  
	        for (int row = 0; row<vertex_nums&&flagrow; row++)  
	        {  
	            if (graph[mustpass[nsize]][row]>0)//判断顶点mustpass[nsize]所在行中是否有出度  
	                flagrow = false;  
	        }  
	        for (int col = 0; col<vertex_nums&&flagcol; col++)  
	        {  
	            if (graph[col][mustpass[nsize]]>0)//判断顶点mustpass[nsize]所在列中是否有入度  
	                flagcol = false;  
	        }  
	        if (!flagcol&&!flagrow)  
	            cnt--;  
	    }  
	    return cnt == 0;  
	}  
	static void myswap(int[]specified_node, int rand_posa, int rand_posb)  
	{  
	    int tmp = specified_node[rand_posa];  
	    specified_node[rand_posa] = specified_node[rand_posb];  
	    specified_node[rand_posb] = tmp;  
	} 
	static void nextPermutation(int []specified_node, int mustsize){
		Random rd = new Random();
		
		
	    int rand_posa = rd.nextInt() % (mustsize - 2) + 1;  
	    int rand_posb = rd.nextInt() % (mustsize - 2) + 1;  
	    while (rand_posa == rand_posb)  
	    {  
	        rand_posa = rd.nextInt() % (mustsize - 2) + 1;  
	        rand_posb = rd.nextInt() % (mustsize - 2) + 1;  
	    }  
	    myswap(specified_node, rand_posa, rand_posb);  
	} 
	static int _tmain1()  
	{    
	    int[] row = new int[vertex_nums];
	    for(int i=0;i<vertex_nums;i++){
	    	row[i] = -1;
	    }
	    int [][] graph = new int[vertex_nums][vertex_nums];
	    for (int i = 0; i<vertex_nums; i++)  
	        graph[i][i] = 0;  
	    //官方提供的简单图case1  
	    graph[0][13] = 15;  
	    graph[0][8] = 17;  
	    graph[0][19] = 1;  
	    graph[0][4] = 8;  
	    graph[1][0] = 4;  
	    graph[2][9] = 19;  
	    graph[2][15] = 8;  
	    graph[3][0] = 14;  
	    graph[3][11] = 12;  
	    graph[4][1] = 15;  
	    graph[4][5] = 17;  
	    graph[5][8] = 18;  
	    graph[5][9] = 14;  
	    graph[5][6] = 2;  
	    graph[6][17] = 4;  
	    graph[7][13] = 1;  
	    graph[7][16] = 19;  
	    graph[8][6] = 1;  
	    graph[8][12] = 17;  
	    graph[9][14] = 11;  
	    graph[10][12] = 1;  
	    graph[11][7] = 12;  
	    graph[11][4] = 7;  
	    graph[12][14] = 5;  
	    graph[13][17] = 12;  
	    graph[13][4] = 2;  
	    graph[14][19] = 9;  
	    graph[15][10] = 14;  
	    graph[15][18] = 2;  
	    graph[16][8] = 1;  
	    graph[17][9] = 14;  
	    graph[17][19] = 3;  
	    graph[17][18] = 10;  
	    graph[18][15] = 8;  
	    graph[18][3] = 8;  
	    graph[19][18] = 12;  
	    graph[2][3] = 20;  
	    graph[3][5] = 20;  
	    graph[5][7] = 20;  
	    graph[7][11] = 20;  
	    graph[11][13] = 20;  
	    graph[17][11] = 20;  
	    graph[11][19] = 20;  
	    graph[17][5] = 20;  
	    graph[5][19] = 20;  
	    /* 
	    //官方提供的简单图case0 
	    graph[0][1]=1; 
	    graph[0][2]=2; 
	    graph[0][3]=1; 
	    graph[2][1]=3; 
	    graph[2][3]=1; 
	    graph[3][1]=1; 
	    graph[3][2]=1; 
	    */  
	    /* 
	    //自定义简单图 
	    graph[3][0]=1; 
	    graph[0][5]=1; 
	    graph[1][2]=3,graph[2][1]=3; 
	    graph[1][6]=1,graph[6][1]=1; 
	    graph[2][3]=5; 
	    graph[2][4]=1; 
	    graph[3][5]=3; 
	    graph[3][6]=1; 
	    graph[4][5]=1; 
	    graph[4][3]=1; 
	    graph[5][7]=1; 
	    graph[6][7]=3; 
	    graph[7][3]=3; 
	    */  
	    int specified_node[] = { 2, 3, 5, 7, 11, 13, 17, 19 };//case1必经点，2为起点，19为终点  
	        //intspecified_node[]={0,3,1,2};//case0的必经点，0为起点，2为终点  
	    int mustsize = specified_node.length;//必经点集的规模 
	    int count_round = 0;  
	    int rounds = 100;//循环次数  
	    int minpath = 999999;  
	    int count_0 = 0;//统计rounds次循环中，无解的次数  
	    int count_low = 0;//统计rounds次循环中，比71小的次数  
	    int count_71 = 0;//统计rounds次循环中，结果为71的次数  
	    int count_95 = 0;//统计rounds次循环中，结果为95的次数  
	    int count_99 = 0;//统计rounds次循环中，结果为99的次数  
	    int count_high = 0;//统计rounds次循环中，比99大的次数  
	    while (count_round<rounds)  
	    {   
	        int [] record_path = new int[vertex_nums];
	        for(int i=0;i<vertex_nums;i++){//记录最短路径过程中的路径
	        	record_path[i] = 0;
	        }
	        int dist = 0, shortdist = 0;  
	        boolean flagcon = isConnected(graph, specified_node, mustsize);//从起点起是否连接了必经点  
	        boolean flagnode = isValidNode(graph, specified_node, mustsize);//是否为出入度有效的节点  
	        if (!flagcon || !flagnode)  
	        {  
	            if (!flagcon)  
	            	System.out.println("起点s无法到达其他所有必经点."); 
	            else 
	            	System.out.println("无效图，必经节点不满足出入度条件。");
	            //system("pause");  
	        }    
	        int []ban_visit = new int[vertex_nums];//禁止访问的点
	        for(int i=0;i<vertex_nums;i++){
	        	ban_visit[i] = 0;
	        }
	        int []result = new int[vertex_nums];
	        for(int i=0;i<vertex_nums;i++){//存储访问的节点的结果  
	        	result[i] = -1;
	        }
	        int idx = 0;  
	        boolean isAnswer = true;//无解的标志,true为有解需要继续计算，false则断言无解，不需要再判断了  
	        int start_vertex = 0, end_vertex = 0;  
	        int start_pos = 0, end_pos = start_pos + 1;  
	        for (; end_pos<mustsize&&isAnswer; start_pos++, end_pos++)  
	        {  
	            while (start_pos < (mustsize - 1) &&  
	                ban_visit[specified_node[start_pos]] == 1)//起点一定是一个未被访问过的点  
	                start_pos++;  
	            start_vertex = specified_node[start_pos];  
	            while (end_pos < (mustsize - 1) &&  
	                ban_visit[specified_node[end_pos]] == 1)//终点一定是一个未被访问过得点  
	                end_pos++;  
	            end_vertex = specified_node[end_pos];  
	            if (start_pos>end_pos)  
	                isAnswer = false;//无解，退出  
	            if (isAnswer)  
	                dist = dijkstra(graph, start_vertex, end_vertex, record_path,  
	                ban_visit);//在图g中获得start_vertex和end_vertex的最短路径，并且禁止访问ban_visit中的点  
	            if (dist != -1)  
	            {  
	                //记录已经被访问过得点，未来将不得再访问（防止环的产生）  
	                for (int k = record_path[end_vertex]; record_path[k] != -1; k =  
	                    record_path[k])  
	                    ban_visit[k] = 1;  
	                ban_visit[start_vertex] = 1;  
	                //记录遍历结果  
	                //vector<int> tmp;  
	                Stack<Integer> tmp = new Stack<Integer>();
	                for (int k = record_path[end_vertex]; record_path[k] != -1; k =  
	                    record_path[k])  
	                	tmp.add(k);
	                    //tmp.push_back(k);  
	                result[idx++] = start_vertex;  
	                for (int j = 0; j<tmp.size(); j++)  
	                	
	                    result[idx++] = tmp.get(tmp.size()-1-j);  
	                shortdist += dist;  
	            }  
	            else  
	            {  
	                isAnswer = false;//无解，退出  
	                break;  
	            }  
	        }  
	        result[idx++] = end_vertex;  
	        /* 
	        if(!isAnswer)//没有解 
	        { 
	        cout<<"必过点为： "; 
	        for(intn=1;n<mustsize-1;n++) 
	        cout<<specified_node[n]<<""; 
	        cout<<endl<<"shortestpath,from "<<specified_node[0]<<"to 
	        "<<specified_node[mustsize-1]<<"isnotexist."<<endl; 
	        } 
	        else//有解 
	        { 
	        cout<<"shortestpath,from "<<specified_node[0]<<"to"<< 
	        specified_node[mustsize-1]<<"is:"<<shortdist<<endl; 
	        cout<<"必过点为： "; 
	        for(intn=1;n<mustsize-1;n++) 
	        cout<<specified_node[n]<<""; 
	        cout<<endl<<"path:"; 
	        for(intk=0;k<idx;k++) 
	        cout<<result[k]<<"--->"; 
	        cout<<endl; 
	        } 
	        */  
	        if (shortdist<71)  
	            count_low++;  
	        if (shortdist == 71)  
	            count_71++;  
	        if (shortdist == 95)  
	            count_95++;  
	        if (shortdist == 99)  
	            count_99++;  
	        if (shortdist>99)  
	            count_high++;  
	        if (!isAnswer)  
	            count_0++;  
	        if (minpath>shortdist)  
	            minpath = shortdist;  
	        count_round++;  
	        nextPermutation(specified_node, mustsize);  
	    }  
	    System.out.println("在" + rounds + "次不同随机序列中，");
	    System.out.println("无路径的次数为" + count_0);
	    System.out.println("结果小于71的次数为" + count_low); 
	    System.out.println("结果为71的次数为" + count_71);  
	    
	    System.out.println("结果为95的次数为" + count_95); 
	    System.out.println("结果为99的次数为" + count_99); 
	    System.out.println("结果大于99的次数为" + count_high);  
	    System.out.println(rounds + "次循环中，最最最最........短路径是: " + minpath);  
	     
	    //system("pause");  
	    return 0;  
	} 
	
	public static void main(String args[]){
		_tmain1();
	}
	

}
