package graph;

import java.util.LinkedList;

public class Graph {	
	private int V;  /*number of vertices*/
	private LinkedList<Integer> al[];
	
	public Graph(int v) {
		this.V=v;
		al=new LinkedList[V];
		for(int i=0;i<V;i++) {
			al[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int from , int to) {
		al[from].add(to);
	}
	
	public void BFS (int startingVertex) {
		boolean visited[] = new boolean[this.V];
		LinkedList<Integer> queue= new LinkedList<>();
		
		queue.add(startingVertex);
		visited[startingVertex] = true;
		
		
	while(queue.size()!=0) {	
		startingVertex=queue.poll();
		System.out.print(startingVertex+"  ");
		
		LinkedList<Integer> el=al[startingVertex];
		
		for(Integer i: el) {
		   if(!visited[i]) {	 
			  queue.add(i);
			  visited[i]=true;
		   }
		}
	}		
	}
	
	public static void main(String[] args) {
		Graph graph= new Graph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(3, 0);
		graph.addEdge(2, 5);
		graph.addEdge(5, 6);
		
		graph.BFS(0);
		
	}
	
}
