package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DetectCycleInDirectedGraph {
	
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
		Graph graph = new Graph(7);

		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 2);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 4);
		
		DetectCycleInDirectedGraph dc=new DetectCycleInDirectedGraph();
		boolean isCycle=dc.isCyclePresent(graph);
		System.out.println("The graph content cycle ? = "+isCycle);
		
	}
		
	public boolean isCyclePresent(Graph graph) {
		Set<Integer> whiteSet=new HashSet<>();
		Set<Integer> greySet=new HashSet<>();
		Set<Integer> blackSet=new HashSet<>();
		
		for(int i=0;i<graph.V;i++) {
			  whiteSet.add(i);
		}
		
		while(!whiteSet.isEmpty()) {
			  int current=whiteSet.iterator().next();
			  if(dfs(current,whiteSet,greySet,blackSet,graph)) {
				    return true;
			  }
		}
		
		return false;
	}
	
	public boolean dfs(int current,Set<Integer> whiteSet,Set<Integer> greySet,Set<Integer> blackSet,Graph graph) {
		moveVertexToDiffSet(current,whiteSet,greySet);
		for(int vertex : graph.al[current]) {
			   if(blackSet.contains(vertex)) {
				     continue;
			   }
			   if(greySet.contains(vertex)) {
				   System.out.println(vertex);
				    return true;
			   }
			   if(dfs(vertex,whiteSet,greySet,blackSet,graph)) {
				     return true;
			   }
		} 
		moveVertexToDiffSet(current,greySet,blackSet);
		return false;
	}
	
	public void moveVertexToDiffSet(int current,Set<Integer> source,Set<Integer> destination){
		source.remove(current);
		destination.add(current);
	}
	
	
}
