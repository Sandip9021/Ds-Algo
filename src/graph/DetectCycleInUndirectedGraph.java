package graph;

import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirectedGraph {

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
		Graph graph = new Graph(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 0);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		graph.addEdge(4, 3);
		
		DetectCycleInUndirectedGraph dc=new DetectCycleInUndirectedGraph();
		boolean isCycle=dc.isCyclePresent(graph);
		System.out.println("The graph content cycle ? = "+isCycle);
		
	}
	
	public boolean isCyclePresent(Graph graph) {
		int[] nodeStatusArr=new int[graph.V];
		Queue<Integer> queue=new LinkedList<>();
		queue.add(0);
		nodeStatusArr[0]=1;
		
		while(!queue.isEmpty()) {
			   int node=queue.poll();
			   nodeStatusArr[node]=2;
			   LinkedList<Integer> li=graph.al[node];
			   for(Integer i : li) {
				     if(nodeStatusArr[i]==1) {
				    	  return true;
				     }
				     if(nodeStatusArr[i]==0) {
				    	 queue.add(i);
				    	 nodeStatusArr[i]=1;
				     }
			   }
		}
		
		return false;
	}

}




