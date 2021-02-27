package graph;

import java.util.LinkedList;

public class DFSUsingRecursion {
	
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
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(2, 1);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 2);
		graph.addEdge(4, 5);
		
		DFSUsingRecursion dc=new DFSUsingRecursion();
		boolean visitedArr[]=new boolean[graph.V];
		dc.dfs(0,visitedArr,graph);
	}
	
	public void dfs(int start,boolean[] visitedArr,Graph graph) {
		  System.out.print(start+"  ");
		  visitedArr[start]=true;
		  for(Integer node : graph.al[start]) {
			    if(!visitedArr[node]) {
			    	 dfs(node,visitedArr,graph);
			    }
		  }
	}
}
