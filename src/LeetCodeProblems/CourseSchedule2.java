package LeetCodeProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CourseSchedule2 {
	  public int[] findOrder(int numCourses, int[][] prerequisites) {
		  Map<Integer,List<Integer>> adjnList=new HashMap<>();
	      int indegree[]=new int[numCourses];
	      int topoSort[]=new int[numCourses];
	      
	      for(int i=0;i<prerequisites.length;i++){
	           int dest=prerequisites[i][0];
	           int source=prerequisites[i][1];
	          List<Integer> list=adjnList.getOrDefault(source,new ArrayList<Integer>());
	          list.add(dest);
	          adjnList.put(source,list);
	          indegree[dest]=indegree[dest]+1;
	      }
	      
	      Queue<Integer> q=new LinkedList<Integer>();
	      for(int i=0;i<numCourses;i++){
	            if(indegree[i]==0){
	                q.add(i);
	            }
	      }
	      
	      int i=0;
	      while(!q.isEmpty()){
	          int node=q.remove();
	          topoSort[i]=node;
	          i++;
	          if(adjnList.containsKey(node)){
	              for(Integer neighbr : adjnList.get(node)){
	                    indegree[neighbr]--;
	                    if(indegree[neighbr]==0){
	                         q.add(neighbr);
	                    }
	              }
	          }
	      }
	      //checking for loop condition
	      if(i==numCourses){
	          return topoSort;
	      }
	      
	      return new int[0];
	  }
	}
