package LeetCodeProblems;

import java.util.LinkedList;

public class NumberOfConnectedCompDFS {
	
    static class Graph{
		private int V; /* number of vertices */
		private LinkedList<Integer> al[]; /* Adjacency list */

		public Graph(int v) {
			this.V = v;
			al = new LinkedList[V];
			for (int i = 0; i < V; i++) {
				al[i] = new LinkedList<>();
			}
		}

		public void addEdge(int from, int to) {
			al[from].add(to);
		}
	}
    
    public static void main(String[] args) {
    	NumberOfConnectedComponents noc=new NumberOfConnectedComponents();
    	int[][] edges = {{0,1},{1,2},{3,4}};
    	int count=noc.countComponents(5, edges);
    	System.out.println("Result :"+count);
	}
    
    public int countComponents(int n, int[][] edges) {
        Graph graph=new Graph(n);
        for(int i=0;i<edges.length;i++){
              graph.addEdge(edges[i][0],edges[i][1]);
              graph.addEdge(edges[i][1],edges[i][0]);
        }
        int count=0;
        boolean visitedArr[]=new boolean[graph.V];
		
        for(int j=0;j<n;j++){
               if(!visitedArr[j]){
                     count++;
                     dfs(j,visitedArr,graph);
               }
        }
        return count;
    }
    
    public void dfs(int start,boolean[] visitedArr,Graph graph) {
		  visitedArr[start]=true;
		  for(Integer node : graph.al[start]) {
			    if(!visitedArr[node]) {
			    	 dfs(node,visitedArr,graph);
			    }
		  }
	}
}
