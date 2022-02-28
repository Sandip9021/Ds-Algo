package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class ShortestPathAlgorithmDAG {
	static class Graph{
		private int V; /* number of vertices */
		private LinkedList<Integer> al[]; /* Adjacency list */

		@SuppressWarnings("unchecked")
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
	
	public List<Integer> bfs(int start,int end,boolean visitedArr[],Graph graph) {
		Queue<Path> queue = new LinkedList<>();
		Path path = new Path(start);
		path.way.add(start);
		queue.add(path);
		
		List<Integer> resultPath = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Path p= queue.poll();
			if(p.node == end) {
				 return p.way;
			}
			for(Integer n : graph.al[p.node]) {
				Path pr = new Path(n);
				pr.way=new ArrayList<>(p.way);
				pr.way.add(n);
				queue.add(pr);
			}
		}
		
		return resultPath;
	}
	
	static class Path{
		List<Integer> way;
		int node;
		public Path(int n) {
			this.way = new ArrayList<>();
			this.node = n;
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		int start=0;
		int end=4;

		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		ShortestPathAlgorithmDAG sp=new ShortestPathAlgorithmDAG();
		boolean visitedArr[]=new boolean[graph.V];
		List<Integer> li = sp.bfs(start,end,visitedArr,graph);
		if(li.size()>0) {
			System.out.println("Shortest Path : "+li);
		}else {
			System.out.println("There no path between "+start+" and "+end);
		}
		
	}

}
