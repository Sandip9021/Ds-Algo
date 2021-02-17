package LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

//Leetcode 1557
public class MinNUmOfVerticesToReachAllNodes {
	
	 public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         List<Integer> result = new ArrayList<>();
	      boolean indegree[]=new boolean[n];
	      
	      for(int i=0;i<edges.size();i++){
	           int to=edges.get(i).get(1);
	           indegree[to]=true;
	      }
      
       for(int i=0;i<n;i++){
             if(!indegree[i]){
                  result.add(i);
             }
       }
      
      return result;
  }
	 //Second Way to implement
	 public List<Integer> findSmallestSetOfVerticesSecondMethod(int n, List<List<Integer>> edges) {
         List<Integer> result = new ArrayList<>();
	       int indegree[]=new int[n];
	      
	      for(int i=0;i<edges.size();i++){
	           int to=edges.get(i).get(1);
	           indegree[to]=indegree[to]+1;
	      }
      
       for(int i=0;i<n;i++){
             if(indegree[i]==0){
                  result.add(i);
             }
       }
      
      return result;
  }
}
